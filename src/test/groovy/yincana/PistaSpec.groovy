package yincana

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PistaSpec extends Specification implements DomainUnitTest<Pista> {
    Jugador mariana = new Jugador(
        nombre: 'Mariana',
        ganados: []
    )

    def setup() {
        Pista pista = new Pista(
            descripcion: 'Le doy hogares a los pájaros',
            ayudados: []
        )

        return pista
    }

    def cleanup() {
    }

    void "No ayudó a ningun jugador"() {
        when:
            def pista = setup()
        then:
            !pista.ayudo(mariana)
    }

    void "Ayudó a un jugador"() {
        when:
            def pista = setup()
            pista.ayudar(mariana)
        then:
            pista.ayudo(mariana)
    }

    void "Ayudar a un jugador devuelve la pista"() {
        when:
            def pista = setup()
        then:
            pista.ayudar(mariana) === pista
    }
}
