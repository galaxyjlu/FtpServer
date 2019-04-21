import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Author: GalaxyXL
 * DateCteate in 2019-04-16 09:56
 */

public class UserInputController {
    //Command from the remote client
    private String userCommand;

    private String [] userCommands;

    private FtpModel ftpModel = new FtpModel();

    public void seperateCommand() {
        userCommands = userCommand.split(" ");
    }

    public void processInput(Socket socket) {
        seperateCommand();
        try {
            switch (userCommands[0]) {
                case "UPLD":
                    ftpModel.receiveFile(userCommands[1], socket.getInputStream());
                case "DWLD":
                    ftpModel.sendFile(userCommands[1], socket.getOutputStream());
                    socket.shutdownOutput();
                case  "LIST":
                    ftpModel.sendFileList(FtpMainThread.folder, socket.getOutputStream());
                    socket.shutdownOutput();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUserCommand() {
        return userCommand;
    }

    public void setUserCommand(String userCommand) {
        this.userCommand = userCommand;
    }
}
