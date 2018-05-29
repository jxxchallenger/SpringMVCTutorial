package socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args){
		String msg = "Client Data";
		
		Socket socket;
		try {
			socket = new Socket("127.0.0.1", 8080);
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw.println(msg);
			pw.flush();
			String line = is.readLine();
			System.out.println("received from server:" + line);
			pw.close();
			is.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
