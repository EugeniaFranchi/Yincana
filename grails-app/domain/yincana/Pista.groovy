package yincana

class Pista {
    String descripcion
    Set<Jugador> ayudados

    static hasMany = [
        ayudados: Jugador,
    ]

    static constraints = {
    }

    boolean ayudo(Jugador jugador){
        return this.ayudados.contains(jugador)
    }

    Pista ayudar(Jugador jugador){
        ayudados << jugador
        return this
    }
}
