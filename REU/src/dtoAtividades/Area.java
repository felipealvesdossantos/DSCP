package dtoAtividades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Geovane
 */
@Entity
@Table(name = "area", schema = "")
public class Area implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    public Area(){}
    
    @Id
    @Basic(optional = false) @Column(name = "idArea")
    @GeneratedValue(strategy=GenerationType.AUTO)  
    private int idArea;
    
    private String descricao;
    private String codArea;
    
    @ManyToOne
    @JoinColumn(name="idArea")
    private Area idAreaMae;
    
    @ManyToOne
    @JoinColumn(name="idFormula")
    private Area idFormula;
    
    
    @ManyToMany(mappedBy="listaArea",fetch= FetchType.EAGER)
    private List<Atividade> listaAtividade;
    
    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public Area getIdAreaMae() {
        return idAreaMae;
    }

    public void setIdAreaMae(Area fkIdAreaMae) {
        this.idAreaMae = fkIdAreaMae;
    }
}