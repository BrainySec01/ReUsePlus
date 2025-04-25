import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InteresseDAO {

    public static void cadastrar(Interesse interesse) {
        String sql = "INSERT INTO interesses (categoria, prioridade, id_usuario) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, interesse.getCategoria());
            stmt.setInt(2, interesse.getPrioridade());
            stmt.setInt(3, interesse.getIdUsuario());
            stmt.executeUpdate();
            System.out.println("Interesse cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar interesse: " + e.getMessage());
        }
    }

    public static void listar(int idUsuario) {
        String sql = "SELECT * FROM interesses WHERE id_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Seus interesses:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("categoria") + " | Prioridade: " + rs.getInt("prioridade"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar interesses: " + e.getMessage());
        }
    }

    public static void remover(int idUsuario, String categoria) {
        String sql = "DELETE FROM interesses WHERE id_usuario = ? AND categoria = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setString(2, categoria);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("Interesse removido com sucesso!");
            } else {
                System.out.println("Interesse não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover interesse: " + e.getMessage());
        }
    }
}