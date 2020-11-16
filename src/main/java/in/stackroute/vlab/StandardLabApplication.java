package in.stackroute.vlab;

import in.stackroute.vlab.servlet.StandardLabTunnel;
import org.apache.guacamole.servlet.GuacamoleHTTPTunnelServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class StandardLabApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(StandardLabApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<StandardLabTunnel> registerTunnelServlet() {
        return new ServletRegistrationBean<>(new StandardLabTunnel(), "/tunnel");
    }
}
