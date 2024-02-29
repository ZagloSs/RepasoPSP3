package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import servidor.MainServidor;

public class MainCliente {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 6566);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);
			
			
			int guess = 0;
			boolean isGuessed=false;
			
			while(!isGuessed) {
				guess = sc.nextInt();
				dos.write(guess);
				isGuessed = dis.readBoolean();
			}
			
			System.out.println(dis.readUTF());
			
			
			socket.close();
			dis.close();
			dos.close();
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}

	}

}
