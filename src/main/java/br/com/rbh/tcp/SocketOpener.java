package br.com.rbh.tcp;

import java.io.IOException;
import java.net.Socket;

public class SocketOpener implements Runnable {

	private String host;
	private Integer port;
	private Socket socket;

	private SocketOpener(String host, Integer port) {
		this.host = host;
		this.port = port;
	}

	public void run() {
		try {
			this.socket = new Socket(host, port);
		} catch (IOException e) {

		}
	}

	public Socket getSocket() {
		return socket;
	}

	public static Socket openSocket(String host, Integer port, Integer timeout) {
		SocketOpener opener = new SocketOpener(host, port);
		Thread t = new Thread(opener);

		t.start();

		try {
			t.join(timeout);
		} catch (InterruptedException e) {

		}

		return opener.getSocket();
	}
}
