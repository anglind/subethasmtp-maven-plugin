package com.github.anglind;


import com.github.anglind.mojo.StartServerMojo;
import com.github.anglind.server.ServerContainer;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Test;
import org.subethamail.smtp.server.SMTPServer;

import java.io.File;

public class StartServerMojoTest extends AbstractMojoTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testServerStarts() throws Exception {
        final File pom = new File(getBasedir(), "src/test/resources/start-server/pom.xml");
        assertNotNull(pom);
        assertTrue(pom.exists());

        final StartServerMojo startServerMojo = (StartServerMojo) lookupMojo("start-server", pom);
        assertNotNull(startServerMojo);
        startServerMojo.execute();

        final int port = (int) getVariableValueFromObject(startServerMojo, "port");
        assertEquals(5000, port);

        final ServerContainer instance = ServerContainer.getInstance();
        final SMTPServer server = instance.getServer();
        assertTrue(server.isRunning());
        server.stop();
    }
}

