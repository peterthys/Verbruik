package com.example.memory

import com.example.memory.DataBase.MemoryCard

class MemoryGame(private val boardSize: BoardSize) {

    val cards: List<MemoryCard>
    var numPairsFound = 0
    var numCardsFlips = 0
    private var indexOfSingleDetectedCard: Int? = null

    init {
        val choosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizedImages = (choosenImages + choosenImages).shuffled()
        cards = randomizedImages.map { MemoryCard(it) }
    }

    fun flipCard(position: Int): Boolean {
        numCardsFlips++
        val card = cards[position]
        var foundMatch = false
        if (indexOfSingleDetectedCard == null) {
            restoreCards()
            indexOfSingleDetectedCard = position

        } else {
            foundMatch = checkForMatch(indexOfSingleDetectedCard!!, position)
            indexOfSingleDetectedCard = null
        }
        card.isFaceUp = !card.isFaceUp
        return foundMatch

    }

    private fun checkForMatch(position1: Int, position2: Int): Boolean {
        if (cards[position1].identifier != cards[position2].identifier) {
            return false
        } else
            cards[position1].isMatched = true
        cards[position2].isMatched = true
        numPairsFound++
        return true
    }

    private fun restoreCards() {
        for (card: MemoryCard in cards) {
            if (!card.isMatched)
                card.isFaceUp = false
        }
    }

    fun haveWonGame(): Boolean {
        return numPairsFound == boardSize.getNumPairs()
    }

    fun isCardFaceUp(position: Int): Boolean {
        return cards[position].isFaceUp

    }

    fun getMoves(): Int {
        return numCardsFlips/2
    }
}