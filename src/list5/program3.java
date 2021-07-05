package list5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class program3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//SOLICTAÇÃO DO CAMINHO DO ARQUIVO
		System.out.println("Enter a origin file: ");
		String arquivo1 = sc.nextLine();

//SOLICITAÇÃO DA ONDE O ARQUIVO SERA COPIADO OU CRIADO 		
		System.out.println("Enter a copy file: ");
		String arquivo2 = sc.nextLine();

// ESTRUTURA TRY PARA TRATAR A LEITURA DO ARQUIVO É ESCRITA 
		try {
// PEGANDO A ENTRADA DO ARQUIVO E ADD EM UMA VARIAVEL FILE É LENDO COM SCANNER
			File texto = new File(arquivo1);
			Scanner origin = new Scanner(texto);
//METODO FileWriter PARA PEGAR O CAMINHO DO ARQUIVO ONDE SERA COPIANDO 
			FileWriter copy = new FileWriter(arquivo2);
// DECLARAÇÃO DA VARIAVEL LINHA PARA AUXILIAR NA ESCRITA DO ARQUIVO 
			String linha;
//ESTRUTURA WHILE DE REPIÇÃO PARA LER CADA LINHA DO ARQUIVO ORIGIAL É COPIAR CADA LINHA PARA O ARQUIVO COPY
			while (origin.hasNextLine()) {
				linha = origin.nextLine();
				copy.write(linha + "\n");
			}
			System.out.println("Successful copy!!");
// FECHANDO AS ESTRUTURAS E SALVANDO. 
			origin.close();
			copy.close();

// TRATANDO EXCEÇÕES 			
		} catch (IOException e) {
			System.out.println("Erro " + e.getMessage());
		}

		sc.close();
	}
}
