package yincana

class Jugador {
    String nombre
    Set<Juego> ganados = []
    Set<Juego> creados = []

    static hasMany = [
        ganados: Juego,
        creados: Juego,
    ]

    static constraints = {
        nombre nullable: false, blanck: false
    }
}
