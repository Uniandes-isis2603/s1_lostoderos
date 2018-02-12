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
public class FacturaDTO {
    private Long ID;
    private String concepto;
    private Integer total;
    private Integer subtotal;

    public FacturaDTO() {
      
    }

    public Long getID() {
        return ID;
    }

    public String getConcepto() {
        return concepto;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    
    
   
    
}
