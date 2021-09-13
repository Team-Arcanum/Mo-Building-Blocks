package com.teamarcanum.mobuildingblocks.common.utils;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class BlockTags {

    public static final Tags.IOptionalNamedTag<Block> COLUMN = moBlockTag("blocks/pillars");

    private static Tags.IOptionalNamedTag<Block> moBlockTag(String _name) {
        return tag(MoBuildingBlocks.MODID, _name);
    }

    private static Tags.IOptionalNamedTag<Block> forgeTag(String _name) {
        return tag("forge", _name);
    }

    private static Tags.IOptionalNamedTag<Block> tag(String _modid, String _name) {
        return net.minecraft.tags.BlockTags.createOptional(new ResourceLocation(_modid, _name));
    }
}
