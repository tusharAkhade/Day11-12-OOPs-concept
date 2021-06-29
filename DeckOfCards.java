import java.util.HashSet;
import java.util.Set;

/**
 * Deck of Cards:
 * There are 4 players
 * Distributing 9 cards to each player.
 * @author Tushar Akhade
 * @since 19 Jun 2021
 */
public class DeckOfCards {
    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        String[] suits = {"Diamond", "Heart", "Spades", "Club"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack" , "Queen", "King", "Ace"};

        int numOfPlayers = 4, cardsToEachPlayer = 9;

        String[][] totalCards = deckOfCards.generateCards(suits, rank);
        Set<String> cards = new HashSet<String>();

        // 'player' stores the cards of all(4) player
        String[][] player = new String[numOfPlayers][cardsToEachPlayer];
        int i = 0, j = 0, k = 0, l = 0, m = 0;

        int totalCardsDistribute  = numOfPlayers * cardsToEachPlayer;
        while (i < totalCardsDistribute) {
            int randomSuit = (int) Math.floor(Math.random()*10)%4;
            int randomRank = (int) Math.floor(Math.random()*100)%13;

            if (cards.add(totalCards[randomSuit][randomRank])) {
                if (i%4 == 0) {
                    player[i%4][j] = totalCards[randomSuit][randomRank];
                    j++;
                    i++;
                } else if(i%4 == 1 ) {
                    player[i%4][k] = totalCards[randomSuit][randomRank];
                    k++;
                    i++;
                } else if(i%4 == 2 ) {
                    player[i%4][l] = totalCards[randomSuit][randomRank];
                    l++;
                    i++;
                } else if(i%4 == 3 ) {
                    player[i%4][m] = totalCards[randomSuit][randomRank];
                    m++;
                    i++;
                }
            }
        }
        deckOfCards.printPlayerCard(player);
    }

    // Generating the cards
    public String[][] generateCards(String[] suits, String[] rank) {
        String[][] totalCards = new String[4][13];
        for (int i=0; i<4; i++) {
            for (int j=0; j<13; j++) {
                totalCards[i][j] = suits[i]+rank[j];
            }
        }
        return totalCards;
    }

    // printing the cards of each player
    void printPlayerCard(String[][] player) {
        for (int i = 0; i<4; i++) {
            System.out.print("Player " + (i+1) + " : ");
            for (int j=0; j<9; j++) {
                System.out.print(player[i][j] + " ");
            }
            System.out.println();
        }
    }
}
