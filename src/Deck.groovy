class Deck
{
    public static final int MAX_SIZE = 52
    private def cards = []

    public Deck()
    {
        reset()
    }
    
    private def reset()
    {
        cards = []
        addSuit(Suit.SPADES)
        addSuit(Suit.HEARTS)
        addSuit(Suit.DIAMONDS)
        addSuit(Suit.CLUBS)  
    }
        
    private def void addSuit(Suit suit)
    {
        for (int i = 2; i <= Card.ACE; i++)
        {
            Card newCard = new Card(i, suit)
            cards.add(newCard)
        }
    }

    def boolean isEmpty()
    {
        return cards.isEmpty()
    }

    // methods

    // add - puts a Card at the end ("bottom") of the pile.  It just uses the List method
    def void add(Card aCard)
    {
        cards.add(aCard)
    }

    def void clear()
    {
        cards.clear()
    }

    // getTopCard - removes and returns the "top" card of the pile.  It just uses the List method
    def getTopCard()
    {
        return cards.remove(0)
    }

    def int size()
    {
        return cards.size()
    }

    def deal()
    {
        if(isEmpty())
        {
            return null
        }
        else
        {
            return cards.remove(cards.size() -1)
        }
    }

    def deal(int number)
    {
        if (number > cards.size())
        {
            return null
        }
        else
        {
            def hand = []
            for(int i = 0; i < number; i++)
            {
                hand[i] = deal()
            }
            return hand
        }
    }
    
    def void shuffle()
    {
        if (cards.size() < MAX_SIZE)
        {
            println "Couldn't shuffle. There are only " + cards.size() + " cards!"
            return
        }
        Random gen = new Random()
        Card[] array = new Card[MAX_SIZE]
        while (cards.size() > 0)
        {
            Card card = cards.remove(cards.size() - 1)
            int i = gen.nextInt(MAX_SIZE)
            while (array[i] != null)
            {
                i = gen.nextInt(MAX_SIZE)
            }                
            array[i] = card
        }
        for (Card card : array)
        {
            cards.add(card)
        }
    }

    def String toString()
    {
        String result = ""
        for(Card card : cards)
        {
            result += card.toString() + "\n"
        }
        return result
    }
}
