package com.teamarcanum.mobuildingblocks.common.block;

import com.teamarcanum.mobuildingblocks.data.BlockStateProvider;
import com.teamarcanum.mobuildingblocks.data.IBlockDataContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Objects;

public class SlabBlock extends net.minecraft.world.level.block.SlabBlock implements IBlockDataContainer {

    private final Block source;

    public SlabBlock(Block _block) {

        super(BlockBehaviour.Properties.copy(_block)
                      .strength(1.5F, 6.0F));

        this.source = _block;
    }

    @Override
    public void generateData(BlockStateProvider _provider) {

        _provider.slabBlock(
                this,
                this.source.getRegistryName(),
                new ResourceLocation("block/" + Objects.requireNonNull(this.source.getRegistryName()).getPath()));
    }
}
