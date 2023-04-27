import java.io.*;
import java.net.*;
public class finalversion{
	public static void main(String[] args){
		try{
			Socket s=new Socket("localhost",50000);
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		 	DataInputStream in=new DataInputStream(s.getInputStream());
			BufferedReader init = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = "";
			
			Integer nRec=0;
			String[] sysInfo=null;
			Integer currentID = 0;
			Integer read =0;
			String[] info=null;
			String servertype=null;
			Integer servercore=0;
			Integer serverid = 0;
			String servertype1=null;
			Integer servercore1=0;
			Integer serverid1 = 0;
			
			dout.write(("HELO\n").getBytes()); // initialise conversation between client and server
			dout.flush();
			str = in.readLine();
			
			dout.write(("AUTH natalie1\n").getBytes()); // authenticate user
			dout.flush();
			str = in.readLine();
		
			dout.write(("REDY\n").getBytes()); // send redy to client to send job
			dout.flush();
			str = in.readLine();
			
			String[] serverType = null; //getting string array ready to store serverType
			Integer[] serverID = null;  //getting integer array ready to store serverID 
			
			while(!str.contains("NONE")){
				if(str.contains("ERR")){ //if server sends back server error stop
					break;
				}
				else if(str.contains("JOBN")|| str.contains("JOBP")){ //create loop when client receives job 
					String[] jobInfo=str.split("\\s+");
					Integer jobID = Integer.parseInt(jobInfo[2]);
			
					if(read==0){
						dout.write(("GETS All\n").getBytes());
						dout.flush();
						System.out.println("GETS All");
						str=in.readLine();
						System.out.println("RCVD"+str);
						info = str.split("\\s+");
						nRec=Integer.parseInt(info[1]);
						System.out.println(nRec);
						dout.write(("OK\n").getBytes()); //then prints out the servers 
						System.out.println("SENT OK");
						dout.flush();
			
						str=in.readLine();
						String[] serverInfo = str.split("\\s+");			
			
						serverType = new String[nRec];
						serverID = new Integer[nRec];
						servertype=serverInfo[0];
						servercore=Integer.parseInt(serverInfo[4]);
						serverid = Integer.parseInt(serverInfo[1]);
						serverType[0] = servertype;
						serverID[0] = serverid;

						int index =0;
			
							for(int i=1; i<nRec; i++){
								str=in.readLine();
								String[] serverlargest = str.split("\\s+");
								servertype1=serverlargest[0];
								servercore1=Integer.parseInt(serverlargest[4]);
								serverid1 = Integer.parseInt(serverlargest[1]);
								serverType[i] = servertype1;
								serverID[i] = serverid1;
	
									if(servercore<servercore1){
										servertype=servertype1;
										System.out.println(servertype);
										servercore=servercore1;
										index = i;
									}
							}
	
							for(int i= index; i<serverType.length; i++){
								System.out.println(i);
								System.out.println(serverID[i]);
								System.out.println(serverType[i]);
									if(servertype.equals(serverType[i])){
			 							serverid = serverID[i];
									}
							}
						dout.write(("OK\n").getBytes());
						dout.flush();
						str=in.readLine();
						read = 1;
					}
					if(currentID>serverid){
						currentID=0;
					}
				dout.write(("SCHD "+jobID+" "+servertype+" "+currentID+"\n").getBytes());
				dout.flush();
				currentID++;
				str=in.readLine();
				System.out.println("RCVD"+str);
				}
				dout.write(("REDY\n").getBytes());
				dout.flush();
				str=in.readLine();
			}
			dout.write(("QUIT\n").getBytes());
			dout.flush();
			str=in.readLine();
			dout.close();
			s.close();
		}catch(Exception e){System.out.println(e);
		}
	}
}
