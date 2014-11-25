class Card
{
    int rank
    Suit suit

    static def ranks = [null, null, "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"]
	//static def values = [null, null, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11]

    public static final int JACK  = 10
    public static final int QUEEN = 10
    public static final int KING  = 10
    public static final int ACE   = 11
    
    /** 
     * Constructor
     * rank can be 2, 3, ..., 10, JACK, QUEEN, KING, ACE
     * suit can be CLUBS, DIAMONDS, HEARTS, SPADES
     */
    public Card (int rank, Suit suit) 
    {
        if (rank < 2 || rank > ACE)
        {
            throw new IllegalArgumentException("invalid rank: " + rank)
        }
        this.rank = rank
        this.suit = suit
    }
    
    /** 
     * Returns a string representation of the card
     */
    def String toString()
    {
        return ranks[rank] + " of " + suit
    }
        
    /** 
     * Returns a negative number if this object is lower in rank than c,
     *   0 if the cards are equal rank, and a positive number if this object
     *   is higher in rank than c. Aces are considered 'high'.
     */
    def int compareRank(Card c)
    {
        return rank - c.rank
    }
    
    /**
     * Returns true if the objects are equals, false otherwise
     */
    def boolean equals(Card c)
    {
        return this.rank == c.rank && this.suit == c.suit
    }
}
