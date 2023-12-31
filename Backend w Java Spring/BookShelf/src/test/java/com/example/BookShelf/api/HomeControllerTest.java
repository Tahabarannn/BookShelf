package com.example.BookShelf.api;

import com.example.BookShelf.dto.TokenResponseDto;
import com.example.BookShelf.dto.request.LoginRequest;
import com.example.BookShelf.dto.request.SignUpRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HomeControllerTest extends BaseRestControllerTest {

    public final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public MockMvc mvc;

    @Test
    @Disabled
    void publicEndpoint() {

    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Disabled
    void user() throws Exception {

        var userForSignUp = SignUpRequest.builder()
                .username("Username 1")
                .password("User password 1")
                .role("USER")
                .build();

        mvc.perform(post("/api/auth/signup")
                        .content(asJsonString(userForSignUp))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        var loginRequestForUser = LoginRequest.builder()
                .username("Username 1")
                .password("User password 1")
                .build();

        MvcResult result = mvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(loginRequestForUser)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        var loggedUser = mapper.readValue(content, TokenResponseDto.class);
        mvc.perform(get("/api/user")
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + loggedUser.getAccessToken())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().is2xxSuccessful());
    }


    @Test
    @Disabled
    void admin() throws Exception {
        var loginRequestAsString =
                mapper.writeValueAsString(new LoginRequest("gurkan", "pass"));

        MvcResult result = mvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginRequestAsString))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        var loggedUser = mapper.readValue(content, TokenResponseDto.class);
        mvc.perform(get("/api/admin")
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + loggedUser.getAccessToken())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().is2xxSuccessful());
    }
}