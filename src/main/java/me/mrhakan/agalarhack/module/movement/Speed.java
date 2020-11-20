package me.mrhakan.agalarhack.module.movement;

import me.mrhakan.agalarhack.module.Category;
import me.mrhakan.agalarhack.module.Module;

public class Speed extends Module {
	
	public static float WalkHackSpeed = 1.5f;
	
	public Speed() {
		super("Speed", Category.MOVEMENT);
	}
	
    @Override
    public void selfSettings() {
        settings.addSetting("a", "b");
    }
    @Override
    public void onEnable() {
    	if(mc.player != null) {
    		mc.player.capabilities.setPlayerWalkSpeed(WalkHackSpeed);
    	}
    }
    
    @Override
    public void onDisable() {
    	if(mc.player != null) {
    		mc.player.capabilities.setPlayerWalkSpeed(WalkHackSpeed - 1.5f);
    	}
    }
}
