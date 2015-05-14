package com.starnetmc.core.commands;

import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.modules.Chat;
import com.starnetmc.core.util.Rank;

public class HelpCommand extends CommandBase<Chat>{

	public HelpCommand(Chat plugin) {
		super(plugin, Rank.DEFAULT, new String[] {"help"});
		// TODO Auto-generated constructor stub
	}

	

}
