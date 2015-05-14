package com.starnetmc.core.commands;

import org.bukkit.entity.Player;

import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.modules.Chat;
import com.starnetmc.core.util.Rank;

public class Time extends CommandBase<Chat> {

	public Time(Chat plugin) {
		super(plugin, Rank.ADMIN, new String[] {"t"});
		// TODO Auto-generated constructor stub
	}


	@Override
	public void execute(Player player, String[] args) {
		
		com.starnetmc.core.commands.util.Time.openTimeGUI(player);
		
	}

}
