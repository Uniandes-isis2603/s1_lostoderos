/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.lostoderos.resources;

import co.edu.uniandes.csw.lostoderos.dtos.ContratoDetailDTO;
import co.edu.uniandes.csw.lostoderos.ejb.ContratoLogic;
import co.edu.uniandes.csw.lostoderos.entities.ContratoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author s.blancoc
 */
@Path("contratos")
@Produces( "application/json" )
@Consumes( "application/json" )
@RequestScoped
public class ContratosTodosResource {
    
    @Inject
    private ContratoLogic contratoLogic;
    

        /**
	 * <h1>GET /api/contratos : Obtener todas las entidades de de contrato.</h1>
	 * <pre>Busca y devuelve todas las entidades de contrato que existen en la aplicacion.
	 *
	 * Codigos de respuesta:
	 * <code style="color: mediumseagreen; background-color: #eaffe0;">
	 * 200 OK Devuelve todas las entidades de contrato de la aplicacion.</code>
	 * </pre>
	 *
	 * @return JSONArray {@link ContratoDetailDTO} - Las entidades de contrato encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
	 */
	@GET
	public List<ContratoDetailDTO> getContratos( ){
		return listContratoEntity2DetailDTO(contratoLogic.getContratos());
	}
        
      private List<ContratoDetailDTO> listContratoEntity2DetailDTO(List<ContratoEntity> entityList) {
      List<ContratoDetailDTO> list = new ArrayList<>();
        for (ContratoEntity entity : entityList) {
            list.add(new ContratoDetailDTO(entity));
        }
        return list;
    }
        
}
