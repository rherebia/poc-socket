package br.com.rbh.tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public static void main(String[] args) throws Exception {
		ServerSocket socketRecepcao = new ServerSocket(6789);

		while (true) {
			Socket socketConexao = socketRecepcao.accept();

			Recepcao recepcao = new Recepcao(socketConexao);

			new Thread(recepcao).start();
		}
	}
}
