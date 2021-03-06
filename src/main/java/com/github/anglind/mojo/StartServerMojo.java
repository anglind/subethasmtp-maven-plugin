package com.github.anglind.mojo;


import com.github.anglind.server.ServerContainer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.subethamail.smtp.server.SMTPServer;


@Mojo(name = "start-server", defaultPhase = LifecyclePhase.PRE_INTEGRATION_TEST)
public class StartServerMojo extends AbstractMojo {

    @Parameter(defaultValue = "25", property = "port")
    private int port;

    public void execute() throws MojoExecutionException {
        final ServerContainer serverContainer = ServerContainer.getInstance();
        final SMTPServer smtpServer = SMTPServer
                .port(port)
                .build();

        getLog().info(String.format("Starting SMTP Server on port %s", port));
        serverContainer.setServer(smtpServer);
        smtpServer.start();
    }
}
