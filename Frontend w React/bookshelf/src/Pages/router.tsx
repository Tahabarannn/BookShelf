import { Outlet } from "@mui/icons-material";
import Navbar from "../Components/Navbar";
import { authRoutes } from "./auth";
import { landingRoutes } from "./Landing";

export const generateRoutes = (isLoggedIn: Boolean) => {
  const generatedRoutes = isLoggedIn ? authRoutes : landingRoutes;

  return generatedRoutes;
};

const Root = () => {
  return (
    <>
      <Navbar />
      <Outlet />
    </>
  );
};
