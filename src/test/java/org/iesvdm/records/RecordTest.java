package org.iesvdm.records;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class RecordTest {

    @Test
    void utilizandoRecordsTest() {

        //Record: clase que actúa como un portador de datos inmutables
        PersonaClass personaClass = new PersonaClass("José M.",
                "Martín",
                LocalDate.of(1980,1,1),
                "7411223344W",
                952102030);

        PersonaRecord personaRecord = new PersonaRecord("José M.",
        "Martín",
        LocalDate.of(1980,1,1),
                "7411223344W",
        952102030);

        //Leer atributos ------------------------------------------
        //                                    | by getter         | by field
        //                                    V                   |
        Assertions.assertTrue(personaClass.getNombre()  //        V
                                                .equals(personaRecord.nombre()));

        //Escribir atributos --
        //                    |
        //                    V
        personaClass.setNombre("Gandalf");

        //ERROR DE COMPILACIÓN -> record es INMUTABLE!
        // Una vez creado no se pueden cambiar sus campos.
        //personaRecord.nombre("Gandalf") <- ERROR!!

        Assertions.assertFalse(personaClass.getNombre()
                                                .equals(personaRecord.nombre()));

        personaClass.setNombre("José M.");

        //personClass.toString() implementado por intellij con {} mientras que personRecord.toString() utiliza []
        //                   |
        //                   ----------------------------------
        //                                                    V
        System.out.println("PersonaClass.toString()\n" + personaClass);
        System.out.println("");
        System.out.println("PersonaRecord.toString()\n" + personaRecord);

        Assertions.assertFalse(personaClass.toString()
                                        .equals(personaRecord.toString()));

        PersonaRecord personaRecordIgual = new PersonaRecord("José M.",
                "Martín",
                LocalDate.of(1980,1,1),
                "7411223344W",
                952102030);

        Assertions.assertTrue(personaRecord.equals(personaRecordIgual));
        Assertions.assertTrue(personaRecord.hashCode() == personaRecordIgual.hashCode());

    }


    @Test
    void constructorCompactoTest() {
        PersonaRecord2 personaRecord2 = new PersonaRecord2( "José M.   ",
                                                "      Martín",
                                                        LocalDate.of(1980, 1, 1),
                                                        "7411223344W",
                                                            952102030);
        //EL CONSTRUCTOR COMPACTO DE PersonaRecord2 convierte a minúsculas y mayúsculas los respectivos campos
        Assertions.assertTrue(personaRecord2.nombre().equals("josé m."));
        Assertions.assertTrue(personaRecord2.apellidos().equals("MARTÍN"));
    }

    @Test
    void modificarUnRecord() {

        PersonaRecord3 personaRecord3 = new PersonaRecord3( "José M.",
                "Martín",
                LocalDate.of(1980, 1, 1),
                "7411223344W",
                952102030);

        Assertions.assertTrue(personaRecord3.nombre().equals("José M."));
        // LOS records SON INMUTABLES, UN CAMBIO SIEMPRE SUPONE CREAR UNO NUEVO
        // Y ASIGNAR ------------
        //     |                |
        //     V                v
        personaRecord3 = personaRecord3.changeNombre("Gandalf");
        Assertions.assertTrue(personaRecord3.nombre().equals("Gandalf"));

    }

    @Test
    void localRecord() {

        //DECLARO EL record EN UN ÁMBITO LOCAL
        //       |
        //       V
        record Coche(String matricula, String marca, String modelo, LocalDate fechaMatriculacion){}

        //UNA VEZ DECLARADO PUEDO UTILIZARLO
        Coche coche = new Coche("MA1234TT", "SEAT", "Córdoba",  LocalDate.of(1999,1,1));
        Assertions.assertTrue(coche.modelo().equals("MA1234TT"));

    }


    @Test
    void nestedRecords() {
        //records ANIDADOS

        //DECLARO LOS records EN UN ÁMBITO LOCAL
        //       |
        //       V
        record Conductor(String nombre, String apellidos, long dni, String tipoCarnet){}
        record Acompañante(String nombre, String apellidos, long dni){}
        //      |
        //      ----------------------------------------------
        //      |                                            |
        //       -----------------                           |
        //                        |                          |
        //                        V                          V
        record Coche(Conductor conductor, Acompañante[] acompañantes, String matricula, String marca, String modelo, LocalDate fechaMatriculacion){}

        //UNA VEZ DECLARADO PUEDO UTILIZARLO
        Coche coche = new Coche( new Conductor("José M.", "Martín", 2499887766l, "B"),
                // ASIGNO UN ARRAY DE record Acompañante
                //                              |
                //                              V
                new Acompañante[] { new Acompañante("Larry", "Wall", 2477889900l), new Acompañante("Paco", "Menéndez", 2477887788l)},
                "MA1234TT", "SEAT", "Córdoba",  LocalDate.of(1999,1,1));

        Assertions.assertTrue(coche.conductor().nombre().equals("José M."));
        Assertions.assertTrue(coche.acompañantes().length == 2);

    }
}
