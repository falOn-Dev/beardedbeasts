package io.github.falon.beardedbeasts.datagen.providers;

import io.github.falon.beardedbeasts.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.Models;

public class ModelProvider extends FabricModelProvider {
	public ModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

	}

	@Override
	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.MUSTARD_GREENS, Models.SINGLE_LAYER_ITEM);
		itemModelGenerator.register(ModItems.MUSTARD_GREENS_BUNDLE, Models.SINGLE_LAYER_ITEM);
	}
}
