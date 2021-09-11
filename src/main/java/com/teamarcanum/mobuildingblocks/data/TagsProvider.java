package com.teamarcanum.mobuildingblocks.data;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.nio.file.Path;

public class TagsProvider extends net.minecraft.data.tags.TagsProvider<Block> {

    protected TagsProvider(DataGenerator _generator, Registry<Block> _registry, @Nullable ExistingFileHelper _fileHelper) {

        super(_generator, _registry, MoBuildingBlocks.MODID, _fileHelper);
    }

    @Override
    protected void addTags() {

        Blocks.registerTags(tag(BlockTags.STAIRS), tag(BlockTags.WALLS));
        Blocks.registerMultiobjectHarvestTags(tag(BlockTags.MINEABLE_WITH_PICKAXE), tag(BlockTags.NEEDS_STONE_TOOL));
        Blocks.registerLayerHarvestTags(tag(BlockTags.MINEABLE_WITH_SHOVEL));
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    protected Path getPath(ResourceLocation _location) {

        return this.generator.getOutputFolder().resolve("data/" + _location.getNamespace() + "/tags/blocks/" + _location.getPath() + ".json");
    }

    @Override
    @Nonnull
    public String getName() {

        return MoBuildingBlocks.MODID + ":Block Tags";
    }
}
