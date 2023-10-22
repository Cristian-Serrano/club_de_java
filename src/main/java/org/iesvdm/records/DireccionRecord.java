package org.iesvdm.records;

public record DireccionRecord(String calle,
                              int numero,
                              String localidad,
                              String provincia,
                              int codigoPostal ) {

    //ERROR DE COMPILACIÓN: un record no puede tener campos
    //private String noPuedeHaberCampos; <- ERROR!

    //Constructor canónico: con todos los atributos como argumentos

    public DireccionRecord(String calle, int numero, String localidad, String provincia, int codigoPostal) {
        this.calle = calle.toUpperCase().trim();
        this.numero = numero;
        this.localidad = localidad.toUpperCase().trim();
        this.provincia = provincia.toUpperCase().trim();
        this.codigoPostal = codigoPostal;
    }

    //Constructor no canónico: en el que faltan atributos. Puedes utilizarlo para settear defaults
    public DireccionRecord(String calle, int numero, String localidad, int codigoPostal) {
        //El atributo con un valor a default MÁLAGA
        //                                     |
        //                                     V
        this(calle, numero, localidad, "MÁLAGA", codigoPostal);

    }
}
