package me.mrhakan.agalarhack.module.combat;

import org.lwjgl.input.Keyboard;

import me.mrhakan.agalarhack.module.Category;
import me.mrhakan.agalarhack.module.Module;

public class AutoCrystal extends Module {
	
	public AutoCrystal() {
		super("AutoCrystal", "automaticly places crystal and breaks", Category.COMBAT);
		this.setKey(Keyboard.KEY_G);
	}
	
}
