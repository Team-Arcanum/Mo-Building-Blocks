package com.teamarcanum.mobuildingblocks.common.block;

import com.teamarcanum.mobuildingblocks.data.BlockStateProvider;
import com.teamarcanum.mobuildingblocks.data.IBlockDataContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Objects;

public class StairBlock extends net.minecraft.world.level.block.StairBlock implements IBlockDataContainer {

    private final Block source;

    public StairBlock(Block _block) {

        super(_block::defaultBlockState, BlockBehaviour.Properties.copy(_block));

        this.source = _block;
    }

    @Override
    public void generateData(BlockStateProvider _provider) {

        _provider.stairsBlock(this, new ResourceLocation("block/" + Objects.requireNonNull(this.source.getRegistryName()).getPath()));
    }
}
