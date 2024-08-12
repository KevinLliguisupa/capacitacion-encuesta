package org.capacitacion.mappers;

import org.capacitacion.dto.PreguntaRespuestaDto;
import org.capacitacion.entidad.PreguntaRespuesta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PreguntaRespuestaMapper {

    @Mapping(target = "preguntaId", source = "entity.pregunta.id")
    PreguntaRespuestaDto toDto(PreguntaRespuesta entity);
    @Mapping(target = "pregunta.id", source = "dto.preguntaId")
    PreguntaRespuesta toEntity(PreguntaRespuestaDto dto);

    List<PreguntaRespuestaDto> toDto(List<PreguntaRespuesta> entities);

}
