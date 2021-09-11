package com.teamarcanum.mobuildingblocks.common.block;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.data.BlockStateProvider;
import com.teamarcanum.mobuildingblocks.data.IBlockDataContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.ModelProvider;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class ColumnBlock extends Block implements IBlockDataContainer, SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private final Block source;

    public ColumnBlock(Block _block) {

        super(BlockBehaviour.Properties.copy(_block));

        this.source = _block;
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> _container) {

        _container.add(WATERLOGGED);
    }

    @Nonnull
    @Override
    public FluidState getFluidState(BlockState _state) {

        return _state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(_state);
    }

    @Override
    public void generateData(BlockStateProvider _provider) {

        ResourceLocation registryName = Objects.requireNonNull(this.source.getRegistryName());
        ResourceLocation columnRegistryName = Objects.requireNonNull(getRegistryName());
        ResourceLocation textureLoc = new ResourceLocation("block/" + registryName.getPath().replaceAll("_column", ""));

        _provider.simpleBlock(
                this,
                _provider.models()
                        .withExistingParent(columnRegistryName.toString(), MoBuildingBlocks.rl(ModelProvider.BLOCK_FOLDER + "/column"))
                        .texture("1", textureLoc)
                        .texture("particle", textureLoc));

        _provider.simpleBlockItem(
                this,
                _provider.itemModels()
                        .withExistingParent(columnRegistryName.toString(), MoBuildingBlocks.rl(ModelProvider.BLOCK_FOLDER + "/column")));
    }

    @Override
    @ParametersAreNonnullByDefault
    @Nonnull
    public VoxelShape getShape(BlockState _state, BlockGetter _getter, BlockPos _pos, CollisionContext _context) {

        return Shapes.box(0.25, 0, 0.25, 0.75, 1, 0.75);
    }
}
