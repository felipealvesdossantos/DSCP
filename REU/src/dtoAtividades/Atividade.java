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
    private Formula fkIdFormula;

    @ManyToOne
    @JoinColumn(name="idAtividade")
    private int fkIdAtividadeMae;
    
    @ManyToMany()
    @JoinTable(
    name="atividadeArea",
    joinColumns={@JoinColumn(name="fkIdAtividade", referencedColumnName="idAtividade")},
    inverseJoinColumns={@JoinColumn(name="fkIdArea", referencedColumnName="idAtividade")})
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

    public Formula getFkIdFormula() {
        return fkIdFormula;
    }

    public void setFkIdFormula(Formula fkIdFormula) {
        this.fkIdFormula = fkIdFormula;
    }

    public int getFkIdAtividadeMae() {
        return fkIdAtividadeMae;
    }

    public void setFkIdAtividadeMae(int fkIdAtividadeMae) {
        this.fkIdAtividadeMae = fkIdAtividadeMae;
    }

    public List<Area> getListaArea() {
        return listaArea;
    }

    public void setListaArea(List<Area> listaArea) {
        this.listaArea = listaArea;
    }
}
