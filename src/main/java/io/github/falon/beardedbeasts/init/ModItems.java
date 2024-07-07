package io.github.falon.beardedbeasts.init;

import io.github.falon.beardedbeasts.BeardedBeasts;
import io.github.falon.beardedbeasts.item.HolsterItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import java.util.LinkedHashMap;
import java.util.Map;


public interface ModItems {
	Map<Item, Identifier> items = new LinkedHashMap<>();

	Item MUSTARD_GREENS = makeItem("mustard_greens", new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build())));
	Item MUSTARD_GREENS_BUNDLE = makeItem("mustard_greens_bundle", new Item(new Item.Settings()));
	Item HOLSTER = makeItem("holster", new HolsterItem(new QuiltItemSettings().maxCount(1)));

	private static <T extends Item> T makeItem(String name, T item) {
		items.put(item, new Identifier(BeardedBeasts.MOD_ID, name));
		return item;
	}

	static void initialize() {
		items.keySet().forEach(item -> {
			Registry.register(Registries.ITEM, items.get(item), item);
		});


	}
}
