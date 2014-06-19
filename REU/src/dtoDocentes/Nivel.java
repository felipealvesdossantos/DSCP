/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dtoDocentes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author GAOliveira
 */
@Entity
@Table(name = "nivel", schema = "")
public class Nivel implements Serializable{
    
    private static final long serialVersionUID = 1L; 
   
    public Nivel(){}
    
    @Id
    @Basic(optional = false) @Column(name = "idNivel")
    @GeneratedValue(strategy=GenerationType.AUTO) 
    private int idNivel;
    
    private String descricao;
    
    @ManyToMany(mappedBy="listaNiveis", fetch= FetchType.EAGER)
    private List<Classe> listaClasse;

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Classe> getListaClasse() {
        return listaClasse;
    }

    public void setListaClasse(List<Classe> listaClasse) {
        this.listaClasse = listaClasse;
    }
}