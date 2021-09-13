package com.teamarcanum.mobuildingblocks.data;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.block.ITagHolder;
import com.teamarcanum.mobuildingblocks.common.block.PillarBlock;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.util.ReverseTagWrapper;
import net.minecraftforge.fmllegacy.RegistryObject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;

public class TagsProvider extends net.minecraft.data.tags.TagsProvider<Block> {

    protected TagsProvider(DataGenerator _generator, Registry<Block> _registry, @Nullable ExistingFileHelper _fileHelper) {

        super(_generator, _registry, MoBuildingBlocks.MODID, _fileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {

        Blocks.registerTags(tag(BlockTags.STAIRS), tag(BlockTags.WALLS));
        Blocks.registerPillarTags(tag(com.teamarcanum.mobuildingblocks.common.utils.BlockTags.COLUMN));

        Blocks.BLOCKS.getEntries().forEach(_block -> {
            Block block = _block.get();
            if(block instanceof ITagHolder) {

                ITagHolder<Block> tagHolder = (ITagHolder<Block>) block;
                for(Tag.Named<Block> tag : tagHolder.tags()) {
                    tag(tag).add(block);
                }
            }
        });
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
