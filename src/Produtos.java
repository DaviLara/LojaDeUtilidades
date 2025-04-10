public class Produtos {
    private String Nome;
    private Integer Quantidade;
    private Double Preco;

    
    

    public String getNome() {

        return Nome;
    }
    public void setNome(String nome) {

        Nome = nome;
    }

    public Integer getQuantidade() {

        return Quantidade;
    }
    public void setQuantidade(Integer quantidade) {

        Quantidade = quantidade;
    }

    public Double getPreco() {
        return Preco;
    }
    public void setPreco(Double preco) {

        Preco = preco;
    }

    public Produtos(String nome, Integer quantidade, Double preco) {
        this.Nome = nome;
        this.Quantidade = quantidade;
        this.Preco = preco;
    }


    public String toString() {
        return 
        "Título: " + Nome + 
        ", Quantidade: " + Quantidade + 
        ", Preço: " + Preco;
    }
}
