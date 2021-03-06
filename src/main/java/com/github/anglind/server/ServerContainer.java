package com.github.anglind.server;

import org.subethamail.smtp.server.SMTPServer;

import java.util.Objects;

public class ServerContainer {

    private static ServerContainer INSTANCE;
    private SMTPServer server;

    private ServerContainer() {
    }

    public static ServerContainer getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new ServerContainer();
        }
        return INSTANCE;
    }

    public SMTPServer getServer() {
        return server;
    }

    public void setServer(final SMTPServer server) {
        this.server = server;
    }
}
