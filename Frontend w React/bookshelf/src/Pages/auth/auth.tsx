import {
  Box,
  Button,
  FormControl,
  FormHelperText,
  Paper,
  TextField,
} from "@mui/material";
import { Player } from "@lottiefiles/react-lottie-player";
import LoginAnimation from "../../Lottie/loginAnimation.json";
import { useState } from "react";
import { Visibility } from "@mui/icons-material";
import { LANDING_BASE_ROUTES } from "../Landing";
import { useNavigate } from "react-router-dom";

const auth = () => {
  const [isLogin, setIsLogin] = useState(true);
  const [isPasswordVisible, setIsPasswordVisible] = useState(false);

  const navigate = useNavigate();

  return (
    <Box
      sx={{
        display: "flex",
        justifyContent: "center",
        mt: "10%",
      }}
    >
      <Box
        sx={{
          width: 480,
        }}
      >
        <Paper
          sx={{
            p: 8,
            boxShadow: 4,
          }}
        >
          <Player
            src={LoginAnimation}
            autoplay
            loop
            style={{
              width: 200,
              height: 200,
            }}
          />

          <Box
            sx={{
              component: "form",
              display: "flex",
              flexDirection: "column",
              gap: 2,
              mt: 4,
            }}
          >
            {!isLogin && (
              <FormControl>
                <TextField label="İsim" />
              </FormControl>
            )}

            <FormControl>
              <TextField label="Email" />
            </FormControl>

            <FormControl>
              <TextField
                type={isPasswordVisible ? "text" : "password"}
                label="Şifre"
                InputProps={{
                  endAdornment: (
                    <Box
                      onClick={() => setIsPasswordVisible((prev) => !prev)}
                      sx={{
                        display: "flex",
                        alignItems: "center",
                      }}
                    >
                      <Visibility
                        sx={{
                          cursor: "pointer",
                          "&:hover": {
                            color: "text.secondary",
                          },
                        }}
                      />
                    </Box>
                  ),
                }}
              />
            </FormControl>

            <Button
              onClick={() => navigate(LANDING_BASE_ROUTES.index)}
              variant="contained"
            >
              {isLogin ? "Giriş Yap" : "Kayıt Ol"}
            </Button>
            <FormHelperText
              onClick={() => setIsLogin((prev) => !prev)}
              sx={{
                textAlign: "center",
                cursor: "pointer",
                "&:hover": {
                  color: "primary.main",
                },
              }}
            >
              {isLogin
                ? "Hesabın yok mu? Kayıt Ol"
                : "Hesabın var mı? Giriş Yap"}
            </FormHelperText>
          </Box>
        </Paper>
      </Box>
    </Box>
  );
};

export default auth;
