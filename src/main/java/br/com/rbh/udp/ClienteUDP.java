package br.com.rbh.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {

	public static void main(String[] args) throws Exception {
		BufferedReader doUsuario = new BufferedReader(new InputStreamReader(
				System.in));

		DatagramSocket socketCliente = new DatagramSocket();

		InetAddress ipAddress = InetAddress.getByName("localhost");

		byte[] dadosEnvio = new byte[1024];
		byte[] dadosRecebido = new byte[1024];

		String frase = doUsuario.readLine();

		dadosEnvio = frase.getBytes();

		DatagramPacket pacoteEnviado = new DatagramPacket(dadosEnvio,
				dadosEnvio.length, ipAddress, 9876);

		socketCliente.send(pacoteEnviado);

		DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebido,
				dadosRecebido.length);

		socketCliente.receive(pacoteRecebido);

		String fraseModificada = new String(pacoteRecebido.getData());

		System.out.println("Do servidor: " + fraseModificada);

		socketCliente.close();
	}
}
