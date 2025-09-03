package com.eafit.nutrition.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicion")
public class Medicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "peso", nullable = false)
    private Double peso; // kg

    @Column(name = "altura", nullable = false)
    private Double altura; // cm

    @Column(name = "circunferencia_cintura")
    private Double circunferenciaCintura;

    @Column(name = "circunferencia_cadera")
    private Double circunferenciaCadera;

    @Column(name = "porcentaje_grasa_corporal")
    private Double porcentajeGrasaCorporal;

    // Constructores
    public Medicion() {}

    public Medicion(Double peso, Double altura) {
        this.fecha = LocalDate.now();
        this.peso = peso;
        this.altura = altura;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public Double getAltura() { return altura; }
    public void setAltura(Double altura) { this.altura = altura; }

    public Double getCircunferenciaCintura() { return circunferenciaCintura; }
    public void setCircunferenciaCintura(Double circunferenciaCintura) { this.circunferenciaCintura = circunferenciaCintura; }

    public Double getCircunferenciaCadera() { return circunferenciaCadera; }
    public void setCircunferenciaCadera(Double circunferenciaCadera) { this.circunferenciaCadera = circunferenciaCadera; }

    public Double getPorcentajeGrasaCorporal() { return porcentajeGrasaCorporal; }
    public void setPorcentajeGrasaCorporal(Double porcentajeGrasaCorporal) { this.porcentajeGrasaCorporal = porcentajeGrasaCorporal; }
}