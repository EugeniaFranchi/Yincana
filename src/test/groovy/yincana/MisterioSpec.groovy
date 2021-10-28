package yincana

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MisterioSpec extends Specification implements DomainUnitTest<Misterio> {
    Jugador mariana = new Jugador(
        nombre: 'Mariana',
        creados: [],
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
    Pista pista4 = new Pista(
        descripcion: 'Entretengo a los niños',
        ayudados: []
    )
    Pista pista5 = new Pista(
        descripcion: 'Soy el más elegido',
        ayudados: []
    )
    Pista pista6 = new Pista(
        descripcion: 'Revisa en el punto de equilobrio',
        ayudados: []
    )

    Mision mision1 = new Mision(
        'Los piratas: parte 2', 
        'Un 16 de Mayo llegaron piratas a las costas de Buenos Aires, y escondieron un gran tesoro. ¿Podrás encontrarlo?',
        'Alto y fuerte, me quedo afuera. El sol, la lluvia, están a mi lado.',
        'La respuesta correcta 1',
        -34.616542734808334,
        -58.368285215341956,
        pista1,
        pista2,
        pista3 
    )

    Mision mision2 = new Mision(
        'Los piratas: parte 2', 
        '...Al año siguiente, los piratas volvieron con un tesoro aún mayor',
        'Cuando yo subo, tú bajas.',
        'La respuesta correcta 2',
        -35.116542734808334,
        -60.368285215341956,
        pista4,
        pista5,
        pista6 
    )

    def setup() {
        Set<Mision> misiones = [mision1, mision2]
        Misterio misterio = new Misterio(
            "Navegando",
            "Descubre los tesoros que han dejado los piratas en Buenos Aires",
            misiones)
        return misterio
    }

    def cleanup() {
    }

    void "Obtener misiones desbloqueadas si no ganó ninguna misión"() {
        when:
            Misterio misterio = setup()
            Set<Mision> misiones = misterio.obtener_misiones_desbloqueadas(mariana)
        then:
            misiones.size() == 1 && mision1 in misiones
    }

    void "Obtener misiones desbloqueadas si no ganó 1 misión"() {
        when:
            Misterio misterio = setup()
            mariana.resolver(mision1, 'La respuesta correcta 1')
            Set<Mision> misiones = misterio.obtener_misiones_desbloqueadas(mariana)
        then:
            misiones.size() == 2 && mision1 in misiones && mision2 in misiones
    }
}
