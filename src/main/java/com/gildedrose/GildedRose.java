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
    public static final int QUALITY_DECREMENT_AFER_SELL_IN = 2;
    public static final int BACKSTAGE_PASSES_TEN_DAYS_SELL_IN = 10;
    public static final int BACKSTAGE_PASSES_FIVE_DAYS_SELL_IN = 5;
    public static final int GENERAL_SELL_IN_DECREMENT = 1;
    public static final int GENERAL_QUALITY_DECREMENT = 1;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            items[i].sellIn = items[i].sellIn - GENERAL_SELL_IN_DECREMENT;

            switch (items[i].name) {
                case AGED_BRIE:
                    if (items[i].quality < MAX_QUALITY) {
                        items[i].quality = items[i].quality + QUALITY_INCREMENT;
                    }
                    break;

                case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                    if (items[i].sellIn <= 0) {
                        items[i].quality = MIN_QUALITY;
                    }
                    else if (items[i].sellIn <= BACKSTAGE_PASSES_FIVE_DAYS_SELL_IN) {
                        items[i].quality = items[i].quality + BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_FIVE_DAYS;
                    }
                    else if (items[i].sellIn <= BACKSTAGE_PASSES_TEN_DAYS_SELL_IN) {
                        items[i].quality = items[i].quality + BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_TEN_DAYS;
                    }
                    else {
                        items[i].quality = items[i].quality - GENERAL_QUALITY_DECREMENT;
                    }
                    if (items[i].quality > MAX_QUALITY) {
                        items[i].quality = MAX_QUALITY;
                    }
                    break;

                case SULFURAS_HAND_OF_RAGNAROS:
                    break;

                default:
                    if (items[i].quality > MIN_QUALITY) {
                        if(items[i].sellIn <= MIN_SELL_IN){
                            items[i].quality = items[i].quality - QUALITY_DECREMENT_AFER_SELL_IN;
                        } else {
                            items[i].quality = items[i].quality - GENERAL_QUALITY_DECREMENT;
                        }
                        if (items[i].quality < MIN_QUALITY) {
                            items[i].quality = MIN_QUALITY;
                        }
                    }
                    break;
            }
        }
    }
}