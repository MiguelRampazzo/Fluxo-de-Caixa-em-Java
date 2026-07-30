package model;
import java.time.LocalDate;

public class Lancamento {
    private Integer id;
    private String descricao;
    private Double valor;
    private LocalDate data;
    private TipoLancamento tipo;

    // Construtor vazio
    public Lancamento() {}

    // Construtor completo
    public Lancamento(String descricao, Double valor, LocalDate data, TipoLancamento tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    // Getters e Setters (Use Alt+Insert no IntelliJ para gerar rápido)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public TipoLancamento getTipo() { return tipo; }
    public void setTipo(TipoLancamento tipo) { this.tipo = tipo; }
}