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
 * HojaDeVidaDTO Objeto de transferencia de datos de la entidad de HojaDeVida. 
 * Los DTO contienen las representaciones de los JSON que se transfieren entre
 * el cliente y el servidor.
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "nombre": string,
 *      "edad": number,
 *      "especialidad": string,
 *      "empleos": string,
 *      "experiencia": string,
 *      "referencia": string
 *  }
 * </pre>
 * Por ejemplo, una entidad de HojaDeVida se representa así: <br>
 * <p>
 * <pre>
 *  {
 *       "nombre": "Sergio Yepes",
 *      "edad": 24,
 *      "especialidad": "Electricidad",
 *      "empleos": "Codensa",
 *      "experiencia": "Levantamiento de equipos eléctricos",
 *      "referencia": "Pedro Gonzalez. tel: 3204045618"
 *  }
 * </pre>
 * @author sa.yepes
 */
public class HojaDeVidaDTO {
    
   private String nombre;
   
   private Integer edad;
   
   private String especialidad;
   
   private String empleos;
   
   private String experiencia;
   
   private String referencia;
   
   /**
    * Constructor por defecto
    */
   public HojaDeVidaDTO(){
       
   }
   
   /**
    * Retorna el nombre de la persona asociada a la hoja de vida.
    * @return Nombre de la persona asociada a la hoja de vida.
    */
   public String getNombre(){
       return nombre;
   }
   
   /**
    * @param nombre El nuevo nombre.
    */ 
   public void setNomber(String nombre){
       this.nombre=nombre;
   }
   
   /**
    * Retorna la edad de la persona asociada a la hoja de vida.
    * @return Edad de la persona asociada a la hoja de vida.
    */
   public Integer getEdad(){
       return edad;
   }
   
   /**
    * @param edad La nueva edad.
    */
   public void setEdad(Integer edad){
       this.edad=edad;
   }
   
   /**
    * Retorna la especialidad de la persona asociada a la hoja de vida.
    * @return Especialidad de la persona asociada a la hoja de vida.
    */
   public String getEspecialidad(){
       return especialidad;
   }
   
   /**
    * @param especialidad La nueva especialidad.
    */
   public void setEspecialidad(String especialidad){
       this.especialidad=especialidad;
   }
   
   /**
    * Retorna los empleos de la persona asociada a la hoja de vida.
    * @return Empleos de la persona asociada a la hoja de vida.
    */
   public String getEmpleos(){
       return empleos;
   }
   
   /**
    * @param empleos Los nuevos empleos.
    */
   public void setEmpleos(String empleos){
       this.empleos=empleos;
   }
   
   /**
    * Retorna la experiencia de la persona asociada a la hoja de vida.
    * @return Experiencia de la persona asociada a la hoja de vida.
    */
   public String getExperiencia(){
       return experiencia;
   }
   
   /**
    * @param experiencia La nueva experiencia de la hoja de vida.
    */
   public void setExperiencia(String experiencia){
       this.experiencia=experiencia;
   }
   
   /**
    * Retorna la referencia de la persona asociada a la hoja de vida.
    * @return Experiencia de la persona asociada a la hoja de vida.
    */
   public String getReferencia(){
       return referencia;
   }
   
   /**
    * @param referencia La nueva referencia.
    */
   public void setReferencia(String referencia){
       this.referencia=referencia;
   }

}
