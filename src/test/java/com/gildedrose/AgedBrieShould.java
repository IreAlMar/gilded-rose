package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieShould {
    public static final String AGED_BRIE = "Aged Brie";
    public static final int MAX_QUALITY = 50;

    Item[] items = new Item[]{new Item(AGED_BRIE, 2, 0)};
    GildedRose app = new GildedRose(items);

    @Test
    void increaseDoubleQualityAfterSellIn(){
        app.items[0].quality = 2;
        app.items[0].sellIn = 0;

        app.updateQuality();
        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void increaseQualityTheOlderItGets() {
        app.items[0].quality = 0;
        app.items[0].sellIn = 2;

        app.updateQuality();
        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void neverHaveQualityOverMax() {
        app.items[0].quality = MAX_QUALITY;
        app.items[0].sellIn = -1;

        app.updateQuality();
        assertEquals(AGED_BRIE, app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(MAX_QUALITY, app.items[0].quality);
    }

    @Test
    void neverHaveNegativeQuality() {
        // TODO
    }

}
