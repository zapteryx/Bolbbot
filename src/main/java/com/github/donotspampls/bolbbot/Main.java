package com.github.donotspampls.bolbbot;

import com.github.donotspampls.bolbbot.commands.*;
import com.github.donotspampls.bolbbot.listeners.*;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static void main(String[] args) {

        // Logging in
        DiscordApi api = new DiscordApiBuilder().setToken(System.getenv("TOKEN")).login().join();
        System.out.println("Logged in to Discord account: " + api.getYourself().getDiscriminatedName());

        // Create command handler
        CommandHandler commandHandler = new JavacordHandler(api);

        // Give the bot owner all permissions
        commandHandler.addPermission(String.valueOf(api.getOwnerId()), "*");

        // Register commands
        commandHandler.registerCommand(new SayCommand());
        commandHandler.registerCommand(new PurgeCommand());
        commandHandler.registerCommand(new GenInviteCommand());
        commandHandler.registerCommand(new CrossBanCommand());
        commandHandler.registerCommand(new CrossUnbanCommand());

        // Register listeners
        api.addListener(new ServerJoinListener(api));
        api.addListener(new ServerLeaveListener(api));

    }

}
