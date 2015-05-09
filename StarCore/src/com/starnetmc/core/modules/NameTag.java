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
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;

public class NameTag implements Module, Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) throws Exception {

		setNametag(e.getPlayer());
		@SuppressWarnings("unused")
		EntityPlayer ep = new EntityPlayer(null, null, makeProfile("",e.getPlayer().getUniqueId(), null), ((CraftPlayer) e.getPlayer()).getHandle().playerInteractManager);
		
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
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			
			if(all != player) {
				
				((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutNamedEntitySpawn(ep));
				
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
	public String getName() {
		// TODO Auto-generated method stub
		return "Nametag Manager";
	}

	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return ModuleType.INFO;
	}

	@Override
	public double getVersion() {
		// TODO Auto-generated method stub
		return 0.1;
	}

	@Override
	public void enable() {
		this.setEnabled(true);
		System.out.println("<Nametag Manager> " + getVersion() + " enabled.");

	}

	@Override
	public void disable() {

		this.setEnabled(false);
		System.out.println("<Nametag Manager> " + getVersion() + " disabled.");

	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		return isEnabled() == arg0;
	}
}
