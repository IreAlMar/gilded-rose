package com.gildedrose.item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UpdatableItemBuilder {

    public static UpdatableItem build(Item item) {

        // Yo aquí habría puesto un switch
        // Esto es reflection -> investigar
        for (ItemTypes itemType : ItemTypes.values()) {
            if (item.name.toLowerCase().contains(itemType.getValue())) {
                Constructor constructor = null;
                try {
                    constructor = itemType.getClazz().getConstructor(Item.class);
                    return (UpdatableItem) constructor.newInstance(item);
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return new DefaultItem(item);
    }
}
