import java.io.*;
import java.net.*;
public class MyClientcopy{
	public static void main(String[] args){
		try{
			Socket s=new Socket("localhost",50000);
			DataOutputStream dout=new 			DataOutputStream(s.getOutputStream());
		 DataInputStream in=new DataInputStream(s.getInputStream());
			BufferedReader init = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = "";
		
	//		dout.writeUTF("Hello Server");
		//	dout.writeUTF("
			dout.write(("HELO\n").getBytes());
			str = in.readLine();
			dout.flush();
			
			dout.write(("AUTH natalie1\n").getBytes());
			dout.flush();
			str = in.readLine();
			//	String str=(String)in.readLine();
		//	System.out.println("message="+str);
			String username = System.getProperty("user.name");
			System.out.println(username);
			dout.flush();
			
			
			dout.write(("REDY\n").getBytes());
			dout.flush();
			str = in.readLine();
			
			dout.write(("GETS All\n").getBytes());
			dout.flush();
			str = in.readLine();
			
			dout.write(("OK\n").getBytes());
			dout.flush();
			
			
		
			dout.write(("OK\n").getBytes());
			dout.flush();
			str=in.readLine();
			
			

			str = in.readLine();
			
			dout.write(("OK\n").getBytes());
			dout.flush();
			str = in.readLine();
			
			dout.write(("QUIT\n").getBytes());
			str = in.readLine();
	//		dout.writeUTF("Bye");
			dout.flush();
		//	String strs=(String)in.readUTF();
		//	System.out.println("message="+str);
			dout.close();
			s.close();
		}catch(Exception e){System.out.println(e);}
	}
}

