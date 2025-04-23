import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO {
    public static void cadastrar(Item item) {
        String sql = "INSERT INTO itens (titulo, descricao, condicao, categoria, valor_estimado, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getTitulo());
            stmt.setString(2, item.getDescricao());
            stmt.setString(3, item.getCondicao());
            stmt.setString(4, item.getCategoria());
            stmt.setDouble(5, item.getValorEstimado());
            stmt.setInt(6, item.getIdUsuario());
            stmt.executeUpdate();
            System.out.println("Item cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar item: " + e.getMessage());
        }
    }

    public static void listarItensDoUsuario(int idUsuario) {
        String sql = "SELECT * FROM itens WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Seus itens:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("titulo") + " | " + rs.getString("categoria") +
                        " | " + rs.getString("condicao") + " | R$" + rs.getDouble("valor_estimado"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar itens: " + e.getMessage());
        }
    }
}
