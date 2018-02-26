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
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    
    @PodamExclude
    @OneToMany
    private UsuarioEntity usuario;
    
    @ManyToMany
    private List<ContratistaEntity> contratistas;

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

    
}
