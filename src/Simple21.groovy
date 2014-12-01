import Deck

// Deck
Deck deck = new Deck()

def console = System.console()

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
    println(player1+"'s top card: " + hand1[hand1.size -1])
    println(player2+"'s top card: " + hand2[hand2.size -1] + "\n")
    
    def cardsInBattle = []
    def player1Score = 0
    def player2Score = 0

    int games = 4
    int currentCard = 0

    // Player can choose to get more cards until they stop or go over 21)
    // While any player has at least one card, we will keep playing
    if (player1Score <= 21 && player2Score <= 21)
    {
        for (int y = 0; y< hand1.size; y++){
            player1Score += hand1[y].rank
        }
        for (int y = 0; y< hand2.size; y++){
            player2Score += hand2[y].rank
        }
       for (int i=0; i< games; i++){

            if(i % 2 == 0){
                // Calculate the number of points the player has at beginning
                println(player2 + "'s score is: " + player2Score)
                yesOrNo = console.readLine(player2 +'> Hit or Stand?')

                if (yesOrNo.equals("Hit") || yesOrNo.equals("hit") || yesOrNo.equals("h") || yesOrNo.equals("H")){

                    hand2 += deck.deal(1)
                    println("\n"+ "New card is :" + hand2[hand2.size -1])
                    player2Score += hand2[hand2.size -1].rank
                    println("\n"+ player2 + "'s score is: " + player2Score)
                    if (player2Score > 21)
                        break;
                }           
             }
            if(i % 2 != 0){
                // Calculate the number of points the player has at beginning
            println(player1 + "'s score is: " + player1Score)
            yesOrNo = console.readLine(player1 +'> Hit or Stand?')

            if ((yesOrNo.equals("Hit") || yesOrNo.equals("hit") || yesOrNo.equals("h") || yesOrNo.equals("H"))){

                hand1 += deck.deal(1)
                println("\n"+ "New card is :" + hand1[hand1.size -1])
                player1Score += hand1[hand1.size-1].rank

                 println("\n"+ player1 + "'s score is: " + player1Score)
                if (player2Score > 21)
                        break
            }
                
            }
        if (player1Score > 21 || player2Score >21)
            break;
        }
    }


    println("\n"+ "All players now stand")
    println("Final Scores Are: ")
    println("   " + player1 + ":"+ player1Score)
    println("   " + player2 + ":"+ player2Score)

    if (player2Score <21 && player1Score <21){
        if (player2Score > player1Score)
            println(player2 + " Wins!")
        else
            println(player1 + " Wins!")
    }
    if (player2Score > 21 && player1Score <= 21)
        println(player1 + " Wins!")
    if (player1Score > 21 && player2Score <= 21)
        println(player2 + " Wins!")

    
    



