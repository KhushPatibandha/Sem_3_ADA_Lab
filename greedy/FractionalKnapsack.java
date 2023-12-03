package greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    double weight;
    double value;
    double cost;
    public Item(double weight, double value, double cost) {
        this.weight = weight;
        this.value = value;
        this.cost = value / weight;
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] values = {120, 100, 60}; 
        int[] weights = {30, 20, 10};
        int w = 50;
        int n = weights.length;
        System.out.println(fractionalKnapsack(values, weights, w, n));
    }
    private static double fractionalKnapsack(int[] values, int[] weights, int w, int n) {
        Item[] items = new Item[n];
        for(int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i], weights[i] / values[i]);
        }
        Arrays.sort(items, new Comparator<Item>() {

            @Override
            public int compare(Item i1, Item i2) {
                return Double.compare(i1.cost, i2.cost);
            }
            
        });
        reverse(items);

        double maxProfit = 0;
        double currWeight = 0;
        for(int i = 0; i < n; i++) {
            double itemWeight = items[i].weight; 
            double itemValue = items[i].value;
            double itemCost = items[i].cost;

            if(itemWeight + currWeight <= w) {
                currWeight += itemWeight;
                maxProfit += itemValue;
            } else {
                double remain = w - currWeight;
                maxProfit += itemCost * remain;
                break;
            }
        }
        return maxProfit;
    }
    private static Item[] reverse(Item[] items) {
        int start = 0;
        int end = items.length - 1;
        
        while(start < end) {
            Item temp = items[start];
            items[start] = items[end];
            items[end] = temp;

            start++;
            end--;
        }

        return items;
    }
}
