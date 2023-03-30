import java.net.*;
import java.io.*;
public class UDPServer{
        public static void main(String args[]){
                DatagramSocket aSocket=null;
                try{
                        aSocket=new DatagramSocket(6789);
                        byte[] buffer = new byte[1000];
                        while(true){
                                Datagram Packet request = new DatagramPacket(bugger, buffer.length);
                                aSocket.receive(request);
                                DatagramPacket reply=new DatagramPacket(request.getData(), request.getLength(), request.getAddress(),request.getPort());
                                aSocket.send(reply);
                        }catch (SocketExcept e){System.out.println("Socket:"+e.getMessage());
                        }catch(IOException e){System.out.println("Socket:"+e.getMessage());
                        }finally(if(aSocket!=null) aSocket.close();}
        }
}

