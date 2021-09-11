package com.teamarcanum.mobuildingblocks.common.events;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.client.MoBuildingBlocksCreativeTab;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = MoBuildingBlocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> _event) {

        final IForgeRegistry<Item> registry = _event.getRegistry();
        Blocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(_block ->
         {
             final Item.Properties properties = new Item.Properties().tab(MoBuildingBlocksCreativeTab.INSTANCE);
             BlockItem blockItem = new BlockItem(_block, properties);
             blockItem.setRegistryName(Objects.requireNonNull(_block.getRegistryName()));
             registry.register(blockItem);
         });
    }
}
