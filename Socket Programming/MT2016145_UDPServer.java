package udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
class MT2016145_UDPServer {
	public static void main(String args[]) throws Exception
	{
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[10];
		byte[] sendData = new byte[10];
		while(true)
		{
			DatagramPacket receivePacket =
					new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			//System.out.println(sentence);
			char c[]=sentence.toCharArray();
			for(int i=0;i<c.length;i++)
			{
				//System.out.println("In fpr");
				System.out.print(c[i]);
			}
			Arrays.sort(c);
			//System.out.println("C::"+c);
			
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			//String capitalizedSentence = sentence.toUpperCase();
			//sendData = capitalizedSentence.getBytes();
			String sortedString=new String(c);
			sendData=sortedString.getBytes();
			
			System.out.println("Sorted::"+sortedString);
			sendData=sortedString.getBytes();
		//	System.out.println(sendData);
			DatagramPacket sendPacket =
					new DatagramPacket(sendData, sendData.length, IPAddress,
							port);
			serverSocket.send(sendPacket);
			//serverSocket.close();
		}
	}
}