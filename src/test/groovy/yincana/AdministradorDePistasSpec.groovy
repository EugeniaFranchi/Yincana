package yincana

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AdministradorDePistasSpec extends Specification implements DomainUnitTest<AdministradorDePistas> {
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
        def pistas = [pista1, pista2, pista3]

        def admin = new AdministradorDePistas(pistas: pistas)

        return admin
    }

    def cleanup() {
    }

    void "Obtener nueva pista: primera vez"() {
        when:
            def admin = setup()
        then:
            admin.obtener_nueva_pista(mariana) == pista1
    }

    void "Obtener nueva pista: segunda vez"() {
        when:
            def admin = setup()
            admin.obtener_nueva_pista(mariana)
        then:
            admin.obtener_nueva_pista(mariana) == pista2
    }

    void "Obtener nueva pista: tercera vez"() {
        when:
            def admin = setup()
            admin.obtener_nueva_pista(mariana)
            admin.obtener_nueva_pista(mariana)
        then:
            admin.obtener_nueva_pista(mariana) == pista3
    }

    void "Obtener pistas del jugador: sin pistas"() {
        when:
            def admin = setup()
            def pistas = admin.obtener_pistas(mariana)
        then:
            pistas.size() == 0
    }

    void "Obtener pistas del jugador: una pista obtenida"() {
        when:
            def admin = setup()
            admin.obtener_nueva_pista(mariana)
            def pistas = admin.obtener_pistas(mariana)
        then:
            pistas.size() == 1 && pistas.contains(pista1) 
    }

    void "Obtener pistas del jugador: dos pistas obtenidas"() {
        when:
            def admin = setup()
            admin.obtener_nueva_pista(mariana)
            admin.obtener_nueva_pista(mariana)
            def pistas = admin.obtener_pistas(mariana)
        then:
            pistas.size() == 2 && pistas.contains(pista1) && pistas.contains(pista2) 
    }

    void "Obtener pistas del jugador: tres pistas obtenidas"() {
        when:
            def admin = setup()
            admin.obtener_nueva_pista(mariana)
            admin.obtener_nueva_pista(mariana)
            admin.obtener_nueva_pista(mariana)
            def pistas = admin.obtener_pistas(mariana)
        then:
            pistas.size() == 3 && pistas.contains(pista1) &&
                pistas.contains(pista2) && pistas.contains(pista3) 
    }
}
