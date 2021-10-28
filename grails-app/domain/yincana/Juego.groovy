package yincana

class Juego {
    String titulo
    String descripcion

    static constraints = {
        titulo nullable: false, blanck: false
        descripcion nullable: false, blanck: false
    }

    Juego(String titulo, String descripcion) {
        this.titulo = titulo
        this.descripcion = descripcion
    }
}
