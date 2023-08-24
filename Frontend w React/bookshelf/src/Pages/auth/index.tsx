import { RouteObject } from "react-router-dom";
import Auth from "./Auth";

export const AUTH_BASE_ROUTES = {
  index: "/",
};

export const authRoutes: RouteObject[] = [
  {
    path: AUTH_BASE_ROUTES.index,
    element: <Auth />,
    index: true,
  },
];
