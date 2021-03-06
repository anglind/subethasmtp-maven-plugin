# SubEthaSMTP Maven Plugin

A wrapper around [SubEtha SMTP](https://github.com/davidmoten/subethasmtp) to allow an SMTP server to be started as part of the `integration-test` phase for integration tests.

## Features
* Start the server as part of the `pre-integration-test` phase and stop it during the `post-integration-test` phase

## Usage

You can use the server with the below plugin configuration:
```xml
<plugin>
    <groupId>com.github.anglind</groupId>
    <artifactId>subethasmtp-maven-plugin</artifactId>
    <version>VERSION</version>
    <executions>
        <execution>
            <id>start-email-server</id>
            <phase>pre-integration-test</phase>
            <goals>
                <goal>start-server</goal>
            </goals>
        </execution>
        <execution>
            <id>stop-email-server</id>
            <phase>post-integration-test</phase>
            <goals>
                <goal>stop-server</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

## Configuration

* `port` - The port the server will start up on. Default: `25`
```xml
<plugin>
    ...
    <configuration>
        <port>50001</port>
    </configuration>
    ...
</plugin>
```

