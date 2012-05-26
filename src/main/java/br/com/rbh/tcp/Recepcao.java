package br.com.rbh.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Recepcao implements Runnable {

	private Socket socketConexao;

	public Recepcao(Socket socketConexao) {
		this.socketConexao = socketConexao;
	}

	public void run() {
		String fraseCliente;
		String fraseEmMaiusculas;

		try {
			BufferedReader doCliente = new BufferedReader(
					new InputStreamReader(socketConexao.getInputStream()));

			DataOutputStream paraCliente = new DataOutputStream(
					socketConexao.getOutputStream());

			fraseCliente = doCliente.readLine();

			fraseEmMaiusculas = fraseCliente.toUpperCase() + '\n';

			paraCliente.writeBytes(fraseEmMaiusculas);
		} catch (Exception e) {

		}
	}

}
