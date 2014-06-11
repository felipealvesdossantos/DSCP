/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

/**
 *
 * @author gaoliveira
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "subArea", schema = "")
public class Subarea implements Serializable{
    
    @Id
    @Basic(optional = false) @Column(name = "idSubarea")
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private int idSubarea;
    private String descricao;
    private String codSubarea;
  

    @ManyToOne
 @JoinColumn(name="idArea", referencedColumnName="idArea")
 private Area area;
    
    @ManyToMany
    @JoinTable(name = "subAreaAtividades", joinColumns = @JoinColumn(name = "idSubarea"), inverseJoinColumns = @JoinColumn(name = "IdAtividades"))
    private List<Atividades> atividades;
      
      public Subarea(){
        
    }
      
}
