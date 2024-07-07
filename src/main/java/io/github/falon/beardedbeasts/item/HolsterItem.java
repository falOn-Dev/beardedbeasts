package io.github.falon.beardedbeasts.item;

import io.github.falon.beardedbeasts.BeardedBeasts;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HolsterItem extends Item {
	private static final EntityType<?> CAPTURE_ENTITY = EntityType.AXOLOTL;


	public HolsterItem(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		if (entity.getType() == CAPTURE_ENTITY && entity.isAlive() && user.isSneaking() && !stack.getOrCreateNbt().contains("entity_data")) {
			user.sendMessage(Text.of("Holstering " + entity.getDisplayName().getString()), true);
			captureEntity(user.getMainHandStack(), entity);
			return ActionResult.SUCCESS;
		} else {
			return ActionResult.FAIL;
		}
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		PlayerEntity user = context.getPlayer();
		ItemStack stack = user.getMainHandStack();
		BlockPos pos = context.getBlockPos();
		World world = context.getWorld();

		NbtCompound nbt = stack.getOrCreateNbt();

		if (user.isSneaking() && nbt.contains("entity_data")) {
			LivingEntity entity = (LivingEntity) CAPTURE_ENTITY.create(world);
			NbtCompound entity_data = nbt.getCompound("entity_data");
			entity.readNbt(entity_data);
			entity.setPos(pos.getX(), pos.getY() + 1, pos.getZ());
			world.spawnEntity(entity);
			nbt.remove("entity_data");

			BeardedBeasts.LOGGER.info("spawned entity");

			nbt.remove("suffix");

			return ActionResult.SUCCESS;
		} else {
			BeardedBeasts.LOGGER.info("failed to spawn entity");
			return ActionResult.FAIL;
		}
	}

	public void captureEntity(ItemStack stack, LivingEntity target) {
		NbtCompound entity_data = new NbtCompound();

		target.saveNbt(entity_data);

		BeardedBeasts.LOGGER.info(entity_data.toString());

		NbtCompound nbt = stack.getOrCreateNbt();

		nbt.put("entity_data", entity_data);
		nbt.putString("suffix", target.getDisplayName().getString());

		target.remove(Entity.RemovalReason.KILLED);
	}


	@Override
	public Text getName(ItemStack stack) {
		if(stack.getOrCreateNbt().contains("suffix")){
			return super.getName(stack).copy().append(Text.of(" (" + stack.getOrCreateNbt().getString("suffix") + ")"));
		} else {
			return super.getName(stack);
		}
	}
}
