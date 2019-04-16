import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: GalaxyXL
 * DateCteate in 2019-04-15 17:24
 */

public class FtpServer extends Thread {
    private Socket socket;

    FtpServer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
