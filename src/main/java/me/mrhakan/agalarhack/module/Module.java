package me.mrhakan.agalarhack.module;

import org.lwjgl.input.Keyboard;

import me.mrhakan.agalarhack.Main;
import me.mrhakan.agalarhack.managers.Settings;
import net.minecraftforge.common.MinecraftForge;

public class Module {
	
	public String name, description;
	private int key;
	private Category category;
	public boolean toggled;
	public Settings settings = new Settings();
	
	public Module(String name, String description, Category category) {
	super();
	this.name = name;
	this.description = description;
	this.category = category;
	this.key = 0;
	this.toggled = false;
	}
	
	public void registerSettings() {
        settings.addSetting("enabled", false);
        settings.addSetting("keybind", String.valueOf(Keyboard.KEY_NONE));
        selfSettings();
        Main.SETTINGS_MANAGER.updateSettings();

    }
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	 public void setSettings(Settings newSettings) {
	        settings = newSettings;
	    }
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public boolean isToggled() {
		return toggled;
	}
	
	public void setToggled(boolean toggled) {
		this.toggled = toggled;
		
		if(this.toggled) {
			this.onEnable();
		}else {
			this.onDisable();
		}
	}
	
	public void selfSettings() {

    }
	
	public void onToggle() {
		
	}
	
	public void toggle() {
		toggled = !toggled;
        onToggle();
        if (toggled) {
            onEnable();
            settings.setSetting("enabled", true);
            Main.SETTINGS_MANAGER.updateSettings();

        } else {
            onDisable();
            settings.setSetting("enabled", false);
            Main.SETTINGS_MANAGER.updateSettings();

        }
	}
	
	public void onEnable() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void onDisable() {
		MinecraftForge.EVENT_BUS.unregister(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Category getCategory() {
		return this.category;
	}
}
