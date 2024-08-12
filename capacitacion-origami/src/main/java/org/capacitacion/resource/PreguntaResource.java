package org.capacitacion.resource;

import org.capacitacion.dto.PreguntaDto;
import org.capacitacion.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PreguntaResource {
    @Autowired
    private PreguntaService preguntaService;

    @GetMapping("/preguntas")
    public ResponseEntity<?> getPregunta(){
        return ResponseEntity.ok(preguntaService.findAll());
    }

    @PostMapping("/guardarPregunta")
    public ResponseEntity<?> guardarPregunta(@RequestBody PreguntaDto preguntaDto){
        return ResponseEntity.ok(preguntaService.guardar(preguntaDto));
    }
}
