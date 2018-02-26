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

    
    /**
     * 
     */
    private ServicioDTO servicio;
    
    /**
     * 
     */
    private FacturaDTO factura;
    
    /**
     * 
     */
    private CotizacionDTO cotizacion;
    
    /**
     * 
     */
    private ContratistaDTO contratista;
    public SolicitudDetailDTO() {
        
        super();
    }
    
    /**
     * 
     * @return 
     */
    public ServicioDTO getServicio() {
        return servicio;
    }
    
    /**
     * 
     * @param servicio 
     */
    public void setServicio(ServicioDTO servicio) {
        this.servicio = servicio;
    }
    
    /**
     * 
     * @return 
     */
    public FacturaDTO getFactura() {
        return factura;
    }
    
    /**
     * 
     * @param factura 
     */
    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }
    
    /**
     * 
     * @return 
     */
    public CotizacionDTO getCotizacion() {
        return cotizacion;
    }

    /**
     * 
     * @param cotizacion 
     */
    public void setCotizacion(CotizacionDTO cotizacion) {
        this.cotizacion = cotizacion;
    }

    /**
     * 
     * @return 
     */
    public ContratistaDTO getContratista() {
        return contratista;
    }

    /**
     * 
     * @param contratista 
     */
    public void setContratista(ContratistaDTO contratista) {
        this.contratista = contratista;
    }

   
    
    
    
}
