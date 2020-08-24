package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasShould {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final int SULFURAS_QUALITY = 80;

    Item[] items = new Item[] { new Item(SULFURAS_HAND_OF_RAGNAROS, 2, 0) };
    GildedRose app = new GildedRose(items);


    @Test
    void neverChangeQuality(){
        app.items[0].quality = SULFURAS_QUALITY;

        app.updateQuality();
        assertEquals(SULFURAS_HAND_OF_RAGNAROS, app.items[0].name);
        assertEquals(SULFURAS_QUALITY, app.items[0].quality);
    }

}
