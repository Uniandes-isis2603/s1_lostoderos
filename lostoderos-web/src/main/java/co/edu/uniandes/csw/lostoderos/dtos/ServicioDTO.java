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

import co.edu.uniandes.csw.lostoderos.entities.ServicioEntity;

/**
 * ServicioDTO Objeto de transferencia de datos de la entidad de Servicio. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre": string,
 *      "categorias": string,
 *      "descripcion": string
 *   }
 * </pre>
 * Por ejemplo una entidad de Servicio se representa asi:<br>
 * <pre>
 *
 *   {
 *      "id": 91852,
 *      "nombre": "Plomería",
 *      "categorias": "agua y tuberias",
 *      "descripción": "Aqui va una descripcion detallada del servicio"
 *   }
 *
 * </pre>
 * @author s.naranjop1
 */
public class ServicioDTO 
{
        private Long id;

	private String nombre;

	private String categorias;
        
        private String descripcion;
        
        /**
	 * Constructor por defecto
	 */
	public ServicioDTO( )
	{
	}

        /**
	 * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
	 * la entidad que viene de argumento.
	 *
	 * @param servicioEntity: Es la entidad que se va a convertir a DTO
	 */
	public ServicioDTO( ServicioEntity servicioEntity )
	{
		this.id = servicioEntity.getId( );
		this.nombre = servicioEntity.getNombre();
                this.categorias = servicioEntity.getCategorias();
                this.descripcion = servicioEntity.getDescripcion();
	}
        
	/**
	 * @return El ID de la entidad Servicio
	 */
	public Long getId( )
	{
		return id;
	}

	/**
	 * @param id El nuevo ID
	 */
	public void setId( Long id )
	{
		this.id = id;
	}

	/**
	 * @return El nombre de la entidad Servicio
	 */
	public String getNombre( )
	{
		return nombre;
	}

	/**
	 * @param nombre El nuevo nombre
	 */
	public void setNombre( String nombre )
	{
		this.nombre = nombre;
	}

	/**
	 * @return Categorias de la entidad Servicio
	 */
	public String getCategorias( )
	{
		return categorias;
	}

	/**
	 * @param categorias Las nuevas categorias de la entidad Servicio
	 */
	public void setCategorias( String categorias )
	{
		this.categorias = categorias;
	}

        /**
	 * @return La descripion de la entidad Servicio
	 */
	public String getDescripcion( )
	{
		return descripcion;
	}

	/**
	 * @param descripcion La nueva descripcion de la entidad Servicio
	 */
	public void setDescripcion( String descripcion )
	{
		this.descripcion = descripcion;
	}
        
        /**
	 * Convertir DTO a Entity
	 *
	 * @return Un Entity con los valores del DTO
	 */
	public ServicioEntity toEntity( )
	{
		ServicioEntity entity = new ServicioEntity( );
		entity.setId( this.id );
                entity.setNombre(this.nombre);
		entity.setCategorias(this.categorias);
                entity.setDescripcion(this.descripcion);
		return entity;
	}
}
