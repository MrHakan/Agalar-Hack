package me.mrhakan.agalarhack;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import me.mrhakan.agalarhack.commands.CommandManager;
import me.mrhakan.agalarhack.managers.SettingsManager;
import me.mrhakan.agalarhack.module.Module;
import me.mrhakan.agalarhack.module.ModuleManager;
import me.mrhakan.agalarhack.proxy.CommonProxy;
import me.mrhakan.agalarhack.ui.Hud;
import me.mrhakan.agalarhack.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
    public static final String discordid = "";
    public static String prefix = ".";
    
    public static Minecraft mc = Minecraft.getMinecraft();
    
    public static ModuleManager moduleManager = new ModuleManager();
    public static final SettingsManager SETTINGS_MANAGER = new SettingsManager();
	public static Hud hud;
	
	@Instance
	public Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		Display.setTitle(Reference.NAME + " " + Reference.VERSION);
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
	public void key(KeyInputEvent e) {
		if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null)
			return;
		try {
			if(Keyboard.isCreated()) {
				if(Keyboard.getEventKeyState() ) {
					int keyCode = Keyboard.getEventKey();
					if(keyCode<= 0)
						return;
					for(Module m : moduleManager.modules) {
						if(m.getKey() == keyCode && keyCode > 0) {
							m.toggle();
						}
					}
				}
			}
			} catch (Exception q) { q.printStackTrace(); }
	}
}
