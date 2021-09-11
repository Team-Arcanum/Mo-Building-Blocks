package com.teamarcanum.mobuildingblocks.data;

import com.google.common.collect.ImmutableList;
import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootTableProvider extends net.minecraft.data.loot.LootTableProvider {

    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation,LootTable.Builder>>>,LootContextParamSet>> subProviders = ImmutableList.of(Pair.of(BlockLoot::new, LootContextParamSets.BLOCK));

    public LootTableProvider(DataGenerator _generator) {

        super(_generator);
    }

    @Nonnull
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation,LootTable.Builder>>>,LootContextParamSet>> getTables() {

        return this.subProviders;
    }

    @Nonnull
    @Override
    public String getName() {

        return MoBuildingBlocks.MODID + ": LootTables";
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {

    }
}
