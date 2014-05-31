/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REU.dto;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "formula", schema = "")
public class Formula implements Serializable{
    
    @Id
    @Basic(optional = false) @Column(name = "idFormula")
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private int idFormula;
    private String descricao;
    
 

      public Formula(){
        
    }
      
}
