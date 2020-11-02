package me.mrhakan.agalarhack;

import org.lwjgl.input.Keyboard;

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
	
	public static ModuleManager moduleManager;
	public static Hud hud;
	
	@Instance
	public Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		
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
