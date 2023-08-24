import { Box, Container, Typography } from "@mui/material";
import Navbar from "../../Components/Navbar";
import LandingImage from "../../Assets/reading.png";
import BookList from "./Component/BookList";

const books = [
  {
    title: "İçimizdeki Şeytan",
    author: "Sabahattin Ali",
    image: "https://i.dr.com.tr/cache/600x600-0/originals/0000000058246-1.jpg",
  },
  {
    title: "İçimizdeki Şeytan",
    author: "Sabahattin Ali",
    image: "https://i.dr.com.tr/cache/600x600-0/originals/0000000058246-1.jpg",
  },
  {
    title: "İçimizdeki Şeytan",
    author: "Sabahattin Ali",
    image: "https://i.dr.com.tr/cache/600x600-0/originals/0000000058246-1.jpg",
  },
  {
    title: "İçimizdeki Şeytan",
    author: "Sabahattin Ali",
    image: "https://i.dr.com.tr/cache/600x600-0/originals/0000000058246-1.jpg",
  },
  {
    title: "İçimizdeki Şeytan",
    author: "Sabahattin Ali",
    image: "https://i.dr.com.tr/cache/600x600-0/originals/0000000058246-1.jpg",
  },
];

export type Book = (typeof books)[number];

const landing = () => {
  return (
    <>
      <Navbar />

      <Container
        sx={{
          display: "flex",
          flexDirection: "column",
          gap: 10,
          my: 12,
        }}
      >
        {/* Hero */}
        <Box
          component="section"
          sx={{
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
          }}
        >
          <img src={LandingImage} />

          <Box
            sx={{
              ml: 7,
              width: "24%",
            }}
          >
            <Typography variant="h3" fontWeight="600">
              Cebindeki Kitaplık!
            </Typography>
            <Typography
              sx={{
                mt: 3,
              }}
            >
              Kendi kitaplığını oluşturarak dilediğin yerden kolayca takibini
              yapabilmek için uygulamamızı indir!
            </Typography>
          </Box>
        </Box>

        {/* What I Read */}
        <BookList title="Okuduklarım" books={books} />

        {/* Suggest */}
        <BookList title="Senin için Seçtiklerimiz" books={books} />
      </Container>
    </>
  );
};

export default landing;
