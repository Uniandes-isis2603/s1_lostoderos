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
public class PersonaNaturalDTO {
    
    private long ID;
    private String Cedula;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNIT() {
        return Cedula;
    }

    public void setNIT(String NIT) {
        this.Cedula = NIT;
    }

    /**
	 * Constructor por defecto
	 */
        public PersonaNaturalDTO() {
    }
    
}
