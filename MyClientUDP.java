import java.net.*;
import java.io.*;
public class UDPServer{
	public static void main(String args[]){
		DatagramSocket aSocket=null;
		try{
			aSocket = new DatagramSocket();
			byte [] m= arggs[0].getBytes();
			InetAddress aHost=InetAddress.getByName(args[1]);
			int serverPort=6789;
			DatagramPacket request = new DatagramPacket(m, m.length(), aHost, serverPort);
			aSocket.send(request);
			byte[] buffer=new byte[1000];
			DatagramPacket reply = new Datagram Packet(buffer, buffer.length);
			aSocket.receive(reply);
			System.out.println("Reply:"+new String(reply.getData()));
		}catch (SocketException e){System.out.println("Socket:" +e.getMessage());
		}catch(IOException e){System.out.println("IO:"+e.getMessage());}finally(if(aSocket!=null) aSocket.close();}
}
}
