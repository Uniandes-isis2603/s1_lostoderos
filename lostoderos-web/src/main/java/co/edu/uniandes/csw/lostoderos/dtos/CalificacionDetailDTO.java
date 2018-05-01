/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.dtos;

import co.edu.uniandes.csw.lostoderos.entities.CalificacionEntity;

/**
 * Clase que extiende de {@link CalificacionDTO} para manejar la transformacion
 * entre los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la entidad de Calificacion vaya a la documentacion
 * de{@link CalificacionDTO}
 *
 *  * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "numEstrellas": number,
 *      "comentario": string,
 *      "tipoServicio": string,
 *      "cliente":
 *         {
 *           "id": number,
 *           "fecha_nacimiento": string,
 *           "forma_pago": number,
 *           "direccion": string
 *         }
 *   }
 * </pre> Por ejemplo una entidad de calificacion se representa asi:<br>
 * <pre>
 *
 *   {
 *      "id": 134,
 *      "numEstrellas": 3,
 *      "comentario": "Muy buen servicio",
 *      "tipoServicio": "Plomeria",
 *      "cliente":
 *         {
 *           "id": 1232,
 *           "fecha_nacimiento": "12/21/1981",
 *           "forma_pago": 1,
 *           "direccion": "CR 64 # 123-54"
 *         }
 *   }
 *
 * </pre>
 *
 * @author s.blancoc
 */
public class CalificacionDetailDTO extends CalificacionDTO {

    private ContratistaDTO contratista;

    private ClienteDTO cliente;

    /**
     * Cnstructor vacio
     */
    public CalificacionDetailDTO() {
        // El constructor está vació porque se recomienda tener un constructor vacio cuando la clase se representa en JSON.
    }

    public CalificacionDetailDTO(CalificacionEntity entity) {
        super(entity);
        if (entity.getContratista() != null) {
            this.contratista = new ContratistaDTO(entity.getContratista());
        } else {
            entity.setContratista(null);
        }
        if (entity.getCliente() != null) {
            this.cliente = new ClienteDTO(entity.getCliente());
        } else {
            entity.setCliente(null);
        }
    }

    /**
     * Transformar el DTO a una entidad
     *
     * @return La entidad que representa la calificacion.
     */
    @Override
    public CalificacionEntity toEntity() {
        CalificacionEntity entity = super.toEntity();
        if (this.getCliente() != null) {
            entity.setCliente(this.getCliente().toEntity());
        }
        if (this.getContratista() != null) {
            entity.setContratista(this.getContratista().toEntity());
        }
        return entity;
    }

    /**
     * @return the contratista
     */
    public ContratistaDTO getContratista() {
        return contratista;
    }

    /**
     * @param contratista the contratista to set
     */
    public void setContratista(ContratistaDTO contratista) {
        this.contratista = contratista;
    }

    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

}
