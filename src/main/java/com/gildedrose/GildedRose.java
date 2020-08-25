package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    public static final int QUALITY_DECREMENT = 1;
    public static final int QUALITY_DECREMENT_AFTER_SELL_IN = 2;
    public static final int QUALITY_INCREMENT = 1;
    public static final int DEFAULT_ITEM_DOUBLE_QUALITY_THRESHOLD = 0;
    public static final int SULFURAS_MAX_QUALITY = 80;


    public static final int SELL_IN_DECREMENT = 1;

    public static final int BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_TEN_DAYS = 2;
    public static final int BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_FIVE_DAYS = 3;
    public static final int BACKSTAGE_PASSES_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 10;
    public static final int BACKSTAGE_PASSES_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 5;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case AGED_BRIE:
                    decreaseSellIn(items[i]);
                    updateAgedBrieQuality(items[i]);
                    break;

                case BACKSTAGE_PASSES:
                    decreaseSellIn(items[i]);
                    updateBackstagePassesQuality(items[i]);
                    break;

                case SULFURAS_HAND_OF_RAGNAROS:
                    break;

                default:
                    decreaseSellIn(items[i]);
                    updateDefaultItemQuality(items[i]);
                    break;
            }
        }
    }

    private void updateAgedBrieQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            increaseQuality(item);
        }
        if (item.sellIn <= 0 && item.quality < MAX_QUALITY){
            increaseQuality(item);
        }
    }

    private void updateBackstagePassesQuality(Item item) {
        if (item.sellIn <= 0) {
            resetQuality(item);
        }
        else if (item.sellIn <= BACKSTAGE_PASSES_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
            item.quality += BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_FIVE_DAYS;
        }
        else if (item.sellIn <= BACKSTAGE_PASSES_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
            item.quality += BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_TEN_DAYS;
        }
        else {
            increaseQuality(item);
        }
        if (item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }

    private void updateDefaultItemQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            if (item.sellIn <= DEFAULT_ITEM_DOUBLE_QUALITY_THRESHOLD) {
                item.quality -= QUALITY_DECREMENT_AFTER_SELL_IN;
            }
            else {
                decreaseQuality(item);
            }
            if (item.quality < MIN_QUALITY) {
                resetQuality(item);
            }
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn -= SELL_IN_DECREMENT;
    }

    private void increaseQuality(Item item) {
        item.quality += QUALITY_INCREMENT;
    }

    private void decreaseQuality(Item item) {
        item.quality -= QUALITY_DECREMENT;
    }

    private void resetQuality(Item item) {
        item.quality = MIN_QUALITY;
    }
}