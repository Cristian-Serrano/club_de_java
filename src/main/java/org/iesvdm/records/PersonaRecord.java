package org.iesvdm.records;

import java.time.LocalDate;

//USA records EN EL PARADIGMA:
//DOP - DATA ORIENTED PROGRAMMING - PROGRAMACIÓN ORIENTADA A DATOS
//FRENTE class EN EL PARADIGMA
//OOP - OBJECT ORIENTED PROGRAMMING - PROGRAMACIÓN ORIENTADA A OBJETOS
public record PersonaRecord(String nombre,
                            String apellidos,
                            LocalDate fechaNacimiento,
                            String nif,
                            long telefono) {

}
