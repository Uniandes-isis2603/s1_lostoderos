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

/**
 * ServicioDTO Objeto de transferencia de datos de la entidad de Servicio. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre": string,
 *      "usuario": string,
 *      "contraseña": string,
 *      "correo": string
 *   }
 * </pre>
 * Por ejemplo una entidad de Servicio se representa asi:<br>
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
 * @author s.naranjop1
 */
public class UsuarioDTO
{
        private Long id;

	private String nombre;    
        
        private String usuario;
        
        private String contraseña;
        
        private String correo;
    
        /**
	 * Constructor por defecto
	 */
	public UsuarioDTO( )
	{
	}
        
        /**
	 * @return El ID de la entidad Usuario
	 */
        public Long getId() 
        {
                return id;
        }

        /**
	 * @param id El nuevo ID
	 */
        public void setId(Long id) 
        {
                this.id = id;
        }

        /**
	 * @return El nombre de la entidad Usuario
	 */
        public String getNombre() 
        {
                return nombre;
        }

        /**
	 * @param nombre El nuevo nombre
	 */
        public void setNombre(String nombre) 
        {
                this.nombre = nombre;
        }

        /**
	 * @return El Usuario de la entidad Usuario
	 */
        public String getUsuario() 
        {
                return usuario;
        }

        /**
	 * @param usuario El nuevo usuario
	 */
        public void setUsuario(String usuario) 
        {
                this.usuario = usuario;
        }

         /**
	 * @return La contraseña de la entidad Usuario
	 */
        public String getContraseña() 
        {
                return contraseña;
        }

        /**
	 * @param contraseña La nueva contraseña
	 */
        public void setContraseña(String contraseña) 
        {
                this.contraseña = contraseña;
        }

        /**
	 * @return El correo de la entidad Usuario
	 */
        public String getCorreo() 
        {
                return correo;
        }

        /**
	 * @param correo El nuevo correo
	 */
        public void setCorreo(String correo) 
        {
                this.correo = correo;
        }
        
        /**
	 * Convertir DTO a Entity
	 *
	 * @return Un Entity con los valores del DTO
	 */
	public UsuarioEntity toEntity( )
	{
		UsuarioEntity entity = new UsuarioEntity( );
		entity.setId( this.id );
		entity.setNombre(this.nombre);
                entity.setUsuario(this.usuario);
                entity.setContraseña(this.contraseña);
                entity.setCorreo(this.correo);
		return entity;
	}
}
