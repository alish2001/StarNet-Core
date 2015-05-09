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

public class News implements Module, Listener{

	
	public static void sendNews(Player player, String sub) {
		
		 IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + F.boldAqua+"The Star Network" + "\"}");
		    IChatBaseComponent chatSub = ChatSerializer.a("{\"text\": \"" + sub + "\"}");
		    
		    PacketPlayOutTitle pt = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
		    PacketPlayOutTitle pst = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, chatSub);
		    
		    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(pt);
		    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(pst);
		
	}
	
	
	@EventHandler(priority = EventPriority.LOW)
	public void onJoin(PlayerJoinEvent e) {
		
		sendNews(e.getPlayer(), F.GOLD+"~ New Stuff :D ~");
		
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
		setEnabled(true);
		System.out.println("<News Manager> "+getVersion()+" enabled.");
	}

	@Override
	public void disable() {
		setEnabled(false);
		System.out.println("<News Manager> "+getVersion()+" disabled.");
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean setEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		return isEnabled() == arg0;
	}

}
