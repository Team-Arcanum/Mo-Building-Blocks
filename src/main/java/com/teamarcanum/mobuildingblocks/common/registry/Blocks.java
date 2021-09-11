package com.teamarcanum.mobuildingblocks.common.registry;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.block.LayerBlock;
import com.teamarcanum.mobuildingblocks.common.block.SlabBlock;
import com.teamarcanum.mobuildingblocks.common.block.StairBlock;
import com.teamarcanum.mobuildingblocks.common.block.WallBlock;
import com.teamarcanum.mobuildingblocks.data.BlockLoot;
import com.teamarcanum.mobuildingblocks.data.StandardRecipeProvider;
import com.teamarcanum.mobuildingblocks.data.StonecutterRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings({"SameParameterValue", "unused"})
public class Blocks {

    public static class MultiRegistryObject {

        public final Block source;
        public final RegistryObject<Block> stairs;
        public final RegistryObject<Block> slab;
        public final RegistryObject<Block> wall;

        public MultiRegistryObject(Block _source, RegistryObject<Block> _stairs, RegistryObject<Block> _slab, RegistryObject<Block> _wall) {

            this.source = _source;
            this.stairs = _stairs;
            this.slab = _slab;
            this.wall = _wall;
        }

        public void registerTags(TagsProvider.TagAppender<Block> _stairsTag, TagsProvider.TagAppender<Block> _wallTag) {

            if(stairs != null)
                _stairsTag.add(stairs.get());

            if(wall != null)
                _wallTag.add(wall.get());
        }

        public void registerHarvestTags(TagsProvider.TagAppender<Block> _toolType, TagsProvider.TagAppender<Block> _harvestLevel) {

            if(stairs != null) {
                _toolType.add(stairs.get());
                _harvestLevel.add(stairs.get());
            }

            if(wall != null) {
                _toolType.add(wall.get());
                _harvestLevel.add(wall.get());
            }

            if(slab != null) {
                _toolType.add(slab.get());
                _harvestLevel.add(slab.get());
            }

        }

        public void registerStonecutterRecipes(Consumer<FinishedRecipe> _recipeConsumer) {

            if(stairs != null)
                StonecutterRecipeProvider.stonecutterRecipe(_recipeConsumer, stairs.get(), source);

            if(slab != null)
                StonecutterRecipeProvider.stonecutterRecipe(_recipeConsumer, slab.get(), source, 2);

            if(wall != null)
                StonecutterRecipeProvider.stonecutterRecipe(_recipeConsumer, wall.get(), source);
        }

        public void registerShapedRecipes(Consumer<FinishedRecipe> _recipeConsumer) {

            if(stairs != null)
                StandardRecipeProvider.stairsRecipe(_recipeConsumer, stairs.get(), source);

            if(slab != null)
                StandardRecipeProvider.slabRecipe(_recipeConsumer, slab.get(), source);

            if(wall != null)
                StandardRecipeProvider.wallRecipe(_recipeConsumer, wall.get(), source);
        }

        public void registerBlockDrops(BlockLoot _blockLoot) {

            if(stairs != null)
                _blockLoot.dropSelf(stairs.get());

            if(slab != null)
                _blockLoot.dropSelf(slab.get());

            if(wall != null)
                _blockLoot.dropSelf(wall.get());
        }
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoBuildingBlocks.MODID);
    public static final List<MultiRegistryObject> MULTI_REGISTRY_OBJECTS = new ArrayList<>();
    public static final List<RegistryObject<LayerBlock>> LAYER_BLOCKS = new ArrayList<>();

    public static final MultiRegistryObject CALCITE = registerObject("calcite", net.minecraft.world.level.block.Blocks.CALCITE);
    public static final MultiRegistryObject AMETHYST = registerObject("amethyst", net.minecraft.world.level.block.Blocks.AMETHYST_BLOCK);
    public static final MultiRegistryObject DEEPSLATE = registerObject("deepslate", net.minecraft.world.level.block.Blocks.DEEPSLATE);
    public static final MultiRegistryObject GILDED_BLACKSTONE = registerObject("gilded_blackstone", net.minecraft.world.level.block.Blocks.GILDED_BLACKSTONE);
    public static final MultiRegistryObject TUFF = registerObject("tuff", net.minecraft.world.level.block.Blocks.TUFF);
    public static final MultiRegistryObject SMOOTH_BASALT = registerObject("smooth_basalt", net.minecraft.world.level.block.Blocks.SMOOTH_BASALT);
    public static final MultiRegistryObject SMOOTH_STONE = registerObject("smooth_stone", net.minecraft.world.level.block.Blocks.SMOOTH_STONE, true, false, true);

