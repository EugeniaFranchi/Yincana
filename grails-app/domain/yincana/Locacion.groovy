package yincana

class Locacion {
    Float latitud
    Float longitud

    static constraints = {
        latitud nullable: false, blanck: false
        longitud nullable: false, blanck: false
    }
}
