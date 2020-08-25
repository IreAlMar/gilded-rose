package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackStagePassesShould {
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final int MAX_QUALITY = 50;

    Item[] items = new Item[] { new Item(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 2, 0) };
    GildedRose app = new GildedRose(items);


    @Test
    void neverHaveQualityOverMax(){
        app.items[0].quality = MAX_QUALITY;

        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, app.items[0].name);
        assertEquals(MAX_QUALITY, app.items[0].quality);
    }

    @Test
    void neverHaveNegativeQuality(){
        // TODO
    }

    @Test
    void increaseQualityByOneWhenSellInIsGreaterThanTen() {
        app.items[0].quality = 5;
        app.items[0].sellIn = 12;

        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, app.items[0].name);
        assertEquals(6, app.items[0].quality);
        assertEquals(11, app.items[0].sellIn);
    }

    @Test
    void increaseQualityByTwoWhenThereAreTenDaysOrLess() {
        app.items[0].quality = 5;
        app.items[0].sellIn = 10;

        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, app.items[0].name);
        assertEquals(7, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void increaseQualityByThreeWhenThereAreFiveDaysOrLess() {
        app.items[0].quality = 5;
        app.items[0].sellIn = 5;

        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, app.items[0].name);
        assertEquals(8, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void dropQualityToZeroAfterTheConcertHasPassed() {
        app.items[0].quality = MAX_QUALITY;
        app.items[0].sellIn = 0;

        app.updateQuality();
        assertEquals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

}
