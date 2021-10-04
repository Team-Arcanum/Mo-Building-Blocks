package com.teamarcanum.mobuildingblocks.data;

import api.teamarcanum.data.RegistryNameUtils;
import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class StonecutterRecipeProvider  extends RecipeProvider {

    public StonecutterRecipeProvider(DataGenerator _generator) {

        super(_generator);
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> _recipeConsumer) {

        Blocks.registerStonecutterRecipes(_recipeConsumer);
    }

    public static void stonecutterRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, ItemLike _input) {

        stonecutterRecipe(_recipeConsumer, _output, _input, 1);
    }

    public static void stonecutterRecipe(Consumer<FinishedRecipe> _recipeConsumer, ItemLike _output, ItemLike _input, int _count) {

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(_input), _output, _count)
                .unlockedBy(RegistryNameUtils.getHasName(_input), has(_input))
                .save(_recipeConsumer, MoBuildingBlocks.MODID + ":" + RegistryNameUtils.getItemName(_output) + "_from_stonecutting");
    }
}
