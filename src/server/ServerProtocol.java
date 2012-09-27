package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerProtocol {

	public ServerProtocol(Socket client){
		handleClient(client);
	}
	
	private void handleClient(Socket client){
		
		try{
			// From Server to Client
	        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
	        // From Client to Server
	        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	        
	        // The variables containing the information received from the Client        
	        StringBuffer fromClient = new StringBuffer();
	        String input;
	        // The variable containing the information to be returned to the Client
	        String toClient;
	        	 
			while ((input = in.readLine()) != null) {
				 System.out.println("Processing request from client");
				 
				 fromClient.append(input);
				 input = null;
			    /*
				 toClient = protocol.processInput(fromClient);
			     out.writeObject(toClient);
			     */
			}
			
			// End the connection
			out.close();
	        in.close();
	        client.close();
	        
		}catch(IOException ioex){
			ioex.printStackTrace();
		}
	}
}
