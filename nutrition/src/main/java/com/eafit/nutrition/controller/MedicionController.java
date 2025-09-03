package com.eafit.nutrition.controller;

import com.eafit.nutrition.model.Medicion;
import com.eafit.nutrition.service.MedicionServiceAutowired;
import com.eafit.nutrition.service.MedicionServiceConstructor;
import com.eafit.nutrition.service.MedicionServiceSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/mediciones")
public class MedicionController {

    private final MedicionServiceConstructor constructorService;
    @Autowired private MedicionServiceAutowired autowiredService;
    private MedicionServiceSetter setterService;

    public MedicionController(MedicionServiceConstructor constructorService) {
        this.constructorService = constructorService;
    }

    @Autowired
    public void setSetterService(MedicionServiceSetter setterService) {
        this.setterService = setterService;
    }

    @GetMapping("/constructor")
    public ResponseEntity<List<Medicion>> getAllConstructor() {
        return ResponseEntity.ok(constructorService.findAll());
    }

    @GetMapping("/autowired")
    public ResponseEntity<List<Medicion>> getAllAutowired() {
        return ResponseEntity.ok(autowiredService.findAll());
    }

    @GetMapping("/setter")
    public ResponseEntity<List<Medicion>> getAllSetter() {
        return ResponseEntity.ok(setterService.findAll());
    }

    @GetMapping("/compare/{id}")
    public ResponseEntity<Map<String, Object>> compareById(@PathVariable Long id) {
        var c = constructorService.findById(id);
        var a = autowiredService.findById(id);
        var s = setterService.findById(id);
        Map<String, Object> out = new HashMap<>();
        out.put("constructorService", c.orElse(null));
        out.put("autowiredService",   a.orElse(null));
        out.put("setterService",      s.orElse(null));
        return ResponseEntity.ok(out);
    }

    @GetMapping("/compare/paciente/{pacienteId}/ultima-medicion")
    public ResponseEntity<Map<String, Object>> compareLast(@PathVariable Long pacienteId) {
        var c = constructorService.findLastMedicionByPacienteId(pacienteId);
        var a = autowiredService.findLastMedicionByPacienteId(pacienteId);
        var s = setterService.findLastMedicionByPacienteId(pacienteId);
        Map<String, Object> out = new HashMap<>();
        out.put("constructorService", c.orElse(null));
        out.put("autowiredService",   a.orElse(null));
        out.put("setterService",      s.orElse(null));
        return ResponseEntity.ok(out);
    }

    @PostMapping("/constructor/paciente/{pacienteId}/nutricionista/{nutricionistaId}")
    public ResponseEntity<Medicion> createWithConstructor(
            @PathVariable Long pacienteId,
            @PathVariable Long nutricionistaId,
            @RequestBody Medicion medicion) {
        var created = constructorService.createMedicion(pacienteId, nutricionistaId, medicion);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
