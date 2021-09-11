package com.teamarcanum.mobuildingblocks.data;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.block.LayerBlock;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class BlockLoot implements Consumer<BiConsumer<ResourceLocation,LootTable.Builder>> {

    private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(net.minecraft.world.level.block.Blocks.DRAGON_EGG, net.minecraft.world.level.block.Blocks.BEACON, net.minecraft.world.level.block.Blocks.CONDUIT, net.minecraft.world.level.block.Blocks.SKELETON_SKULL, net.minecraft.world.level.block.Blocks.WITHER_SKELETON_SKULL, net.minecraft.world.level.block.Blocks.PLAYER_HEAD, net.minecraft.world.level.block.Blocks.ZOMBIE_HEAD, net.minecraft.world.level.block.Blocks.CREEPER_HEAD, net.minecraft.world.level.block.Blocks.DRAGON_HEAD, net.minecraft.world.level.block.Blocks.SHULKER_BOX, net.minecraft.world.level.block.Blocks.BLACK_SHULKER_BOX, net.minecraft.world.level.block.Blocks.BLUE_SHULKER_BOX, net.minecraft.world.level.block.Blocks.BROWN_SHULKER_BOX, net.minecraft.world.level.block.Blocks.CYAN_SHULKER_BOX, net.minecraft.world.level.block.Blocks.GRAY_SHULKER_BOX, net.minecraft.world.level.block.Blocks.GREEN_SHULKER_BOX, net.minecraft.world.level.block.Blocks.LIGHT_BLUE_SHULKER_BOX, net.minecraft.world.level.block.Blocks.LIGHT_GRAY_SHULKER_BOX, net.minecraft.world.level.block.Blocks.LIME_SHULKER_BOX, net.minecraft.world.level.block.Blocks.MAGENTA_SHULKER_BOX, net.minecraft.world.level.block.Blocks.ORANGE_SHULKER_BOX, net.minecraft.world.level.block.Blocks.PINK_SHULKER_BOX, net.minecraft.world.level.block.Blocks.PURPLE_SHULKER_BOX, net.minecraft.world.level.block.Blocks.RED_SHULKER_BOX, net.minecraft.world.level.block.Blocks.WHITE_SHULKER_BOX, net.minecraft.world.level.block.Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(ImmutableSet.toImmutableSet());
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    private final Map<ResourceLocation,LootTable.Builder> map = Maps.newHashMap();

    protected void addTables() {

        Blocks.registerLoot(this);
    }

    public void dropOther(Block _block, ItemLike _output) {

        this.add(_block, createSingleItemTable(_output));
    }

    public void dropSelf(Block _block) {
        this.dropOther(_block, _block);
    }
    
    public void layerBlock(LayerBlock _layerBlock) {
        
        this.add(_layerBlock, (_block) -> LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS)).add(AlternativesEntry.alternatives(AlternativesEntry.alternatives(LootItem.lootTableItem(_block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 1))), LootItem.lootTableItem(_block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 2))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))), LootItem.lootTableItem(_block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 3))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))), LootItem.lootTableItem(_block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 4))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))), LootItem.lootTableItem(_block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 5))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0F))), LootItem.lootTableItem(_block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 6))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))), LootItem.lootTableItem(_block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 7))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0F))), LootItem.lootTableItem(_block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(8.0F)))).when(HAS_NO_SILK_TOUCH), AlternativesEntry.alternatives(LootItem.lootTableItem(_layerBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 1))), LootItem.lootTableItem(_layerBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 2))), LootItem.lootTableItem(_layerBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 3))), LootItem.lootTableItem(_layerBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 4))), LootItem.lootTableItem(_layerBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 5))), LootItem.lootTableItem(_layerBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 6))), LootItem.lootTableItem(_layerBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(_block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 7))), LootItem.lootTableItem(_layerBlock.getSource()))))));
    }
    
    protected void add(Block _block, Function<Block, LootTable.Builder> _function) {
        
        this.add(_block, _function.apply(_block));
    }

    protected void add(Block _block, LootTable.Builder _builder) {

        this.map.put(_block.getLootTable(), _builder);
    }

    protected Iterable<Block> getKnownBlocks() {
        return Registry.BLOCK;
    }

    public void accept(BiConsumer<ResourceLocation,LootTable.Builder> _builder) {

        this.addTables();
        Set<ResourceLocation> set = Sets.newHashSet();

        for(Block block : getKnownBlocks()) {

            if(!Objects.requireNonNull(block.getRegistryName()).getNamespace().equals(MoBuildingBlocks.MODID)) {

                continue;
            }

            ResourceLocation resourcelocation = block.getLootTable();
            if(resourcelocation != BuiltInLootTables.EMPTY && set.add(resourcelocation)) {

                LootTable.Builder loottable$builder = this.map.remove(resourcelocation);

                if(loottable$builder == null) {
                    throw new IllegalStateException(String.format("Missing loottable '%s' for '%s'", resourcelocation, Registry.BLOCK.getKey(block)));
                }

                _builder.accept(resourcelocation, loottable$builder);
            }
        }

        if(!this.map.isEmpty()) {

            throw new IllegalStateException("Created block loot tables for non-blocks: " + this.map.keySet());
        }
    }

    protected static LootTable.Builder createSingleItemTable(ItemLike _block) {

        return LootTable.lootTable().withPool(applyExplosionCondition(_block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(_block))));
    }

    protected static <T> T applyExplosionCondition(ItemLike _block, ConditionUserBuilder<T> _builder) {

        return (T) (!EXPLOSION_RESISTANT.contains(_block.asItem()) ? _builder.when(ExplosionCondition.survivesExplosion()) : _builder.unwrap());
    }
}
