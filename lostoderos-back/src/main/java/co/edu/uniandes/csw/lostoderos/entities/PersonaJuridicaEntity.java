/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author na.morenoe
 */
@Entity
public class PersonaJuridicaEntity extends BaseEntity implements Serializable{
    
    private String nit;


    public String getNit() 
    {
        return nit;
    }

    public void setNit(String nit) 
    {
        this.nit = nit;
    }
    
}
