/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

/**
 *
 * @author na.morenoe
 */
public class PersonaJuridicaDTO {
    
    private long ID;
    private String NIT;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    /**
	 * Constructor por defecto
	 */
        public PersonaJuridicaDTO() {
    }
    
    
}


