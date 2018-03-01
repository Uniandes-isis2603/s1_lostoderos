/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author na.morenoe
 */
@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonaNaturalEntity extends ClienteEntity implements Serializable{
    
    private String cedula;


    public String getCedula() 
    {
        return cedula;
    }

    public void setCedula(String cedula) 
    {
        this.cedula = cedula;
    }
    
}
