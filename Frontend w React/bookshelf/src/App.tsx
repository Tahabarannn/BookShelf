import { Button, CssBaseline } from "@mui/material";
import { theme } from "./Utils/theme";
import { ThemeProvider } from "@emotion/react";
import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { generateRoutes } from "./Pages/router";
import { useMemo, useState } from "react";

const App = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const generatedRoutes = generateRoutes(isLoggedIn);
  const router = useMemo(
    () => createBrowserRouter([...generatedRoutes]),
    [isLoggedIn]
  );

  return (
    <>
      <Button onClick={() => setIsLoggedIn(!isLoggedIn)} variant="contained">
        Login / Logout
      </Button>

      <ThemeProvider theme={theme}>
        <CssBaseline />
        <RouterProvider router={router} />
      </ThemeProvider>
    </>
  );
};

export default App;
