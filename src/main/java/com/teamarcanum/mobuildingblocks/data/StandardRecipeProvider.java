package com.teamarcanum.mobuildingblocks.data;

import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class StandardRecipeProvider extends RecipeProvider {

    public StandardRecipeProvider(DataGenerator _generator) {
        super(_generator);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> _recipeConsumer) {

        Blocks.registerStandardRecipes(_recipeConsumer);
    }

    public static void buttonRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, ItemLike _input) {

        ShapelessRecipeBuilder.shapeless(_output).requires(_input)
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input)).save(_recipeConsumer);
    }

    public static void layerRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, ItemLike _input) {

        ShapelessRecipeBuilder.shapeless(_output, 8).requires(_input)
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input)).save(_recipeConsumer);
    }

    public static void stairsRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, Tag<Item> _input) {
        ShapedRecipeBuilder.shaped(_output, 4).define('#', _input).pattern("#  ").pattern("## ").pattern("###")
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input)).save(_recipeConsumer);
    }

    public static void stairsRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, ItemLike _input) {
        ShapedRecipeBuilder.shaped(_output, 4).define('#', _input).pattern("#  ").pattern("## ").pattern("###")
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input)).save(_recipeConsumer);
    }

    public static void slabRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, Tag<Item> _input) {
        ShapedRecipeBuilder.shaped(_output, 6).define('#', _input).pattern("###")
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input)).save(_recipeConsumer);
    }

    public static void slabRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, ItemLike _input) {
        ShapedRecipeBuilder.shaped(_output, 6).define('#', _input).pattern("###")
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input)).save(_recipeConsumer);
    }

    public static void wallRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, Tag<Item> _input) {
        ShapedRecipeBuilder.shaped(_output, 6).define('#', _input).pattern("###").pattern("###")
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input)).save(_recipeConsumer);
    }

    public static void wallRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, ItemLike _input) {
        ShapedRecipeBuilder.shaped(_output, 6).define('#', _input).pattern("###").pattern("###")
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input)).save(_recipeConsumer);
    }

    public static void columnRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, Tag<Item> _input) {
        ShapedRecipeBuilder.shaped(_output, 3).define('#', _input).pattern("#").pattern("#").pattern("#")
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input)).save(_recipeConsumer);
    }

    public static void columnRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, ItemLike _input) {
        ShapedRecipeBuilder.shaped(_output, 3).define('#', _input).pattern("#").pattern("#").pattern("#")
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input)).save(_recipeConsumer);
    }
}
