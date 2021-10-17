package com.teamarcanum.mobuildingblocks.common.registry;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.client.MoBuildingBlocksCreativeTab;
import com.teamarcanum.mobuildingblocks.common.block.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"SameParameterValue", "unused"})
public class Blocks {

    public static class MultiRegistryObject {
        public final StairBlock stairs;
        public final SlabBlock slab;
        public final WallBlock wall;
        public final PillarBlock pillar;

        public MultiRegistryObject(StairBlock _stairs, SlabBlock _slab, WallBlock _wall, PillarBlock _pillar) {
            this.stairs = _stairs;
            this.slab = _slab;
            this.wall = _wall;
            this.pillar = _pillar;
        }

        public void register() {
            if(stairs != null)
                register(stairs, stairs);

            if(slab != null)
                register(slab, slab);

            if(wall != null)
                register(wall, wall);
        }

        private void register(IIdentifierProvider _provider, Block _block) {
            Registry.register(Registry.BLOCK, _provider.id(), _block);
            Registry.register(Registry.ITEM, _provider.id(), new BlockItem(_block, new FabricItemSettings().group(MoBuildingBlocksCreativeTab.INSTANCE)));
        }
    }

    public static final List<MultiRegistryObject> MULTI_REGISTRY_OBJECTS = new ArrayList<>();
    public static final List<LayerBlock> LAYER_BLOCKS = new ArrayList<>();
    public static final List<PillarBlock> PILLAR_BLOCKS = new ArrayList<>();
    public static final List<ButtonBlock> BUTTON_BLOCKS = new ArrayList<>();

