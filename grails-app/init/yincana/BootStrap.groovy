package yincana

class BootStrap {

    def init = { servletContext ->
        Jugador mariana = new Jugador(
            nombre: 'Mariana',
            creados: [],
            ganados: []
        ).save()
        Jugador gaston = new Jugador(
            nombre: 'Gaston',
            creados: [],
            ganados: []
        ).save()
        Jugador ariel = new Jugador(
            nombre: 'Ariel',
            creados: [],
            ganados: []
        ).save()

        Pista pista1 = new Pista(
            descripcion: 'Le doy hogares a los pájaros',
            ayudados: []
        ).save()
        Pista pista2 = new Pista(
            descripcion: 'Te ayudo a respirar',
            ayudados: []
        ).save()
        Pista pista3 = new Pista(
            descripcion: 'Te doy fruta para comer',
            ayudados: []
        ).save()

        new Mision(
            titulo: 'Los piratas', 
            descripcion: 'Un 16 de Mayo llegaron piratas a las costas de Buenos Aires, y escondieron un gran tesoro. ¿Podrás encontrarlo?',
            acertijo: 'Alto y fuerte, me quedo afuera. El sol, la lluvia, están a mi lado.',
            respuesta: 'La corona de Reino Unido',
            latitud: -34.616542734808334,
            longitud: -58.368285215341956,
            pista1: pista1,
            pista2: pista2,
            pista3: pista3 
        ).save()
    }

    def destroy = {
    }
}
