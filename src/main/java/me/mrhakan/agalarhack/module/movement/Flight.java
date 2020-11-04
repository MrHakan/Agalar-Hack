package me.mrhakan.agalarhack.module.movement;

import me.mrhakan.agalarhack.module.Category;
import me.mrhakan.agalarhack.module.Module;

import org.lwjgl.input.Keyboard;

import me.mrhakan.agalarhack.Main;

public class Flight extends Module {
	
	public static float flyHackSpeed = 0.1f;
	
	public Flight() {
		super("Flight", "Flies like creative mode", Category.MOVEMENT);
		this.setKey(Keyboard.KEY_F);
	}
	
	
    @Override
    public void onEnable() {     
        	Main.mc.player.capabilities.isFlying = true;
			
			if(Main.mc.gameSettings.keyBindJump.isPressed()) {
				Main.mc.player.motionY += 0.2;
			}
			if(Main.mc.gameSettings.keyBindSneak.isPressed()) {
				Main.mc.player.motionY -= 0.2;
			}
			if(Main.mc.gameSettings.keyBindForward.isPressed()) {
				Main.mc.player.capabilities.setFlySpeed(flyHackSpeed);
			}
        }
    
    @Override
    public void onDisable() {
        	Main.mc.player.capabilities.isFlying = false;
        }
    }
	
