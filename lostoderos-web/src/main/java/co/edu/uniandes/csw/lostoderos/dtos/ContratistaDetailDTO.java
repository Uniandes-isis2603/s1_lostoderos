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

import co.edu.uniandes.csw.lostoderos.entities.CalificacionEntity;
import co.edu.uniandes.csw.lostoderos.entities.ContratistaEntity;
import co.edu.uniandes.csw.lostoderos.entities.ServicioEntity;
import co.edu.uniandes.csw.lostoderos.entities.SolicitudEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link ContratistaDTO} para manejar la transformación
 * entre los objetos JSON y las Entidades de la base da datos. Para conocer el
 * contenido de la ciudad vaya a la documentación de {@link ContratistaDTO}
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": number,
 *      "nombre": string,
 *      "usuario": string,
 *      "contraseña": string,
 *      "correo": string,
 *      "reputacion": string,
 *      "disponibilidad": string
 *  }
 * </pre>
 *
 * @author sa.yepes
 */
public class ContratistaDetailDTO extends ContratistaDTO {

    /**
     * servicios del contratista
     */
    private List<ServicioDTO> servicios;

    /**
     * solicitudes del contratista
     */
    private List<SolicitudDTO> solicitudes;

    /**
     * hoja de vida del contratista
     */
    private HojaDeVidaDTO hojaVida;

    /**
     * calificaciones del contratista
     */
    private List<CalificacionDTO> calificaciones;

    /**
     * contrato del contratista
     */
    private ContratoDTO contrato;

    /**
     * Constructor por defecto.
     */
    public ContratistaDetailDTO() {
        // El constructor está vació porque se recomienda tener un constructor vacio cuando la clase se representa en JSON.
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de contratista a partir de la cual se construye
     * el objeto
     */
    public ContratistaDetailDTO(ContratistaEntity entity) {
        super(entity);
        if (entity.getServicios() != null) {
            servicios = new ArrayList<>();
            for (ServicioEntity servicio : entity.getServicios()) {
                servicios.add(new ServicioDTO(servicio));
            }
        }
        if (entity.getSolicitudes() != null) {
            solicitudes = new ArrayList<>();
            for (SolicitudEntity solicitud : entity.getSolicitudes()) {
                solicitudes.add(new SolicitudDTO(solicitud));
            }
        }
        if (entity.getCalificaciones() != null) {
            calificaciones = new ArrayList<>();
            for (CalificacionEntity calificacion : entity.getCalificaciones()) {
                calificaciones.add(new CalificacionDTO(calificacion));
            }
        }
        if (entity.getContrato() != null) {
            contrato = new ContratoDTO(entity.getContrato());
        } else {
            entity.setContrato(null);
        }
        if (entity.getHojaVida() != null) {
            hojaVida = new HojaDeVidaDTO(entity.getHojaVida());
        } else {
            entity.setHojaVida(null);
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO.
     */
    @Override
    public ContratistaEntity toEntity() {
        ContratistaEntity contratista = super.toEntity();
        if (this.getSolicitudes() != null) {
            List<SolicitudEntity> solicitudesEntity = new ArrayList<>();
            for (SolicitudDTO s : getSolicitudes()) {
                solicitudesEntity.add(s.toEntity());
            }
            contratista.setSolicitudes(solicitudesEntity);
        }
        if (this.getServicios() != null) {
            List<ServicioEntity> serviciosEntity = new ArrayList<>();
            for (ServicioDTO s : getServicios()) {
                serviciosEntity.add(s.toEntity());
            }
            contratista.setServicios(serviciosEntity);
        }
        if (this.getHojaVida() != null) {
            contratista.setHojaVida(this.hojaVida.toEntity());
        }
        if (this.contrato != null) {
            contratista.setContrato(this.contrato.toEntity());
        }
        return contratista;
    }

    /**
     * @return the servicios
     */
    public List<ServicioDTO> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<ServicioDTO> servicios) {
        this.servicios = servicios;
    }

    /**
     * @return the solicitudes
     */
    public List<SolicitudDTO> getSolicitudes() {
        return solicitudes;
    }

    /**
     * @param solicitudes the solicitudes to set
     */
    public void setSolicitudes(List<SolicitudDTO> solicitudes) {
        this.solicitudes = solicitudes;
    }

    /**
     * @return the hojaVida
     */
    public HojaDeVidaDTO getHojaVida() {
        return hojaVida;
    }

    /**
     * @param hojaVida the hojaVida to set
     */
    public void setHojaVida(HojaDeVidaDTO hojaVida) {
        this.hojaVida = hojaVida;
    }

    /**
     * @return the calificaciones
     */
    public List<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    /**
     * @param calificaciones the calificaciones to set
     */
    public void setCalificaciones(List<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * @return the contrato
     */
    public ContratoDTO getContrato() {
        return contrato;
    }

    /**
     * @param contrato the contrato to set
     */
    public void setContrato(ContratoDTO contrato) {
        this.contrato = contrato;
    }
}
