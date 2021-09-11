package com.teamarcanum.mobuildingblocks.common.block;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.data.BlockStateProvider;
import com.teamarcanum.mobuildingblocks.data.IBlockDataContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;

import javax.annotation.Nonnull;
import java.util.Objects;

@SuppressWarnings("deprecation")
public class LayerBlock extends SnowLayerBlock implements IBlockDataContainer, SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private final Block source;

    public LayerBlock(Block _source) {

        super(BlockBehaviour.Properties.copy(_source));

        this.source = _source;
        this.registerDefaultState(this.getStateDefinition().any().setValue(LAYERS, 1).setValue(WATERLOGGED, false));
    }

    public Block getSource() {

        return source;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block,BlockState> _container) {

        _container.add(LAYERS, WATERLOGGED);
    }

    @Nonnull
    @Override
    public FluidState getFluidState(BlockState _state) {

        return _state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(_state);
    }

    @Override
    public void generateData(BlockStateProvider _provider) {

        ResourceLocation registryName = Objects.requireNonNull(this.source.getRegistryName());
        ResourceLocation textureLoc = new ResourceLocation("block/" + Objects.requireNonNull(this.source.getRegistryName()).getPath());

        VariantBlockStateBuilder builder = _provider.getVariantBuilder(this);
        for(int height = 1; height <= 8; height++) {
            if(height == 8) {
                builder.partialState().with(BlockStateProperties.LAYERS, height).addModels(
                        new ConfiguredModel(_provider.models().cubeAll(registryName.getPath() + "_layer" + height, new ResourceLocation(ModelProvider.BLOCK_FOLDER + "/" + registryName.getPath())))
                );
            } else {
                builder.partialState().with(BlockStateProperties.LAYERS, height).addModels(
                        new ConfiguredModel(_provider.models()
                                                    .withExistingParent(registryName.getPath() + "_layer" + (height == 1 ? "" : Integer.toString(height)), new ResourceLocation("minecraft", "snow_height" + 2 * height))
                                                    .texture("texture", textureLoc)
                                                    .texture("particle", textureLoc)
                        )
                );
            }
        }
    }

    @Override
    public boolean customItem() {

        return true;
    }

    @Override
    public void generateItem(BlockStateProvider _provider) {

        _provider.simpleBlockItem(this,
                                  new ModelFile.ExistingModelFile(
                                          new ResourceLocation(MoBuildingBlocks.MODID, "block/" + Objects.requireNonNull(getRegistryName()).getPath()),
                                          _provider.itemModels().existingFileHelper));
    }
}
