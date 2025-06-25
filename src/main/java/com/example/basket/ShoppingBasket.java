package com.example.basket;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ShoppingBasket {

    public static int calculateTotal(List<String> items) {
        Map<String, Integer> itemCounts = new HashMap<>();

        for (String item : items) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }

        int total = 0;

        for (Map.Entry<String, Integer> entry : itemCounts.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();

            switch (item.toLowerCase()) {
                case "apple":
                    total += 35 * count;
                    break;
                case "banana":
                    total += 20 * count;
                    break;
                case "melon":
                    total += 50 * ((count / 2) + (count % 2)); // BOGO offer
                    break;
                case "lime":
                    total += 15 * ((count / 3) * 2 + (count % 3)); // 3 for 2 offer
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item: " + item);
            }
        }

        return total;
    }
}
