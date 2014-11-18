import Deck

// Deck
Deck deck = new Deck()

// Defining each player for printing
def player1 = "Turner"
def player2 = "iPrep"

int handSize = 2 // each player gets two cards
def hand1 = []
def hand2 = []

int player1GamesWon = 0
int player2GamesWon = 0

int numGames = 200

// Play the game numGames times.
for (int i = 0; i<numGames; i++)
{
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
        // Calculate the number of points the player has
        for (int i = 0; i< hand1.length; i++){
            player1Score += ranks[rank]
            player2Score = 
        }

        // Fight!
        cardsInBattle.add(card1)
        cardsInBattle.add(card2)
    
        // Compare shown cards.. determine a winner
        int comp = card1.compareRank(card2)
    
        if (comp != 0) // if there is a winner
        {
            // Randomize the cards we win so that we don't end up in an infinite loop
            // from comparing the same cards over and over
            Collections.shuffle(cardsInBattle)

            if (comp > 0) // first card wins
            {
                hand1.addAll(cardsInBattle) // add to the back of the list
                player1BattlesWon++
            }
            else // second card wins
            {
                hand2.addAll(cardsInBattle) // add to the back of the list
                player2BattlesWon++
            }
            // clear the cards in battle
            cardsInBattle.clear()
        }
    }

    // Determine the winner!
    def winner
    if (hand1.size() > hand2.size())
    {
        winner = player1
        player1GamesWon++
    }
    else
    {
        winner = player2
        player2GamesWon++
    }
    
    // Announce the winner
    println(winner + " wins the war (" + player1BattlesWon + " battles, " + player2BattlesWon + " battles)")
}

println ""
// Announce the winner of the "best-of" series
println(player1 + ": " + player1GamesWon + " wars, " + player2 + ": " + player2GamesWon + " wars")