package com.starnetmc.core.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.starnetmc.core.util.F;

public class News extends java.lang.Object {

	protected static List<String> headlines = new ArrayList<String>();

	protected JavaPlugin pl;

	public News(JavaPlugin pl) {
		this.pl = pl;
		getNews();
	}

	public static void sendNews(final Player player) {
		
		// Add news here
		headlines.add("Release soon!");
		headlines.add("Games in development!");

		final Iterator<String> o = headlines.iterator();

		while (o.hasNext()) {

			new BukkitRunnable() {

				public void run() {

					IChatBaseComponent chatTitle = ChatSerializer
							.a("{\"text\": \"" + F.boldAqua
									+ "The Star Network	" + "\"}");
					IChatBaseComponent chatSub = ChatSerializer
							.a("{\"text\": \"" + o.next() + "\"}");

					PacketPlayOutTitle pt = new PacketPlayOutTitle(
							EnumTitleAction.TITLE, chatTitle);
					PacketPlayOutTitle pst = new PacketPlayOutTitle(
							EnumTitleAction.SUBTITLE, chatSub);

					((CraftPlayer) player).getHandle().playerConnection
							.sendPacket(pt);
					((CraftPlayer) player).getHandle().playerConnection
							.sendPacket(pst);
				}
			};
		}

	}

	public void getNews() {
	}

}
