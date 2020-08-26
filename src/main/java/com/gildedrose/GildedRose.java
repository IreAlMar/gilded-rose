package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.item.UpdatableItem;
import com.gildedrose.item.UpdatableItemBuilder;

import java.util.ArrayList;
import java.util.List;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        List<UpdatableItem> updatableItems = new ArrayList<>();

        for (Item item : items) {
            updatableItems.add(UpdatableItemBuilder.build(item));
        }

        updatableItems.stream().forEach(UpdatableItem::update);
    }

}