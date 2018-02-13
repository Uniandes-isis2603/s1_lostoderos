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
 * ContratistaDTO Objeto de transferencia de datos de la entidad de Contratista.
 * Los DTO contienen las representaciones de los JSON que se transfieren entre
 * el cliente y el servidor.
 * <p>
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": number,
 *      "nombre": string,
 *      "reputacion": string,
 *      "disponibilidad": boolean,
 *  }
 * </pre>
 * Por ejemplo, una entidad de Contratista se representa así: <br>
 * <pre>
 *  {
 *      "id": 91364,
 *      "nombre": "Sergio Yepes",
 *      "reputacion": "Muy buena",
 *      "disponibilidad" : true
 *  }
 * </pre>
 * @author sa.yepes
 */
public class ContratistaDTO {
    
    private Long id;
    
    private String nombre;
    
    private String reputacion;
    
    private Boolean disponibilidad;
    
    /**
     * Constructor por defecto.
     */
    public ContratistaDTO(){
        
    }
    
    /**
     * Retorna la identificación del contratista.
     * @return Id del contratista.
     */
    public Long getId(){
        return id;
    }
    
    /**
     * @param id Nueva identificación.
     */
    public void setId(Long id){
        this.id=id;
    }
           
    /**
     * Retorna el nombre del contratista.
     * @return Nombre del contratista.
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    /**
     * Retorna la reputación del contratista.
     * @return Reputación del contratista.
     */
    public String getReputacion(){
        return reputacion;
    }
    
    /*
     * @param reputacion Nueva reputación.
     */
    public void setReputacion(String reputacion){
        this.reputacion=reputacion;
    }
    
    /**
     * True si el contratista está disponible, false en caso contrario.
     * @return True si el contratista está disponible, false en caso contrario.
     */
    public boolean isDisponibilidad(){
        return disponibilidad;
    }
    
    /**
     * @param disponibilidad Nueva disponibilidad del contratista.
     */
    public void setDisponibilidad(Boolean disponibilidad){
        this.disponibilidad=disponibilidad;
    }  
}