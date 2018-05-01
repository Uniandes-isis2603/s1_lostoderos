
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.HojaDeVidaEntity;
import java.io.Serializable;

/**
 * HojaDeVidaDTO Objeto de transferencia de datos de la entidad de HojaDeVida.
 * Los DTO contienen las representaciones de los JSON que se transfieren entre
 * el cliente y el servidor. Al serializarse como JSON esta clase implementa el
 * siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": number,
 *      "nombre": string,
 *      "edad": number,
 *      "especialidad": string,
 *      "empleos": string,
 *      "experiencia": string,
 *      "referencias": string
 *  }
 * </pre> Por ejemplo, una entidad de HojaDeVida se representa así: <br>
 * <pre>
 *  {
 *      "id": 9910,
 *      "nombre": "Sergio Yepes",
 *      "edad": 24,
 *      "especialidad": "Electricidad",
 *      "empleos": "Codensa",
 *      "experiencia": "Levantamiento de equipos eléctricos",
 *      "referencias": "Pedro Gonzalez. tel: 3204045618"
 *  }
 * </pre>
 *
 * @author sa.yepes
 */
public class HojaDeVidaDTO implements Serializable {

    private Long id;

    private String nombre;

    private Integer edad;

    private String especialidad;

    private String empleos;

    private String experiencia;

    private String referencias;

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param hojaVida: Es la entidad que se va a convertir a DTO
     */
    public HojaDeVidaDTO(HojaDeVidaEntity hojaVida) {
        if (hojaVida != null) {
            this.id = hojaVida.getId();
            this.nombre = hojaVida.getNombre();
            this.edad = hojaVida.getEdad();
            this.especialidad = hojaVida.getEspecialidad();
            this.empleos = hojaVida.getEmpleos();
            this.experiencia = hojaVida.getExperiencia();
            this.referencias = hojaVida.getReferencias();
        }
    }

    /**
     * Constructor por defecto
     */
    public HojaDeVidaDTO() {
        // El constructor está vació porque se recomienda tener un constructor vacio cuando la clase se representa en JSON.
    }

    /**
     * Retorna el id de la hoja de vida.
     *
     * @return Id de la hoja de vida.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id Id de la hoja de vida.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el nombre de la persona asociada a la hoja de vida.
     *
     * @return Nombre de la persona asociada a la hoja de vida.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la edad de la persona asociada a la hoja de vida.
     *
     * @return Edad de la persona asociada a la hoja de vida.
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad La nueva edad.
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * Retorna la especialidad de la persona asociada a la hoja de vida.
     *
     * @return Especialidad de la persona asociada a la hoja de vida.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad La nueva especialidad.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Retorna los empleos de la persona asociada a la hoja de vida.
     *
     * @return Empleos de la persona asociada a la hoja de vida.
     */
    public String getEmpleos() {
        return empleos;
    }

    /**
     * @param empleos Los nuevos empleos.
     */
    public void setEmpleos(String empleos) {
        this.empleos = empleos;
    }

    /**
     * Retorna la experiencia de la persona asociada a la hoja de vida.
     *
     * @return Experiencia de la persona asociada a la hoja de vida.
     */
    public String getExperiencia() {
        return experiencia;
    }

    /**
     * @param experiencia La nueva experiencia de la hoja de vida.
     */
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Retorna la referencia de la persona asociada a la hoja de vida.
     *
     * @return Experiencia de la persona asociada a la hoja de vida.
     */
    public String getReferencias() {
        return referencias;
    }

    /**
     * @param referencia La nueva referencia.
     */
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public HojaDeVidaEntity toEntity() {
        HojaDeVidaEntity entity = new HojaDeVidaEntity();
        entity.setId(this.id);
        entity.setNombre(nombre);
        entity.setEdad(this.edad);
        entity.setEmpleos(this.empleos);
        entity.setEspecialidad(this.especialidad);
        entity.setExperiencia(this.experiencia);
        entity.setReferencias(this.referencias);
        return entity;
    }
}
