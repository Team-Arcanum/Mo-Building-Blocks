package com.teamarcanum.mobuildingblocks.data;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.Objects;

public class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {

    public BlockStateProvider(DataGenerator _gen, ExistingFileHelper _exFileHelper) {

        super(_gen, MoBuildingBlocks.MODID, _exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        Blocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(_block ->
         {
             if(_block instanceof IBlockDataContainer dataContainer) {

                 dataContainer.generateData(this);
                 if(dataContainer.customItem()) {
                     dataContainer.generateItem(this);
                     return;
                 }
             } else {

                 this.simpleBlock(_block);
             }

             this.simpleBlockItem(
                     _block,
                     new ModelFile.ExistingModelFile(
                             new ResourceLocation(MoBuildingBlocks.MODID, "block/" + Objects.requireNonNull(_block.getRegistryName()).getPath()),
                             itemModels().existingFileHelper));
         });
    }
}
