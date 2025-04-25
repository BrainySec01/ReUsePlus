public class Interesse {
    private int id;
    private String categoria;
    private int prioridade;
    private int idUsuario;

    public Interesse(String categoria, int prioridade, int idUsuario) {
        this.categoria = categoria;
        this.prioridade = prioridade;
        this.idUsuario = idUsuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
}