package me.mrhakan.agalarhack.commands.Commands;

import org.lwjgl.input.Keyboard;

import me.mrhakan.agalarhack.Main;
import me.mrhakan.agalarhack.commands.Command;
import me.mrhakan.agalarhack.managers.MessageManager;
import me.mrhakan.agalarhack.module.Module;

public class bind extends Command {
    public bind() {
        super("bind", new String[]{"t", "toggle"});
    }
    @Override
    public void onCommand(String[] args) {
        if(args.length > 2){
            try{
                for(Module m: Main.moduleManager.getModuleList()) {
                    if (m.getName().equalsIgnoreCase(args[1])) {
                        Main.SETTINGS_MANAGER.updateSettings();
                        try {
                            m.settings.setSetting("keybind", String.valueOf(Keyboard.getKeyIndex(args[2].toUpperCase())));
                            MessageManager.sendMessagePrefix(m.getName() + " is now binded to " + args[2].toUpperCase() +"(" + Keyboard.getKeyIndex(args[2].toUpperCase() + "") + ")");
                        } catch (Exception e) {
                            MessageManager.sendMessagePrefix(m.getName() + "something went wrong");

                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}