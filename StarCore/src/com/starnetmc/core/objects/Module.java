package com.starnetmc.core.objects;

public interface Module {

	public String getName();

	public void setName(String name);

	public ModuleType getType(ModuleType mt);

	public void setType(ModuleType mt);

	public void enable();
	public void disable();
	public boolean isEnabled();
	public boolean setEnabled(boolean arg0);
}

