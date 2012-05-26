package br.com.rbh.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteTCP {

	public static void main(String[] args) throws Exception {
		String frase;
		String fraseModificada;

		BufferedReader doUsuario = new BufferedReader(new InputStreamReader(
				System.in));

		Socket socketCliente = SocketOpener.openSocket("localhost", 6789, 5000);

		DataOutputStream paraServidor = new DataOutputStream(
				socketCliente.getOutputStream());

		BufferedReader doServidor = new BufferedReader(new InputStreamReader(
				socketCliente.getInputStream()));

		frase = doUsuario.readLine();

		paraServidor.writeBytes(frase + '\n');

		fraseModificada = doServidor.readLine();

		System.out.println("Do servidor: " + fraseModificada);

		socketCliente.close();
	}
}
