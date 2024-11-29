public class Produto {
    private String tipo;
    private String descricao;
    private double peso;
    private int quantidade;
    private String unidade;

    public Produto(String tipo, String descricao, double peso, int quantidade, String unidade) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.peso = peso;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPeso() {
        return peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getUnidade() {
        return unidade;
    }
}
