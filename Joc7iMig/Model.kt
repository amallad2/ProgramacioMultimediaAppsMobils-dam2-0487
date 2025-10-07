package org.proven.seven

import kotlin.random.Random

class Model {

    companion object {
        const val PLAYING = 1
        const val WAITING_PLAY = 2
    }

    var numIntents: Int = 0
        private set // El setter es privado para que solo se pueda modificar desde la clase

    var listCards: MutableList<Card> = mutableListOf()
        private set

    var stateGame: Int = 0

    /**
     * Inicializa la lista de cartas con valores predefinidos.
     * Las cartas no son visibles al principio.
     *
     * @param numCards El número de cartas a crear.
     */
    private fun initCards(numCards: Int) {
        listCards.clear()
        for (i in 0 until numCards) {
            val temp = i % 8
            val value = if (temp == 0) 0.5 else temp.toDouble()
            listCards.add(Card(value, false))
        }
        // Descomentar para barajar las cartas en cada partida
        // listCards.shuffle()
    }

    /**
     * Reinicia el juego, restableciendo los intentos e inicializando las cartas.
     *
     * @param numCards El número de cartas para la nueva partida.
     */
    fun restartGame(numCards: Int) {
        numIntents = 0
        initCards(numCards)
        stateGame = PLAYING
    }

    /**
     * Incrementa el contador de intentos en uno.
     */
    fun incrementIntent() {
        numIntents++
    }

    /**
     * Calcula la suma de los valores de las cartas visibles.
     *
     * @return La suma total de las cartas boca arriba.
     */
    fun getSumCards(): Double {
        return listCards.filter { it.isVisible }.sumOf { it.value }
    }

    /**
     * Cambia el estado de visibilidad (de visible a oculto y viceversa) de una carta.
     *
     * @param position La posición de la carta en la lista.
     */
    fun swapCard(position: Int) {
        if (position in listCards.indices) {
            val card = listCards[position]
            card.isVisible = !card.isVisible
        }
    }

    /**
     * Obtiene una carta por su posición.
     *
     * @param pos La posición de la carta.
     * @return La carta en esa posición o null si la posición es inválida.
     */
    fun getCard(pos: Int): Card? {
        return listCards.getOrNull(pos)
    }

    /**
     * Devuelve el número total de cartas en el juego.
     */
    fun getSizeCards(): Int {
        return listCards.size
    }
}

// Ejemplo de uso del Modelo, equivalente al método main de Java
fun main() {
    val m = Model()
    m.restartGame(8)
    m.getCard(3)?.isVisible = true
    println("Suma 1: ${m.getSumCards()}")
    m.getCard(4)?.isVisible = true
    println("Suma 2: ${m.getSumCards()}")
    m.getCard(0)?.isVisible = true
    println("Suma 3: ${m.getSumCards()}")
    m.getCard(4)?.isVisible = false
    println("Suma 4: ${m.getSumCards()}")
}