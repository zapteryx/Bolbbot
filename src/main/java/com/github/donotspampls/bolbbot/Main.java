package com.github.donotspampls.bolbbot;

import com.github.donotspampls.bolbbot.commands.*;
import com.github.donotspampls.bolbbot.listeners.InviteListener;
import com.github.donotspampls.bolbbot.listeners.ServerJoinListener;
import com.github.donotspampls.bolbbot.listeners.ServerLeaveListener;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // Logging in
        DiscordApi api = new DiscordApiBuilder().setToken(args[0]).login().join();
        api.updateActivity("lobby music", ActivityType.LISTENING);
        logger.info("Logged in to Discord account: " + api.getYourself().getDiscriminatedName());

        // Create command handler
        CommandHandler commandHandler = new JavacordHandler(api);

        // Register commands
        commandHandler.registerCommand(new CatCommand());
        commandHandler.registerCommand(new CrossBanCommand());
        commandHandler.registerCommand(new CrossUnbanCommand());
        commandHandler.registerCommand(new GenInviteCommand());
        commandHandler.registerCommand(new LimitCommand());
        commandHandler.registerCommand(new PurgeCommand());
        commandHandler.registerCommand(new SayCommand());

        // Register listeners
        api.addListener(new InviteListener());
        api.addListener(new ServerJoinListener(api));
        api.addListener(new ServerLeaveListener());

    }

}
