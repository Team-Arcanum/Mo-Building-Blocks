package com.teamarcanum.mobuildingblocks.client;

import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;

public class ClientProxy {

    public static void load() {
        ColorProviderRegistry.BLOCK.register((_state, _tint, _pos, _i) -> FoliageColors.getSpruceColor(), Blocks.SPRUCE_LEAVES_LAYER);
        ColorProviderRegistry.BLOCK.register((_state, _tint, _pos, _i) -> FoliageColors.getBirchColor(), Blocks.BIRCH_LEAVES_LAYER);
        ColorProviderRegistry.BLOCK.register((_state, _tint, _pos, _i) -> _tint != null && _pos != null ? BiomeColors.getFoliageColor(_tint, _pos) : FoliageColors.getDefaultColor(), Blocks.OAK_LEAVES_LAYER, Blocks.JUNGLE_LEAVES_LAYER, Blocks.ACACIA_LEAVES_LAYER, Blocks.DARK_OAK_LEAVES_LAYER);

        ColorProviderRegistry.ITEM.register((_stack, _i) -> {
            BlockColors blockColors = MinecraftClient.getInstance().getBlockColors();
            BlockState blockstate = ((BlockItem)_stack.getItem()).getBlock().getDefaultState();
            return blockColors.getColor(blockstate, null, null, _i);
        }, Blocks.OAK_LEAVES_LAYER, Blocks.BIRCH_LEAVES_LAYER, Blocks.SPRUCE_LEAVES_LAYER, Blocks.JUNGLE_LEAVES_LAYER, Blocks.DARK_OAK_LEAVES_LAYER, Blocks.ACACIA_LEAVES_LAYER);

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.OAK_LEAVES_LAYER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.BIRCH_LEAVES_LAYER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.SPRUCE_LEAVES_LAYER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.JUNGLE_LEAVES_LAYER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DARK_OAK_LEAVES_LAYER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.ACACIA_LEAVES_LAYER, RenderLayer.getCutoutMipped());
    }
}
