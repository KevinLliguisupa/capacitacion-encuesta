package org.capacitacion.services;

import org.capacitacion.dto.PreguntaDto;
import org.capacitacion.entidad.Pregunta;
import org.capacitacion.entidad.PreguntaRespuesta;
import org.capacitacion.mappers.PreguntaMapper;
import org.capacitacion.respository.PreguntaRepository;
import org.capacitacion.respository.PreguntaRespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;
    @Autowired
    private PreguntaMapper preguntaMapper;
    @Autowired
    private PreguntaRespuestaRepository preguntaRespuestaRepository;

    public List<PreguntaDto> findAll() {
        List<PreguntaDto> list = preguntaMapper.toDto(preguntaRepository.findAllByOrderByIdDesc());
        return list;
    }

    public PreguntaDto guardar(PreguntaDto preguntaDto){
        Pregunta pregunta = preguntaMapper.toEntity(preguntaDto);

        if(pregunta.getFechaRegistro() == null){
            pregunta.setFechaRegistro(new Date());
        }

        preguntaRepository.save(pregunta);

        return preguntaMapper.toDto(pregunta);
    }

    public String crearEncuesta(){
        List<PreguntaDto> preguntas = findAll();

        for (PreguntaDto p : preguntas) {
            PreguntaRespuesta r = new PreguntaRespuesta();
            r.setPregunta(new Pregunta(p.getId()));
            r.setRealizada(false);
            r.setCalificacion(0);
            r.setFechaRegistro(new Date());
            preguntaRespuestaRepository.save(r);
        }

        return "Encuesta creada correctamente";
    }
}
