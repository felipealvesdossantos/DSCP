package dtoAtividades;

/**
 *
 * @author gaoliveira
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gaoliveira
 */
@Entity
@Table(name = "atividade", schema = "")
public class Atividade implements Serializable {

    private static final long serialVersionUID = 2L;

    public Atividade() {
    }

    @Id
    @Column(name = "idAtividade")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAtividade;

    private String codigo;

    private String descricao;

    @Column(nullable = true)
    private Double pontos;

    @Column(nullable = true)
    private int idAtividadeMae;

    private int idFormula;

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPontos() {
        return pontos;
    }

    public void setPontos(Double pontos) {
        this.pontos = pontos;
    }

    public int getIdAtividadeMae() {
        return idAtividadeMae;
    }

    public void setIdAtividadeMae(int idAtividadeMae) {
        this.idAtividadeMae = idAtividadeMae;
    }

    public int getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(int idFormula) {
        this.idFormula = idFormula;
    }
}
