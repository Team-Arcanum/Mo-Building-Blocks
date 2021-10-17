package com.teamarcanum.mobuildingblocks.common.block;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

public class WallBlock extends net.minecraft.block.WallBlock implements IIdentifierProvider {
    private final String id;

    public WallBlock(String _id, Block _block) {
        super(FabricBlockSettings.copy(_block));

        this.id = _id;
    }

    public Identifier id() {
        return new Identifier(MoBuildingBlocks.MODID, id);
    }
}
