import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import Button from "@mui/material/Button";
import { styled, alpha } from "@mui/material/styles";
import InputBase from "@mui/material/InputBase";
import SearchIcon from "@mui/icons-material/Search";
import ManageAccountsIcon from "@mui/icons-material/ManageAccounts";
import MenuBookIcon from "@mui/icons-material/MenuBook";
import InventoryIcon from "@mui/icons-material/Inventory";
import { useNavigate } from "react-router-dom";
import { LANDING_BASE_ROUTES } from "../Pages/Landing";

const pages = [
  { title: "Listelerim", path: "/lists", icon: <MenuBookIcon /> },
  { title: "Kütüphanem", path: "/library", icon: <InventoryIcon /> },
  { title: "Taha Baran", path: "/user", icon: <ManageAccountsIcon /> },
];

const Search = styled("div")(({ theme }) => ({
  position: "relative",
  borderRadius: theme.shape.borderRadius,
  backgroundColor: alpha(theme.palette.common.white, 0.15),
  "&:hover": {
    backgroundColor: alpha(theme.palette.common.white, 0.25),
  },
  marginLeft: 0,
  width: "100%",
  [theme.breakpoints.up("sm")]: {
    marginLeft: theme.spacing(1),
    width: "auto",
  },
}));

const SearchIconWrapper = styled("div")(({ theme }) => ({
  padding: theme.spacing(0, 2),
  height: "100%",
  position: "absolute",
  pointerEvents: "none",
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
}));

const StyledInputBase = styled(InputBase)(({ theme }) => ({
  color: "inherit",
  "& .MuiInputBase-input": {
    padding: theme.spacing(1, 1, 1, 0),
    // vertical padding + font size from searchIcon
    paddingLeft: `calc(1em + ${theme.spacing(4)})`,
    transition: theme.transitions.create("width"),
    width: "100%",
    [theme.breakpoints.up("sm")]: {
      width: "35ch",
    },
  },
}));

function Navbar() {
  const navigate = useNavigate();

  return (
    <AppBar position="static">
      <Container maxWidth="xl">
        <Toolbar
          sx={{
            justifyContent: "space-around",
          }}
        >
          <Typography
            onClick={() => navigate(LANDING_BASE_ROUTES.index)}
            variant="h6"
            noWrap
            component="a"
            sx={{
              mr: 2,
              display: { xs: "none", md: "flex" },
              fontFamily: "monospace",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
              cursor: "pointer",
            }}
          >
            BookShelf
          </Typography>

          <Search>
            <SearchIconWrapper>
              <SearchIcon />
            </SearchIconWrapper>
            <StyledInputBase
              placeholder="Search…"
              inputProps={{ "aria-label": "search" }}
            />
          </Search>

          <Box sx={{ display: { xs: "none", md: "flex" }, gap: 2 }}>
            {pages.map((page) => (
              <Button
                key={page.title}
                sx={{
                  my: 2,
                  color: "white",
                  display: "flex",
                  justifyContent: "center",
                  gap: ".5rem",
                  "&:hover": {
                    color: "CaptionText",
                  },
                }}
              >
                {page.icon}
                {page.title}
              </Button>
            ))}
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
export default Navbar;
