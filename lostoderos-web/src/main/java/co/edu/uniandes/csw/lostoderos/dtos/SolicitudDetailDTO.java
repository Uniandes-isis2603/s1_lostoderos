/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

/**
 *
 * @author m.saravia
 */
public class SolicitudDetailDTO extends SolicitudDTO{

    public SolicitudDetailDTO() {
        
        super();
    }
    
    /**
     * pago de la solicitud
     */
    private PagoDTO info_pago;

    /**
     * el pago que se desee
     * @return info_pago
     */
    public PagoDTO getInfo_pago() {
        return info_pago;
    }

    /**
     * pago a cambiar
     * @param info_pago pago que se desea
     */
    public void setInfo_pago(PagoDTO info_pago) {
        this.info_pago = info_pago;
    }
    
    
    
}
