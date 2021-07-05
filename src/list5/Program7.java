package list5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program7 {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		// IPORTANDO A CLASSE ArrayList PARA FACILITAR A MANIPULA플O DE VETORES JA ADD A
		// CLASSE ELETRODOMESTICO
		List<Eletrodomestico> list = new ArrayList<>();
		
// SOLICITANDANDO O CAMINHO DO ARQUIVO  
		System.out.println("Enter with file: ");
		String arquivo = sc.nextLine();
		
// ESTRUTURA TRY PARA TRATAR A LEITURA DO ARQUIVO
		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
			
// DECLARA플O DE VARIAVEIS
			double soma = 0, media = 0;
			int val = 0;

			String itemCsv = br.readLine();
			
// METODO WHILE ONDE VAI REPITIR ENQUANDO A LINHAS FOREM DIFERENTES DE NULL 
			while (itemCsv != null) {
				
// A CADA LEITURA DE LINHA SERA SOMADO +1 NA VARIAVEL VAL 
				val++;
				String[] fields = itemCsv.split(",");

				String store = fields[0];
				String phone = fields[1];
				String name = fields[2];
				double price = Double.parseDouble(fields[3]);
				
//PEGANDO CADA VALOR QUE FOREM SENDO ADICIONA NA LISTA E SOMANDO
				soma += price;
				list.add(new Eletrodomestico(name, store, price, phone));
				itemCsv = br.readLine();
			}
// PEGANDO A SOMA DOS VALORES E DIVIDINDO PELO NUMERO DE LINHA/LOJAS
			media = soma / val;
			
//SOLICITANDO CAMINHO ONDE SERA SALVO O NOVO ARQUIVO 
			System.out.println("Where will be saved!! ");
			String saved = sc.nextLine();
			
//ESTRUTURA TRY PARA TRATAR A ESCRITA DO ARQUIVO 
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(saved))) {
				
// ESCREVENDO A MEDIA DOS VALORES 
				bw.write("media: " + String.format("%.2f", media) + "\n");
				bw.write("LOJAS QUE NAO OBTIVERAM A MEDIA" + "\n");
				
// CONDICIONAMENTO PARA TESTA QUAL LOJA OBTEVE O VALOR ABAIXO DA MEDIA 
				for (Eletrodomestico item : list) {
					if (item.getPrice() < media) {
						bw.write("loja:" + item.getStore() + " tel:" + item.getPhone());
						bw.newLine();
					}

				}

				System.out.println(saved + " Successful saved!!");

			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();
	}
}
// CRIAN플O DA CLASS ELETRODOMESTICO
class Eletrodomestico {
	
//DECLARA플O DAS VARIAVEIS SENDO TODAS PRIVATE ONDE SOMENTE A CLASSE TEM ACESSO 
	private String name;
	private String store;
	private Double price;
	private String phone;
	
//CRIA플O DO CONSTRUTOR COM PARAMENTRO 
	public Eletrodomestico(String name, String store, Double price, String phone) {
		this.name = name;
		this.store = store;
		this.price = price;
		this.phone = phone;
	}
//DECLARA합ES DE GET E SET ONDE TODOS OS ITEM S홒 ACESSIVEIS A TODAS AS CLASSES 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPhone() {
		return phone;
	}

	public void setFone(String phone) {
		this.phone = phone;
	}

}
