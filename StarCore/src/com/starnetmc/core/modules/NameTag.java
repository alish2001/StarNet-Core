package com.starnetmc.core.modules;

import java.util.UUID;

import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.MinecraftServer;
import net.minecraft.server.v1_8_R1.PacketPlayOutNamedEntitySpawn;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.CraftServer;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class NameTag extends Module {

	
	public NameTag(JavaPlugin plugin) {
		super("Nametag Manager",0.0,ModuleType.INFO,plugin);
	}
	
	public NameTag() {
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) throws Exception {

		setNametag(e.getPlayer());
		@SuppressWarnings("unused")
		EntityPlayer ep = new EntityPlayer(null, null, makeProfile("", e
				.getPlayer().getUniqueId(), null),
				((CraftPlayer) e.getPlayer()).getHandle().playerInteractManager);

	}

	public static void setNametag(Player player) throws Exception {

		String _prevName = player.getName();
		EntityPlayer ep = ((CraftPlayer) player).getHandle();
		switch (Manager.getRank(player.getUniqueId().toString())) {

		case "DEFAULT":
			ep.displayName = player.getName();
			break;
		case "VIP":
			ep.displayName = F.boldDA + "VIP " + player.getName();
			break;
		case "MVP":
			ep.displayName = F.boldAqua + "MVP " + player.getName();
			break;
		case "HELPER":
			ep.displayName = F.boldGreen + "HELPER " + player.getName();
			break;
		case "MODERATOR":
			ep.displayName = F.boldGold + "MOD " + player.getName();
			break;
		case "ADMIN":
			ep.displayName = F.boldRed + "ADMIN " + player.getName();
			break;
		case "DEVELOPER":
			ep.displayName = F.boldDP + "DEV " + player.getName();
			break;
		case "BUILDER":
			ep.displayName = F.boldBlue + "BUILDER " + player.getName();
			break;
		case "OWNER":
			ep.displayName = F.boldDR + "OWNER " + player.getName();
			break;
		case "YOUTUBE":
			ep.displayName = F.BOLD + "YOU" + F.RED + "" + F.BOLD + "TUBE "
					+ player.getName();
			break;

		}

		for (Player all : Bukkit.getOnlinePlayers()) {

			if (all != player) {

				((CraftPlayer) player).getHandle().playerConnection
						.sendPacket(new PacketPlayOutNamedEntitySpawn(ep));

			}

		}
		ep.displayName = _prevName;

	}

	public static GameProfile makeProfile(String name, UUID skinId, UUID npcID) {
		GameProfile profile = new GameProfile(npcID, name);
		if (skinId != null) {
			MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer())
					.getServer();
			GameProfile skin = new GameProfile(skinId, null);
			skin = nmsServer.aB().fillProfileProperties(skin, true); // Srg =
																		// func_147130_as
			if (skin.getProperties().get("textures") == null
					|| !skin.getProperties().get("textures").isEmpty()) {
				Property textures = skin.getProperties().get("textures")
						.iterator().next();
				profile.getProperties().put("textures", textures);
			}
		}
		return profile;
	}


	@Override
	public void enable() {
		isEnabled = true;
		log("Enabled.");

	}

	@Override
	public void disable() {

		isEnabled = false;
		log("Disabled.");

	}

	public static boolean isEnabled;

}
