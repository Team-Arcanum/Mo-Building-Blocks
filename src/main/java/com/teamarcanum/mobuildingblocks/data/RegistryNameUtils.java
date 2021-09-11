package com.teamarcanum.mobuildingblocks.data;


import net.minecraft.core.Registry;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("deprecation")
public class RegistryNameUtils {

    public static String getHasName(Tag<Item> _tag) {
        return "has_" + _tag.toString();
    }

    public static String getHasName(ItemLike _item) {
        return "has_" + Registry.ITEM.getKey(_item.asItem()).getPath();
    }

    public static String getItemName(ItemLike _item) {
        return Registry.ITEM.getKey(_item.asItem()).getPath();
    }
}
