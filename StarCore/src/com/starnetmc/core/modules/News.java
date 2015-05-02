package com.starnetmc.core.modules;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;

public class News implements Module{

	
	
	
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

	@Override
	public void enable() {
		setEnabled(true);
		
	}

	@Override
	public void disable() {
		setEnabled(false);
		
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
