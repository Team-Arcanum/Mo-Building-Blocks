package com.teamarcanum.mobuildingblocks.common.block;

import api.teamarcanum.common.block.ITagHolder;
import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.data.BlockStateProvider;
import api.teamarcanum.data.IBlockDataContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelProvider;

import java.util.Objects;

public class ButtonBlock extends net.minecraft.world.level.block.StoneButtonBlock implements IBlockDataContainer, ITagHolder<Block> {

    private final Block source;
    private final Tag.Named<Block>[] tags;
    private final ItemLike ingredient;

    public ButtonBlock(Block _source, ItemLike _ingredient, Tag.Named<Block>... _tags) {
        super(BlockBehaviour.Properties.copy(_source).isValidSpawn(ButtonBlock::isValidSpawn));

        this.source = _source;
        this.tags = _tags;
        this.ingredient = _ingredient;
    }

    private static boolean isValidSpawn(BlockState _state, BlockGetter _blockGetter, BlockPos _blockPos, EntityType<?> _entityType) {
        return false;
    }

    @Override
    public void generateData(BlockStateProvider _provider) {
        ResourceLocation registryName = Objects.requireNonNull(getRegistryName());

        _provider.getVariantBuilder(this).forAllStates(_state ->
                                                       {
                                                           boolean powered = _state.getValue(POWERED);
                                                           ResourceLocation parent = getParentModel(powered, _provider);
                                                           ResourceLocation name = MoBuildingBlocks.rl(registryName.getPath() + (powered ? "_powered" : ""));
                                                           AttachFace face = _state.getValue(FACE);
                                                           Direction direction = _state.getValue(FACING);

                                                           return new ConfiguredModel[]{
                                                                   new ConfiguredModel(_provider.models().withExistingParent(name.toString(), parent)
                                                                                               .texture("texture", getTexture(_provider)),
                                                                                       getX(face), (int) (direction.getOpposite().toYRot()), false)
                                                           };
                                                       });
    }

    @Override
    public void generateItem(BlockStateProvider _provider) {
        _provider.itemModels().withExistingParent(
                        Objects.requireNonNull(getRegistryName()).toString(), _provider.mcLoc(ModelProvider.BLOCK_FOLDER + "/button_inventory").toString())
                .texture("texture", getTexture(_provider));
    }

    @Override
    public boolean customItem() {
        return true;
    }

    private ResourceLocation getParentModel(boolean _powered, BlockStateProvider _provider) {
        return _provider.mcLoc(ModelProvider.BLOCK_FOLDER + "/button" + (_powered ? "_pressed" : ""));
    }

    private ResourceLocation getTexture(BlockStateProvider _provider) {
        return _provider.mcLoc(ModelProvider.BLOCK_FOLDER + "/" + Objects.requireNonNull(source.getRegistryName()).getPath());
    }

    private int getX(AttachFace _face) {
        switch(_face) {
            case FLOOR -> {
                return 0;
            }
            case CEILING -> {
                return 180;
            }
            default -> {
                return 90;
            }
        }
    }

    @Override
    public Tag.Named<Block>[] tags() {
        return this.tags;
    }

    public ItemLike ingredient() {
        return this.ingredient;
    }
}
