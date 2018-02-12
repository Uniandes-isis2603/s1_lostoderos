/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

/**
 * ServicioDTO Objeto de transferencia de datos de la entidad de Pago. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "codigoTarjeta": string,
 *      "comprobantePagoMedio": string,
 *      "comprobantePagoTotal": string,
 * 
 *   }
 * </pre>
 * Por ejemplo una entidad de Servicio se representa asi:<br>
 * <p>
 * <pre>
 *
 *   {
 *      "id": 91852,
 *      "nombre": "Plomería",
 *      "categorias": "agua y tuberias",
 *      "descripción": "Aqui va una descripcion detallada del servicio"
 *   }
 *
 * </pre>
 *
 * @author s.naranjop1
 */
public class PagoDTO {
    private Long ID;
    private String numTarjeta;
    private String codigoTarjeta;
    private String fechaTarjeta;
    private String descripcion;
    private Boolean comprobantePagoMedio;
    private Boolean comprobantePagoTotal;

    public PagoDTO() {
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setCodigoTarjeta(String codigoTarjeta) {
        this.codigoTarjeta = codigoTarjeta;
    }

    public void setFechaTarjeta(String fechaTarjeta) {
        this.fechaTarjeta = fechaTarjeta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setComprobantePagoMedio(Boolean comprobantePagoMedio) {
        this.comprobantePagoMedio = comprobantePagoMedio;
    }

    public void setComprobantePagoTotal(Boolean comprobantePagoTotal) {
        this.comprobantePagoTotal = comprobantePagoTotal;
    }
        
    

   
    //entity

    public Long getID() {
        return ID;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public String getCodigoTarjeta() {
        return codigoTarjeta;
    }

    public String getFechaTarjeta() {
        return fechaTarjeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Boolean getComprobantePagoMedio() {
        return comprobantePagoMedio;
    }

    public Boolean getComprobantePagoTotal() {
        return comprobantePagoTotal;
    }
}
