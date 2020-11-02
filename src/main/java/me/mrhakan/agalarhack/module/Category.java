package me.mrhakan.agalarhack.module;

public enum Category {
	COMBAT("Combat"), EXPLOITS("Exploits"), MOVEMENT("Movement"), RENDER("Render"), MISC("Misc"), WORLD("World");
	
	public String name;
	public int moduleIndex;
	
	Category(String name) {
		this.name = name;
	}
}
