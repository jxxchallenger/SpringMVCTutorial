package socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args){
		try {
			ServerSocket serverSocket = new ServerSocket(8080);
			Socket socket = serverSocket.accept();
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = is.readLine();
			System.out.println("received from client:" + line);
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("received data:" + line);
			pw.flush();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
