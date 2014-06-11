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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gaoliveira
 */

@Entity
@Table(name = "atividades", schema = "")
public class Atividades implements Serializable{
    
    @Id
    @Basic(optional = false) @Column(name = "idAtividades")
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private int idAtividades;
    private String descricao;
    private String codAtividade;
    private Double pontos;

    @ManyToMany(mappedBy="atividades")
    private List<Subarea> subarea;
 
      
      public Atividades(){
        
    }
      
}
