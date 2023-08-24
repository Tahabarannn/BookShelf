import { Box, Typography } from "@mui/material";
import { Book } from "../landing";

type BookListProps = {
  title: string;
  books: Book[];
};

const BookList = ({ title, books }: BookListProps) => {
  return (
    <Box>
      <Box
        sx={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
        }}
      >
        <Typography variant="h4" fontWeight="600">
          {title}
        </Typography>

        <Typography
          sx={{
            cursor: "pointer",
            "&:hover": {
              color: "primary.main",
            },
          }}
        >
          Tümünü Gör
        </Typography>
      </Box>

      <Box
        sx={{
          display: "flex",
          justifyContent: "space-evenly",
          alignItems: "center",
          gap: 2,
          mt: 2,
        }}
      >
        {books.map((book) => (
          <BookItem key={book.title} book={book} />
        ))}
      </Box>
    </Box>
  );
};

export default BookList;

const BookItem = ({ book }: { book: Book }) => {
  return (
    <Box
      sx={{
        cursor: "pointer",
        transition: "all 0.2s ease-in-out",
        "&:hover": {
          transform: "scale(1.05)",
        },
      }}
    >
      <Box
        sx={{
          width: 200,
        }}
      >
        <Box
          component="img"
          src={book.image}
          sx={{
            width: 200,
            height: 320,
            borderRadius: "8px",
          }}
        />
      </Box>
      <Box
        sx={{
          width: 200,
        }}
      >
        <Typography
          noWrap
          fontWeight="600"
          sx={{
            text0verflow: "ellipsis",
          }}
        >
          {book.title}
        </Typography>
        <Typography fontSize={14}>{book.author}</Typography>
      </Box>
    </Box>
  );
};
