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

    /**
     * Solicitud que le corresponde a la cotizacion
     */
    private SolicitudDTO solicitud;
    
    /**
     * solicitud de la cotizacion
     * @return solicitud
     */
    public SolicitudDTO getSolicitud() {
        return solicitud;
    }

    /**
     * 
     * @param solicitud solicitud que se desea establecer
     */
    public void setSolicitud(SolicitudDTO solicitud) {
        this.solicitud = solicitud;
    }
    
    /**
     * constructor vacio
     */
    public CotizacionDetailDTO() {

        // El constructor está vació porque se recomienda tener un constructor vacio cuando la clase se representa en JSON.
    }

    /**
     * contructor de cotizacion
     * @param entity entidad que se 
     */
    public CotizacionDetailDTO(CotizacionEntity entity) {
        super(entity);
    }

    /**
     * metodo que convierte el obj json en una entidad
     * @param entity entidad que se vuelve un obj json
     * @return entidad de cotizacion
     */
    public CotizacionEntity toEntity(CotizacionEntity entity) {
        if(entity.getSolicitud() != null){
            this.solicitud= new SolicitudDTO(entity.getSolicitud());
        }else{
            entity.setSolicitud(null);
        }
        return super.toEntity(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return string del objeto con sus atributos
     */
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
