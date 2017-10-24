package JavaSqlRemoteConnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {


    public static void main(String args[]){
        int port=8085;
        try {
            Scanner scn=new Scanner(System.in);
            Socket socket=new Socket("127.0.0.1",port);
            System.out.println("BaseClient Connected to "+socket.getRemoteSocketAddress());
            String key="",clientText="";

            InputStream ios= socket.getInputStream();
            DataInputStream dataInputStream=new DataInputStream(ios);

            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            while(true){
                System.out.println("Put your Text");
                clientText=scn.nextLine();
                System.out.println("ENTER KEY");
                key=scn.nextLine();
//                String encryptedMessage=encrypt(clientText,key);
//                dataOutputStream.writeUTF(encryptedMessage);
//                System.out.println("Encrypted Message "+encryptedMessage);

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
