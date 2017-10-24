package JavaSqlRemoteConnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String args[]){
        int port=8085;
        try {
            Scanner scn=new Scanner(System.in);
            ServerSocket serverSocket=new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server Says: Client Connected to Server at port "+serverSocket.getLocalPort());
            Socket socket=serverSocket.accept();
            System.out.println("Server Says: Client Connected "+socket.getLocalAddress());
            String clientText="",key="";
            InputStream ios= socket.getInputStream();
            DataInputStream dataInputStream=new DataInputStream(ios);

            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            // This stops
            while(true){
                if(ios.available()>0) {
                    clientText = dataInputStream.readUTF();
//                    System.out.println("ENTER KEY");
//                    key=scn.nextLine();
//                    if (!clientText.isEmpty())
//                        System.out.println("Client Says: " + decrypt(clientText,key));
//                    else
//                        System.out.println("Client Text Empty: ");
                }
                else{
//                    System.out.println("Server:Client Didn't Write anything");
                }
            }


        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
