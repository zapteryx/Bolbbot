package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;

import static com.github.donotspampls.bolbbot.Constants.*;

public class CountCommand implements CommandExecutor {

    @Command(aliases = {",count"}, usage = ",count <server> <count>", description = "Dynamically sets the amount of users in a game server.")
    public void onCommand(DiscordApi api, String[] args, MessageAuthor author, Message message) {
        if (author.canManageRolesOnServer()) {
            switch (args[0]) {
                case "1": {
                    bc1count = Integer.parseInt(args[1]);
                    message.addReaction("\uD83D\uDC4D");
                    break;
                }
                case "2": {
                    bc2count = Integer.parseInt(args[1]);
                    message.addReaction("\uD83D\uDC4D");
                    break;
                }
                case "3": {
                    bc3count = Integer.parseInt(args[1]);
                    message.addReaction("\uD83D\uDC4D");
                    break;
                }
                case "4": {
                    bc4count = Integer.parseInt(args[1]);
                    message.addReaction("\uD83D\uDC4D");
                    break;
                }
                case "5": {
                    bc5count = Integer.parseInt(args[1]);
                    message.addReaction("\uD83D\uDC4D");
                    break;
                }
                case "list": {
                    message.reply("**Server 1** " + bc1count + "\n**Server 2** " + bc2count + "\n**Server 3** " + bc3count + "\n**Server 4** " + bc4count + "\n**Server 5** " + bc5count + "\n**Server 6** " + bc6count);
                    break;
                }
                default: {
                    message.addReaction("\u26A0");
                    break;
                }
            }
        } else message.delete();
    }

}
