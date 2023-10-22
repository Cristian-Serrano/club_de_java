package org.iesvdm.records;

import org.iesvdm.model.Administrativo;
import org.iesvdm.model.Empleado;
import org.iesvdm.model.Persona;
import org.iesvdm.model.Programador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TypeCheckTest {

        @Test
        void typeCheckAntesDeJava16() {
            //ANTES DE JAVA 16 TYPE CHECK  instanceof y cast (moldeado)
            Persona persona1 = new Administrativo("Pedro", "Picapiedra", 1122334455, 123, "junior");
            Persona persona2 = new Programador("Pablo", "Mármol", 1122334456, 124, new String[] {"senior"});
            List<Persona> personaList = Arrays.asList(persona1,
                          persona2
                    );
            //LAMBDA DE BLOQUE----------
            //  consumer: T -> void    |
            //                         V
            personaList.forEach( (p) -> {

                if (p instanceof Administrativo) {
                    // NECESITO UN CASTEO DE TIPO
                    //                  |
                    //                   ------------
                    //                              |
                    //                              V
                    Administrativo administrativo = (Administrativo) p;
                    System.out.println("ADMINISTRAVITO:" + p);

                } else if ( p instanceof Programador) {
                    // NECESITO UN CASTEO DE TIPO
                    //                  |
                    //                   ------------
                    //                              |
                    //                              V
                    Programador programador = (Programador) p;
                    System.out.println("PROGRAMADOR:" + p);
                }

            });

    }

    @Test
    void typeCheckDespuesDeJava16() {
        //ANTES DE JAVA 16 TYPE CHECK  instanceof y cast (moldeado)
        Persona persona1 = new Administrativo("Pedro", "Picapiedra", 1122334455, 123, "junior");
        Persona persona2 = new Programador("Pablo", "Mármol", 1122334456, 124, new String[]{"senior"});
        List<Persona> personaList = Arrays.asList(persona1,
                persona2
        );
        //LAMBDA DE BLOQUE----------
        //  consumer: T -> void    |
        //                         V
        personaList.forEach( (p) -> {

            if (p instanceof Administrativo administrativo) {
                //YA NO NECESITO UN CASTEO DE TIPO, ASIGNO EN EL instanceof
                System.out.println("ADMINISTRAVITO:" + administrativo);

            } else if ( p instanceof Programador programador) {
                //YA NO NECESITO UN CASTEO DE TIPO, ASIGNO EN EL instanceof
                System.out.println("PROGRAMADOR:" + programador);
            }

        });
    }


    /**
     * @see <a href="https://openjdk.org/jeps/440#:~:text=A%20record%20pattern%20can%20use,int%20a%2C%20int%20b)%20.">Java 21 Record Pattern</a>
     */
    @Test
    void recordPatternJava21() {

        record Persona(String nombre, String apellidos, long dni){}
        //      |
        //      ------------------------
        //                             |
        //                             V
        record Empleado(int codigo, Persona persona){}
        record Coche(String matricula, String numeroBastidor, LocalDate fechaMatriculacion){}

        List<Record> recordList = Arrays.asList(new Persona("Pedro", "Picapiedra", 1122334455),
                                                new Empleado(123, new Persona("Pablo", "Marmol", 1122334466)),
                                                new Coche("MA1122TT", "123456", LocalDate.of(1999,1,1))
                                );

        for (Record record: recordList
             ) {

            //EN EL FUTURO PATTERN MATCHING TAMBIÉN PARA OBJETOS NORMALES NO SÓLO records..
            if (record instanceof Persona(var nombre, var apellidos, var dni)) {
                System.out.println("Persona: " + nombre + " " + apellidos + " | dni: " + dni);
            } else if (record instanceof Empleado(var codigo, Persona(var nombre, var apellidos, _))) {
                                                                                        //        |---IGNORO EL dni EL OPERADOR DE IGNORAR _ EN PREVIEW
                                                                                        //        V   UNNAMED PATTERN - PATRÓN SIN NOMBRE
                System.out.println("Empleado: " + codigo + " | " + nombre + " " + apellidos /*+ " | dni: " + dni*/);
            } else if (record instanceof Coche(var mat, var numeroBast, var fechaMat)) {
                System.out.println("Coche: " + mat + " |  bastidor: " + numeroBast + " | fecha de matriculación: " + fechaMat);
            }
        }

        Assertions.assertTrue(true);

    }
}
