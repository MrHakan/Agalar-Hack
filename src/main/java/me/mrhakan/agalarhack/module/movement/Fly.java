package me.mrhakan.agalarhack.module.movement;

import org.lwjgl.input.Keyboard;

import me.mrhakan.agalarhack.module.Category;
import me.mrhakan.agalarhack.module.Module;

public class Fly extends Module {
	
	public Fly() {
		super("Fly", "Flies like creative mode", Category.MOVEMENT);
		this.setKey(Keyboard.KEY_F);
	}

}
