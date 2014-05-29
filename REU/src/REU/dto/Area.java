package REU.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private int id;
    
    private String Nome;
    private String Telefonecelular;
    private String Telefonecelular2;
    private String Telefonecelular3;
    private String Telefoneresidencial;
    private String Telefoneempresa;
    private String email;
    private String endereco;
    private String data;
    private String onservacao;
    
    
    @ManyToOne(optional=true) @JoinColumn(name = "nome_")
   private Area area;
      
      public Area(){
        
    }
      
}