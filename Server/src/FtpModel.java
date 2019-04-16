import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.Socket;

/**
 * Author: GalaxyXL
 * DateCteate in 2019-04-16 09:57
 */

public class FtpModel {

    public void sendFile(String fileName, DataOutputStream dataOutputStream){
        try {
            File file = new File(FtpMainThread.folder + fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buff = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buff)) != -1) {
                dataOutputStream.write(buff, 0, length);
                //dataOutputStream.flush();
            }
            dataOutputStream.flush();
        } catch (FileNotFoundException nfe) {
            nfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void sendFileList(String path, BufferedWriter bufferedWriter) {
        try {
            File file = new File(path);
            File[] files = file.listFiles();
            for (File f : files) {
                bufferedWriter.write(f.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveFile(String fileName, DataInputStream dataInputStream) {
        try {
            File file = new File(FtpMainThread.folder + fileName);
            DataOutputStream dataOutputStream = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(file)));
            int length;
            byte[] buff = new byte[1024];
            while ((length = dataInputStream.read(buff)) != -1) {
                dataOutputStream.write(buff, 0, length);
                //dataOutputStream.flush();
            }
            dataOutputStream.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
