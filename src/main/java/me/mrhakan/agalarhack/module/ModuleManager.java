package me.mrhakan.agalarhack.module;

import java.util.ArrayList;
import java.util.List;

import me.mrhakan.agalarhack.Main;
import me.mrhakan.agalarhack.module.combat.*;
import me.mrhakan.agalarhack.module.movement.*;
import me.mrhakan.agalarhack.module.render.*;

public class ModuleManager {
	
	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();
		//COMBAT
		this.modules.add(new AutoCrystal());
		//EXPLOITS
		
		//MISC
		
		//MOVEMENT
		this.modules.add(new Sprint());
		this.modules.add(new Fly());
		//RENDER
		this.modules.add(new Fullbright());
		//WORLD
	}
	
	public Module getModule (String name) {
		for(Module m : this.modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModuleList() {
		return this.modules;
	}
	
	public static List<Module> getModulesByCategory(Category c) {
		List<Module> modules = new ArrayList<Module>();
		
		for(Module m : Main.moduleManager.modules) {
			if(m.getCategory() == c)
				modules.add(m);
		}
		return modules;
	}
	
}
