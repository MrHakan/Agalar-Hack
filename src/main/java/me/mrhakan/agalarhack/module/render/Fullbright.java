package me.mrhakan.agalarhack.module.render;

import me.mrhakan.agalarhack.module.Category;
import me.mrhakan.agalarhack.module.Module;

public class Fullbright extends Module {

	public Fullbright() {
		super("Fullbright", Category.RENDER);
	}

    @Override
    public void selfSettings() {
        settings.addSetting("a", "b");
    }
    
    @Override
    public void onEnable() {
    	if(mc.player != null) {
    		mc.gameSettings.gammaSetting =+ 100;
    	}
    }
    
    @Override
    public void onDisable() {
    	if(mc.player != null) {
    		mc.gameSettings.gammaSetting =- 100;
    	}
    }
}
