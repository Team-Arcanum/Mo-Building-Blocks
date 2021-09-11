package com.teamarcanum.mobuildingblocks.common.block;

import com.teamarcanum.mobuildingblocks.data.BlockStateProvider;
import com.teamarcanum.mobuildingblocks.data.IBlockDataContainer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.generators.ModelFile;

import java.util.Objects;

public class WallBlock extends net.minecraft.world.level.block.WallBlock implements IBlockDataContainer {

    private final Block source;

    public WallBlock(Block _block) {

        super(BlockBehaviour.Properties.copy(_block));

        this.source = _block;
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
