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
     * servicio que se va prestar en la solicitud
     */
    private ServicioDTO servicio;

    /**
     * factura que se va prestar en la solicitud
     */
    private FacturaDTO factura;

    /**
     * cotizacion que le corresponde a la solicitud
     */
    private CotizacionDTO cotizacion;

    /**
     * contratistas que van a atender a la solicitud
     */
    private ContratistaDTO contratista;

    /**
     * cliente que realiza la solicitu
     */
    private ClienteDTO cliente;

    /**
     * constructor vacio
     */
    public SolicitudDetailDTO() {
        // El constructor está vació porque se recomienda tener un constructor vacio cuando la clase se representa en JSON.
    }

    /**
     * constructor de solicitud
     * @param entity entidad de solcitud
     */
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
     * @return servicio
     */
    public ServicioDTO getServicio() {
        return servicio;
    }

    /**
     *
     * @param servicio servicio que se quiere establecer
     */
    public void setServicio(ServicioDTO servicio) {
        this.servicio = servicio;
    }

    /**
     *
     * @return factura
     */
    public FacturaDTO getFactura() {
        return factura;
    }

    /**
     *
     * @param factura factura que se va establecer
     */
    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }

    /**
     *
     * @return cotizacion
     */
    public CotizacionDTO getCotizacion() {
        return cotizacion;
    }

    /**
     *
     * @param cotizacion cotizacion que se va establecer
     */
    public void setCotizacion(CotizacionDTO cotizacion) {
        this.cotizacion = cotizacion;
    }

    /**
     *
     * @return contratista
     */
    public ContratistaDTO getContratista() {
        return contratista;
    }

    /**
     *
     * @param contratista contratista que se va establecer
     */
    public void setContratista(ContratistaDTO contratista) {
        this.contratista = contratista;
    }

    /**
     * 
     * @return cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**+
     * 
     * @param cliente cliebte que se quiere establecer
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * 
     * @return string del obj de solicitud
     */
    @Override
    public String toString() {
        return "SolicitudDetailDTO{" + "servicio=" + servicio + ", factura=" + factura + ", cotizacion=" + cotizacion + ", contratista=" + contratista  + ", cliente=" + cliente + '}';
    }

    /**
     * Metodo que conviert un obj de solicitud en una entidad del mismo
     * @return entidad de solicitud
     */
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
