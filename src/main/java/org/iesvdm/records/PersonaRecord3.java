package org.iesvdm.records;

import java.time.LocalDate;

// NO SE PUEDE HEREDAR DE records ESTÁN MARCADOS COMO CLASES final SOLO PUEDEN IMPLEMENTAR INTEFACES
//                                      |
//                                      V
public record PersonaRecord3 /* extends PersonRecord ERROR!!*/ (String nombre,
        String apellidos,
        LocalDate fechaNacimiento,
        String nif,
        long telefono){

    //LOS records SON INMUTABLES: una vez creado no puedes cambiar el valor de sus atributos
    //SI SE NECESITA CAMBIAR UN ATRIBUTO DEBES CREAR UN record NUEVO.
    //          |
    //          V
    public PersonaRecord3 changeNombre(String newNombre) {
        //                                      |
        //                              --------
        //                             |    RESTO SON LOS ATRIBUTOS DEL record
        //                             V         V           V   ...
        return new PersonaRecord3(newNombre, apellidos, fechaNacimiento, nif, telefono);
    }
    public PersonaRecord3 changeApellidos(String newApellidos) {
        //                                          |
        //                                        ---
        //                           --          |     -- RESTO SON LOS ATRIBUTOS DEL record
        //                          V            V         V           V   ...
        return new PersonaRecord3(nombre, newApellidos, fechaNacimiento, nif, telefono);
    }

}
