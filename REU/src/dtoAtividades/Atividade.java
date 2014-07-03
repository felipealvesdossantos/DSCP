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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gaoliveira
 */

@Entity
@Table(name = "atividade", schema = "")
public class Atividade implements Serializable {
 
    private static final long serialVersionUID = 2L; 
    
    public Atividade(){}
    
    @Id
    @Column(name = "idAtividade")
    @GeneratedValue(strategy=GenerationType.AUTO)   
    private int idAtividade;
    
    @Column(unique = true)
    private String codigo;
    
    private String codigoMae;
    private String descricao;
    private Double pontos;
    
    
    @ManyToOne
    @JoinColumn(name="idFormula")
    private Formula idFormula;

    @ManyToOne  
    private Atividade idAtividadeMae;

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

    public String getCodigoMae() {
        return codigoMae;
    }

    public void setCodigoMae(String codigoMae) {
        this.codigoMae = codigoMae;
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

    public Formula getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(Formula idFormula) {
        this.idFormula = idFormula;
    }
<<<<<<< HEAD

    public Atividade getIdAtividadeMae() {
        return idAtividadeMae;
    }

    public void setIdAtividadeMae(Atividade idAtividadeMae) {
        this.idAtividadeMae = idAtividadeMae;
    }
=======
    
    public Atividade getIdAtividadeMae() {
        return idAtividadeMae;
    }
>>>>>>> 50f296535517197c34be158b0c32383b00cc7a26
}