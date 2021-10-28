package yincana

import groovy.lang.Tuple

class Mision extends Juego {
    String acertijo
    String respuesta
    Locacion locacion
    AdministradorDePistas administradorDePistas

    static constraints = {
        acertijo nullable: false, blanck: false
        respuesta nullable: false, blanck: false
        locacion nullable: false, blanck: false
        administradorDePistas nullable: false
    }

    Mision(acertijo, respuesta, latitud, longitud, pista1, pista2, pista3) {
        println("holaaaaaaaaaaaa")
        this.acertijo = acertijo
        this.respuesta = respuesta
        this.locacion = new Locacion(latitud: latitud, longitud: longitud)
        this.administradorDePistas = new AdministradorDePistas(pistas: [pista1, pista2, pista3])
    }

    boolean resolver(String intento){
        return intento == this.respuesta
    }

    Pista obtener_nueva_pista(Jugador jugador){
        return this.administradorDePistas.obtener_nueva_pista(jugador)
    }

    Set<Pista> obtener_pistas(Jugador jugador){
        return this.administradorDePistas.obtener_pistas(jugador)
    }

}
