package com.starnetmc.core.objects;

public interface Module {

	public String getName();

	public ModuleType getType(ModuleType mt);


	public void enable();
	public void disable();
	public boolean isEnabled();
	public boolean setEnabled(boolean arg0);
}

