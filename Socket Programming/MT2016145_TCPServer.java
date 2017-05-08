package tcp2;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class MT2016145_TCPServer {
	public static void main(String[] args) throws IOException {
		int arrFromClient[]=new int[10];
		ServerSocket welcomeSocket = new ServerSocket(6786);
		while(true){
		    Socket connectionSocket = welcomeSocket.accept();
		    DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
		    DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		    for(int i=0;i<10;i++) {
		        arrFromClient[i] = inFromClient.readInt();
		    }
		    Arrays.sort(arrFromClient);
		    for (int i = arrFromClient.length-1; i >=0 ; i--) {
		        outToClient.writeInt(arrFromClient[i]);
		    }
		}
	}
}
