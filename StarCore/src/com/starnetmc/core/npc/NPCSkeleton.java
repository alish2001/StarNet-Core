package com.starnetmc.core.npc;

import net.minecraft.server.v1_8_R1.EntitySkeleton;
import net.minecraft.server.v1_8_R1.World;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftSkeleton;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class NPCSkeleton extends EntitySkeleton {

	public NPCSkeleton(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(double d0, double d1, double d2) {
	}



	

	@Override
	public void g(double d0, double d1, double d2) {
		return;
	}

	public static Skeleton spawn(Location location) {
		World mcWorld = ((CraftWorld) location.getWorld()).getHandle();
		NPCSkeleton customEntity = new NPCSkeleton(mcWorld);
		customEntity.setLocation(location.getX(), location.getY(),
				location.getZ(), location.getYaw(), location.getPitch());
		((CraftLivingEntity) customEntity.getBukkitEntity())
				.setRemoveWhenFarAway(false);
		mcWorld.addEntity(customEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
		return (CraftSkeleton) customEntity.getBukkitEntity();
	}

}
