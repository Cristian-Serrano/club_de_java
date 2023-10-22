package org.iesvdm.model;

import java.util.Objects;

public abstract class Empleado extends Persona{

    private int codigo;

    public Empleado(String nombre, String apellidos, long dni, int codigo) {
        super(nombre, apellidos, dni);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni=" + dni +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return codigo == empleado.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codigo);
    }
}


