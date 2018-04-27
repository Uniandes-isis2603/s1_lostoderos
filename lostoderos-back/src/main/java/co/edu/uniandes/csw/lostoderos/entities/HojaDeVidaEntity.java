/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.lostoderos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author sa.yepes
 */
@Entity
public class HojaDeVidaEntity extends BaseEntity implements Serializable{
    
    
    private String nombre;
    
    private Integer edad;
    
    private String especialidad;
    
    private String empleos;
    
    private String experiencia;
    
    private String referencias;
    
    @PodamExclude
    @OneToOne
    private ContratistaEntity contratista;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the empleos
     */
    public String getEmpleos() {
        return empleos;
    }

    /**
     * @param empleos the empleos to set
     */
    public void setEmpleos(String empleos) {
        this.empleos = empleos;
    }

    /**
     * @return the experiencia
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     * @param experiencia the experiencia to set
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * @return the referencias
     */
    public String getReferencias() {
        return referencias;
    }

    /**
     * @param referencias the referencias to set
     */
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    /**
     * @return the contrato
     */
    public ContratistaEntity getContratista() {
        return contratista;
    }

    /**
     * @param contratista the contrato to set
     */
    public void setContratista(ContratistaEntity contratista) {
        this.contratista = contratista;
    }
    
}
