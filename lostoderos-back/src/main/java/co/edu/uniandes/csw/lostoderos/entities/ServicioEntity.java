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
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author s.naranjop1
 */
@Entity
public class ServicioEntity extends BaseEntity implements Serializable
{
    private String nombre;
    private String categorias;
    private String descripcion;
    private String imagen;
    
    @PodamExclude
    @ManyToOne
    private UsuarioEntity usuario;
    
    @PodamExclude
    @ManyToMany( mappedBy = "servicios", cascade = CascadeType.PERSIST)
    private List<ContratistaEntity> contratistas = new ArrayList<ContratistaEntity>();
    
    @PodamExclude
    @OneToOne( mappedBy="servicio", fetch = FetchType.LAZY)
    private SolicitudEntity solicitud;

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getCategorias() 
    {
        return categorias;
    }

    public void setCategorias(String categorias) 
    {
        this.categorias = categorias;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    public UsuarioEntity getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) 
    {
        this.usuario = usuario;
    }

    public List<ContratistaEntity> getContratistas() 
    {
        return contratistas;
    }

    public void setContratistas(List<ContratistaEntity> contratistas) 
    {
        this.contratistas = contratistas;
    }

    public String getImagen() 
    {
        return imagen;
    }

    public void setImagen(String imagen) 
    {
        this.imagen = imagen;
    }

    /**
     * @return the solicitud
     */
    public SolicitudEntity getSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(SolicitudEntity solicitud) {
        this.solicitud = solicitud;
    }
}
