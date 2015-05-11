package com.starnetmc.core.modules;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;
import com.starnetmc.core.util.F;

public class News implements Module, Listener {

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
			sendNews(e.getPlayer(), F.GOLD + "~ Arcade coming soon!! ~");
		} else {
			return;
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "News Manager";
	}

	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return ModuleType.INFO;
	}

	public double getVersion() {

		return 1.0;

	}

	@Override
	public void enable() {
		isEnabled = true;
		System.out.println("<News Manager> " + getVersion() + " enabled.");
	}

	@Override
	public void disable() {
		isEnabled = false;
		System.out.println("<News Manager> " + getVersion() + " disabled.");

	}

	public static boolean isEnabled;

}
