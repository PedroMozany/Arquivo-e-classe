package list5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class program1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
//SOLICITANDO CAMINHO DO ARQUIVO 1
		System.out.println("Enter a file1: ");
		String texto1 = sc.nextLine();
		
//SOLICITANDO CAMINHO DO ARQUIVO 2	
		System.out.println("Enter a file2: ");
		String texto2 = sc.nextLine();
		
// CRIANDO OBJETO DO TIPO PATH	RETURNANDO O CAMINHO QUE FOI INSERIDO
		Path file1 = Paths.get(texto1);
		Path file2 = Paths.get(texto2);
		
//ULTILIZANDO METODO TRY PARA TRATAR UM POSSIVEL EXCEÇÃO
		try {
			byte[] line1 = Files.readAllBytes(file1);
			byte[] line2 = Files.readAllBytes(file2);
			
			
			String leitura1 = new String(line1);
			String leitura2 = new String(line2);
			
			System.out.println(leitura1);
			System.out.println(leitura2);
			
			
//CONDICIONAMENTO PARA VERIFIAR BYTE A BYTE PARA SABER SE SÃO IGUAIS OU DIFERENTES
			if(line1.length == line2.length) {
				System.out.println("Iguais");
			}else {
				System.out.println("Diferentes");
			}

		} catch (IOException e) {
			System.out.println("Erro " + e.getMessage());
		}
		
	
		
		
sc.close();
	}
}
