import Deck

// Deck
Deck deck = new Deck()

// Defining each player for printing
def turner = "Turner"
def iprep = "iPrep"
int handSize = Deck.MAX_SIZE / 2 // assumes we have an even number
int turnerGames = 0
int iprepGames = 0

for (int i = 0; i<20; i++)
{
    // Reset the deck
    deck.reset()
    // Shuffle the Deck
    deck.shuffle()
    
    // Deal Cards - only once per game

    // Dealing the hands
    def hand1 = deck.deal(handSize)
    def hand2 = deck.deal(handSize)
    
    // print each hand before we play
    // println(hand1)
    // println(hand2)
    
    // While any player has at least one card, we will keep playing
    def cardsInBattle = []
    def player1BattlesWon = 0
    def player2BattlesWon = 0
    while (hand1.size() != 0 && hand2.size() != 0)
    {
        // Get next card for each player
        Card card1 = hand1.remove(hand1.size() -1)
        Card card2 = hand2.remove(hand2.size() -1)

        // Fight!
        cardsInBattle.add(card1)
        cardsInBattle.add(card2)
    
        // Compare shown cards.. determine a winner
        int comp = card1.compareRank(card2)
    
        if (comp != 0) // if there is a winner
        {
            if (comp < 0) // second card wins
            {
                hand2.addAll(cardsInBattle)
                player2BattlesWon++
            }
            else // first card wins
            {
                hand1.addAll(cardsInBattle)
                player1BattlesWon++
            }
            // clear the cards in battle
            cardsInBattle.clear()
        }

        if (comp == 0)
        {
            int hand1Size = hand1.size()
            int hand2Size = hand2.size()

            if(hand2Size==0)
            {
                hand1.addAll(cardsInBattle)
            }
            else
            if(hand1Size==0)
            {
                hand2.addAll(cardsInBattle)
            }
        }

        //println(turner + ": " + hand1.size() + ", " + iprep + ": " + hand2.size())
    }
    
    // Determine the winner!
    def winner
    if (hand1.size() > hand2.size())
    {
        winner = turner
        turnerGames++
    }
    else
    {
        winner = iprep
        iprepGames++
    }
    
    // Announce the winner
    println(winner + " wins the war (" + player1BattlesWon + ", " + player2BattlesWon + ")!")
}

println ""
// Announce the winner of the "best-of" series
println(turner + ": " + turnerGames + ", " + iprep + ": " + iprepGames)
