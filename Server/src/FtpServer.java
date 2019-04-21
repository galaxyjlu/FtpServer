import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: GalaxyXL
 * DateCteate in 2019-04-15 17:24
 */

public class FtpServer extends Thread {
    private Socket socket;

    private UserInputController userInputController = new UserInputController();

    FtpServer(Socket socket){
        this.socket = socket;
    }

    public String getUserCommands() {
        try {
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void run() {
        userInputController.setUserCommand(getUserCommands());
        userInputController.processInput(socket);
        System.out.println(userInputController.getUserCommand());
    }
}
