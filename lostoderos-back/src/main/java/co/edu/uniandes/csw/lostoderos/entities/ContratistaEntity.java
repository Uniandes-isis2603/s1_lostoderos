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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author sa.yepes
 */
@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ContratistaEntity extends UsuarioEntity implements Serializable{
    
    private String reputacion;
    
    private Boolean disponibilidad;
    
    @PodamExclude
    @OneToOne(mappedBy="contratista", fetch = FetchType.LAZY)
    private ContratoEntity contrato;
    
    @PodamExclude
    @OneToMany(mappedBy = "contratista", cascade=CascadeType.PERSIST)
    private List<CalificacionEntity> calificaciones = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "contratista", cascade=CascadeType.PERSIST)
    private List<SolicitudEntity> solicitudes = new ArrayList<>();
    
    @PodamExclude
    @ManyToMany
    private List<ServicioEntity> servicios = new ArrayList<>();
    
    @PodamExclude
    @OneToOne(mappedBy="contratista", fetch = FetchType.LAZY)
    private HojaDeVidaEntity hojaVida;

    /**
     * Obtiene el atributo reputación.
     * 
     * @return La reputación
     */
    public String getReputacion() {
        return reputacion;
    }

    /**
     * Establece el atributo reputación.
     * @param reputacion Reputación a establecer.
     */
    public void setReputacion(String reputacion) {
        this.reputacion = reputacion;
    }

   /**
     * Obtiene el atributo disponiblidad.
     * 
     * @return La disponibilidad.
     */
    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Establece el atributo disponibilidad.
     * @param disponibilidad Disponibilidad a establecer.
     */
    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /**
     * @return the contrato
     */
    public ContratoEntity getContrato() {
        return contrato;
    }

    /**
     * @param contrato the contrato to set
     */
    public void setContrato(ContratoEntity contrato) {
        this.contrato = contrato;
    }

    /**
     * @return the calificaciones
     */
    public List<CalificacionEntity> getCalificaciones() {
        return calificaciones;
    }

    /**
     * @param calificaciones the calificaciones to set
     */
    public void setCalificaciones(List<CalificacionEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * @return the solicitudes
     */
    public List<SolicitudEntity> getSolicitudes() {
        return solicitudes;
    }

    /**
     * @param solicitudes the solicitudes to set
     */
    public void setSolicitudes(List<SolicitudEntity> solicitudes) {
        this.solicitudes = solicitudes;
    }

    /**
     * @return the servicios
     */
    public List<ServicioEntity> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<ServicioEntity> servicios) {
        this.servicios = servicios;
    }

    /**
     * @return the hojaVida
     */
    public HojaDeVidaEntity getHojaVida() {
        return hojaVida;
    }

    /**
     * @param hojaVida the hojaVida to set
     */
    public void setHojaVida(HojaDeVidaEntity hojaVida) {
        this.hojaVida = hojaVida;
    }
}
