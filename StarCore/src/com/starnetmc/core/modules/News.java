package com.starnetmc.core.modules;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.starnetmc.core.npc.NPCDragon;
import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;

public class News extends Module {

	public News(JavaPlugin plugin) {
		super("News Manager", 1.0, ModuleType.INFO, plugin);

	}

	public News() {

	}

	public static void sendNews(Player player, String sub) {

		IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \""
				+ F.boldAqua + "The Star Network" + "\"}");
		IChatBaseComponent chatSub = ChatSerializer.a("{\"text\": \"" + sub
				+ "\"}");

		PacketPlayOutTitle pt = new PacketPlayOutTitle(EnumTitleAction.TITLE,
				chatTitle);
		PacketPlayOutTitle pst = new PacketPlayOutTitle(
				EnumTitleAction.SUBTITLE, chatSub);

		((CraftPlayer) player).getHandle().playerConnection.sendPacket(pt);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(pst);

	}

	@EventHandler(priority = EventPriority.LOW)
	public void onJoin(PlayerJoinEvent e) {

		if (isEnabled == true) {
			sendNews(e.getPlayer(), F.GOLD + "~ 97% Done! ~");
		} else {
			return;
		}
	}

	@Override
	public void enable() {
		isEnabled = true;
		douglas();
		log("Enabled.");
	}

	@Override
	public void disable() {
		isEnabled = false;
		log("Disabled.");
	}

	public static boolean isEnabled;

	public void douglas() {

		Location loc = new Location(Bukkit.getWorld("Eclipse"), 96, -60, 0);

		EnderDragon douglas = NPCDragon.spawn(loc);
		douglas.setCustomName(F.boldAqua + "The Star Network" + F.GREEN + " - "
				+ F.GOLD + "Welcomes You!");
		douglas.setCustomNameVisible(true);

	}

}
