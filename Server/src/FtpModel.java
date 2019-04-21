import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.Socket;

/**
 * Author: GalaxyXL
 * DateCteate in 2019-04-16 09:57
 */

public class FtpModel {

    public void sendFile(String fileName, OutputStream OutputStream){
        try {
            File file = new File(FtpMainThread.folder + fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buff = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buff)) != -1) {
                OutputStream.write(buff, 0, length);
                //dataOutputStream.flush();
            }
            OutputStream.flush();
            fileInputStream.close();
        } catch (FileNotFoundException nfe) {
            nfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void sendFileList(String path, OutputStream outputStream) {
        try {
            File file = new File(path);
            File[] files = file.listFiles();
            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(outputStream));
            for (File f : files) {
                br.write(f.getName() + "\n");
            }
            br.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveFile(String fileName, InputStream inputStream) {
        try {
            File file = new File(FtpMainThread.folder + fileName);
            System.out.println(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            DataOutputStream dataOutputStream = new DataOutputStream(
                    new BufferedOutputStream(fileOutputStream));
            int length;
            byte[] buff = new byte[1024];
            while ((length = inputStream.read(buff)) != -1) {
                dataOutputStream.write(buff, 0, length);
                dataOutputStream.flush();
            }
            fileOutputStream.close();
            dataOutputStream.flush();

            //dataOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
