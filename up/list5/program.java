package list5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//SOLICITAÇÃO DO CAMINHO ONDE SERA SALVO 
		System.out.println("Digite o caminho do arquivo aonde sera salvo: ");
		String arquivo = sc.nextLine();
		File texto = new File(arquivo);

//CHAMNDO A CLASSE PESSOA
		person pessoa = new person();

//METODO DE REPETIÇÃO PARA PREENCHER O CADASTRO COM 10 PESSOAS
		for (int i = 0; i <= 9; i++) {
			System.out.println("Qual é o seu nome? ");
			pessoa.setNome(sc.nextLine());
			System.out.println("Qual é a sua data de nascimento? ");
			pessoa.setBirthDate(sdf.parse(sc.next()));
			sc.nextLine();
			System.out.println(pessoa.month());

			// ESTRUTURA TRY PARA TRATAR A ESCRITA SAVANDO SEM PAGAR O QUE JA EXISTE
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(texto, true))) {
				PrintWriter printWriter = new PrintWriter(bw);

				printWriter.println(pessoa.month());
				printWriter.close();
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
		}

		sc.close();
	}
}

// CRIAÇÃO DA CLASSE PESSOA 
class person {
	// DELARAÇÃO DA VARIAVEL COMO PRIVATAS PARA SOMENTE A CLASSE TER ACESSO
	private String nome;
	private Date birthDate;

// IMPORTAÇÃO DA CLASSE SimpleDateFormat PARA FORMANTAR A DATA PARA O PADRÃO NORMAL 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();

// CONSTRUTOR PADRÃO 
	public person() {

	}

	// ESTRUTURAR DE GET E SET PARA OUTRAS CLASSE PODER TER ACESSO AOS CONTEUDOS É
	// TBEM PODER MOTIFICAR OS CONTEUDOS.
	public String getNome() {
		return nome;
	}

	public void setNome(String string) {
		this.nome = string;
	}

	public Date getBirthDate() {

		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	// METODO PARA FORMATAR A SAIDA DO ITENS DO PROGRAMA
	public String toString() {
		return nome + " " + sdf.format(birthDate);
	}

	// METODO PARA TESTAR MÊS DE ANIVERSARIO DE CADA PESSOA.
	public String month() {
		cal.setTime(getBirthDate());
		int month = cal.get(Calendar.MONTH) + 1;

		if (1 == month) {
			return ("Janeiro: " + "\n" + toString());
		} else if (2 == month) {
			return ("Feveiro:" + "\n" + toString());
		} else if (3 == month) {
			return ("Março:" + "\n" + toString());
		} else if (4 == month) {
			return ("Abril:" + "\n" + toString());
		} else if (5 == month) {
			return ("Maio:" + "\n" + toString());
		} else if (6 == month) {
			return ("Junho:" + "\n" + toString());
		} else if (7 == month) {
			return ("Julho:" + "\n" + toString());
		} else if (8 == month) {
			return ("Agosto:" + "\n" + toString());
		} else if (9 == month) {
			return ("Setembro:" + "\n" + toString());
		} else if (10 == month) {
			return ("Outubro:" + "\n" + toString());
		} else if (11 == month) {
			return ("Novembro:" + "\n" + toString());
		} else if (12 == month) {
			return ("Dezembro:" + "\n" + toString());
		}

		return nome;

	}
}
