import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] sorted = new int[deck.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.add(i);
        }
        for (int i = 0; i < deck.length - 1; i++) {
            sorted[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        sorted[queue.poll()] = deck[deck.length - 1];
        return sorted;
    }
}
