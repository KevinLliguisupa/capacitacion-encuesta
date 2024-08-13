package org.proyecto.managedbeans;

import org.proyecto.config.Constantes;
import org.proyecto.model.PreguntaRespuesta;
import org.proyecto.services.intefaces.AppServices;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class RespuestaMB implements Serializable {
    @Inject
    private AppServices appServices;
    private List<PreguntaRespuesta> respuestasList;

    @PostConstruct
    public void init() {
        this.respuestasList = new ArrayList<>();
        this.respuestasList = appServices.methodListGET(Constantes.appUrl + "respuestas", PreguntaRespuesta[].class);
    }

    public List<PreguntaRespuesta> getRespuestasList() {
        return respuestasList;
    }

    public void setRespuestasList(List<PreguntaRespuesta> respuestasList) {
        this.respuestasList = respuestasList;
    }
}
