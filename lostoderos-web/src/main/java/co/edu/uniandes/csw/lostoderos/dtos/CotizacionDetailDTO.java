/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.CotizacionEntity;

/**
 *
 * @author m.saravia
 */
public class CotizacionDetailDTO extends CotizacionDTO {

    public CotizacionDetailDTO() {
        
        super();
    }
    
    public CotizacionDetailDTO(CotizacionEntity entity){
        
        super(entity);
    }

    @Override
    public CotizacionEntity toEntity() {
        return super.toEntity(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
