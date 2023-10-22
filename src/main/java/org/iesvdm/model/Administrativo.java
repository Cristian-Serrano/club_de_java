package org.iesvdm.model;

import java.util.Objects;

public final class Administrativo extends Empleado {

    protected String categoria;

    public Administrativo(String nombre, String apellidos, long dni, int codigo, String categoria) {
        super(nombre, apellidos, dni, codigo);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "categoria='" + categoria + '\'' +
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
        Administrativo that = (Administrativo) o;
        return Objects.equals(categoria, that.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), categoria);
    }
}
