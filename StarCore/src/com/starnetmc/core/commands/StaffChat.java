package com.starnetmc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.starnetmc.core.accounts.AccountManager;
import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.modules.Chat;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Rank;
import com.starnetmc.core.util.UString;

public class StaffChat extends CommandBase<Chat> {

	public StaffChat(Chat plugin) {
		super(plugin, Rank.HELPER, new String[] { "staffchat", "sc" });
	}

	public void execute(Player player, String[] args) {

		if (args.length < 1) {
			player.sendMessage(F.error("Commands", "Please use: /sc <Message>"));
			return;
		}
		
		String msg = UString.forgeArgMessage(args, 0);
		
			for(Player staff : Bukkit.getOnlinePlayers()) {
				
				if(AccountManager.getAccount(player).getRank() == getRequiredRank()) {
					
					staff.sendMessage(F.info(ChatColor.stripColor(player.getDisplayName()), msg));
					continue;
					
				}
				
				if(AccountManager.getAccount(player).getRank() != getRequiredRank()) {
					continue;
				}
			
			}
	}

}