    public static final MultiRegistryObject CALCITE = registerObject("calcite", net.minecraft.block.Blocks.CALCITE);
    public static final MultiRegistryObject AMETHYST = registerObject("amethyst", net.minecraft.block.Blocks.AMETHYST_BLOCK);
    public static final MultiRegistryObject DEEPSLATE = registerObject("deepslate", net.minecraft.block.Blocks.DEEPSLATE);
    public static final MultiRegistryObject GILDED_BLACKSTONE = registerObject("gilded_blackstone", net.minecraft.block.Blocks.GILDED_BLACKSTONE);
    public static final MultiRegistryObject CRACKED_POLISHED_BLACKSTONE_BRICKS = registerObject("cracked_polished_blackstone_bricks", net.minecraft.block.Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
    public static final MultiRegistryObject TUFF = registerObject("tuff", net.minecraft.block.Blocks.TUFF);
    public static final MultiRegistryObject SMOOTH_BASALT = registerObject("smooth_basalt", net.minecraft.block.Blocks.SMOOTH_BASALT);
    public static final MultiRegistryObject SMOOTH_STONE = registerObject("smooth_stone", net.minecraft.block.Blocks.SMOOTH_STONE, true, false, true, true);
    public static final MultiRegistryObject CRACKED_STONE_BRICKS = registerObject("cracked_stone_bricks", net.minecraft.block.Blocks.CRACKED_STONE_BRICKS);

    public static final MultiRegistryObject WHITE_CONCRETE = registerObject("white_concrete", net.minecraft.block.Blocks.WHITE_CONCRETE);
    public static final MultiRegistryObject ORANGE_CONCRETE = registerObject("orange_concrete", net.minecraft.block.Blocks.ORANGE_CONCRETE);
    public static final MultiRegistryObject MAGENTA_CONCRETE = registerObject("magenta_concrete", net.minecraft.block.Blocks.MAGENTA_CONCRETE);
    public static final MultiRegistryObject LIGHT_BLUE_CONCRETE = registerObject("light_blue_concrete", net.minecraft.block.Blocks.LIGHT_BLUE_CONCRETE);
    public static final MultiRegistryObject YELLOW_CONCRETE = registerObject("yellow_concrete", net.minecraft.block.Blocks.YELLOW_CONCRETE);
    public static final MultiRegistryObject LIME_CONCRETE = registerObject("lime_concrete", net.minecraft.block.Blocks.LIME_CONCRETE);
    public static final MultiRegistryObject PINK_CONCRETE = registerObject("pink_concrete", net.minecraft.block.Blocks.PINK_CONCRETE);
    public static final MultiRegistryObject GRAY_CONCRETE = registerObject("gray_concrete", net.minecraft.block.Blocks.GRAY_CONCRETE);
    public static final MultiRegistryObject LIGHT_GRAY_CONCRETE = registerObject("light_gray_concrete", net.minecraft.block.Blocks.LIGHT_GRAY_CONCRETE);
    public static final MultiRegistryObject CYAN_CONCRETE = registerObject("cyan_concrete", net.minecraft.block.Blocks.CYAN_CONCRETE);
    public static final MultiRegistryObject PURPLE_CONCRETE = registerObject("purple_concrete", net.minecraft.block.Blocks.PURPLE_CONCRETE);
    public static final MultiRegistryObject BLUE_CONCRETE = registerObject("blue_concrete", net.minecraft.block.Blocks.BLUE_CONCRETE);
    public static final MultiRegistryObject BROWN_CONCRETE = registerObject("brown_concrete", net.minecraft.block.Blocks.BROWN_CONCRETE);
    public static final MultiRegistryObject GREEN_CONCRETE = registerObject("green_concrete", net.minecraft.block.Blocks.GREEN_CONCRETE);
    public static final MultiRegistryObject RED_CONCRETE = registerObject("red_concrete", net.minecraft.block.Blocks.RED_CONCRETE);
    public static final MultiRegistryObject BLACK_CONCRETE = registerObject("black_concrete", net.minecraft.block.Blocks.BLACK_CONCRETE);

    public static final MultiRegistryObject WHITE_TERRACOTTA = registerObject("white_terracotta", net.minecraft.block.Blocks.WHITE_TERRACOTTA);
    public static final MultiRegistryObject ORANGE_TERRACOTTA = registerObject("orange_terracotta", net.minecraft.block.Blocks.ORANGE_TERRACOTTA);
    public static final MultiRegistryObject MAGENTA_TERRACOTTA = registerObject("magenta_terracotta", net.minecraft.block.Blocks.MAGENTA_TERRACOTTA);
    public static final MultiRegistryObject LIGHT_BLUE_TERRACOTTA = registerObject("light_blue_terracotta", net.minecraft.block.Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final MultiRegistryObject YELLOW_TERRACOTTA = registerObject("yellow_terracotta", net.minecraft.block.Blocks.YELLOW_TERRACOTTA);
    public static final MultiRegistryObject LIME_TERRACOTTA = registerObject("lime_terracotta", net.minecraft.block.Blocks.LIME_TERRACOTTA);
    public static final MultiRegistryObject PINK_TERRACOTTA = registerObject("pink_terracotta", net.minecraft.block.Blocks.PINK_TERRACOTTA);
    public static final MultiRegistryObject GRAY_TERRACOTTA = registerObject("gray_terracotta", net.minecraft.block.Blocks.GRAY_TERRACOTTA);
    public static final MultiRegistryObject LIGHT_GRAY_TERRACOTTA = registerObject("light_gray_terracotta", net.minecraft.block.Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final MultiRegistryObject CYAN_TERRACOTTA = registerObject("cyan_terracotta", net.minecraft.block.Blocks.CYAN_TERRACOTTA);
    public static final MultiRegistryObject PURPLE_TERRACOTTA = registerObject("purple_terracotta", net.minecraft.block.Blocks.PURPLE_TERRACOTTA);
    public static final MultiRegistryObject BLUE_TERRACOTTA = registerObject("blue_terracotta", net.minecraft.block.Blocks.BLUE_TERRACOTTA);
    public static final MultiRegistryObject BROWN_TERRACOTTA = registerObject("brown_terracotta", net.minecraft.block.Blocks.BROWN_TERRACOTTA);
    public static final MultiRegistryObject GREEN_TERRACOTTA = registerObject("green_terracotta", net.minecraft.block.Blocks.GREEN_TERRACOTTA);
    public static final MultiRegistryObject RED_TERRACOTTA = registerObject("red_terracotta", net.minecraft.block.Blocks.RED_TERRACOTTA);
    public static final MultiRegistryObject BLACK_TERRACOTTA = registerObject("black_terracotta", net.minecraft.block.Blocks.BLACK_TERRACOTTA);

    public static final LayerBlock SAND_LAYER = registerLayer("sand_layer", net.minecraft.block.Blocks.SAND);
    public static final LayerBlock DIRT_LAYER = registerLayer("dirt_layer", net.minecraft.block.Blocks.DIRT);
    public static final LayerBlock GRAVEL_LAYER = registerLayer("gravel_layer", net.minecraft.block.Blocks.GRAVEL);
    public static final LayerBlock COARSE_DIRT_LAYER = registerLayer("coarse_dirt_layer", net.minecraft.block.Blocks.COARSE_DIRT);
    public static final LayerBlock MOSS_BLOCK_LAYER = registerLayer("moss_block_layer", net.minecraft.block.Blocks.MOSS_BLOCK);
    public static final LayerBlock OAK_LEAVES_LAYER = registerLayer("oak_leaves_layer", net.minecraft.block.Blocks.OAK_LEAVES);
    public static final LayerBlock BIRCH_LEAVES_LAYER = registerLayer("birch_leaves_layer", net.minecraft.block.Blocks.BIRCH_LEAVES);
    public static final LayerBlock SPRUCE_LEAVES_LAYER = registerLayer("spruce_leaves_layer", net.minecraft.block.Blocks.SPRUCE_LEAVES);
    public static final LayerBlock JUNGLE_LEAVES_LAYER = registerLayer("jungle_leaves_layer", net.minecraft.block.Blocks.JUNGLE_LEAVES);
    public static final LayerBlock DARK_OAK_LEAVES_LAYER = registerLayer("dark_oak_leaves_layer", net.minecraft.block.Blocks.DARK_OAK_LEAVES);
    public static final LayerBlock ACACIA_LEAVES_LAYER = registerLayer("acacia_leaves_layer", net.minecraft.block.Blocks.ACACIA_LEAVES);

    public static final PillarBlock STONE_PILLAR = registerPillar("stone_pillar", net.minecraft.block.Blocks.STONE);
    public static final PillarBlock COBBLED_DEEPSLATE_PILLAR = registerPillar("cobbled_deepslate_pillar", net.minecraft.block.Blocks.COBBLED_DEEPSLATE);
    public static final PillarBlock POLISHED_DEEPSLATE_PILLAR = registerPillar("polished_deepslate_pillar", net.minecraft.block.Blocks.POLISHED_DEEPSLATE);
    public static final PillarBlock DEEPSLATE_BRICKS_PILLAR = registerPillar("deepslate_bricks_pillar", net.minecraft.block.Blocks.DEEPSLATE_BRICKS);
    public static final PillarBlock DEEPSLATE_TILES_PILLAR = registerPillar("deepslate_tiles_pillar", net.minecraft.block.Blocks.DEEPSLATE_TILES);
    public static final PillarBlock BLACKSTONE = registerPillar("blackstone_pillar", net.minecraft.block.Blocks.BLACKSTONE);
    public static final PillarBlock POLISHED_BLACKSTONE_PILLAR = registerPillar("polished_blackstone_pillar", net.minecraft.block.Blocks.POLISHED_BLACKSTONE);
    public static final PillarBlock POLISHED_BLACKSTONE_BRICKS_PILLAR = registerPillar("polished_blackstone_bricks_pillar", net.minecraft.block.Blocks.POLISHED_BLACKSTONE_BRICKS);
    public static final PillarBlock COBBLESTONE_PILLAR = registerPillar("cobblestone_pillar", net.minecraft.block.Blocks.COBBLESTONE);
    public static final PillarBlock STONE_BRICKS_PILLAR = registerPillar("stone_bricks_pillar", net.minecraft.block.Blocks.STONE_BRICKS);
    public static final PillarBlock MOSSY_STONE_BRICKS_PILLAR = registerPillar("mossy_stone_bricks_pillar", net.minecraft.block.Blocks.MOSSY_STONE_BRICKS);
    public static final PillarBlock QUARTZ_BRICKS_PILLAR = registerPillar("quartz_bricks_pillar", net.minecraft.block.Blocks.QUARTZ_BRICKS);
    public static final PillarBlock OBSIDIAN_PILLAR = registerPillar("obsidian_pillar", net.minecraft.block.Blocks.OBSIDIAN);
    public static final PillarBlock OAK_PLANKS = registerPillar("oak_planks_pillar", net.minecraft.block.Blocks.OAK_PLANKS);
    public static final PillarBlock BIRCH_PLANKS = registerPillar("birch_planks_pillar", net.minecraft.block.Blocks.BIRCH_PLANKS);
    public static final PillarBlock SPRUCE_PLANKS = registerPillar("spruce_planks_pillar", net.minecraft.block.Blocks.SPRUCE_PLANKS);
    public static final PillarBlock JUNGLE_PLANKS = registerPillar("jungle_planks_pillar", net.minecraft.block.Blocks.JUNGLE_PLANKS);
    public static final PillarBlock DARK_OAK_PLANKS = registerPillar("dark_oak_planks_pillar", net.minecraft.block.Blocks.DARK_OAK_PLANKS);
    public static final PillarBlock ACACIA_PLANKS = registerPillar("acacia_planks_pillar", net.minecraft.block.Blocks.ACACIA_PLANKS);

    public static final ButtonBlock COPPER_BUTTON = registerButton("copper_button", net.minecraft.block.Blocks.COPPER_BLOCK);

    private static ButtonBlock registerButton(String _name, Block _block) {
        ButtonBlock buttonBlock = new ButtonBlock(_name, _block);
        BUTTON_BLOCKS.add(buttonBlock);

        return buttonBlock;
    }

    private static PillarBlock registerPillar(String _name, Block _block) {
        PillarBlock pillarBlock = new PillarBlock(_name, _block);
        PILLAR_BLOCKS.add(pillarBlock);

        return pillarBlock;
    }

    private static LayerBlock registerLayer(String _name, Block _block) {
        LayerBlock layerBlock = new LayerBlock(_name, _block);
        LAYER_BLOCKS.add(layerBlock);

        return layerBlock;
    }

    private static MultiRegistryObject registerObject(String _name, Block _block) {
        return registerObject(_name, _block, true, true, true, true);
    }

    private static MultiRegistryObject registerObject(String _name, Block _block, boolean _stairs, boolean _slab, boolean _wall, boolean _pillar) {
        StairBlock stairs = null;
        SlabBlock slab = null;
        WallBlock wall = null;
        PillarBlock pillar = null;

        if(_stairs)
            stairs = new StairBlock(_name + "_stairs", _block);

        if(_slab)
            slab = new SlabBlock(_name + "_slab", _block);

        if(_wall)
            wall = new WallBlock(_name + "_wall", _block);

        if(_pillar) {
            pillar = new PillarBlock(_name + "_column", _block);
            PILLAR_BLOCKS.add(pillar);
        }

        MultiRegistryObject multiRegistryObject = new MultiRegistryObject(stairs, slab, wall, pillar);
        MULTI_REGISTRY_OBJECTS.add(multiRegistryObject);

        return multiRegistryObject;
    }

    public static void register() {
        for(MultiRegistryObject obj : MULTI_REGISTRY_OBJECTS) {
            obj.register();
        }

        for(PillarBlock pillarBlock : PILLAR_BLOCKS) {
            registerBlock(pillarBlock, pillarBlock);
        }

        for(LayerBlock layerBlock : LAYER_BLOCKS) {
            registerBlock(layerBlock, layerBlock);
        }

        for(ButtonBlock buttonBlock : BUTTON_BLOCKS) {
            registerBlock(buttonBlock, buttonBlock);
        }
    }

    private static void registerBlock(IIdentifierProvider _provider, Block _block) {
        Registry.register(Registry.BLOCK, _provider.id(), _block);
        Registry.register(Registry.ITEM, _provider.id(), new BlockItem(_block, new FabricItemSettings().group(MoBuildingBlocksCreativeTab.INSTANCE)));
    }
}
