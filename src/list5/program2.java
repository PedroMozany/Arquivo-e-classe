package list5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//SOLICITANDO CAMINHO DO ARQUIVO 1
		System.out.println("Enter a file1: ");
		String texto1 = sc.nextLine();

// CRIANDO OBJETO DO TIPO FILE	RETURNANDO O CAMINHO QUE FOI INSERIDO
		File file1 = new File(texto1);

//ULTILIZANDO METODO TRY PARA TRATAR UM POSSIVEL EXCEÇÃO
		try {

//ULTILIZANDO CLASS LineNumberReader PARA CONTAR NUMERO DE LINHAS QUE UM ARQUIVO TEM.			
			LineNumberReader lnr = new LineNumberReader(new FileReader(file1));

			lnr.skip(file1.length());

//PEGUEI O RESOLTADO DO NUMEROS LINHAS SOME COM  MAIS 1 PARA INICIAR COM 1 EM VEZ DE 0 PARA  DAR QUANTIDADE ACIMA DE 0 É SALVEI EM INTEIRO  		
			int linhas = lnr.getLineNumber() + 1;

			System.out.println("Quantidade de linhas: " + linhas);

			lnr.close();
		} catch (IOException e) {
			System.out.println("Erro " + e.getMessage());
		}

		sc.close();
	}
}
