package com.teamarcanum.mobuildingblocks.common.utils;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.RequiredTagList;
import net.minecraft.tag.RequiredTagListRegistry;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Tags {
    public static final Tag<Block> COLUMN = tag("pillars");

    private static Tag<Block> tag(String _name) {
        return TagFactory.BLOCK.create(new Identifier(MoBuildingBlocks.MODID, _name));
    }
}
