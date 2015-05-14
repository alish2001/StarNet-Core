package com.starnetmc.core.commands;

import org.bukkit.entity.Player;

import com.starnetmc.core.commands.util.CommandBase;
import com.starnetmc.core.gadgets.GadgetGUI;
import com.starnetmc.core.modules.Gadgets;
import com.starnetmc.core.util.Rank;

public class GadgetCommand extends CommandBase<Gadgets> {

	public GadgetCommand(Gadgets plugin) {
		super(plugin, Rank.VIP, new String[] { "gadgets", "gadget" });
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Player player, String[] args) {

		GadgetGUI.openGadgetInventory(player);

	}

}
