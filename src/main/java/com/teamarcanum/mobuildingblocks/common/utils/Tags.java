package com.teamarcanum.mobuildingblocks.common.utils;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import net.minecraft.block.Block;
import net.minecraft.tag.RequiredTagList;
import net.minecraft.tag.RequiredTagListRegistry;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Tags {
    protected static final RequiredTagList<Block> REQUIRED_TAGS;

    public static final Tag.Identified<Block> COLUMN;

    private static Tag.Identified<Block> tag(String _name) {
        return REQUIRED_TAGS.add(_name);
    }

    static {
        REQUIRED_TAGS = RequiredTagListRegistry.register(Registry.BLOCK_KEY, new Identifier(MoBuildingBlocks.MODID, "tags/blocks").toString());
        COLUMN = tag("pillars");
    }
}
