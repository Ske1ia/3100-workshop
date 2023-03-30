import java.io.*;
import java.net.*;
public class MyServer{
	public static void main(String[] args){
		try{
			ServerSocket ss=new ServerSocket(50000);
			Socket s=ss.accept();
			DataInputStream dis=new DataInputStream(s.getInputStream());
		//	DataOutputStream out=new DataOutputStream(s.getOutputStream());
			BufferedReader out = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out.write(("G'day\n").getBytes());
			String str=(String)dis.readLine();
			System.out.println("message="+str);
		//	out.writeUTF("G'day");
			String strs=(String)dis.readUTF();
			out.flush();
			System.out.println("message="+strs);
			out.write(("Bye\n").getBytes());
			//	out.writeUTF("Bye");
			ss.close();
		}catch(Exception e){System.out.println(e);}
	}
}
