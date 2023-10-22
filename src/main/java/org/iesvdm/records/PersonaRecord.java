package org.iesvdm.records;

import java.time.LocalDate;

public record PersonaRecord(String nombre,
                            String apellidos,
                            LocalDate fechaNacimiento,
                            String nif,
                            long telefono) {

}
