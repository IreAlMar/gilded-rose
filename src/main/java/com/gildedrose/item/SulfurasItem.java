package com.gildedrose.item;

public class SulfurasItem extends UpdatableItem {

    public static final int SULFURAS_MAX_QUALITY = 80;

    public SulfurasItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        updateItemQuality();
    }

    public void updateItemQuality(){
    }
}
