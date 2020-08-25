package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleItemShould {
    public static final String SIMPLE_ITEM = "Elixir of the Mongoose";

    Item[] items = new Item[]{new Item(SIMPLE_ITEM, 2, 0)};
    GildedRose app = new GildedRose(items);

    @Test
    void neverHaveQualityOverMax() {
        // TODO
    }

    @Test
    void neverHaveNegativeQuality() {
        app.items[0].quality = 0;
        app.items[0].sellIn = 0;

        app.updateQuality();
        assertEquals(SIMPLE_ITEM, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void decreaseQualityTheOlderItGets() {
        app.items[0].quality = 3;
        app.items[0].sellIn = 2;

        app.updateQuality();
        assertEquals(SIMPLE_ITEM, app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void decreaseQualityTwiceAsFastOnceTheSellByDateHasPassed() {
        app.items[0].quality = 3;
        app.items[0].sellIn = 0;

        app.updateQuality();
        assertEquals(SIMPLE_ITEM, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

}
