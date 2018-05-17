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
 * @author s.rangel
 */
@Entity
public class PagoEntity extends BaseEntity implements Serializable {

    private String numTarjeta;
    private String codigoTarjeta;
    private String fechaTarjeta;
    private String descripcion;
    private Boolean comprobantePagoMedio;
    private Boolean comprobantePagoTotal;
    
    @PodamExclude
    @OneToOne
    private FacturaEntity factura;

    /**
     * @param numTarjeta El nuevo numero de tarjeta de la entidad Todero
     */
    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    /**
     * @param codigoTarjeta El nuevo cndigo de la tarjeta de la entidad Todero
     */
    public void setCodigoTarjeta(String codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

    /**
     * @param fechaTarjeta La nueva fecha de la tarjeta de la entidad Todero
     */
    public void setFechaTarjeta(String fechaTarjeta) {
        this.fechaTarjeta = fechaTarjeta;
    }

    /**
     * @param descripcion La nueva descripcion de la entidad Todero
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param comprobantePagoMedio El nuevo comprobante medio de la entidad
     * Todero
     */
    public void setComprobantePagoMedio(Boolean comprobantePagoMedio) {
        this.comprobantePagoMedio = comprobantePagoMedio;
    }

    /**
     * @param comprobantePagoTotal El nuevo comprobante total de la entidad
     * Todero
     */
    public void setComprobantePagoTotal(Boolean comprobantePagoTotal) {
        this.comprobantePagoTotal = comprobantePagoTotal;
    }

    /**
     * @return El numero de la tarjeta de la entidad Pago
     */
    public String getNumTarjeta() {
        return numTarjeta;
    }

    /**
     * @return El codigo de la tarjeta de la entidad Pago
     */
    public String getCodigoTarjeta() {
        return codigoTarjeta;
    }

    /**
     * @return El codigo de la tarjeta de la entidad Pago
     */
    public String getFechaTarjeta() {
        return fechaTarjeta;
    }

    /**
     * @return El desripcion de la tarjeta de la entidad Pago
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return El comprobante medio de la tarjeta de la entidad Pago
     */
    public Boolean getComprobantePagoMedio() {
        return comprobantePagoMedio;
    }

    /**
     * @return El comprobante de pago final de la tarjeta de la entidad Pago
     */
    public Boolean getComprobantePagoTotal() {
        return comprobantePagoTotal;
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }
    
}
