/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.entities;

import java.io.Serializable;

/**
 *
 * @author na.morenoe
 */
public class PersonaNaturalEntity extends BaseEntity implements Serializable{
    
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
