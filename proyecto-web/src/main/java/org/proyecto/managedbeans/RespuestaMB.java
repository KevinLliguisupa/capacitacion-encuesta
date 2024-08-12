package org.proyecto.managedbeans;

import org.proyecto.config.Constantes;
import org.proyecto.model.Pregunta;
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
    private PreguntaRespuesta respuesta;
    private Pregunta preguntaSeleccionada;
    private List<PreguntaRespuesta> respuestasList;

    @PostConstruct
    public void init() {
        this.respuestasList = new ArrayList<>();
        iniciar();
    }

    public void iniciar(){
        respuesta = new PreguntaRespuesta();
        this.respuestasList = appServices.methodListGET(Constantes.appUrl + "respuestas", PreguntaRespuesta[].class);
    }

    public void responderPregunta(Pregunta p) {
        this.preguntaSeleccionada = p;
    }

    public void guardarRespuesta(){
        this.respuesta.setPreguntaId(preguntaSeleccionada.getId());
        PreguntaRespuesta r = (PreguntaRespuesta) appServices.methodPOST(respuesta,
                Constantes.appUrl + "guardarRespuesta", PreguntaRespuesta.class);
        iniciar();
    }

    public List<PreguntaRespuesta> getRespuestasList() {
        return respuestasList;
    }

    public void setRespuestasList(List<PreguntaRespuesta> respuestasList) {
        this.respuestasList = respuestasList;
    }

    public PreguntaRespuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(PreguntaRespuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Pregunta getPreguntaSeleccionada() {
        return preguntaSeleccionada;
    }

    public void setPreguntaSeleccionada(Pregunta preguntaSeleccionada) {
        this.preguntaSeleccionada = preguntaSeleccionada;
    }
}
