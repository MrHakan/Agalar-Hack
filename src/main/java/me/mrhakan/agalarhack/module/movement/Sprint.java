package me.mrhakan.agalarhack.module.movement;

import org.lwjgl.input.Keyboard;

import me.mrhakan.agalarhack.module.Category;
import me.mrhakan.agalarhack.module.Module;

public class Sprint extends Module {
	
	public Sprint() {
		super("Sprint", "auto runs when you hold w", Category.MOVEMENT);
		this.setKey(Keyboard.KEY_M);
	}

}
