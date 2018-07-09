package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;

import static com.github.donotspampls.bolbbot.Constants.*;

public class LimitCommand implements CommandExecutor {

    @Command(aliases = {",limit"}, usage = ",limit <server> <limit>", description = "Dynamically sets the amount of users allowed in a game server.")
    public void onCommand(DiscordApi api, String[] args, MessageAuthor author, Message message) {
        if (author.canManageRolesOnServer()) {
            switch (args[0]) {
                case "1": {
                    bc1limit = Integer.parseInt(args[1]);
                    message.addReaction("\uD83D\uDC4D");
                    break;
                }
                case "2": {
                    bc2limit = Integer.parseInt(args[1]);
                    message.addReaction("\uD83D\uDC4D");
                    break;
                }
                case "3": {
                    bc3limit = Integer.parseInt(args[1]);
                    message.addReaction("\uD83D\uDC4D");
                    break;
                }
                case "4": {
                    bc4limit = Integer.parseInt(args[1]);
                    message.addReaction("\uD83D\uDC4D");
                    break;
                }
                case "5": {
                    bc5limit = Integer.parseInt(args[1]);
                    message.addReaction("\uD83D\uDC4D");
                    break;
                }
                default: {
                    message.addReaction("⚠");
                    break;
                }
            }
        } else message.delete();
    }

}
