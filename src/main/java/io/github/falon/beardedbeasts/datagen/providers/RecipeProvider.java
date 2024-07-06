package io.github.falon.beardedbeasts.datagen.providers;

import io.github.falon.beardedbeasts.common.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.RecipeCategory;

import java.util.function.Consumer;

public class RecipeProvider extends FabricRecipeProvider {

	public RecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
		offerReversibleCompactingRecipes(
			exporter,
			RecipeCategory.FOOD,
			ModItems.MUSTARD_GREENS,
			RecipeCategory.FOOD,
			ModItems.MUSTARD_GREENS_BUNDLE
		);
	}
}
