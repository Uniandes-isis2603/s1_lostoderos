/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.SolicitudEntity;

/**
 *
 * @author m.saravia
 */
public class SolicitudDetailDTO extends SolicitudDTO {

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

    /**
     *
     */
    private ClienteDTO cliente;

    public SolicitudDetailDTO() {
        // El constructor está vació porque se recomienda tener un constructor vacio cuando la clase se representa en JSON.
    }

    public SolicitudDetailDTO(SolicitudEntity entity) {
        super(entity);


        if (entity.getCliente() != null) {
            this.cliente = new ClienteDTO(entity.getCliente());
        } else {
            entity.setCliente(null);
        }

        if (entity.getContratista() != null) {
            this.contratista = new ContratistaDTO(entity.getContratista());
        } else {
            entity.setContratista(null);
        }

        if (entity.getCotizacion() != null) {
            this.cotizacion = new CotizacionDTO(entity.getCotizacion());
        } else {
            entity.setCotizacion(null);
        }

        if (entity.getFactura() != null) {
            this.factura = new FacturaDTO(entity.getFactura());
        } else {
            entity.setFactura(null);
        }

        if (entity.getServicio() != null) {
            this.servicio = new ServicioDTO(entity.getServicio());
        } else {
            entity.setServicio(null);
        }

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


    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "SolicitudDetailDTO{" + "servicio=" + servicio + ", factura=" + factura + ", cotizacion=" + cotizacion + ", contratista=" + contratista  + ", cliente=" + cliente + '}';
    }

    @Override
    public SolicitudEntity toEntity() {
        //To change body of generated methods, choose Tools | Templates.
        SolicitudEntity solicitud = super.toEntity();

        if (this.cliente != null) {
            solicitud.setCliente(cliente.toEntity());
        }

        if (this.contratista != null) {
            solicitud.setContratista(contratista.toEntity());
        }

        if (this.cotizacion != null) {
            solicitud.setCotizacion(cotizacion.toEntity());
        }

        if (this.factura != null) {
            solicitud.setFactura(factura.toEntity());
        }

        if (this.servicio != null) {
            solicitud.setServicio(servicio.toEntity());
        }

        return solicitud;

    }

}
