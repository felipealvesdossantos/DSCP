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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author GAOliveira
 */
@Entity
@Table(name = "niveis", schema = "")
public class Niveis implements Serializable{
    
    @Id
    @Basic(optional = false) @Column(name = "idniveis")
    @GeneratedValue(strategy=GenerationType.AUTO)
    

    private int idNiveis;
    private String descricao;
    
    

    @ManyToMany(mappedBy="niveis")
    private List<Classes> classe;
 
    
      public Niveis(){
        
    }
      
}