import Deck

// Deck
Deck deck = new Deck()

// Defining each player for printing
def player1 = "Turner"
def player2 = "iPrep"

int handSize = Deck.MAX_SIZE / 2 // assumes we have an even number
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
    
    // Deal the hands (half for each player)
    hand1 = deck.deal(handSize)
    hand2 = deck.deal(handSize)
    
    // print each hand before we play
    // println(hand1)
    // println(hand2)
    
    def cardsInBattle = []
    def player1BattlesWon = 0
    def player2BattlesWon = 0

    // The "battle" loop. Each draw is a battle in the war (game)
    // While any player has at least one card, we will keep playing
    while (hand1.size() > 0 && hand2.size() > 0)
    {
        // Draw the top card for each player
        Card card1 = hand1.remove(0)
        Card card2 = hand2.remove(0)

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
