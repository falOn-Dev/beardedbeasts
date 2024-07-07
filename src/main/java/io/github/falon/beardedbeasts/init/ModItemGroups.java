package io.github.falon.beardedbeasts.init;

import io.github.falon.beardedbeasts.BeardedBeasts;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public interface ModItemGroups {
	static final ItemGroup HERPETO_CRAFT_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(ModItems.MUSTARD_GREENS))
		.name(Text.translatable("itemGroup.herpeto_craft.beardedbeasts_group"))
		.entries((context, entries) -> {
			ModItems.items.forEach((item, identifier) -> entries.addItem(item));
		})
		.build();

	static void initialize() {
		Registry.register(Registries.ITEM_GROUP, new Identifier(BeardedBeasts.MOD_ID, "beardedbeasts_group"), HERPETO_CRAFT_GROUP);
	}
}

