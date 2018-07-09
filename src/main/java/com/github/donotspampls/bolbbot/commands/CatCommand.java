package com.github.donotspampls.bolbbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class CatCommand implements CommandExecutor {

    @Command(aliases = {",cat"}, usage = ",cat", description = "Gets a random.cat image")
    public void onCommand(DiscordApi api, TextChannel channel) {
        try {
            JSONObject json = new JSONObject(readUrl());
            String link = (String) json.get("file");
            channel.sendMessage(link);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readUrl() throws Exception {
        URL url = new URL("http://aws.random.cat/meow");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        }
    }

}
