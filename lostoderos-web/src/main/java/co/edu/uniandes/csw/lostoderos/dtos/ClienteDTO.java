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

/**
 * ServicioDTO Objeto de transferencia de datos de la entidad de Servicio. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el servidor.
 * <p>
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
 * <p>
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
 *
 * @author s.naranjop1
 */
public class ClienteDTO extends UsuarioDTO
{
        private Long id;
        
        private String fecha_nacimiento;
        
        private String forma_pago;
        
        private String direccion;
        
        /**
	 * Constructor por defecto
	 */
	public ClienteDTO( )
	{
            super();
	}
        
        /**
	 * @return El ID de la entidad Cliente
	 */
        @Override
        public Long getId() 
        {
                return id;
        }

        /**
	 * @param id El nuevo ID
	 */
        @Override
        public void setId(Long id) 
        {
                this.id = id;
        }

        /**
	 * @return La fecha de nacimiento de la entidad Cliente
	 */
        public String getFecha_nacimiento() 
        {
                return fecha_nacimiento;
        }

        /**
	 * @param fecha_nacimiento La nueva fecha de nacimiento
	 */
        public void setFecha_nacimiento(String fecha_nacimiento) 
        {
                this.fecha_nacimiento = fecha_nacimiento;
        }

        /**
	 * @return La forma de pago de la entidad Cliente
	 */
        public String getForma_pago() 
        {
                return forma_pago;
        }

        /**
	 * @param forma_pago La nueva forma de pago
	 */
        public void setForma_pago(String forma_pago) 
        {
                this.forma_pago = forma_pago;
        }

        /**
	 * @return La direccion de la entidad Cliente
	 */
        public String getDireccion() 
        {
                return direccion;
        }

        /**
	 * @param direccion La nueva direccion
	 */
        public void setDireccion(String direccion) 
        {
                this.direccion = direccion;
        }
}
