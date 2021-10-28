package yincana

class Misterio extends Juego {
    Set<Mision> misiones = []

    static hasMany = [
        misiones: Mision,
    ]

    static constraints = {
    }

    Misterio(String titulo, String descripcion, Set<Mision> misiones){
        super(titulo, descripcion)
        this.misiones = misiones
    }

    Set<Mision> obtener_misiones_desbloqueadas(Jugador jugador){
        Set<Mision> misiones = this.misiones.findAll {mision -> 
            jugador.gano(mision)}
        // Añado el siguiente al ultimo completado
        misiones << this.misiones[misiones.size()]
        return misiones
    }
}
