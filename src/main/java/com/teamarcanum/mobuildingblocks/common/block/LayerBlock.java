package com.teamarcanum.mobuildingblocks.common.block;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

@SuppressWarnings("deprecation")
public class LayerBlock extends SnowBlock implements Waterloggable, IIdentifierProvider {
    private final String id;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public LayerBlock(String _id, Block _source) {

        super(FabricBlockSettings.copy(_source));

        this.id = _id;
        this.setDefaultState(this.stateManager.getDefaultState().with(LAYERS, 1).with(WATERLOGGED, false));
    }

    public Identifier id() {
        return new Identifier(MoBuildingBlocks.MODID, id);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block,BlockState> _container) {

        _container.add(LAYERS, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState _state) {

        return _state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(_state);
    }
}
