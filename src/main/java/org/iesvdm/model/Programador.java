package org.iesvdm.model;

import java.util.Arrays;

public final class Programador extends Empleado{

    private String[] lenguajes;

    public Programador(String nombre, String apellidos, long dni, int codigo, String[] lenguajes) {
        super(nombre, apellidos, dni, codigo);
        this.lenguajes = lenguajes;
    }

    public String[] getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String[] lenguajes) {
        this.lenguajes = lenguajes;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "lenguajes=" + Arrays.toString(lenguajes) +
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
        Programador that = (Programador) o;
        return Arrays.equals(lenguajes, that.lenguajes);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(lenguajes);
        return result;
    }
}
