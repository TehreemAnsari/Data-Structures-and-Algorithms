package udp2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
class MT2016145_UDPClient {
	public static void main(String args[]) throws Exception
	{
		System.out.println("Enter 10 characters and then press enter");
		BufferedReader inFromUser =
				new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[10];
		byte[] receiveData = new byte[10];
		/*
		 * char[] c1=new char[10];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<10;i++)
		{
			c1[i]=sc.next().charAt(0);
		}
		String  sentence = c1.toString();
		*/
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();	//converting string to bytes
		DatagramPacket sendPacket =
				new DatagramPacket(sendData, sendData.length, IPAddress,
						9876);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket =
				new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String modifiedSentence =
				new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence);
		clientSocket.close();
		//sc.close();
	}
}