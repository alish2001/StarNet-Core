package com.starnetmc.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.starnetmc.core.util.F;
import com.starnetmc.core.util.GadgetGUI;
import com.starnetmc.core.util.Manager;

public class GadgetCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("gadgets")) {
			
			if(!(sender instanceof Player)) {
				return true;
			}
			
			final Player player = (Player) sender;
			
			try {
				switch(Manager.getRank(player.getUniqueId().toString())) {
				
				case "DEFAULT":
					player.sendMessage(F.error("Permissions", "No permission! Buy VIP to get early access to beta features!"));
					return true;
					
				default:					
						GadgetGUI.openGadgetInventory(player);
						return false;
				
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return false;
	}

}
