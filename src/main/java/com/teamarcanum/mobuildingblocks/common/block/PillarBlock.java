package com.teamarcanum.mobuildingblocks.common.block;

import com.google.common.collect.ImmutableMap;
import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.utils.Tags;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.function.Function;

@SuppressWarnings("deprecation")
public class PillarBlock extends Block implements Waterloggable, IIdentifierProvider {
    private final String id;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final EnumProperty<PillarState> PILLAR_STATE = EnumProperty.of("pillar_state", PillarState.class);

    public PillarBlock(String _id, Block _block) {
        super(FabricBlockSettings.copy(_block));

        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(PILLAR_STATE, PillarState.CENTER));
        this.id = _id;
    }

    public Identifier id() {
        return new Identifier(MoBuildingBlocks.MODID, id);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block,BlockState> _container) {
        _container.add(WATERLOGGED, PILLAR_STATE);
    }

    @Override
    public FluidState getFluidState(BlockState _state) {
        return _state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(_state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState _state, Direction _direction, BlockState _neighbor, WorldAccess _level, BlockPos _pos, BlockPos _otherBlockPos) {
        return this.calculateState(_level, _pos).with(WATERLOGGED, _state.get(WATERLOGGED));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext _context) {
        return this.calculateState(_context.getWorld(), _context.getBlockPos());
    }

    private BlockState calculateState(WorldAccess _level, BlockPos _pos) {
        Tag<Block> tag = Tags.COLUMN;

        assert tag != null;
        boolean hasUp = tag.contains(_level.getBlockState(_pos.up()).getBlock());
        boolean hasDown = tag.contains(_level.getBlockState(_pos.down()).getBlock());

        if(hasUp) {
            if(hasDown) {
                return this.getDefaultState().with(PILLAR_STATE, PillarState.CENTER);
            }
            return this.getDefaultState().with(PILLAR_STATE, PillarState.BOTTOM);
        } else if(hasDown) {
            return this.getDefaultState().with(PILLAR_STATE, PillarState.TOP);
        }
        return this.getDefaultState().with(PILLAR_STATE, PillarState.TOP);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState _state, BlockView _world, BlockPos _pos, ShapeContext _context) {
        PillarState state = _state.get(PILLAR_STATE);
        return getYShape(state);
    }

    private VoxelShape getYShape(PillarState _pillarState) {
        switch(_pillarState) {
            case TOP -> {
                VoxelShape shape = VoxelShapes.empty();
                shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.0625, 0.8125, 0.0625, 0.9375, 1, 0.9375), BooleanBiFunction.OR);
                shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 0.8125, 0.8125), BooleanBiFunction.OR);

                return shape;
            }
            case BOTTOM -> {
                VoxelShape shape = VoxelShapes.empty();
                shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 0.1875, 0.9375), BooleanBiFunction.OR);
                shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.1875, 0.1875, 0.1875, 0.8125, 1, 0.8125), BooleanBiFunction.OR);

                return shape;
            }
            default -> {
                return VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 1, 0.8125);
            }
        }
    }

    public enum PillarState implements StringIdentifiable {
        TOP("top", "pillar_top"),
        CENTER("center", "pillar"),
        BOTTOM("bottom", "pillar_bottom");

        private final String name;
        private final String modelId;

        PillarState(String _name, String _modelId) {
            this.name = _name;
            this.modelId = _modelId;
        }

        public String getModelId() {
            return this.modelId;
        }

        @Override
        public String asString() {
            return name;
        }
    }
}
