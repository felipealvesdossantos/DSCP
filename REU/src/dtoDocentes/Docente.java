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
@Table(name = "docente", schema = "")
public class Docente implements Serializable{
    
    @Id
    @Basic(optional = false) @Column(name = "idDocente")
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private int idDocente;
    private String nome;

    
    @ManyToOne(optional=true) @JoinColumn(name = "nomeDocente")
   private Docente docente;
      
    
    @ManyToMany
    @JoinTable(name = "docenteClasses", joinColumns = @JoinColumn(name = "idDocente"), inverseJoinColumns = @JoinColumn(name = "IdClasse"))
    private List<Classe> classe;
    
      public Docente(){
        
    }
      
}
