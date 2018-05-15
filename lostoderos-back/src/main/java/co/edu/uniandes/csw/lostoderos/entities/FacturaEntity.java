package co.edu.uniandes.csw.lostoderos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s.rangel
 */
@Entity
public class FacturaEntity extends BaseEntity implements Serializable {

    private String producto;
    private Integer total;
    private Integer subtotal;
    private String formaPago;
    @PodamExclude
    @OneToOne
    private PagoEntity pago;
    
    private SolicitudEntity solicitud;
    
    
    /**
     * construcor por defecto
     */
    public FacturaEntity() {

    }

    /**
     * @return el producto de la entidad Cliente
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @return el total de la entidad Cliente
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @return el subtotal de la entidad Cliente
     */
    public Integer getSubtotal() {
        return subtotal;
    }

    /**
     * @return la forma de pago de la entidad factura
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * @return el pago de la entidad factura
     */
    public PagoEntity getPago() {
        return pago;
    }

    /**
     * @param producto El nuevo producto medio de la entidad Factura
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @param total El nuevo total de la entidad factura
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @param subtotal El nuevo subtotal de la entidad factura
     */
    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @param formaPago La nueva forma de pago de la entidad factura
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * @param pago el nuevo pago de entidad factura
     */
    public void setPago(PagoEntity pago) {
        this.pago = pago;
    }

}
