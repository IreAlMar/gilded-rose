package com.gildedrose.item;

public class AgedBrieItem extends UpdatableItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        updateItemQuality();
    }

    public void updateItemQuality(){
        if (item.quality < MAX_QUALITY) {
            increaseQuality();
        }
        if (item.sellIn <= 0 && item.quality < MAX_QUALITY) {
            increaseQuality();
        }
    }
}
