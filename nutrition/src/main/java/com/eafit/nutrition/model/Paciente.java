package com.eafit.nutrition.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", nullable=false, length=100)
    private String nombre;

    @Column(name="apellido", nullable=false, length=100)
    private String apellido;

    @Column(name="fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name="email", nullable=false, length=150, unique=true)
    private String email;

    @Column(name="telefono", length=20)
    private String telefono;

    @Column(name="activo", nullable=false)
    private boolean activo = true;

    // Muchos a uno con Nutricionista (EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nutricionista_id", nullable = false)
    @JsonIgnoreProperties({"pacientes", "notas"}) // evita ciclos
    private Nutricionista nutricionista;

    // Uno a muchos con Nota (LAZY)
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"paciente", "nutricionista"}) // evita ciclos
    private List<Nota> notas = new ArrayList<>();

    public Paciente() {}

    public Paciente(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    // Helper
    public void addNota(Nota n){
        notas.add(n);
        n.setPaciente(this);
    }

    // Getters/Setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getNombre(){ return nombre; }
    public void setNombre(String nombre){ this.nombre = nombre; }

    public String getApellido(){ return apellido; }
    public void setApellido(String apellido){ this.apellido = apellido; }

    public LocalDate getFechaNacimiento(){ return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento){ this.fechaNacimiento = fechaNacimiento; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    public String getTelefono(){ return telefono; }
    public void setTelefono(String telefono){ this.telefono = telefono; }

    public boolean isActivo(){ return activo; }
    public void setActivo(boolean activo){ this.activo = activo; }

    public Nutricionista getNutricionista(){ return nutricionista; }
    public void setNutricionista(Nutricionista nutricionista){ this.nutricionista = nutricionista; }

    public List<Nota> getNotas(){ return notas; }
    public void setNotas(List<Nota> notas){ this.notas = notas; }
}