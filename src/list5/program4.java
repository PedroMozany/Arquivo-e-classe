package list5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class program4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// DECLARAÇÃO DE VARIAVEL
		int quant = 0, quntLinha = 0;

		// SOLICITAÇÃO DE ENTRADA DE DADOS
		System.out.println("Palavra a ser Localizada: ");
		String chave = sc.nextLine();

		System.out.println("Enter a file: ");
		String entrada = sc.nextLine();

		// PEGUEI O CANHINHO QUE FOI DIGITADO NO CONSOLE E SALVEI EM UM FILE PARA
		// REALIZAR LEITURA DO ARQUIVO
		File arquivo = new File(entrada);

		// ESTRUTURA TRY PARA TRATAR POSSIVEIS EXCEÇÕES DE LEITURA NO ARQUIVO
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

			// PEGUEI O ARQUIVO QUE FOI LIDO PELO METO BUFFER E SALVEI EM UMA STRING PARA
			// SER MANIPULADO
			String linhas = br.readLine();

			// METO WHILE
			while (linhas != null) {

				// SALVANDO CADA PALVRA EM UM VETOR
				String[] texto = linhas.split(entrada);
// PREENCHENDO O VETOR CONTATO O NUMERO DE LINHAS CONDICIONAMENTO PARA COMPARAR A PALVRA CHAVE COM CADA PALAVRA DO TEXTO E RETORNA IINFOMANDO A LINHA E QUANTAS VEZ APARECE NO TEXTO.
				for (int i = 0; i < texto.length; i++) {
					quntLinha++;
					if (texto[i].equals(chave)) {
						quant++;
						System.out
								.println(texto[i] + " " + "Quantidade" + " " + quant + " " + "Linha" + " " + quntLinha);

					}

				}
				linhas = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Erro " + e.getMessage());
		}

		sc.close();
	}
}
