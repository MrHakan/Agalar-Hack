package me.mrhakan.agalarhack;

import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import me.mrhakan.agalarhack.managers.CommandManager;
import me.mrhakan.agalarhack.managers.SettingsManager;
import me.mrhakan.agalarhack.module.Module;
import me.mrhakan.agalarhack.managers.ModuleManager;
import me.mrhakan.agalarhack.ui.Hud;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

		@Mod(
		modid = "agh",
		name = "Agalar Hack",
		version = "0.0.2")
public class Main {

	public static String name = "Agalar Hack";
	public static String modid = "agh";
	public static String currentvers = "0.0.2";
	public static String prefix = ".";
    
    public static Minecraft mc = Minecraft.getMinecraft();
    
    public static ModuleManager moduleManager = new ModuleManager();
    public static final SettingsManager SETTINGS_MANAGER = new SettingsManager();
	public static Hud hud;

	@Instance
	public Main instance;
	

	
	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		Display.setTitle(name + " " + currentvers);
	}
	
	@EventHandler
	public void init (FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(instance);
		MinecraftForge.EVENT_BUS.register(new Hud());
		moduleManager = new ModuleManager();
		hud = new Hud();

	}
	
	@EventHandler
	public void PostInit (FMLPreInitializationEvent event) {
        moduleManager.loadModules();
        CommandManager.init();
        MinecraftForge.EVENT_BUS.register(new CommandManager());
        MinecraftForge.EVENT_BUS.register(this);

	}
	
	@SubscribeEvent

	public void onKeyPress(InputEvent.KeyInputEvent event) {
		for (Module m: moduleManager.getModuleList()) {
			if(Keyboard.isKeyDown(m.getKey())){
				m.toggle();

			}

		}
	}
}
