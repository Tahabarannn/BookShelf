package com.example.BookShelf.api;

import com.example.BookShelf.dto.*;
import com.example.BookShelf.dto.request.SaveBookRequest;
import com.example.BookShelf.model.BookStatus;
import com.example.BookShelf.service.BookListService;
import com.example.BookShelf.service.BookSaveService;
import com.example.BookShelf.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookRestControllerTest extends BaseRestControllerTest {

    @MockBean
    private BookListService bookListService;

    @MockBean
    private BookSaveService bookSaveService;

    @MockBean
    private UserService userService;

    @Autowired
    MockMvc mockMvc;

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void itShouldSaveBook_WhenValidBookRequestBody() throws Exception {

        // given - precondition or setup
        SaveBookRequest request = SaveBookRequest.builder()
                .title("title")
                .totalPage(100)
                .build();

        BookListItemResponse response = BookListItemResponse.builder()
                .title("title")
                .author("authorName")
                .build();

        // when -  action or the behaviour that we are going test
        when(bookSaveService.saveBook(request)).thenReturn(response);

        // then - verify the output
        mockMvc.perform(post("/api/v1/book/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andDo(print())
                .andExpect(jsonPath("$.title").value(response.getTitle()))
                .andExpect(status().isCreated());

    }

    @Test
    void itShouldGetAllBook_WhenGivenCategory() throws Exception {

        // given - precondition or setup
        CategoryType categoryType = CategoryType.COMIC;

        BookResponse response1 = BookResponse.builder()
                .CategoryId(1L)
                .author("authorName")
                .build();

        BookResponse response2 = BookResponse.builder()
                .CategoryId(1L)
                .author("authorName2")
                .build();

        List<BookResponse> response = List.of(response1, response2);

        UserDto userDto = UserDto.builder()
                .id(1L)
                .username("username")
                .build();

        // when -  action or the behaviour that we are going test
        when(userService.findUserInContext()).thenReturn(userDto);
        when(bookListService.searchByCategory(categoryType, userDto.getId())).thenReturn(response);


        // then - verify the output
        mockMvc.perform(get("/api/v1/book/search/" + categoryType) //String.format("/api/v1/book/search/%s", categoryType.getValue())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.[0].authorName").value(response1.getAuthor()))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());
    }

    @Test
    void itShouldGetAllBook_WhenGivenStatus() throws Exception {

        // given - precondition or setup
        BookStatus status = BookStatus.READ;

        BookResponse response1 = BookResponse.builder()
                .status(BookStatus.READ)
                .author("authorName")
                .build();

        BookResponse response2 = BookResponse.builder()
                .status(BookStatus.READ)
                .author("authorName2")
                .build();

        List<BookResponse> response = List.of(response1, response2);

        UserDto userDto = UserDto.builder()
                .id(1L)
                .username("username")
                .build();

        // when -  action or the behaviour that we are going test
        when(userService.findUserInContext()).thenReturn(userDto);
        when(bookListService.searchBookStatus(status, userDto.getId())).thenReturn(response);

        // then - verify the output
        mockMvc.perform(get(String.format("/api/v1/book/%s", status))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.[0].authorName").value(response1.getAuthor()))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());

    }

    @Test
    void itShouldGetAllBook_WhenGivenTitle() throws Exception {

        // given - precondition or setup
        String title = "Book 1";

        BookResponse response1 = BookResponse.builder()
                .title(title)
                .author("authorName")
                .build();

        BookResponse response2 = BookResponse.builder()
                .title(title)
                .author("authorName2")
                .build();

        List<BookResponse> response = List.of(response1, response2);

        UserDto userDto = UserDto.builder()
                .id(1L)
                .username("username")
                .build();

        // when -  action or the behaviour that we are going test
        when(bookListService.searchByTitle(title)).thenReturn(response);

        // then - verify the output
        mockMvc.perform(get(String.format("/api/v1/book/list/%s", title))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.[0].authorName").value(response1.getAuthor()))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());
    }

    @Test
    void itShouldGetBooks_WhenSearch() throws Exception {

        // given - precondition or setup
        BookResponse response1 = BookResponse.builder()
                .title("Book 1")
                .author("authorName")
                .build();

        BookResponse response2 = BookResponse.builder()
                .title("Book 1")
                .author("authorName2")
                .build();

        List<BookResponse> response = List.of(response1, response2);

        UserDto userDto = UserDto.builder()
                .id(1L)
                .username("username")
                .build();

        // when -  action or the behaviour that we are going test
        when(userService.findUserInContext()).thenReturn(userDto);
        when(bookListService.listBooks(anyInt(), anyInt(), eq(userDto.getId()))).thenReturn(response);

        // then - verify the output
        mockMvc.perform(get("/api/v1/book/search?size=" + 1 + "&page=" + 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());
    }

    @Test
    void itShouldGetNoContent_WhenDeleteBook() throws Exception {

        // given - precondition or setup
        Long bookId = 1L;

        // when -  action or the behaviour that we are going test
        doNothing().when(bookSaveService).deleteBook(bookId);

        // then - verify the output
        mockMvc.perform(delete("/api/v1/book/delete/{bookId}", bookId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void itShouldGetBook_WhenSearch() throws Exception {

        // given - precondition or setup
        BookResponse response1 = BookResponse.builder()
                .title("Book 1")
                .author("authorName")
                .build();

        // when -  action or the behaviour that we are going test
        when(bookListService.findBook(anyLong())).thenReturn(response1);

        // then - verify the output
        mockMvc.perform(get(String.format("/api/v1/book/get/" + anyLong()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.title").value(response1.getTitle()))
                .andExpect(status().isOk());
    }
}
