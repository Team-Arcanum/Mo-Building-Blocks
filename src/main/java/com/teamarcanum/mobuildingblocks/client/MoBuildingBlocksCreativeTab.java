package com.teamarcanum.mobuildingblocks.client;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class MoBuildingBlocksCreativeTab extends CreativeModeTab {

    public static final MoBuildingBlocksCreativeTab INSTANCE = new MoBuildingBlocksCreativeTab();

    public MoBuildingBlocksCreativeTab() {

        super(MoBuildingBlocks.MODID);
    }

    @Override
    @Nonnull
    public ItemStack makeIcon() {

        return new ItemStack(Blocks.SMOOTH_STONE.stairs.get());
    }
}
