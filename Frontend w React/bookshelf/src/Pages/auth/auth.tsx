import { Box, FormControl, Paper, TextField } from '@mui/material'
import { Player } from '@lottiefiles/react-lottie-player'
import LoginAnimation from '../../Lottie/loginAnimation.json'

const auth = () => {
  return (
    <Box sx={{
      display: 'flex',
      justifyContent: 'center',
      mt: '10%',
    }}>
      <Box sx={{
        width: 480,
      }}>
        <Paper sx={{
          p: 8,
        }}>
          <Player
           src={LoginAnimation}
           autoplay 
           loop
           style={{
            width: 200,
            height: 200,
           }} />

           <Box sx={{
            display: 'flex',
            flexDirection: 'column',
            gap: 2,
            mt: 4,
           }}>
            <FormControl>
              <TextField label='Email'/>
            </FormControl>

            <FormControl>
              <TextField label='Şifre'/>
            </FormControl>
           </Box>
        </Paper>
      </Box>
    </Box>
  )
}

export default auth;