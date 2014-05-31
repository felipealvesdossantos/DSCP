/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REU.dto;

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
 * @author GAOliveira
 */
@Entity
@Table(name = "classe", schema = "")
public class Classes implements Serializable{
    
    @Id
    @Basic(optional = false) @Column(name = "idClasse")
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private int idClasse;
    private String descricao;
    private String tipo;
    
 @ManyToMany(mappedBy="classe")
    private List<Docente> docente;
 
 @ManyToMany
    @JoinTable(name = "classesNiveis", joinColumns = @JoinColumn(name = "idClasse"), inverseJoinColumns = @JoinColumn(name = "IdNiveis"))
    private List<Niveis> niveis;
    
      public Classes(){
        
    }
      
}