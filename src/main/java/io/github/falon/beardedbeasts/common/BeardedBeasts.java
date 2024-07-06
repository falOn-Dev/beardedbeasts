package io.github.falon.beardedbeasts.common;

import io.github.falon.beardedbeasts.common.init.ModItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeardedBeasts implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Bearded Beasts");
	public static final String MOD_ID = "beardedbeasts";

    @Override
    public void onInitialize(ModContainer mod) {
        LOGGER.info("Hello Quilt world from {}! Stay fresh!", mod.metadata().name());

		ModItems.initialize();
    }
}
