import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: GalaxyXL
 * DateCteate in 2019-04-16 09:22
 */

public class FtpMainThread {
    static String folder = "D:\\benzi\\test\\";

    //Server socket
    private ServerSocket serverSocket = null;

    //Port
    private int port;

    public FtpMainThread(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void startMainThread() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new FtpServer(socket).start();
            } catch (IOException ioe1) {
                ioe1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FtpMainThread mainThread = new FtpMainThread(8080);
        mainThread.startMainThread();
        //FtpModel ftpModel = new FtpModel();
        //ftpModel.sendFileList("D:\\benzi\\");
    }

}
