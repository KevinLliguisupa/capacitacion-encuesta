package org.proyecto.managedbeans;

import org.proyecto.config.Constantes;
import org.proyecto.model.Pregunta;
import org.proyecto.model.PreguntaRespuesta;
import org.proyecto.services.intefaces.AppServices;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class PreguntaRespuestaMB implements Serializable {
    @Inject
    private AppServices appServices;

    private Pregunta pregunta;
    private List<PreguntaRespuesta> respuestas;

    @PostConstruct
    public void init() {
        this.pregunta = new Pregunta();
        this.respuestas = new ArrayList<>();
    }

    public String seleccionarPregunta(Pregunta preguntaSeleccionada){
        if (preguntaSeleccionada != null){
            this.pregunta = preguntaSeleccionada;
            respuestas = appServices.methodListGET(Constantes.appUrl + "respuestas/" + pregunta.getId(),
                    PreguntaRespuesta[].class);
        }

        return "preguntaRespuestas?faces-redirect=true";
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public List<PreguntaRespuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<PreguntaRespuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
