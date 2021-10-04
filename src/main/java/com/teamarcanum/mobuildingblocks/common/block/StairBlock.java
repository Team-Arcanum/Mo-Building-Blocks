package com.teamarcanum.mobuildingblocks.common.block;

import api.teamarcanum.common.block.ITagHolder;
import com.teamarcanum.mobuildingblocks.data.BlockStateProvider;
import api.teamarcanum.data.IBlockDataContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Objects;

public class StairBlock extends net.minecraft.world.level.block.StairBlock implements IBlockDataContainer, ITagHolder<Block> {

    private final Block source;
    private final Tag.Named<Block>[] tags;

    public StairBlock(Block _block, Tag.Named<Block>[] _tags) {

        super(_block::defaultBlockState, BlockBehaviour.Properties.copy(_block));

        this.source = _block;
        this.tags = _tags;
    }

    @Override
    public Tag.Named<Block>[] tags() {

        return this.tags;
    }

    @Override
    public void generateData(BlockStateProvider _provider) {

        _provider.stairsBlock(this, new ResourceLocation("block/" + Objects.requireNonNull(this.source.getRegistryName()).getPath()));
    }
}
