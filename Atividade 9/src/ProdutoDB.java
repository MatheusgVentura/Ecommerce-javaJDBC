import java.sql.*;

public class ProdutoDB {
    private Connection connection;

    // Construtor para estabelecer a conexão com o banco de dados
    public ProdutoDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/ecommerce";
            String user = "root";
            String password = "Matheus2005";

            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar com o banco de dados", e);
        }
    }

    public void inserirProduto(Produto produto) {
        String sql = "INSERT INTO produtos (tipo, descricao, peso, quantidade, unidade) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPeso());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setString(5, produto.getUnidade());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Produto cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    public void listarProdutos() {
        String sql = "SELECT * FROM produtos";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("+----+------------------------+------------------------------------+-------+-----------+---------------------+");
            System.out.printf("| %-2s | %-22s | %-34s | %-5s | %-9s | %-18s |\n", "ID", "Tipo", "Descrição", "Peso", "Qtd", "Unidade");
            System.out.println("+----+------------------------+------------------------------------+-------+-----------+---------------------+");

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String descricao = rs.getString("descricao");
                double peso = rs.getDouble("peso");
                int quantidade = rs.getInt("quantidade");
                String unidade = rs.getString("unidade");

                System.out.printf("| %-2d  | %-22s | %-34s | %-5.2f | %-9d | %-18s |\n", id, tipo, descricao, peso, quantidade, unidade);
            }
            System.out.println("+----+------------------------+------------------------------------+-------+-----------+---------------------+");
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
    }
}
