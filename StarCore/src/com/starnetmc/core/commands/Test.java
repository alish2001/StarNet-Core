package com.starnetmc.core.commands;


import org.bukkit.entity.Player;

import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.modules.Chat;
import com.starnetmc.core.util.F;
import com.starnetmc.core.util.Rank;

public class Test extends CommandBase<Chat>{

	public Test(Chat plugin) {
		super(plugin, Rank.VIP, new String[] {"test"});
		// TODO Auto-generated constructor stub
	}

	public static int ID;
	
	public void execute(Player player, String[] args) {
		
		player.sendMessage(F.info("Test Command", "Nothing right now! -Spark"));
		
	}
	
}
