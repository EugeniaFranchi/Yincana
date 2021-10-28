package yincana

class Misterio extends Juego {
    Set<Mision> misiones = []

    static hasMany = [
        misiones: Mision,
    ]

    static constraints = {
    }
}
