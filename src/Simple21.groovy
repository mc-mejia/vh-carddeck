import Deck

// Deck
Deck deck = new Deck()

// Defining each player for printing
def player1 = "Turner"
def player2 = "iPrep"

int handSize = 2 // each player gets two cards
def hand1 = []
def hand2 = []


 // Reset the deck
    deck.reset()
    // Shuffle the Deck
    deck.shuffle()
    
    // Deal the hands (2 cards at beginning)
    hand1 = deck.deal(handSize)
    hand2 = deck.deal(handSize)
    
    // print only the last card
    println(hand1[hand1.length -1])
    println(hand2[hand2.length -1])
    
    def cardsInBattle = []
    def player1Score = 0
    def player2Score = 0

    // Player can choose to get more cards until they stop or go over 21)
    // While any player has at least one card, we will keep playing
    while (player1Score <= 21 && player2Score <= 21)
    {
        // Calculate the number of points the player has at beginning
        for (int y = 0; y< hand1.length; y++){
            player1Score += ranks[hand1[y].rank]
            player2Score += ranks[hand2[y].rank]
        }
