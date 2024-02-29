package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import cliente.HiloCliente;
import guessed.Guessed;

public class MainServidor {
	public static ArrayList<HiloCliente> hilosClientes = new ArrayList<HiloCliente>();
	public static void main(String[] args) {
		
		Random r = new Random();
		int randomNumber = r.nextInt(1,11);
		
		Guessed guess = new Guessed(false);
		
		try(ServerSocket serverSocket = new ServerSocket(6566)){
			while(true) {
				Socket socketClient = serverSocket.accept();
				HiloCliente hiloCliente = new HiloCliente(socketClient,randomNumber, guess);
				hilosClientes.add(hiloCliente);
				System.out.println(hiloCliente.getSocket());
				hilosClientes.get(hilosClientes.size()-1).start();
			}

		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	

}
