package yincana

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class JugadorSpec extends Specification implements DomainUnitTest<Jugador> {
    Pista pista1 = new Pista(
        descripcion: 'Le doy hogares a los pájaros',
        ayudados: []
    )
    Pista pista2 = new Pista(
        descripcion: 'Te ayudo a respirar',
        ayudados: []
    )
    Pista pista3 = new Pista(
        descripcion: 'Te doy fruta para comer',
        ayudados: []
    )

    Mision mision = new Mision(
        'Los piratas', 
        'Un 16 de Mayo llegaron piratas a las costas de Buenos Aires, y escondieron un gran tesoro. ¿Podrás encontrarlo?',
        'Alto y fuerte, me quedo afuera. El sol, la lluvia, están a mi lado.',
        'La respuesta correcta',
        -34.616542734808334,
        -58.368285215341956,
        pista1,
        pista2,
        pista3 
    )

    def setup() {
        Jugador mariana = new Jugador(
            nombre: 'Mariana',
            creados: [],
            ganados: []
        )
        return mariana
    }

    def cleanup() {
    }

    void "Resolver con respuesta correcta"() {
        when:
            Jugador mariana = setup()
        then:
            mariana.resolver(mision, 'La respuesta correcta')
    }

    void "Resolver con respuesta incorrecta"() {
        when:
            Jugador mariana = setup()
        then:
            !mariana.resolver(mision, 'La respuesta incorrecta')
    }
}
