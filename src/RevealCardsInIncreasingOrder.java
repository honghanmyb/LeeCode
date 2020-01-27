import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        List<Integer> unsorted = new ArrayList<>(deck.length);
        for(int deckNum : deck){
            unsorted.add(deckNum);
        }
        unsorted.sort(Comparator.comparingInt(anInt -> anInt));
        List<Integer> deckSorted = deckSort(unsorted);
        int[] sorted = new int[deck.length];
        for(int i = 0; i < sorted.length; i++){
            sorted[i] = deckSorted.get(i);
        }
        return sorted;
    }

    private List<Integer> deckSort(List<Integer> unsorted){
        int size = unsorted.size();
        if(size <= 2){
            return unsorted;
        }
        List<Integer> sorted = new ArrayList<>(size / 2);
        List<Integer> newUnsorted = new ArrayList<>(size / 2);
        int endIndex = (size - 1) / 2;
        for(int i = 0; i <= endIndex; i ++){
            sorted.add(unsorted.get(i));
        }
        for(int i = endIndex + 1; i < size; i++){
            newUnsorted.add(unsorted.get(i));
        }
        List<Integer> newSorted = deckSort(newUnsorted);
        if(size % 2 == 1){
            newSorted.add(0, newSorted.get(newSorted.size() - 1));
            newSorted.remove(newSorted.size() - 1);
        }
        unsorted.clear();
        for(int i = 0; i < sorted.size(); i++){
            unsorted.add(sorted.get(i));
            if(i < newSorted.size()){
                unsorted.add(newSorted.get(i));
            }
        }
        return unsorted;
    }
}
