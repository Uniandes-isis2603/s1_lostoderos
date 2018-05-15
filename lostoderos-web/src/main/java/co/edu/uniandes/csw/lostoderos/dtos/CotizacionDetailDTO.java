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

    private SolicitudDTO solicitud;
    
    

    public SolicitudDTO getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(SolicitudDTO solicitud) {
        this.solicitud = solicitud;
    }
    
    public CotizacionDetailDTO() {

        // El constructor está vació porque se recomienda tener un constructor vacio cuando la clase se representa en JSON.
    }

    public CotizacionDetailDTO(CotizacionEntity entity) {
        super(entity);
    }


    public CotizacionEntity toEntity(CotizacionEntity entity) {
        if(entity.getSolicitud() != null){
            this.solicitud= new SolicitudDTO(entity.getSolicitud());
        }else{
            entity.setSolicitud(null);
        }
        return super.toEntity(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
