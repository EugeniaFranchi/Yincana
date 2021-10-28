package yincana

class Locacion {
    BigDecimal latitud
    BigDecimal longitud

    static constraints = {
        latitud nullable: false, blanck: false
        longitud nullable: false, blanck: false
    }
}
