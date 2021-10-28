package yincana

class AdministradorDePistas {
    Set<Pista> pistas = []

    static hasMany = [
        pistas: Pista,
    ]

    static constraints = {
    }

    Pista obtener_nueva_pista(Jugador jugador){
        Pista nueva_pista = this.pistas.find {pista -> 
            !pista.ayudo(jugador)
        }
        return nueva_pista.ayudar(jugador)
    }

    Set<Pista> obtener_pistas(Jugador jugador){
        Set<Pista> pistas = this.pistas.findAll {pista -> 
            pista.ayudo(jugador)
        }
        return pistas
    }
}
