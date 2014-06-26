/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dtoAtividades;

/**
 *
 * @author gaoliveira
 */
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gaoliveira
 */

@Entity
@Table(name = "atividade", schema = "")
public class Atividade implements Serializable{
 
    private static final long serialVersionUID = 1L; 
    
    public Atividade(){}
    
    @Id
    @Basic(optional = false) @Column(name = "idAtividade")
    @GeneratedValue(strategy=GenerationType.AUTO)   
    private int idAtividade;
    
    private String descricao;
    private String codAtividade;
    private Double pontos;
    
    @ManyToOne
    @JoinColumn(name="idFormula")
    private Formula idFormula;

    @ManyToOne
    @JoinColumn(name="idAtividadeMae")
    private Atividade idAtividadeMae;
    
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "atividadeArea", 
    joinColumns = @JoinColumn(name = "idAtividade"), 
    inverseJoinColumns = @JoinColumn(name = "idArea"))
    private List<Area> listaArea;
    
    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodAtividade() {
        return codAtividade;
    }

    public void setCodAtividade(String codAtividade) {
        this.codAtividade = codAtividade;
    }

    public Double getPontos() {
        return pontos;
    }

    public void setPontos(Double pontos) {
        this.pontos = pontos;
    }

    public Formula getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(Formula idFormula) {
        this.idFormula = idFormula;
    }

    public Atividade getIdAtividadeMae() {
        return idAtividadeMae;
    }

    public void setIdAtividadeMae(Atividade idAtividadeMae) {
        this.idAtividadeMae = idAtividadeMae;
    }

//    public List<Area> getListaArea() {
//        return listaArea;
//    }
//
//    public void setListaArea(List<Area> listaArea) {
//        this.listaArea = listaArea;
//    }
}
