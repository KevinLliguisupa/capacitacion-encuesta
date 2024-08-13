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
public class PreguntaMB implements Serializable {

    @Inject
    private AppServices appServices;
    private List<Pregunta> preguntas;
    private Pregunta nuevaPregunta;
    private Pregunta preguntaSeleccionada;
    private PreguntaRespuesta respuesta;

    @PostConstruct
    public void init() {
        this.preguntas = new ArrayList<>();
        iniciar();
    }

    public void iniciar(){
        respuesta = new PreguntaRespuesta();
        nuevaPregunta = new Pregunta();
        preguntas = appServices.methodListGET(Constantes.appUrl + "preguntas", Pregunta[].class);
    }

    public void guardarPregunta(){
        Pregunta p = (Pregunta) appServices.methodPOST(nuevaPregunta, Constantes.appUrl + "guardarPregunta", Pregunta.class);
        iniciar();
    }

    public void responderPregunta(Pregunta p) {
        this.preguntaSeleccionada = p;
    }

    public void guardarRespuesta(){
        this.respuesta.setPreguntaId(preguntaSeleccionada.getId());
        PreguntaRespuesta r = (PreguntaRespuesta) appServices.methodPOST(respuesta,
                Constantes.appUrl + "guardarRespuesta", PreguntaRespuesta.class);
        respuesta = new PreguntaRespuesta();
    }

    public void crearEncuesta(){
        String response = (String) appServices.methodPOST(Constantes.appUrl + "crearEncuesta", String.class);
        System.out.println("Peticion de creacion de encuesta: " + response);
    }

    public void editarPregunta(Pregunta p){
        this.nuevaPregunta = p;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Pregunta getNuevaPregunta() {
        return nuevaPregunta;
    }

    public void setNuevaPregunta(Pregunta nuevaPregunta) {
        this.nuevaPregunta = nuevaPregunta;
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

