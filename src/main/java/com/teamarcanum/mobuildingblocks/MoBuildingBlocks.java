package com.teamarcanum.mobuildingblocks;

import com.teamarcanum.mobuildingblocks.client.ClientProxy;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MoBuildingBlocks implements ModInitializer {

    public static final Logger LOG = LogManager.getLogger();
    public static final String MODID = "mobuildingblocks";
    public static MoBuildingBlocks INSTANCE;

    @Override
    public void onInitialize() {
        INSTANCE = this;

        Blocks.register();
        ClientProxy.load();
    }

    public static Identifier rl(String _id) {
        return new Identifier(MODID, _id);
    }
}
