package com.teamarcanum.mobuildingblocks.common.block;

import api.teamarcanum.common.block.ITagHolder;
import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.data.BlockStateProvider;
import api.teamarcanum.data.IBlockDataContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class PillarBlock extends Block implements IBlockDataContainer, SimpleWaterloggedBlock, ITagHolder<Block> {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<PillarState> PILLAR_STATE = EnumProperty.create("pillar_state", PillarState.class);

    private final Block source;
    private final Tag.Named<Block>[] tags;

    public PillarBlock(Block _block, Tag.Named<Block>[] _tags) {

        super(BlockBehaviour.Properties.copy(_block));

        this.tags = _tags;
        this.source = _block;
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false).setValue(PILLAR_STATE, PillarState.CENTER));
    }

    @Override
    public Tag.Named<Block>[] tags() {

        return this.tags;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> _container) {

        _container.add(WATERLOGGED, PILLAR_STATE);
    }

    @Nonnull
    @Override
    public FluidState getFluidState(BlockState _state) {

        return _state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(_state);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public BlockState updateShape(BlockState _state, Direction _direction, BlockState _otherBlockState, LevelAccessor _level, BlockPos _pos, BlockPos _otherBlockPos) {

        return this.calculateState(_level, _pos).setValue(WATERLOGGED, _state.getValue(WATERLOGGED));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext _context) {

        Level level = Objects.requireNonNull(_context.getLevel());

        return this.calculateState(level, _context.getClickedPos());
    }

    private BlockState calculateState(LevelAccessor _level, BlockPos _pos) {

        Tag<Block> tag = BlockTags.getAllTags().getTag(com.teamarcanum.mobuildingblocks.common.utils.BlockTags.COLUMN.getName());

        assert tag != null;
        boolean hasUp = tag.contains(_level.getBlockState(_pos.above()).getBlock());
        boolean hasDown = tag.contains(_level.getBlockState(_pos.below()).getBlock());

        if(hasUp) {
            if(hasDown) {
                return this.defaultBlockState().setValue(PILLAR_STATE, PillarState.CENTER);
            }
            return this.defaultBlockState().setValue(PILLAR_STATE, PillarState.BOTTOM);
        } else if(hasDown) {
            return this.defaultBlockState().setValue(PILLAR_STATE, PillarState.TOP);
        }
        return this.defaultBlockState().setValue(PILLAR_STATE, PillarState.TOP);
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public VoxelShape getShape(BlockState _state, BlockGetter _getter, BlockPos _pos, CollisionContext _context) {

        PillarState columnState = _state.getValue(PILLAR_STATE);
        return getYShape(columnState);
    }

    @Nonnull
    private VoxelShape getYShape(PillarState _pillarState) {

        switch(_pillarState) {

            case TOP -> {
                VoxelShape shape = Shapes.empty();
                shape = Shapes.join(shape, Shapes.box(0.0625, 0.8125, 0.0625, 0.9375, 1, 0.9375), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.1875, 0.8125, 0.8125, 0.8125), BooleanOp.OR);

                return shape;
            }
            case BOTTOM -> {
                VoxelShape shape = Shapes.empty();
                shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.0625, 0.9375, 0.1875, 0.9375), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0.1875, 0.1875, 0.8125, 1, 0.8125), BooleanOp.OR);

                return shape;
            }
            default -> {
                return Shapes.box(0.1875, 0, 0.1875, 0.8125, 1, 0.8125);
            }
        }
    }

    @Override
    public boolean customItem() {

        return true;
    }

    @Override
    public void generateItem(BlockStateProvider _provider) {

        ResourceLocation columnRegistryName = Objects.requireNonNull(getRegistryName());

        _provider.simpleBlockItem(
                this,
                _provider.models().withExistingParent(columnRegistryName.toString() + "_center", MoBuildingBlocks.rl(ModelProvider.BLOCK_FOLDER + "/pillar")));
    }

    @Override
    public void generateData(BlockStateProvider _provider) {

        ResourceLocation registryName = Objects.requireNonNull(this.source.getRegistryName());
        ResourceLocation columnRegistryName = Objects.requireNonNull(getRegistryName());
        ResourceLocation textureLoc = new ResourceLocation("block/" + registryName.getPath().replaceAll("_pillar", ""));

        VariantBlockStateBuilder builder = _provider.getVariantBuilder(this);

        builder.forAllStates(_blockState -> {

            PillarState pillarState = _blockState.getValue(PILLAR_STATE);

            return new ConfiguredModel[]{
                    new ConfiguredModel(
                            _provider.models()
                                    .withExistingParent(columnRegistryName.toString() + "_" + pillarState.getSerializedName(), MoBuildingBlocks.rl(pillarState.getModelId()))
                                    .texture("texture", textureLoc)
                                    .texture("particle", textureLoc))
            };
        });
    }

    public enum PillarState implements StringRepresentable {

        TOP("top", "pillar_top"),
        CENTER("center", "pillar"),
        BOTTOM("bottom", "pillar_bottom");

        private final String name;
        private final String modelId;

        PillarState(String _name, String _modelId) {

            this.name = _name;
            this.modelId = _modelId;
        }

        @Nonnull
        public String getModelId() {

            return this.modelId;
        }

        @Override
        @Nonnull
        public String getSerializedName() {

            return this.name;
        }
    }
}
