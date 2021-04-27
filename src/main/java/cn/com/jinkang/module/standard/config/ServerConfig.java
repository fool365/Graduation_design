package cn.com.jinkang.module.standard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ServerConfig implements ApplicationListener<WebServerInitializedEvent> {
    @Value("${server.servlet.context-path}")
    private String context;
    private static String serverPort;

    public ServerConfig() {
    }

    public static String getUrl() {
        InetAddress address = null;

        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException var2) {
            var2.printStackTrace();
        }

        return "http://" + address.getHostAddress() + ":" + serverPort;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        serverPort = event.getWebServer().getPort() + this.context;
    }
}