    public static final MultiRegistryObject WHITE_CONCRETE = registerObject("white_concrete", net.minecraft.world.level.block.Blocks.WHITE_CONCRETE);
    public static final MultiRegistryObject ORANGE_CONCRETE = registerObject("orange_concrete", net.minecraft.world.level.block.Blocks.ORANGE_CONCRETE);
    public static final MultiRegistryObject MAGENTA_CONCRETE = registerObject("magenta_concrete", net.minecraft.world.level.block.Blocks.MAGENTA_CONCRETE);
    public static final MultiRegistryObject LIGHT_BLUE_CONCRETE = registerObject("light_blue_concrete", net.minecraft.world.level.block.Blocks.LIGHT_BLUE_CONCRETE);
    public static final MultiRegistryObject YELLOW_CONCRETE = registerObject("yellow_concrete", net.minecraft.world.level.block.Blocks.YELLOW_CONCRETE);
    public static final MultiRegistryObject LIME_CONCRETE = registerObject("lime_concrete", net.minecraft.world.level.block.Blocks.LIME_CONCRETE);
    public static final MultiRegistryObject PINK_CONCRETE = registerObject("pink_concrete", net.minecraft.world.level.block.Blocks.PINK_CONCRETE);
    public static final MultiRegistryObject GRAY_CONCRETE = registerObject("gray_concrete", net.minecraft.world.level.block.Blocks.GRAY_CONCRETE);
    public static final MultiRegistryObject LIGHT_GRAY_CONCRETE = registerObject("light_gray_concrete", net.minecraft.world.level.block.Blocks.LIGHT_GRAY_CONCRETE);
    public static final MultiRegistryObject CYAN_CONCRETE = registerObject("cyan_concrete", net.minecraft.world.level.block.Blocks.CYAN_CONCRETE);
    public static final MultiRegistryObject PURPLE_CONCRETE = registerObject("purple_concrete", net.minecraft.world.level.block.Blocks.PURPLE_CONCRETE);
    public static final MultiRegistryObject BLUE_CONCRETE = registerObject("blue_concrete", net.minecraft.world.level.block.Blocks.BLUE_CONCRETE);
    public static final MultiRegistryObject BROWN_CONCRETE = registerObject("brown_concrete", net.minecraft.world.level.block.Blocks.BROWN_CONCRETE);
    public static final MultiRegistryObject GREEN_CONCRETE = registerObject("green_concrete", net.minecraft.world.level.block.Blocks.GREEN_CONCRETE);
    public static final MultiRegistryObject RED_CONCRETE = registerObject("red_concrete", net.minecraft.world.level.block.Blocks.RED_CONCRETE);
    public static final MultiRegistryObject BLACK_CONCRETE = registerObject("black_concrete", net.minecraft.world.level.block.Blocks.BLACK_CONCRETE);

