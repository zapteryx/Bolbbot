package com.github.donotspampls.bolbbot;

import com.github.donotspampls.bolbbot.commands.*;
import com.github.donotspampls.bolbbot.listeners.*;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Logging in
        DiscordApi api = new DiscordApiBuilder().setToken(System.getenv("TOKEN")).login().join();
        logger.info("Logged in to Discord account: " + api.getYourself().getDiscriminatedName());

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

        // Spin up a web server so Heroku doesn't complain
        try {
            int port = Integer.parseInt(System.getenv("PORT"));

            Server server = new Server(port);
            ResourceHandler resource_handler = new ResourceHandler();

            resource_handler.setDirectoriesListed(false);
            resource_handler.setWelcomeFiles(new String[]{ "index.html" });
            resource_handler.setResourceBase("../src/main/resources");

            HandlerList handlers = new HandlerList();
            handlers.setHandlers(new Handler[] { resource_handler, new DefaultHandler() });
            server.setHandler(handlers);

            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
