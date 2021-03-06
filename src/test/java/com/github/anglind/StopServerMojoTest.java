package com.github.anglind;


import com.github.anglind.mojo.StopServerMojo;
import com.github.anglind.server.ServerContainer;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Test;
import org.subethamail.smtp.server.SMTPServer;

import java.io.File;

public class StopServerMojoTest extends AbstractMojoTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testServerStops() throws Exception {
        final File pom = new File(getBasedir(), "src/test/resources/stop-server/pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        final ServerContainer instance = ServerContainer.getInstance();
        SMTPServer server = SMTPServer.port(50010).build();
        instance.setServer(server);
        server.start();
        assertTrue(server.isRunning());

        final StopServerMojo stopServerMojo = (StopServerMojo) lookupMojo("stop-server", pom);
        assertNotNull(stopServerMojo);
        stopServerMojo.execute();

        assertFalse(server.isRunning());
    }
}

