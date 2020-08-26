package com.gildedrose.item;

public class BackStageItem extends UpdatableItem {

    public static final int BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_TEN_DAYS = 2;
    public static final int BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_FIVE_DAYS = 3;
    public static final int BACKSTAGE_PASSES_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 10;
    public static final int BACKSTAGE_PASSES_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD = 5;

    public BackStageItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        updateItemQuality();
    }

    public void updateItemQuality(){
        if (item.sellIn <= 0) {
            resetQuality();
        }
        else if (item.sellIn <= BACKSTAGE_PASSES_TRIPLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
            item.quality += BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_FIVE_DAYS;
        }
        else if (item.sellIn <= BACKSTAGE_PASSES_DOUBLE_QUALITY_INCREASE_SELL_IN_THRESHOLD) {
            item.quality += BACKSTAGE_PASSES_QUALITY_INCREMENT_LESS_TEN_DAYS;
        }
        else {
            increaseQuality();
        }
        if (item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        }
    }
}
