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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author GAOliveira
 */
@Entity
@Table(name = "classe", schema = "")
public class Classe implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    public Classe(){}
    
    @Id
    @Basic(optional = false) @Column(name = "idClasse")
    @GeneratedValue(strategy=GenerationType.AUTO)    
    private int idClasse;
    
    private String descricao;
    private String tipo;
    private String idNiveis;

    
    
    @ManyToMany(mappedBy="listaClasse", fetch= FetchType.EAGER)
    private List<Docente> listaDocente;
 
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "classesNiveis", 
    joinColumns = @JoinColumn(name = "idClasse"), 
    inverseJoinColumns = @JoinColumn(name = "idNivel"))
    private List<Nivel> listaNiveis;

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Docente> getListaDocente() {
        return listaDocente;
    }

    public void setListaDocente(List<Docente> listaDocente) {
        this.listaDocente = listaDocente;
    }

    public List<Nivel> getListaNiveis() {
        return listaNiveis;
    }

    public void setListaNiveis(List<Nivel> listaNiveis) {
        this.listaNiveis = listaNiveis;
    }
    
    public String getIdNiveis() {
        return idNiveis;
    }

    public void setIdNiveis(String idNiveis) {
        this.idNiveis = idNiveis;
    }
}