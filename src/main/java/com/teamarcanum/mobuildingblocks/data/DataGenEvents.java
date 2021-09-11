package com.teamarcanum.mobuildingblocks.data;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MoBuildingBlocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenEvents {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent _event) {

        DataGenerator generator = _event.getGenerator();

        if(_event.includeClient()) {

            generator.addProvider(new LanguageProvider(generator));
            generator.addProvider(new BlockStateProvider(generator, _event.getExistingFileHelper()));
        }

        if(_event.includeServer()) {

            generator.addProvider(new TagsProvider(generator, Registry.BLOCK, _event.getExistingFileHelper()));
            generator.addProvider(new StandardRecipeProvider(generator));
            generator.addProvider(new StonecutterRecipeProvider(generator));
            generator.addProvider(new LootTableProvider(generator));
        }
    }
}