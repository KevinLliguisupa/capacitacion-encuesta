package org.proyecto.managedbeans;

import org.proyecto.config.Constantes;
import org.proyecto.model.Pregunta;
import org.proyecto.services.intefaces.AppServices;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PreguntaMB implements Serializable {

    @Inject
    private AppServices appServices;
    private List<Pregunta> preguntas;
    private Pregunta pregunta;

    @PostConstruct
    public void init() {
        iniciar();
    }

    public void iniciar(){
        pregunta = new Pregunta();
        preguntas = appServices.methodListGET(Constantes.appUrl + "preguntas", Pregunta[].class);
    }

    public void guardarPregunta(){
        Pregunta p = (Pregunta) appServices.methodPOST(pregunta, Constantes.appUrl + "guardarPregunta", Pregunta.class);
        System.out.println("Pregunta: " + p.toString());
        iniciar();
    }

    public void editarPregunta(Pregunta p){
        this.pregunta = p;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
}

