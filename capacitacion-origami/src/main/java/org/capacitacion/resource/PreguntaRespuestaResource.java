package org.capacitacion.resource;

import org.capacitacion.dto.PreguntaRespuestaDto;
import org.capacitacion.services.PreguntaRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PreguntaRespuestaResource {
    @Autowired
    private PreguntaRespuestaService preguntaRespuestaService;

    @GetMapping("/respuestas")
    public ResponseEntity<?> getRespuestas(){
        return ResponseEntity.ok(preguntaRespuestaService.findAll());
    }

    @GetMapping("/respuestas/{id}")
    public ResponseEntity<?> getRespuestasById(@PathVariable("id") Long id){
        return ResponseEntity.ok(preguntaRespuestaService.findById(id));
    }


    @PostMapping("/guardarRespuesta")
    public ResponseEntity<?> guardarRespuesta(@RequestBody PreguntaRespuestaDto preguntaRespuestaDto){
        return ResponseEntity.ok(preguntaRespuestaService.guardar(preguntaRespuestaDto));
    }
}
