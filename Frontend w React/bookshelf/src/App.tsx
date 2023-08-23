import { CssBaseline } from "@mui/material";
import { theme } from "./Utils/theme";
import { ThemeProvider } from "@emotion/react";
import Landing from "./Pages/Landing/landing";

const App = () => {
  return (
    <>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        <Landing />
      </ThemeProvider>
    </>
  );
};

export default App;
