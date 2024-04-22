import java.util.Scanner;

/**
 * the main class that is used to run the program and to print strings
 * @author XUAN HUY PHAM ~ 000899551
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many suits: ");//ask about num of suits
        int suit = input.nextInt();

        System.out.print("How many ranks: ");//ask about num of ranks
        int rank = input.nextInt();


        DeckOfCards deck = new DeckOfCards(rank, suit);
        System.out.print(deck);
        System.out.println("\nCards:");//to print out the cards in deck
        deck.print();

        boolean flag = true;//set flag as true value
        while (flag) {
            System.out.println();
            System.out.println("1 = SHUFFLE, 2 = DEAL 1 HAND, 3 = DEAL 100_000 TIMES, 4 = QUIT");

            //switch case to separate tasks base on user's input
            int choice = input.nextInt();
            switch (choice) {
                case 1://this will perform the shuffles
                    deck.shuffle();
                    System.out.println(deck);
                    System.out.println("New order of cards: ");//and print out the new array with shuffled cards
                    deck.print();
                    break;
                case 2://deal one hand
                    System.out.println("How many cards? ");
                    int deal1Hand = input.nextInt();
                    Card[] hand = deck.dealCards(deal1Hand);
                    System.out.println("Cards dealt: ");//print out the number of cards user want to deal
                    for (Card card : hand) {
                        System.out.print(card + " ");
                    }
                    System.out.println();
                    break;
                case 3://perform the shuffling and dealing 100 000 times :>
                    System.out.println("How many cards? ");
                    int shuffle100000times = input.nextInt();
                    deck.histogram(shuffle100000times);
                    break;
                case 4://exit the program
                    flag = false;
                    System.out.println("Exiting the program...");
                    break;
                default://in case user's input is invalid
                    System.out.println("Invalid choice, try again!");
                    break;
            }
        }
    }
}
