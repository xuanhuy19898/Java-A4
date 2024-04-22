import java.util.Arrays;
import java.util.Random;

/**
 * Assignment 4
 * @author XUAN HUY PHAM ~ 000899551
 */
public class DeckOfCards {
    private  Card[] cards; //array that stores cards in the deck
    private  int size; //num of cards in the deck
    private  int maxRank;//the max rank value of a card
    private  int numSuits; //num of suits in the deck


    /**
     *this DeckOfCards object holds a set of Card objects in an array
     * the size of the deck is determined by maxRank and suitNumber
     * @param maxRank
     * @param numSuits
     */
    public DeckOfCards(int maxRank, int numSuits) {
        this.maxRank = maxRank;//set the max rank value for a card
        this.numSuits = numSuits;//set the number of suits in the deck
        this.size = maxRank * numSuits;//calculate thhe total size of the deck
        this.cards = new Card[size];//create a new array in order to store the cards from the deck

        int index = 0;//set the index at 0
        for (int rank = 1; rank <= maxRank; rank++) {//condition to create a new card with the same suit and rank
            for (int suit = 1; suit <= numSuits; suit++) {
                cards[index] = new Card(suit, rank);
                index++;//and then increase the index to move to the next index in the array
            }
        }
    }

    /**
     * perform the shuffle by generating a random index within the range of the deck size
     * and then store that card in a temporary var
     */
    public void shuffle() {
        Random random = new Random(); //create a new instance of the random class

        for (int i = 0; i < size; i++) {
            int j = random.nextInt(size);//generate a random index within the range of the deck
            Card temp = cards[i];//store the card in temp variable
            cards[i] = cards[j];//swap the current card with the new card at the random index
            cards[j] = temp;//assign temp varibale to the random index
        }
    }

    public int getNumSuits() { //this is to return the number of suits in the deck
        return numSuits;
    }

    //this method is to calculate and return the total of cards
    public int getSize() {
        return maxRank * numSuits;
    }

    /**
     * this method is to deal card to form a hand
     * @param numCards the num of cards to deal
     * @return return an array of cards to present the hand
     */
    public Card[] dealCards(int numCards) {
        Card[] hand = new Card[numCards]; //craete an array
        for (int i = 0; i < numCards; i++) {
            hand[i] = cards[i];//assign each card from the deck to the new hand array
        }
        return hand; //return the array that includes the dealt cards
    }


    public Card getTopCard() { //to return the top card in the deck
        return cards[0];//represent the card at index 0, as well as the top one
    }
    public int getMinValue() { //to return the minimum value of a card in the deck
        return 1;//it's always 1
    }
    public int getMaxValue() {//to return the maximum value of a card in the deck
        return maxRank * numSuits; //it's the size of the deck
    }


    /**
     * this method is to generate a histogram of hand values, it shuffles and deals cards multiple times
     * @param numCards the num of cards to deal for each hand
     */
    public void histogram(int numCards) {
        int[] histogramArray = new int[getNumSuits() * getMaxValue() + 1];//to create an array to store the histogram

        for (int i = 0; i < 100000; i++) {//it deals 100000 times
            shuffle();//it shuffles the deck first
            Card[] hand = dealCards(numCards);//then deal the cards for a hand
            int handValue = 0;
            for (Card card : hand) {//it calculates the sum of card value
                handValue += card.getValue();
            }
            histogramArray[handValue - getMinValue()]++;//increement the corresponding histogram value based on the hand value
        }

        for (int i = 2; i < histogramArray.length; i++) {//this is to print the non-zero value of each frequency
            if (histogramArray[i] != 0) {
                System.out.println(i + " : " + histogramArray[i]);
            }
        }
    }


    public void print() { //just to print cards in the deck
        for (Card card : cards) {
            System.out.print(card + "\n");
        }
    }

    @Override
    public String toString() { //to return a string which represent the deck
        return "Deck of " + size + " cards: low = " + getMinValue() +
                " high = " + getMaxValue() + " top = " + getTopCard();
    }
}
