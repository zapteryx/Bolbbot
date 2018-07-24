package com.github.donotspampls.bolbbot.listeners;

import org.javacord.api.event.server.member.ServerMemberLeaveEvent;
import org.javacord.api.listener.server.member.ServerMemberLeaveListener;

import static com.github.donotspampls.bolbbot.Constants.*;

public class ServerLeaveListener implements ServerMemberLeaveListener {

    @Override
    public void onServerMemberLeave(ServerMemberLeaveEvent ev) {
        String name = ev.getServer().getIdAsString();
        switch (name) {
            case BOLB_CHAIRS_1:
                bc1count -= 1;
                break;
            case BOLB_CHAIRS_2:
                bc2count -= 1;
                break;
            case BOLB_CHAIRS_3:
                bc3count -= 1;
                break;
            case BOLB_CHAIRS_4:
                bc4count -= 1;
                break;
            case BOLB_CHAIRS_5:
                bc5count -= 1;
                break;
        }
    }

}
