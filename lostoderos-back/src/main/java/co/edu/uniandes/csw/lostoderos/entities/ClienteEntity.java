/*
MIT License

Copyright (c) 2017 ISIS2603

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
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.naranjop1
 */
@Entity
public class ClienteEntity extends UsuarioEntity implements Serializable
{
    private String fecha_nacimiento;
    private String forma_pago;
    private String direccion;
    
    @PodamExclude
    @OneToMany( mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List <SolicitudEntity> solicitudes = new ArrayList<SolicitudEntity>();
    
    @PodamExclude
    @OneToMany( mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List <CalificacionEntity> calificaciones = new ArrayList<CalificacionEntity>();
    
    public String getFecha_nacimiento() 
    {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) 
    {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getForma_pago() 
    {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) 
    {
        this.forma_pago = forma_pago;
    }

    public String getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(String direccion) 
    {
        this.direccion = direccion;
    }

    public List <SolicitudEntity> getSolicitudes() 
    {
        return solicitudes;
    }

    public void setSolicitudes(List <SolicitudEntity> solicitudes) 
    {
        this.solicitudes = solicitudes;
    }

    public List <CalificacionEntity> getCalificaciones() 
    {
        return calificaciones;
    }

    public void setCalificaciones(List <CalificacionEntity> calificaciones) 
    {
        this.calificaciones = calificaciones;
    }
    
    
}
