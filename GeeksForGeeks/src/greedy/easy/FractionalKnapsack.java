package greedy.easy;

import java.util.*;

class Item {
    int value;
    int weight;
    Item (int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class KnapsackComparator implements Comparator<Item> {
    public int compare (Item a, Item b) {
        return b.value*a.weight - a.value*b.weight;
    }
}

public class FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n) {
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(arr[i].value, arr[i].weight);
        }
        Arrays.sort(items, new KnapsackComparator());

        double cap = 0.0;
        for (int i = 0; i < n; i++) {
            if (items[i].weight < W) {
                cap += (double)items[i].value;
                W -= items[i].weight;
            } else {
                cap += W*(double)items[i].value/(double)items[i].weight;
                break;
            }
        }
        return cap;
    }
}
