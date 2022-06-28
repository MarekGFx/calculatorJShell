package calcserverapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

public class CalcServer  extends Thread implements AutoCloseable {
	
		private final int portNumber;
		private ServerSocket socketServer = new ServerSocket();

		public CalcServer(int portNumber) throws IOException {
			this.portNumber = portNumber;
			socketServer = new ServerSocket(this.portNumber);
		}
		
		public void run() {

			while (true) {

				try (Socket socket = socketServer.accept()) { // instrukcja blokuj¹ca
					boolean isAutoFlush = true;

					InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
					//OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				//	PrintWriter response = new PrintWriter(socket.getOutputStream(), isAutoFlush);
				//	BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
					
//					ClientHandler client = new ClientHandler(socket,inputStreamReader,outputStreamWriter);
//					client.start();
//					System.out.println("client(). Thread name: " + Thread.currentThread().getName());
					String msgFromClient = bufferedReader.readLine();
					System.out.println("Client: " + msgFromClient);

					JShell jshell = JShell.create();
					try (jshell) {
						List<SnippetEvent> events = jshell.eval(msgFromClient);
						for (SnippetEvent e : events) {
							if (e.causeSnippet() == null) {
								switch (e.status()) {
								case VALID:
									if (e.value() != null) {
										System.out.printf(e.value());
									//	response.println(e.value());
										System.out.println();
									}

									break;
								default:
								//	response.println("Error\n");
								}
							}
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}

		@Override
		public void close() throws Exception {
			if (socketServer != null) {
				socketServer.close();
			}
		}


}
