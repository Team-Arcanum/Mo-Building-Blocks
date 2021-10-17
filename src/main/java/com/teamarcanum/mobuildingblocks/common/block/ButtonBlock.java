package com.teamarcanum.mobuildingblocks.common.block;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ButtonBlock extends StoneButtonBlock implements IIdentifierProvider {
    private final String id;

    public ButtonBlock(String _id, Block _source) {
        super(FabricBlockSettings.copy(_source).allowsSpawning(ButtonBlock::isValidSpawn));

        this.id = _id;
    }

    public Identifier id() {
        return new Identifier(MoBuildingBlocks.MODID, id);
    }

    private static boolean isValidSpawn(BlockState _state, BlockView _blockGetter, BlockPos _blockPos, EntityType<?> _entityType) {
        return false;
    }
}
