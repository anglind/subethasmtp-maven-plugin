package com.github.anglind.mojo;

import com.github.anglind.server.ServerContainer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.subethamail.smtp.server.SMTPServer;

@Mojo(name = "stop-server", defaultPhase = LifecyclePhase.POST_INTEGRATION_TEST)
public class StopServerMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException, MojoFailureException {
        final ServerContainer serverContainer = ServerContainer.getInstance();

        final SMTPServer smtpServer = serverContainer.getServer();
        if (smtpServer.isRunning()) {
            smtpServer.stop();
        }
    }
}
