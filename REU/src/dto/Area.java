package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * @author Geovane
 */
@Entity
@Table(name = "area", schema = "")
public class Area implements Serializable{
    
    @Id
    @Basic(optional = false) @Column(name = "id_area")
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private int idArea;
    private String descricao;
    private String codArea;

    
    @OneToMany(mappedBy="area")
 private List<Subarea> listaProdutos;

      
      public Area(){
        
    }
      
}