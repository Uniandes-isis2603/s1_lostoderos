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
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.UsuarioEntity;
import java.io.Serializable;

/**
 * ServicioDTO Objeto de transferencia de datos de la entidad de Servicio. Los
 * DTO contienen las represnetaciones de los JSON que se transfieren entre el
 * cliente y el servidor. Al serializarse como JSON esta clase implementa el
 * siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre": string,
 *      "usuario": string,
 *      "contraseña": string,
 *      "correo": string
 *   }
 * </pre> Por ejemplo una entidad de Servicio se representa asi:<br>
 * <pre>
 *
 *   {
 *      "id": 91852,
 *      "nombre": "Juan Perez",
 *      "usuario": "Jperez",
 *      "contraseña": "enero1999",
 *      "correo": "Jperez@gmail.com"
 *   }
 *
 * </pre>
 *
 * @author s.naranjop1
 */
public class UsuarioDTO implements Serializable{

    protected Long id;

    protected String nombre;

    protected String usuario;

    protected String contrasena;

    protected String correo;

    /**
     * Constructor por defecto
     */
    public UsuarioDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param usuarioEntity: Es la entidad que se va a convertir a DTO
     */
    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        if (usuarioEntity != null) {
            this.id = usuarioEntity.getId();
            this.nombre = usuarioEntity.getNombre();
            this.usuario = usuarioEntity.getUsuario();
            this.contrasena = usuarioEntity.getContrasena();
            this.correo = usuarioEntity.getCorreo();
        }
    }

    /**
     * @return El ID de la entidad Usuario
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return El nombre de la entidad Usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return El Usuario de la entidad Usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario El nuevo usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return La contraseña de la entidad Usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contraseña La nueva contraseña
     */
    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    /**
     * @return El correo de la entidad Usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo El nuevo correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Convertir DTO a Entity
     *
     * @param entity entidad que herada de clase Usuario
     * @return Un Entity con los valores del DTO
     */
    public UsuarioEntity toEntity(UsuarioEntity entity) {
        if (entity != null) {
            entity.setId(this.id);
            entity.setNombre(this.nombre);
            entity.setUsuario(this.usuario);
            entity.setContrasena(this.contrasena);
            entity.setCorreo(this.correo);
        }
        return entity;

    }
}
