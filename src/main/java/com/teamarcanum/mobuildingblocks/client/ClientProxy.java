package com.teamarcanum.mobuildingblocks.client;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MoBuildingBlocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy {

    @SubscribeEvent
    public static void setup(final FMLClientSetupEvent event) {

        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        blockColors.register((_state, _tint, _pos, _i) -> FoliageColor.getEvergreenColor(), Blocks.SPRUCE_LEAVES_LAYER.get());
        blockColors.register((_state, _tint, _pos, _i) -> FoliageColor.getBirchColor(), Blocks.BIRCH_LEAVES_LAYER.get());
        blockColors.register((_state, _tint, _pos, _i) -> _tint != null && _pos != null ? BiomeColors.getAverageFoliageColor(_tint, _pos) : FoliageColor.getDefaultColor(), Blocks.OAK_LEAVES_LAYER.get(), Blocks.JUNGLE_LEAVES_LAYER.get(), Blocks.ACACIA_LEAVES_LAYER.get(), Blocks.DARK_OAK_LEAVES_LAYER.get());

        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        itemColors.register((_stack, _i) -> {
            BlockState blockstate = ((BlockItem)_stack.getItem()).getBlock().defaultBlockState();
            return blockColors.getColor(blockstate, null, null, _i);
        }, Blocks.OAK_LEAVES_LAYER.get(), Blocks.BIRCH_LEAVES_LAYER.get(), Blocks.SPRUCE_LEAVES_LAYER.get(), Blocks.JUNGLE_LEAVES_LAYER.get(), Blocks.DARK_OAK_LEAVES_LAYER.get(), Blocks.ACACIA_LEAVES_LAYER.get());

        ItemBlockRenderTypes.setRenderLayer(Blocks.OAK_LEAVES_LAYER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(Blocks.BIRCH_LEAVES_LAYER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(Blocks.SPRUCE_LEAVES_LAYER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(Blocks.JUNGLE_LEAVES_LAYER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(Blocks.DARK_OAK_LEAVES_LAYER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(Blocks.ACACIA_LEAVES_LAYER.get(), RenderType.cutoutMipped());
    }
}
