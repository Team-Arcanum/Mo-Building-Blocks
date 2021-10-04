package com.teamarcanum.mobuildingblocks.common.registry;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.block.*;
import com.teamarcanum.mobuildingblocks.data.BlockLoot;
import com.teamarcanum.mobuildingblocks.data.StandardRecipeProvider;
import com.teamarcanum.mobuildingblocks.data.StonecutterRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
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
        public final RegistryObject<PillarBlock> pillar;

        public MultiRegistryObject(Block _source, RegistryObject<Block> _stairs, RegistryObject<Block> _slab, RegistryObject<Block> _wall, RegistryObject<PillarBlock> _pillar) {

            this.source = _source;
            this.stairs = _stairs;
            this.slab = _slab;
            this.wall = _wall;
            this.pillar = _pillar;
        }

        public void registerTags(TagsProvider.TagAppender<Block> _stairsTag, TagsProvider.TagAppender<Block> _wallTag) {

            if(this.stairs != null)
                _stairsTag.add(this.stairs.get());

            if(this.wall != null)
                _wallTag.add(this.wall.get());
        }

        public void registerHarvestTags(TagsProvider.TagAppender<Block> _toolType, TagsProvider.TagAppender<Block> _harvestLevel) {

            if(this.stairs != null) {
                _toolType.add(this.stairs.get());
                _harvestLevel.add(this.stairs.get());
            }

            if(this.wall != null) {
                _toolType.add(this.wall.get());
                _harvestLevel.add(this.wall.get());
            }

            if(this.slab != null) {
                _toolType.add(this.slab.get());
                _harvestLevel.add(this.slab.get());
            }
        }

        public void registerStonecutterRecipes(Consumer<FinishedRecipe> _recipeConsumer) {

            if(this.stairs != null)
                StonecutterRecipeProvider.stonecutterRecipe(_recipeConsumer, this.stairs.get(), this.source);

            if(this.slab != null)
                StonecutterRecipeProvider.stonecutterRecipe(_recipeConsumer, this.slab.get(), this.source, 2);

            if(this.wall != null)
                StonecutterRecipeProvider.stonecutterRecipe(_recipeConsumer, this.wall.get(), this.source);

            if(this.pillar != null)
                StonecutterRecipeProvider.stonecutterRecipe(_recipeConsumer, this.pillar.get(), this.source);
        }

        public void registerShapedRecipes(Consumer<FinishedRecipe> _recipeConsumer) {

            if(this.stairs != null)
                StandardRecipeProvider.stairsRecipe(_recipeConsumer, this.stairs.get(), this.source);

            if(this.slab != null)
                StandardRecipeProvider.slabRecipe(_recipeConsumer, this.slab.get(), this.source);

            if(this.wall != null)
                StandardRecipeProvider.wallRecipe(_recipeConsumer, this.wall.get(), this.source);

            if(this.pillar != null)
                StandardRecipeProvider.columnRecipe(_recipeConsumer, this.pillar.get(), this.source);
        }

        public void registerBlockDrops(BlockLoot _blockLoot) {

            if(this.stairs != null)
                _blockLoot.dropSelf(this.stairs.get());

            if(this.slab != null)
                _blockLoot.dropSelf(this.slab.get());

            if(this.wall != null)
                _blockLoot.dropSelf(this.wall.get());
        }
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoBuildingBlocks.MODID);
    public static final List<MultiRegistryObject> MULTI_REGISTRY_OBJECTS = new ArrayList<>();
    public static final List<RegistryObject<LayerBlock>> LAYER_BLOCKS = new ArrayList<>();
    public static final List<RegistryObject<PillarBlock>> PILLAR_BLOCKS = new ArrayList<>();
    public static final List<RegistryObject<ButtonBlock>> BUTTON_BLOCKS = new ArrayList<>();

    public static final MultiRegistryObject CALCITE = registerObject("calcite", net.minecraft.world.level.block.Blocks.CALCITE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject AMETHYST = registerObject("amethyst", net.minecraft.world.level.block.Blocks.AMETHYST_BLOCK, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject DEEPSLATE = registerObject("deepslate", net.minecraft.world.level.block.Blocks.DEEPSLATE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject GILDED_BLACKSTONE = registerObject("gilded_blackstone", net.minecraft.world.level.block.Blocks.GILDED_BLACKSTONE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject CRACKED_POLISHED_BLACKSTONE_BRICKS = registerObject("cracked_polished_blackstone_bricks", net.minecraft.world.level.block.Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject TUFF = registerObject("tuff", net.minecraft.world.level.block.Blocks.TUFF, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject SMOOTH_BASALT = registerObject("smooth_basalt", net.minecraft.world.level.block.Blocks.SMOOTH_BASALT, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject SMOOTH_STONE = registerObject("smooth_stone", net.minecraft.world.level.block.Blocks.SMOOTH_STONE, true, false, true, true, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject CRACKED_STONE_BRICKS = registerObject("cracked_stone_bricks", net.minecraft.world.level.block.Blocks.CRACKED_STONE_BRICKS, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);

    public static final MultiRegistryObject WHITE_CONCRETE = registerObject("white_concrete", net.minecraft.world.level.block.Blocks.WHITE_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject ORANGE_CONCRETE = registerObject("orange_concrete", net.minecraft.world.level.block.Blocks.ORANGE_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject MAGENTA_CONCRETE = registerObject("magenta_concrete", net.minecraft.world.level.block.Blocks.MAGENTA_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject LIGHT_BLUE_CONCRETE = registerObject("light_blue_concrete", net.minecraft.world.level.block.Blocks.LIGHT_BLUE_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject YELLOW_CONCRETE = registerObject("yellow_concrete", net.minecraft.world.level.block.Blocks.YELLOW_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject LIME_CONCRETE = registerObject("lime_concrete", net.minecraft.world.level.block.Blocks.LIME_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject PINK_CONCRETE = registerObject("pink_concrete", net.minecraft.world.level.block.Blocks.PINK_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject GRAY_CONCRETE = registerObject("gray_concrete", net.minecraft.world.level.block.Blocks.GRAY_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject LIGHT_GRAY_CONCRETE = registerObject("light_gray_concrete", net.minecraft.world.level.block.Blocks.LIGHT_GRAY_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject CYAN_CONCRETE = registerObject("cyan_concrete", net.minecraft.world.level.block.Blocks.CYAN_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject PURPLE_CONCRETE = registerObject("purple_concrete", net.minecraft.world.level.block.Blocks.PURPLE_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject BLUE_CONCRETE = registerObject("blue_concrete", net.minecraft.world.level.block.Blocks.BLUE_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject BROWN_CONCRETE = registerObject("brown_concrete", net.minecraft.world.level.block.Blocks.BROWN_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject GREEN_CONCRETE = registerObject("green_concrete", net.minecraft.world.level.block.Blocks.GREEN_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject RED_CONCRETE = registerObject("red_concrete", net.minecraft.world.level.block.Blocks.RED_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject BLACK_CONCRETE = registerObject("black_concrete", net.minecraft.world.level.block.Blocks.BLACK_CONCRETE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);

    public static final MultiRegistryObject WHITE_TERRACOTTA = registerObject("white_terracotta", net.minecraft.world.level.block.Blocks.WHITE_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject ORANGE_TERRACOTTA = registerObject("orange_terracotta", net.minecraft.world.level.block.Blocks.ORANGE_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject MAGENTA_TERRACOTTA = registerObject("magenta_terracotta", net.minecraft.world.level.block.Blocks.MAGENTA_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject LIGHT_BLUE_TERRACOTTA = registerObject("light_blue_terracotta", net.minecraft.world.level.block.Blocks.LIGHT_BLUE_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject YELLOW_TERRACOTTA = registerObject("yellow_terracotta", net.minecraft.world.level.block.Blocks.YELLOW_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject LIME_TERRACOTTA = registerObject("lime_terracotta", net.minecraft.world.level.block.Blocks.LIME_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject PINK_TERRACOTTA = registerObject("pink_terracotta", net.minecraft.world.level.block.Blocks.PINK_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject GRAY_TERRACOTTA = registerObject("gray_terracotta", net.minecraft.world.level.block.Blocks.GRAY_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject LIGHT_GRAY_TERRACOTTA = registerObject("light_gray_terracotta", net.minecraft.world.level.block.Blocks.LIGHT_GRAY_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject CYAN_TERRACOTTA = registerObject("cyan_terracotta", net.minecraft.world.level.block.Blocks.CYAN_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject PURPLE_TERRACOTTA = registerObject("purple_terracotta", net.minecraft.world.level.block.Blocks.PURPLE_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject BLUE_TERRACOTTA = registerObject("blue_terracotta", net.minecraft.world.level.block.Blocks.BLUE_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject BROWN_TERRACOTTA = registerObject("brown_terracotta", net.minecraft.world.level.block.Blocks.BROWN_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject GREEN_TERRACOTTA = registerObject("green_terracotta", net.minecraft.world.level.block.Blocks.GREEN_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject RED_TERRACOTTA = registerObject("red_terracotta", net.minecraft.world.level.block.Blocks.RED_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final MultiRegistryObject BLACK_TERRACOTTA = registerObject("black_terracotta", net.minecraft.world.level.block.Blocks.BLACK_TERRACOTTA, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);

    public static final RegistryObject<LayerBlock> SAND_LAYER = registerLayer("sand_layer", net.minecraft.world.level.block.Blocks.SAND, BlockTags.MINEABLE_WITH_SHOVEL);
    public static final RegistryObject<LayerBlock> DIRT_LAYER = registerLayer("dirt_layer", net.minecraft.world.level.block.Blocks.DIRT, BlockTags.MINEABLE_WITH_SHOVEL);
    public static final RegistryObject<LayerBlock> GRAVEL_LAYER = registerLayer("gravel_layer", net.minecraft.world.level.block.Blocks.GRAVEL, BlockTags.MINEABLE_WITH_SHOVEL);
    public static final RegistryObject<LayerBlock> COARSE_DIRT_LAYER = registerLayer("coarse_dirt_layer", net.minecraft.world.level.block.Blocks.COARSE_DIRT, BlockTags.MINEABLE_WITH_SHOVEL);
    public static final RegistryObject<LayerBlock> MOSS_BLOCK_LAYER = registerLayer("moss_block_layer", net.minecraft.world.level.block.Blocks.MOSS_BLOCK, BlockTags.MINEABLE_WITH_HOE);
    public static final RegistryObject<LayerBlock> OAK_LEAVES_LAYER = registerLayer("oak_leaves_layer", net.minecraft.world.level.block.Blocks.OAK_LEAVES, BlockTags.MINEABLE_WITH_HOE);
    public static final RegistryObject<LayerBlock> BIRCH_LEAVES_LAYER = registerLayer("birch_leaves_layer", net.minecraft.world.level.block.Blocks.BIRCH_LEAVES, BlockTags.MINEABLE_WITH_HOE);
    public static final RegistryObject<LayerBlock> SPRUCE_LEAVES_LAYER = registerLayer("spruce_leaves_layer", net.minecraft.world.level.block.Blocks.SPRUCE_LEAVES, BlockTags.MINEABLE_WITH_HOE);
    public static final RegistryObject<LayerBlock> JUNGLE_LEAVES_LAYER = registerLayer("jungle_leaves_layer", net.minecraft.world.level.block.Blocks.JUNGLE_LEAVES, BlockTags.MINEABLE_WITH_HOE);
    public static final RegistryObject<LayerBlock> DARK_OAK_LEAVES_LAYER = registerLayer("dark_oak_leaves_layer", net.minecraft.world.level.block.Blocks.DARK_OAK_LEAVES, BlockTags.MINEABLE_WITH_HOE);
    public static final RegistryObject<LayerBlock> ACACIA_LEAVES_LAYER = registerLayer("acacia_leaves_layer", net.minecraft.world.level.block.Blocks.ACACIA_LEAVES, BlockTags.MINEABLE_WITH_HOE);

    public static final RegistryObject<PillarBlock> STONE_PILLAR = registerPillar("stone_pillar", net.minecraft.world.level.block.Blocks.STONE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> COBBLED_DEEPSLATE_PILLAR = registerPillar("cobbled_deepslate_pillar", net.minecraft.world.level.block.Blocks.COBBLED_DEEPSLATE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> POLISHED_DEEPSLATE_PILLAR = registerPillar("polished_deepslate_pillar", net.minecraft.world.level.block.Blocks.POLISHED_DEEPSLATE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> DEEPSLATE_BRICKS_PILLAR = registerPillar("deepslate_bricks_pillar", net.minecraft.world.level.block.Blocks.DEEPSLATE_BRICKS, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> DEEPSLATE_TILES_PILLAR = registerPillar("deepslate_tiles_pillar", net.minecraft.world.level.block.Blocks.DEEPSLATE_TILES, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> BLACKSTONE = registerPillar("blackstone_pillar", net.minecraft.world.level.block.Blocks.BLACKSTONE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> POLISHED_BLACKSTONE_PILLAR = registerPillar("polished_blackstone_pillar", net.minecraft.world.level.block.Blocks.POLISHED_BLACKSTONE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> POLISHED_BLACKSTONE_BRICKS_PILLAR = registerPillar("polished_blackstone_bricks_pillar", net.minecraft.world.level.block.Blocks.POLISHED_BLACKSTONE_BRICKS, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> COBBLESTONE_PILLAR = registerPillar("cobblestone_pillar", net.minecraft.world.level.block.Blocks.COBBLESTONE, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> STONE_BRICKS_PILLAR = registerPillar("stone_bricks_pillar", net.minecraft.world.level.block.Blocks.STONE_BRICKS, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> MOSSY_STONE_BRICKS_PILLAR = registerPillar("mossy_stone_bricks_pillar", net.minecraft.world.level.block.Blocks.MOSSY_STONE_BRICKS, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> QUARTZ_BRICKS_PILLAR = registerPillar("quartz_bricks_pillar", net.minecraft.world.level.block.Blocks.QUARTZ_BRICKS, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL);
    public static final RegistryObject<PillarBlock> OBSIDIAN_PILLAR = registerPillar("obsidian_pillar", net.minecraft.world.level.block.Blocks.OBSIDIAN, BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_DIAMOND_TOOL);
    public static final RegistryObject<PillarBlock> OAK_PLANKS = registerPillar("oak_planks_pillar", net.minecraft.world.level.block.Blocks.OAK_PLANKS, BlockTags.MINEABLE_WITH_AXE);
    public static final RegistryObject<PillarBlock> BIRCH_PLANKS = registerPillar("birch_planks_pillar", net.minecraft.world.level.block.Blocks.BIRCH_PLANKS, BlockTags.MINEABLE_WITH_AXE);
    public static final RegistryObject<PillarBlock> SPRUCE_PLANKS = registerPillar("spruce_planks_pillar", net.minecraft.world.level.block.Blocks.SPRUCE_PLANKS, BlockTags.MINEABLE_WITH_AXE);
    public static final RegistryObject<PillarBlock> JUNGLE_PLANKS = registerPillar("jungle_planks_pillar", net.minecraft.world.level.block.Blocks.JUNGLE_PLANKS, BlockTags.MINEABLE_WITH_AXE);
    public static final RegistryObject<PillarBlock> DARK_OAK_PLANKS = registerPillar("dark_oak_planks_pillar", net.minecraft.world.level.block.Blocks.DARK_OAK_PLANKS, BlockTags.MINEABLE_WITH_AXE);
    public static final RegistryObject<PillarBlock> ACACIA_PLANKS = registerPillar("acacia_planks_pillar", net.minecraft.world.level.block.Blocks.ACACIA_PLANKS, BlockTags.MINEABLE_WITH_AXE);

    public static final RegistryObject<ButtonBlock> COPPER_BUTTON = registerButton("copper_button", net.minecraft.world.level.block.Blocks.COPPER_BLOCK, Items.COPPER_INGOT, BlockTags.MINEABLE_WITH_PICKAXE);

    @SafeVarargs
    private static RegistryObject<ButtonBlock> registerButton(String _name, Block _block, ItemLike _ingredient, Tag.Named<Block>... _tags) {

        RegistryObject<ButtonBlock> buttonBlock = BLOCKS.register(_name, () -> new ButtonBlock(_block, _ingredient, _tags));
        BUTTON_BLOCKS.add(buttonBlock);

        return buttonBlock;
    }

    @SafeVarargs
    private static RegistryObject<PillarBlock> registerPillar(String _name, Block _block, Tag.Named<Block>... _tags) {

        RegistryObject<PillarBlock> pillarBlock = BLOCKS.register(_name, () -> new PillarBlock(_block, _tags));
        PILLAR_BLOCKS.add(pillarBlock);

        return pillarBlock;
    }

    @SafeVarargs
    private static RegistryObject<LayerBlock> registerLayer(String _name, Block _block, Tag.Named<Block>... _tags) {

        RegistryObject<LayerBlock> layerBlock = BLOCKS.register(_name, () -> new LayerBlock(_block, _tags));
        LAYER_BLOCKS.add(layerBlock);

        return layerBlock;
    }

    @SafeVarargs
    private static MultiRegistryObject registerObject(String _name, Block _block, Tag.Named<Block>... _tags) {

        return registerObject(_name, _block, true, true, true, true, _tags);
    }

    @SafeVarargs
    private static MultiRegistryObject registerObject(String _name, Block _block, boolean _stairs, boolean _slab, boolean _wall, boolean _pillar, Tag.Named<Block>... _tags) {

        RegistryObject<Block> stairs = null;
        RegistryObject<Block> slab = null;
        RegistryObject<Block> wall = null;
        RegistryObject<PillarBlock> pillar = null;

        if(_stairs)
            stairs = BLOCKS.register(_name + "_stairs", () -> new StairBlock(_block, _tags));

        if(_slab)
            slab = BLOCKS.register(_name + "_slab", () -> new SlabBlock(_block, _tags));

        if(_wall)
            wall = BLOCKS.register(_name + "_wall", () -> new WallBlock(_block, _tags));

        if(_pillar) {
            pillar = BLOCKS.register(_name + "_column", () -> new PillarBlock(_block, _tags));
            PILLAR_BLOCKS.add(pillar);
        }

        MultiRegistryObject multiRegistryObject = new MultiRegistryObject(_block, stairs, slab, wall, pillar);
        MULTI_REGISTRY_OBJECTS.add(multiRegistryObject);

        return multiRegistryObject;
    }

    public static void registerTags(TagsProvider.TagAppender<Block> _stairsTag, TagsProvider.TagAppender<Block> _wallTag) {

        for(MultiRegistryObject object : MULTI_REGISTRY_OBJECTS) {

            object.registerTags(_stairsTag, _wallTag);
        }
    }

    public static void registerPillarTags(TagsProvider.TagAppender<Block> _pillarTag) {

        for(RegistryObject<PillarBlock> object : PILLAR_BLOCKS) {

            _pillarTag.add(object.get());
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

        for(RegistryObject<PillarBlock> registryObject : PILLAR_BLOCKS) {

            PillarBlock block = registryObject.get();
            _loot.dropSelf(block);
        }

        for(RegistryObject<ButtonBlock> registryObject : BUTTON_BLOCKS) {

            ButtonBlock block = registryObject.get();
            _loot.dropSelf(block);
        }
    }

    @ParametersAreNonnullByDefault
    public static void registerStandardRecipes(Consumer<FinishedRecipe> _recipeConsumer) {

        for(MultiRegistryObject object : MULTI_REGISTRY_OBJECTS) {

            object.registerShapedRecipes(_recipeConsumer);
        }

        for(RegistryObject<LayerBlock> registryObject : LAYER_BLOCKS) {

            StandardRecipeProvider.layerRecipe(_recipeConsumer, registryObject.get(), registryObject.get().source());
        }

        for(RegistryObject<ButtonBlock> registryObject : BUTTON_BLOCKS) {

            StandardRecipeProvider.buttonRecipe(_recipeConsumer, registryObject.get(), registryObject.get().ingredient());
        }
    }

    @ParametersAreNonnullByDefault
    public static void registerStonecutterRecipes(Consumer<FinishedRecipe> _recipeConsumer) {

        for(MultiRegistryObject object : MULTI_REGISTRY_OBJECTS) {

            object.registerStonecutterRecipes(_recipeConsumer);
        }
    }
}
