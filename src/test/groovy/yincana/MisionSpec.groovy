package yincana

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MisionSpec extends Specification implements DomainUnitTest<Mision> {
    Jugador mariana = new Jugador(
        nombre: 'Mariana',
        ganados: []
    )

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

    def setup() {
        Mision mision = new Mision(
            titulo: 'Los piratas', 
            descripcion: 'Un 16 de Mayo llegaron piratas a las costas de Buenos Aires, y escondieron un gran tesoro. ¿Podrás encontrarlo?',
            creador: mariana,
            acertijo: 'Alto y fuerte, me quedo afuera. El sol, la lluvia, están a mi lado.',
            respuesta: 'La respuesta correcta',
            latitud: -34.616542734808334,
            longitud: -58.368285215341956,
            pista1: pista1,
            pista2: pista2,
            pista3: pista3 
        )
        return mision
    }

    def cleanup() {
    }

    void "Resolver con respuesta correcta"() {
        when:
            Mision mision = setup()
        then:
            mision.resolver('La respuesta correcta')
    }

    void "Resolver con respuesta incorrecta"() {
        when:
            Mision mision = setup()
        then:
            !mision.resolver('La respuesta incorrecta')
    }

/*    void "Obtener nueva pista: primera vez"() {
        when:
            Mision mision = setup()
        then:
            mision.obtener_nueva_pista(mariana) == pista1
    }

    void "Obtener nueva pista: segunda vez"() {
        when:
            Mision mision = setup()
            mision.obtener_nueva_pista(mariana)
        then:
            mision.obtener_nueva_pista(mariana) == pista2
    }

    void "Obtener nueva pista: tercera vez"() {
        when:
            Mision mision = setup()
            mision.obtener_nueva_pista(mariana)
            mision.obtener_nueva_pista(mariana)
        then:
            mision.obtener_nueva_pista(mariana) == pista3
    }

    void "Obtener pistas del jugador: sin pistas"() {
        when:
            Mision mision = setup()
            def pistas = mision.obtener_pistas(mariana)
        then:
            pistas.size() == 0
    }

    void "Obtener pistas del jugador: una pista obtenida"() {
        when:
            Mision mision = setup()
            mision.obtener_nueva_pista(mariana)
            def pistas = mision.obtener_pistas(mariana)
        then:
            pistas.size() == 1 && pistas.contains(pista1) 
    }

    void "Obtener pistas del jugador: dos pistas obtenidas"() {
        when:
            Mision mision = setup()
            mision.obtener_nueva_pista(mariana)
            mision.obtener_nueva_pista(mariana)
            def pistas = mision.obtener_pistas(mariana)
        then:
            pistas.size() == 2 && pistas.contains(pista1) && pistas.contains(pista2) 
    }

    void "Obtener pistas del jugador: tres pistas obtenidas"() {
        when:
            Mision mision = setup()
            mision.obtener_nueva_pista(mariana)
            mision.obtener_nueva_pista(mariana)
            mision.obtener_nueva_pista(mariana)
            def pistas = mision.obtener_pistas(mariana)
        then:
            pistas.size() == 3 && pistas.contains(pista1) &&
                pistas.contains(pista2) && pistas.contains(pista3) 
    }*/
}
