package com.teamarcanum.mobuildingblocks.client;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class MoBuildingBlocksCreativeTab {

    public static final ItemGroup INSTANCE = FabricItemGroupBuilder.build(
            new Identifier(MoBuildingBlocks.MODID, "general"), () -> new ItemStack(Blocks.SMOOTH_STONE.stairs));
}
