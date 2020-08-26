package com.gildedrose.item;

public class DefaultItem extends UpdatableItem {

    private static final int QUALITY_DECREMENT_AFTER_SELL_IN = 2;
    private static final int DOUBLE_QUALITY_THRESHOLD = 0;

    public DefaultItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        updateItemQuality();
    }

    public void updateItemQuality(){
        if (this.item.quality > MIN_QUALITY) {
            if (this.item.sellIn <= DOUBLE_QUALITY_THRESHOLD) {
                this.item.quality -= QUALITY_DECREMENT_AFTER_SELL_IN;
            }
            else {
                decreaseQuality();
            }
            if (this.item.quality < MIN_QUALITY) {
                resetQuality();
            }
        }
    }
}
