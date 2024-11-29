import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ProdutoDB produtoDB = new ProdutoDB();

            System.out.println("Cadastro de Produtos:");

            for (int i = 0; i < 5; i++) {
                System.out.print("Informe o tipo do produto: ");
                String tipo = scanner.nextLine();

                System.out.print("Informe a descrição do produto: ");
                String descricao = scanner.nextLine();

                System.out.print("Informe o peso do produto (em kg): ");
                double peso = scanner.nextDouble();

                System.out.print("Informe a quantidade do produto em estoque: ");
                int quantidade = scanner.nextInt();

                System.out.print("Informe a unidade de medida (metro, metro quadrado, litro, kg): ");
                String unidade = scanner.next();
                scanner.nextLine();  // Consumir a quebra de linha

                Produto produto = new Produto(tipo, descricao, peso, quantidade, unidade);
                produtoDB.inserirProduto(produto);

                System.out.println("Produto cadastrado com sucesso!\n");
            }

            System.out.println("Produtos cadastrados:");
            produtoDB.listarProdutos();

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
