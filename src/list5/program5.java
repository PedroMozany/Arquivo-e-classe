package list5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class program5 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		// JA NO INICIO SOLICITEI O CAMINHO ONDE SERA SALVO O FORMULARIO � FICARA SALVO
		// EM UMA VARIALVEL FILE PARA SER FEITO A ESCRITA.
		System.out.println("Digite o caminho do arquivo aonde sera salvo: ");
		String arquivo = sc.nextLine();
		File texto = new File(arquivo);

		// VARIAVEL CODIGO INICIANDO COM ZERO
		int codigo = 0;

		// JA CHAMANDO A CLASSE PESSOA
		Pessoa person = new Pessoa();

// DECLRA��O DA VARIAVEL BOOBLEAN INICIALIZADA SENDO VERDADEIRA
		boolean Flag = true;

// METODO WHILE COM PARAMETRO ONDE FLAG PRECISAR SER VERDEIRO PARA O PROGRAMA REPETIR TODA ESTRUTURA. 
		while (Flag == true) {
//A CADA REPETI��O DO PROGRAMA SERA SOMADO MAIS UM NA VARIAVEL CODIGO 
			codigo += 1;
			// ESTRUTURA DE PREENCHEMENTO ONDE TODOS ITEM DA CLASSE PESSOA VAO SER
			// MOTIFICADOS.
			System.out.println("Preencha o formulario: ");
			person.setCodigo(codigo);
			// OBSERVA��O: AQUI COLOQUEI O PREENCHAMENTO DE LINHA A MAIS PARA SER CONSUMINDO
			// OU SEJA PARA INICIALIZAR REALMENTE O PROGRAMA � NECESSARIO DAR UM ENTER.
			sc.nextLine();
			// SOLICITA��ES DE ENTRAR
			System.out.println("Digite o seu nome: ");
			person.setNome(sc.nextLine());
			System.out.println("Digite a sua idade: ");
			person.setIdade(sc.nextInt());
			System.out.println("Digite o seu endere�o: ");
			sc.nextLine();
			person.setEndere�o(sc.nextLine());
			System.out.println("Digite algum complemento: ");
			person.setComplemento(sc.nextLine());
			System.out.println("Digite o seu numero: ");
			person.setNumero(sc.nextLine());

			// ESTRUTURA TRY; FIZ AS DECLARA��ES BufferedWriter E FileWriter NO PARAMENTRO
			// PARA PROGRAMA FICAR MAIS RAPITO E COSUMIR MENO LINHAS E PARA NAO TER
			// NECESSIDADE
			// DE DAR .CLOSE NO FINAL.
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(texto, true))) {

				PrintWriter printWriter = new PrintWriter(bw);

				// ULTILIZEI O printWriter QUE � UMA SOLU��O MAIS ELEGANTE PARA ESSE TIPO DE
				// PROGRAMA
				printWriter.println(person);
				System.out.println("Salvo com sucesso!!");

				printWriter.close();
				// TRATAMENTO DE EXCE��O PARA UMA POSSIVEL ERRO
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

			System.out.println("Deseja cadastrar mais pessoas? S/N ");

			// DECLARA��O DA METODO CHAR
			char m = sc.next().charAt(0);

			// ESTRUTURA DE CONDICIONAMENTO COM PARAMENTRO PARA TESTAR A CONDI��O � ALTERAR
			// O VALOR DA VARIAVEL BOOLEAN PARA FALSE E FINALIZAR O PROGRAMA OU CONDINUAR
			if (m == 'n' || m == 'N') {

				Flag = false;
				System.out.println("Programa finalizado!! ");

			} else {
				Flag = true;
			}

		}

		sc.close();
	}
}

// IMPLEMENTA��O DA CLASSE PESSOA 
class Pessoa {
	Scanner sc = new Scanner(System.in);

// DECLARA��O DOS ITEM DA CLASSE ONDE OS ACESSORES S�O PRIVATOS ONDE PERMITE SOMENTE A CLASSE TER ACESSO. 
	private int codigo, idade;
	private String numero;
	private String nome;
	private String endere�o;
	private String complemento;

	// CONSTRUTOR PADR�O
	public Pessoa() {
	}

// ESTRUTURAR DE GET E SET PARA OUTRAS CLASSE PODER TER ACESSO AOS CONTEUDOS � TBEM PODER MOTIFICAR OS CONTEUDOS. 
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNumero() {

		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

// METODO PARA FORMATAR A SAIDA DO ITENS DO PROGRAMA ONDE CADA ITENS VAI TER UMA QUEBRA DE LINHA � FICAR MAIS ELEGANTE VISUALMENTE. 
	public String toString() {
		return "C�digo:" + codigo + "\n" + "Nome:" + nome + "\n" + "Idade:" + idade + "\n" + "Endere�o:" + endere�o
				+ "\n" + "Numero:" + numero + "\n" + "Complemento:" + complemento;
	}

}
