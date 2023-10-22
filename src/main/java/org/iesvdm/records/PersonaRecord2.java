package org.iesvdm.records;

import java.time.LocalDate;

public record PersonaRecord2(String nombre,
                             String apellidos,
                             LocalDate fechaNacimiento,
                             String nif,
                             long telefono) {

    //Constructor compacto
    public PersonaRecord2 {
        //EN EL CONSTRUCTOR COMPACTO NO NECESITAS REFERENCIA this
        //atributos del record
        //  |       |
        //  V       V
        nombre = nombre.trim().toLowerCase();
        apellidos = apellidos.trim().toUpperCase();


    }
}
