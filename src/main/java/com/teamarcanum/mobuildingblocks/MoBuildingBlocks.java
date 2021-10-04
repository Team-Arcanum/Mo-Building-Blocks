package com.teamarcanum.mobuildingblocks;

import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import api.teamarcanum.common.utils.Version;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoBuildingBlocks.MODID)
@Mod.EventBusSubscriber(modid = MoBuildingBlocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoBuildingBlocks {

    public static final Logger LOG = LogManager.getLogger();
    public static final String MODID = "mobuildingblocks";
    public static MoBuildingBlocks INSTANCE;

    public final Version version;

    public MoBuildingBlocks() {
        INSTANCE = this;

        version = new Version(ModLoadingContext.get().getActiveContainer().getModInfo().getVersion());

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Blocks.BLOCKS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation rl(String _id) {
        return new ResourceLocation(MODID, _id);
    }
}
