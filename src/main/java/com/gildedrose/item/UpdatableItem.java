package com.gildedrose.item;

public abstract class UpdatableItem {
    static final int MIN_QUALITY = 0;
    static final int MAX_QUALITY = 50;

    static final int QUALITY_DECREMENT = 1;
    static final int QUALITY_INCREMENT = 1;
    static final int SELL_IN_DECREMENT = 1;

    Item item;

    public UpdatableItem(Item item) {
        this.item = item;
    }


//    abstract int validateQuality(int quality);
    public abstract void update();

    void decreaseSellIn() {
        this.item.sellIn -= SELL_IN_DECREMENT;
    }

    void increaseQuality() {
        this.item.quality += QUALITY_INCREMENT;
    }

    void decreaseQuality() {
        this.item.quality -= QUALITY_DECREMENT;
    }

    void resetQuality() {
        this.item.quality = MIN_QUALITY;
    }
}
