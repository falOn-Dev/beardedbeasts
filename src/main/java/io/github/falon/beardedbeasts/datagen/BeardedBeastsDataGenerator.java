package io.github.falon.beardedbeasts.datagen;

import io.github.falon.beardedbeasts.datagen.providers.ModelProvider;
import io.github.falon.beardedbeasts.datagen.providers.RecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BeardedBeastsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(RecipeProvider::new);
		pack.addProvider(ModelProvider::new);
	}
}
