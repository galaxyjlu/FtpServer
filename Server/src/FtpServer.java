import java.net.ServerSocket;

/**
 * Author: GalaxyXL
 * DateCteate in 2019-04-15 17:24
 */

public class FtpServer implements FtpServerRepository, Runnable {
    ServerSocket socket;

    private FtpServer(){

    }

    private static FtpServer ftpServer = new FtpServer();

    public static FtpServerRepository getInstance() {
        return ftpServer;
    }

    @Override
    public void run() {

    }
}
