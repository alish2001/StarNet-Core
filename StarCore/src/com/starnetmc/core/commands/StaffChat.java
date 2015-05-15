package com.starnetmc.core.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.modules.Chat;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Manager;
import com.starnetmc.core.util.Rank;

public class StaffChat extends CommandBase<Chat> {

	public StaffChat(Chat plugin) {
		super(plugin, Rank.HELPER, new String[] { "staffchat", "sc" });
		// TODO Auto-generated constructor stub
	}

	public void execute(Player player, String[] args) {

		if (args.length < 1) {
			player.sendMessage(F.error("Commands", "Please use: /sc <Message>"));
			return;
		}

		String annc = "";
		StringBuilder sb = new StringBuilder();
		for (String arg : args) {
			sb.append(arg + " ");
		}
		annc = sb.toString();

		
		
		
		try {
			for(Player staff : Bukkit.getOnlinePlayers()) {
				
				if(Manager.getRank(staff.getUniqueId().toString()).has(getRequiredRank())) {
					
					staff.sendMessage(F.info(ChatColor.stripColor(player.getDisplayName()), annc));
					continue;
					
				}
				if(!Manager.getRank(staff.getUniqueId().toString()).has(getRequiredRank())) {
					continue;
				}
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
