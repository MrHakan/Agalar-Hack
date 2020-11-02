package me.mrhakan.agalarhack.ui;

import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;

import me.mrhakan.agalarhack.Main;
import me.mrhakan.agalarhack.module.Module;
import me.mrhakan.agalarhack.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Hud extends Gui {
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static class ModuleComparator implements Comparator<Module> {
		
		@Override
		public int compare(Module arg0, Module arg1) {
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return -1;
			}
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
				return 1;
			}
			return 0;
		}
	}
	
	private final ResourceLocation watermark = new ResourceLocation(Reference.MOD_ID, "textures/watermark.png");
	
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		Collections.sort(Main.moduleManager.modules, new ModuleComparator());
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRenderer;
		
		
		//client name
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			fr.drawString("Agalar Hack", 2, 1, 0xffffff);
			fr.drawString(Reference.VERSION, 64, 1, 0xfffffacd);
		}
        //client logo
//		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
//			mc.renderEngine.bindTexture(watermark);
//			drawScaledCustomSizeModalRect(0, 0, 0, 0, 50, 50, 50, 50, 50, 50);
//		}
		
		//arraylist
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			int y = 2;
			final int[] counter = {1};
			for(Module mod : Main.moduleManager.getModuleList()) {
				if(!mod.getName().equalsIgnoreCase("TabGui") && mod.isToggled()) {
					fr.drawStringWithShadow(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 2, y, rainbow(counter[0] * 300));
					y += fr.FONT_HEIGHT;
					counter[0]++;
				}
			}
		}
	}
		public static int rainbow(int delay) {
			double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 25.0);
			rainbowState %=  360;
			return Color.getHSBColor((float) (rainbowState / 360.0f), 1f, 1f).getRGB();	
	}
}
