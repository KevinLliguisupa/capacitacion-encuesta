package org.capacitacion.services;

import org.capacitacion.dto.PreguntaDto;
import org.capacitacion.entidad.Pregunta;
import org.capacitacion.mappers.PreguntaMapper;
import org.capacitacion.respository.PreguntaRepository;
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

}
