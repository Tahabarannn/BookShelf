import { CssBaseline } from "@mui/material";
import Auth from "./Pages/auth/auth";
import { theme } from "./Utils/theme";
import { ThemeProvider } from "@emotion/react"

const App = () => {
  return (
    <>
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Auth />
    </ThemeProvider>
    </>
  );
}

export default App;