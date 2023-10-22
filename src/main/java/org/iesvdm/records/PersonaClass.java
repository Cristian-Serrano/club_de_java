package org.iesvdm.records;

import java.time.LocalDate;
import java.util.Objects;

public class PersonaClass{

    private String nombre;

    private String apellidos;

    private LocalDate fechaNacimiento;

    private String nif;

    private long telefono;

    public PersonaClass(String nombre, String apellidos, LocalDate fechaNacimiento, String nif, long telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nif = nif;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaClass that = (PersonaClass) o;
        return Objects.equals(nif, that.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif);
    }

    @Override
    public String toString() {
        return "PersonaClass{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nif='" + nif + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
