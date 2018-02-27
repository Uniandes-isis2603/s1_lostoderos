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

import co.edu.uniandes.csw.lostoderos.entities.HojaDeVidaEntity;

/**
 *Clase que extiende de {@link HojaDeVidaDTO} para manejar la transformación
 * entre los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la hoja de vida vaya a la documentación de {@link HojaDeVidaDTO}
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": nombre,
 *      "nombre": string,
 *      "edad": number,
 *      "especialidad": string,
 *      "empleos": string,
 *      "experiencia": string,
 *      "referencias": string
 *  }
 * </pre>
 * @author sa.yepes
 */
public class HojaDeVidaDetailDTO extends HojaDeVidaDTO {
    
    /**
     * Constructor por defecto
     */
    public HojaDeVidaDetailDTO(){
        
    }
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de hoja de vida a partir de la cual se construye el objeto
     */
    public HojaDeVidaDetailDTO(HojaDeVidaEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public HojaDeVidaEntity toEntity() {
        HojaDeVidaEntity hojaDeVidaE = super.toEntity();
        return hojaDeVidaE;
    }
    
}
