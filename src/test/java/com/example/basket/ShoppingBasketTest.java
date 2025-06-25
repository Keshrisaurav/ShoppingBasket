package com.example.basket;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketTest {

    @Test
    public void testEmptyBasket() {
        assertEquals(0, ShoppingBasket.calculateTotal(Collections.emptyList()));
    }

    @Test
    public void testSingleApple() {
        assertEquals(35, ShoppingBasket.calculateTotal(Arrays.asList("Apple")));
    }

    @Test
    public void testMultipleApples() {
        assertEquals(70, ShoppingBasket.calculateTotal(Arrays.asList("Apple", "Apple")));
    }

    @Test
    public void testSingleBanana() {
        assertEquals(20, ShoppingBasket.calculateTotal(Arrays.asList("Banana")));
    }

    @Test
    public void testMelonBOGO() {
        assertEquals(50, ShoppingBasket.calculateTotal(Arrays.asList("Melon", "Melon"))); // BOGO
        assertEquals(100, ShoppingBasket.calculateTotal(Arrays.asList("Melon", "Melon", "Melon", "Melon"))); // 4 Melons
        assertEquals(150, ShoppingBasket.calculateTotal(Arrays.asList("Melon", "Melon", "Melon"))); // 3 Melons
    }

    @Test
    public void testLimeThreeForTwo() {
        assertEquals(30, ShoppingBasket.calculateTotal(Arrays.asList("Lime", "Lime", "Lime"))); // 3-for-2
        assertEquals(45, ShoppingBasket.calculateTotal(Arrays.asList("Lime", "Lime", "Lime", "Lime", "Lime", "Lime", "Lime", "Lime", "Lime"))); // 9 Limes => 6 paid
    }

    @Test
    public void testMixedBasket() {
        assertEquals(135, ShoppingBasket.calculateTotal(Arrays.asList("Apple", "Banana", "Melon", "Melon"))); // 35 + 20 + 50
        assertEquals(200, ShoppingBasket.calculateTotal(Arrays.asList("Apple", "Apple", "Melon", "Lime", "Lime", "Lime"))); // 70 + 50 + 30 = 150
    }

    @Test
    public void testUnknownItemThrowsException() {
        try {
            ShoppingBasket.calculateTotal(Arrays.asList("Pineapple"));
        } catch (IllegalArgumentException e) {
            assertEquals("Unknown item: Pineapple", e.getMessage());
        }
    }
}
