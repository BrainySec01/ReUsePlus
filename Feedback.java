public class Feedback {
    private int id;
    private int idUsuario;
    private int idTroca;
    private String comentario;
    private int avaliacao;  // Rating from 1 to 5

    public Feedback(int idUsuario, int idTroca, String comentario, int avaliacao) {
        this.idUsuario = idUsuario;
        this.idTroca = idTroca;
        this.comentario = comentario;
        this.avaliacao = avaliacao;
    }

    public void salvar() {
        // Save feedback to the database
        String sql = "INSERT INTO feedback (id_usuario, id_troca, comentario, avaliacao) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, this.idUsuario);
            stmt.setInt(2, this.idTroca);
            stmt.setString(3, this.comentario);
            stmt.setInt(4, this.avaliacao);
            stmt.executeUpdate();
            System.out.println("Feedback salvo com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar feedback: " + e.getMessage());
        }
    }
}