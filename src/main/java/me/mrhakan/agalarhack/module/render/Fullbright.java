package me.mrhakan.agalarhack.module.render;

import org.lwjgl.input.Keyboard;

import me.mrhakan.agalarhack.module.Category;
import me.mrhakan.agalarhack.module.Module;

public class Fullbright extends Module {

	public Fullbright() {
		super("Fullbright", "overrides gamma", Category.RENDER);
		this.setKey(Keyboard.KEY_H);
	}

	
}
