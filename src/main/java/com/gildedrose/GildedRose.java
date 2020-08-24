package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SELL_IN = 0;
    public static final int MAX_QUALITY = 50;
    public static final int SULFURAS_MAX_QUALITY = 80;
    public static final int QUALITY_INCREMENT = 1;
    public static final int BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_TEN_DAYS = 2;
    public static final int BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_FIVE_DAYS = 3;
    public static final int QUALITY_DECREMENT_DOUBLE = 2;
    public static final int BACKSTAGE_PASSES_MAX_SELL_IN = 11;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                if (items[i].quality > MIN_QUALITY) {
                    if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        items[i].quality = items[i].quality - QUALITY_INCREMENT;
                    }
                }
            } else {
                if (items[i].quality < MAX_QUALITY) {
                    items[i].quality = items[i].quality + QUALITY_INCREMENT;

                    if (items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (items[i].sellIn < BACKSTAGE_PASSES_MAX_SELL_IN) {
                            if (items[i].quality < MAX_QUALITY) {
                                items[i].quality = items[i].quality + QUALITY_INCREMENT;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < MAX_QUALITY) {
                                items[i].quality = items[i].quality + QUALITY_INCREMENT;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].sellIn = items[i].sellIn - QUALITY_INCREMENT;
            }

            if (items[i].sellIn < MIN_SELL_IN) {
                if (!items[i].name.equals(AGED_BRIE)) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (items[i].quality > MIN_QUALITY) {
                            if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                items[i].quality = items[i].quality - QUALITY_INCREMENT;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < MAX_QUALITY) {
                        items[i].quality = items[i].quality + QUALITY_INCREMENT;
                    }
                }
            }
        }
    }
}