public class Item {
    private int id;
    private String titulo;
    private String descricao;
    private String condicao;
    private String categoria;
    private double valorEstimado;
    private int idUsuario;

    public Item(String titulo, String descricao, String condicao, String categoria, double valorEstimado, int idUsuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.condicao = condicao;
        this.categoria = categoria;
        this.valorEstimado = valorEstimado;
        this.idUsuario = idUsuario;
    }

    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getCondicao() { return condicao; }
    public String getCategoria() { return categoria; }
    public double getValorEstimado() { return valorEstimado; }
    public int getIdUsuario() { return idUsuario; }
}
