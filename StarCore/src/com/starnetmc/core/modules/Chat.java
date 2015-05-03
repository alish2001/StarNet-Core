package com.starnetmc.core.modules;

import com.starnetmc.core.objects.Module;
import com.starnetmc.core.objects.ModuleType;

public class Chat implements Module {

	private String name;
	private ModuleType mt;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}


	@Override
	public ModuleType getType(ModuleType mt) {
		// TODO Auto-generated method stub
		return this.mt;
	}

	@Override
	public double getVersion() {
		
		return 0.5;
		
	}
	

	@Override
	public void enable() {
		setEnabled(true);
		System.out.println("<Chat> "+getVersion()+" enabled.");

	}

	@Override
	public void disable() {
		setEnabled(false);
		System.out.println("<Chat> "+getVersion()+" disabled.");
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
