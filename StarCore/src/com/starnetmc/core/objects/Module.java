package com.starnetmc.core.objects;

public interface Module {

	public String getName();

	public ModuleType getType(ModuleType mt);

	public double getVersion();

	public void enable();
	public void disable();
	
}
