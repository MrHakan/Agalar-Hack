package me.mrhakan.agalarhack.commands;

import java.util.HashSet;

import me.mrhakan.agalarhack.Main;
import me.mrhakan.agalarhack.commands.Commands.bind;
import me.mrhakan.agalarhack.commands.Commands.toggle;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommandManager {
    public static HashSet<Command> commands = new HashSet<>();

    public static void init(){
        commands.clear();
        commands.add(new toggle());
        commands.add(new bind());
    }
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void chatEvent(ClientChatEvent event) {
        String[] args = event.getMessage().split(" ");
        if(event.getMessage().startsWith(Main.prefix)) {
            event.setCanceled(true);
            for (Command c: commands){
                if(args[0].equalsIgnoreCase(Main.prefix + c.getCommand())){
                    c.onCommand(args);
                }
            }
        }

    }
}
