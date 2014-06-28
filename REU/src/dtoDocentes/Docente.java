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
import javax.persistence.Table;

/**
 *
 * @author gaoliveira
 */

@Entity
@Table(name = "docente", schema = "")
public class Docente implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    public Docente(){}
    
    @Id
    @Basic(optional = false) @Column(name = "idDocente")
    @GeneratedValue(strategy=GenerationType.AUTO)    
    private int idDocente;
    
    private String nome;
       
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "docenteClasses", 
    joinColumns = @JoinColumn(name = "idDocente"), 
    inverseJoinColumns = @JoinColumn(name = "idClasse"))
    private List<Classe> listaClasse;

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Classe> getListaClasse() {
        return listaClasse;
    }

    public void setListaClasse(List<Classe> listaClasse) {
        this.listaClasse = listaClasse;
    }  
}
