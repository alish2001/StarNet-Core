package com.starnetmc.core.npc;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftEnderDragon;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.entity.CreatureSpawnEvent;

import net.minecraft.server.v1_8_R1.EntityEnderDragon;
import net.minecraft.server.v1_8_R1.World;

public class NPCDragon extends EntityEnderDragon {

	public NPCDragon(World world) {
		super(world);
	}

	
	@Override
	public void move(double d0, double d1, double d2) {
	}



	

	@Override
	public void g(double d0, double d1, double d2) {
		return;
	}

	public static EnderDragon spawn(Location location) {
		World mcWorld = ((CraftWorld) location.getWorld()).getHandle();
		NPCDragon customEntity = new NPCDragon(mcWorld);
		customEntity.setLocation(96, -65,
				0, location.getYaw(), location.getPitch());
		((CraftLivingEntity) customEntity.getBukkitEntity())
				.setRemoveWhenFarAway(false);
		mcWorld.addEntity(customEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
		return (CraftEnderDragon) customEntity.getBukkitEntity();
	}

	
}
