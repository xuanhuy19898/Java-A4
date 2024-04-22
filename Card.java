/**
 * This is to represent a card
 * @author XUAN HUY PHAM - 000899551
 */
class Card {
    private final int rank;    // The rank of the card
    private final int suit;    // The suit of the card

    /**
     * Creates a new card with the specified rank and suit.
     * @param rank The rank of the card.
     * @param suit The suit of the card.
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public int getValue() { //this is to return the value of the card
        return rank * suit;
    }
    @Override
    public String toString() { // Returns a string representation of the card.
        return "S" + suit + "R" + rank;
    }
}
