/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.blancoc
 */
@Entity
public class ContratoEntity extends BaseEntity implements Serializable {
  
    @PodamExclude 
    @OneToOne(mappedBy = "contrato", fetch = FetchType.LAZY)
     private ContratistaEntity contratista;

    /**
     * @return the contratista
     */
    public ContratistaEntity getContratista() {
        return contratista;
    }

    /**
     * @param contratista the contratista to set
     */
    public void setContratista(ContratistaEntity contratista) {
        this.contratista = contratista;
    }
    
    
    
    
    
}
