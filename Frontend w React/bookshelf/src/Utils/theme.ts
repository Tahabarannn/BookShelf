import { createTheme } from "@mui/material";

export const theme = createTheme({
  palette: {
    background: {
      default: "#f3f3f3",
      paper: "#fff",
    },
  },
  shape: {
    borderRadius: 8,
  },
  components: {
    MuiButton: {
      styleOverrides: {
        root: {
          textTransform: "none",
        },
      },
    },
  },
});
