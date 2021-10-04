package com.teamarcanum.mobuildingblocks.common.block;

import api.teamarcanum.common.block.ITagHolder;
import com.teamarcanum.mobuildingblocks.data.BlockStateProvider;
import api.teamarcanum.data.IBlockDataContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.generators.ModelFile;

import java.util.Objects;

public class WallBlock extends net.minecraft.world.level.block.WallBlock implements IBlockDataContainer, ITagHolder<Block> {

    private final Block source;
    private final Tag.Named<Block>[] tags;

    public WallBlock(Block _block, Tag.Named<Block>[] _tags) {

        super(BlockBehaviour.Properties.copy(_block));

        this.source = _block;
        this.tags = _tags;
    }

    @Override
    public Tag.Named<Block>[] tags() {

        return this.tags;
    }

    @Override
    public void generateData(BlockStateProvider _provider) {

        ResourceLocation registryName = Objects.requireNonNull(this.source.getRegistryName());
        ResourceLocation textureLoc = new ResourceLocation("block/" + registryName.getPath().replaceAll("_wall", ""));
        _provider.wallBlock(this, textureLoc);
    }

    @Override
    public boolean customItem() {
        return true;
    }

    @Override
    public void generateItem(BlockStateProvider _provider) {

        ResourceLocation registryName = Objects.requireNonNull(this.source.getRegistryName());
        ResourceLocation textureLoc = new ResourceLocation("block/" + registryName.getPath().replaceAll("_wall", ""));

        _provider.itemModels().getBuilder(Objects.requireNonNull(getRegistryName()).getPath())
                .parent(new ModelFile.ExistingModelFile(new ResourceLocation("minecraft:block/wall_inventory"), _provider.itemModels().existingFileHelper))
                .texture("wall", textureLoc);
    }
}
