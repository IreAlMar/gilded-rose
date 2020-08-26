package com.gildedrose.item;

public enum ItemTypes {
    SULFURAS("sulfuras", SulfurasItem.class),
    BACKSTAGE_PASSES("backstage passes", BackStageItem.class),
    AGED_BRIE("aged brie", AgedBrieItem.class);

    private String value;
    private Class clazz;

    ItemTypes(String value, Class clazz) {
        this.value = value;
        this.clazz = clazz;
    }

    public String getValue() {
        return value;
    }

    public Class getClazz() {
        return clazz;
    }
}
