/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

/**
 *
 * @author s.rangel
 */
public class PagoDTO {
        private long ID;
    private int numTarjeta;
    private int codigoTarjeta;
    private String fechaTarjeta;
    private String descripcion;
    private String comprobantePagoMedio;
    private String comprobantePagoTotal;

    public PagoDTO() {
    }
        
    

    public long getID() {
        return ID;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public int getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public String getFechaTarjeta() {
        return fechaTarjeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getComprobantePagoMedio() {
        return comprobantePagoMedio;
    }

    public String getComprobantePagoTotal() {
        return comprobantePagoTotal;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setCodigoTarjeta(int codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

    public void setFechaTarjeta(String fechaTarjeta) {
        this.fechaTarjeta = fechaTarjeta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setComprobantePagoMedio(String comprobantePagoMedio) {
        this.comprobantePagoMedio = comprobantePagoMedio;
    }

    public void setComprobantePagoTotal(String comprobantePagoTotal) {
        this.comprobantePagoTotal = comprobantePagoTotal;
    }
            
    //entity
}
