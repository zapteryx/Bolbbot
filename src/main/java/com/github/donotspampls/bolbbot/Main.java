package com.github.donotspampls.bolbbot;

import com.github.donotspampls.bolbbot.commands.*;
import com.github.donotspampls.bolbbot.listeners.InviteListener;
import com.github.donotspampls.bolbbot.listeners.ServerJoinListener;
import com.github.donotspampls.bolbbot.listeners.ServerLeaveListener;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // Logging in
        DiscordApi api = new DiscordApiBuilder().setToken(System.getenv("TOKEN")).login().join();
        logger.info("Logged in to Discord account: " + api.getYourself().getDiscriminatedName());

        // Create command handler
        CommandHandler commandHandler = new JavacordHandler(api);

        // Register commands
        commandHandler.registerCommand(new SayCommand());
        commandHandler.registerCommand(new PurgeCommand());
        commandHandler.registerCommand(new GenInviteCommand());
        commandHandler.registerCommand(new CrossBanCommand());
        commandHandler.registerCommand(new CrossUnbanCommand());

        // Register listeners
        api.addListener(new ServerJoinListener(api));
        api.addListener(new ServerLeaveListener(api));
        api.addListener(new InviteListener(api));

    }

}
