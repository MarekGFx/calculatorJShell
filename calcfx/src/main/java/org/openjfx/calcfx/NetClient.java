package org.openjfx.calcfx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetClient implements AutoCloseable {
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;

	public NetClient(String serverAddress, int portNumber) throws UnknownHostException, IOException {
		socket = new Socket(serverAddress, portNumber);
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
	}

	public String getResponse(String msgToSend) throws IOException {

		String answerFromServer = "";
		while (true) {
			try {
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

				bufferedWriter.write(msgToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();

				answerFromServer = bufferedReader.readLine();

			} catch (IOException e) {
				e.printStackTrace();
			}

			return answerFromServer;
		}
	}

	@Override
	public void close() throws Exception {
		if (socket != null)
			socket.close();
	}

}
