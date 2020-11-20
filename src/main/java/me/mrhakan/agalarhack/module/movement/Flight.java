package me.mrhakan.agalarhack.module.movement;

import me.mrhakan.agalarhack.module.Category;
import me.mrhakan.agalarhack.module.Module;



import me.mrhakan.agalarhack.Main;

public class Flight extends Module {
	
	public static float flyHackSpeed = 0.1f;

	
	public Flight() {
		super("Flight", Category.MOVEMENT);

	}
	
    @Override
    public void selfSettings() {
        settings.addSetting("fast", "slow");
    }

    @Override
    public void onEnable() {
    	if(mc.player != null) {
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
        }

    @Override
    public void onDisable() {
    	if(mc.player != null) {
        	Main.mc.player.capabilities.isFlying = false;
        }	
    }
}
	
