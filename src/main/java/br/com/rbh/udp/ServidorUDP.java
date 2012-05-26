package br.com.rbh.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServidorUDP {

	public static void main(String[] args) throws Exception {

		DatagramSocket socketServidor = new DatagramSocket(9876);

		byte[] dadosRecebidos = new byte[1024];
		byte[] dadosEnviados = new byte[1024];

		while (true) {
			DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebidos,
					dadosRecebidos.length);

			socketServidor.receive(pacoteRecebido);

			String frase = new String(pacoteRecebido.getData());

			InetAddress ipAddress = pacoteRecebido.getAddress();

			int porta = pacoteRecebido.getPort();

			String fraseEmMaiusculas = frase.toUpperCase();

			dadosEnviados = fraseEmMaiusculas.getBytes();

			DatagramPacket pacoteEnviado = new DatagramPacket(dadosEnviados,
					dadosEnviados.length, ipAddress, porta);

			socketServidor.send(pacoteEnviado);
		}
	}
}
