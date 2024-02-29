package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import guessed.Guessed;
import servidor.MainServidor;

public class HiloCliente extends Thread{
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	private int rNumber;
	private boolean guessed = false;
	private Guessed guessClass;
	
	
	public HiloCliente(Socket socket, int rNumber, Guessed guess) {
		super();
		this.socket = socket;
		this.rNumber = rNumber;
		this.guessClass = guess;
		
	}

	public void run() {
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			int guess = 0;
			
			while(!guessed) {
				guess = dis.read();
				if(guess == rNumber) {
					guessed = true;
					dos.writeBoolean(true);
				}else {
					dos.writeBoolean(false);
				}
			}
			
			if(!guessClass.isGuessed()) {
				guessClass.setGuessed(true);
				dos.writeUTF("Lo adivinaste el primero");
			}else {
				dos.writeUTF("vaya, ya lo adivino alguien antes");
			}
			
			dis.close();
			dos.close();
			socket.close();
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public boolean getGuessed() {
		return guessed;
	}
}