    public static final MultiRegistryObject WHITE_TERRACOTTA = registerObject("white_terracotta", net.minecraft.world.level.block.Blocks.WHITE_TERRACOTTA);
    public static final MultiRegistryObject ORANGE_TERRACOTTA = registerObject("orange_terracotta", net.minecraft.world.level.block.Blocks.ORANGE_TERRACOTTA);
    public static final MultiRegistryObject MAGENTA_TERRACOTTA = registerObject("magenta_terracotta", net.minecraft.world.level.block.Blocks.MAGENTA_TERRACOTTA);
    public static final MultiRegistryObject LIGHT_BLUE_TERRACOTTA = registerObject("light_blue_terracotta", net.minecraft.world.level.block.Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final MultiRegistryObject YELLOW_TERRACOTTA = registerObject("yellow_terracotta", net.minecraft.world.level.block.Blocks.YELLOW_TERRACOTTA);
    public static final MultiRegistryObject LIME_TERRACOTTA = registerObject("lime_terracotta", net.minecraft.world.level.block.Blocks.LIME_TERRACOTTA);
    public static final MultiRegistryObject PINK_TERRACOTTA = registerObject("pink_terracotta", net.minecraft.world.level.block.Blocks.PINK_TERRACOTTA);
    public static final MultiRegistryObject GRAY_TERRACOTTA = registerObject("gray_terracotta", net.minecraft.world.level.block.Blocks.GRAY_TERRACOTTA);
    public static final MultiRegistryObject LIGHT_GRAY_TERRACOTTA = registerObject("light_gray_terracotta", net.minecraft.world.level.block.Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final MultiRegistryObject CYAN_TERRACOTTA = registerObject("cyan_terracotta", net.minecraft.world.level.block.Blocks.CYAN_TERRACOTTA);
    public static final MultiRegistryObject PURPLE_TERRACOTTA = registerObject("purple_terracotta", net.minecraft.world.level.block.Blocks.PURPLE_TERRACOTTA);
    public static final MultiRegistryObject BLUE_TERRACOTTA = registerObject("blue_terracotta", net.minecraft.world.level.block.Blocks.BLUE_TERRACOTTA);
    public static final MultiRegistryObject BROWN_TERRACOTTA = registerObject("brown_terracotta", net.minecraft.world.level.block.Blocks.BROWN_TERRACOTTA);
    public static final MultiRegistryObject GREEN_TERRACOTTA = registerObject("green_terracotta", net.minecraft.world.level.block.Blocks.GREEN_TERRACOTTA);
    public static final MultiRegistryObject RED_TERRACOTTA = registerObject("red_terracotta", net.minecraft.world.level.block.Blocks.RED_TERRACOTTA);
    public static final MultiRegistryObject BLACK_TERRACOTTA = registerObject("black_terracotta", net.minecraft.world.level.block.Blocks.BLACK_TERRACOTTA);

    public static final RegistryObject<LayerBlock> SAND_LAYER = registerLayer("sand_layer", net.minecraft.world.level.block.Blocks.SAND);
    public static final RegistryObject<LayerBlock> DIRT_LAYER = registerLayer("dirt_layer", net.minecraft.world.level.block.Blocks.DIRT);
    public static final RegistryObject<LayerBlock> GRAVEL_LAYER = registerLayer("gravel_layer", net.minecraft.world.level.block.Blocks.GRAVEL);
    public static final RegistryObject<LayerBlock> COARSE_DIRT_LAYER = registerLayer("coarse_dirt_layer", net.minecraft.world.level.block.Blocks.COARSE_DIRT);
    public static final RegistryObject<LayerBlock> MOSS_BLOCK_LAYER = registerLayer("moss_block_layer", net.minecraft.world.level.block.Blocks.MOSS_BLOCK);

    private static RegistryObject<LayerBlock> registerLayer(String _name, Block _block) {

        RegistryObject<LayerBlock> layerBlock = BLOCKS.register(_name, () -> new LayerBlock(_block));
        LAYER_BLOCKS.add(layerBlock);

        return layerBlock;
    }

    private static MultiRegistryObject registerObject(String _name, Block _block) {

        return registerObject(_name, _block, true, true, true);
    }

    private static MultiRegistryObject registerObject(String _name, Block _block, boolean _stairs, boolean _slab, boolean _wall) {

        RegistryObject<Block> stairs = null;
        RegistryObject<Block> slab = null;
        RegistryObject<Block> wall = null;

        if(_stairs)
            stairs = BLOCKS.register(_name + "_stairs", () -> new StairBlock(_block));

        if(_slab)
            slab = BLOCKS.register(_name + "_slab", () -> new SlabBlock(_block));

        if(_wall)
            wall = BLOCKS.register(_name + "_wall", () -> new WallBlock(_block));

        MultiRegistryObject multiRegistryObject = new MultiRegistryObject(_block, stairs, slab, wall);
        MULTI_REGISTRY_OBJECTS.add(multiRegistryObject);

        return multiRegistryObject;
    }

    public static void registerTags(TagsProvider.TagAppender<Block> _stairsTag, TagsProvider.TagAppender<Block> _wallTag) {

        for(MultiRegistryObject object : MULTI_REGISTRY_OBJECTS) {

            object.registerTags(_stairsTag, _wallTag);
        }
    }

    public static void registerMultiobjectHarvestTags(TagsProvider.TagAppender<Block> _toolType, TagsProvider.TagAppender<Block> _harvestLevel) {

        for(MultiRegistryObject object : MULTI_REGISTRY_OBJECTS) {

            object.registerHarvestTags(_toolType, _harvestLevel);
        }
    }

    public static void registerLayerHarvestTags(TagsProvider.TagAppender<Block> _toolType) {

        for(RegistryObject<LayerBlock> block : LAYER_BLOCKS) {

            _toolType.add(block.get());
        }
    }

    public static void registerLoot(BlockLoot _loot) {

        for(MultiRegistryObject object : MULTI_REGISTRY_OBJECTS) {

            object.registerBlockDrops(_loot);
        }

        for(RegistryObject<LayerBlock> registryObject : LAYER_BLOCKS) {

            LayerBlock block = registryObject.get();
            _loot.layerBlock(block);
        }
    }

    @ParametersAreNonnullByDefault
    public static void registerStandardRecipes(Consumer<FinishedRecipe> _recipeConsumer) {

        for(MultiRegistryObject object : MULTI_REGISTRY_OBJECTS) {

            object.registerShapedRecipes(_recipeConsumer);
        }

        for(RegistryObject<LayerBlock> registryObject : LAYER_BLOCKS) {

            StandardRecipeProvider.layerRecipe(_recipeConsumer, registryObject.get(), registryObject.get().getSource());
        }
    }

    @ParametersAreNonnullByDefault
    public static void registerStonecutterRecipes(Consumer<FinishedRecipe> _recipeConsumer) {

        for(MultiRegistryObject object : MULTI_REGISTRY_OBJECTS) {

            object.registerStonecutterRecipes(_recipeConsumer);
        }
    }
}
