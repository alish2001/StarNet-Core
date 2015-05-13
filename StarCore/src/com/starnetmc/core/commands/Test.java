package com.starnetmc.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;

public class Test implements CommandExecutor{

	public static int ID;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("test")) {
			if(!(sender instanceof Player)) {
				return true;
			}
			
			final Player player = (Player) sender;
			
			player.sendMessage(F.error("Test Command", "Nothing to test right now! Come back later! - Spark"));
			
			
		}
		
		return false;
	}
	
}
