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

    boolean resolver(Mision mision, String intento){
        if (mision.resolver(intento)) {
            ganados << mision
            return true
        }
        return false
    }

    boolean gano(Juego juego){
        return juego in this.ganados
    }
}
