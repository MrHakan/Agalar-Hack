package me.mrhakan.agalarhack.module.movement;

import me.mrhakan.agalarhack.module.Category;
import me.mrhakan.agalarhack.module.Module;

public class Jesus extends Module {

	public Jesus() {
		super("Jesus", Category.MOVEMENT);
	}
	
    @Override
    public void selfSettings() {
        settings.addSetting("a", "b");
    }
    @Override
    public void onEnable() {
    	if(mc.player != null) {
    		mc.player.isInWater();
    	}
    }
    
    @Override
    public void onDisable() {
    	if(mc.player != null) {
    		
    	}
    }
	
}
