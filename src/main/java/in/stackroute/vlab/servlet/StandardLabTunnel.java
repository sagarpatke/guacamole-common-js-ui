package in.stackroute.vlab.servlet;

import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.GuacamoleSocket;
import org.apache.guacamole.net.GuacamoleTunnel;
import org.apache.guacamole.net.InetGuacamoleSocket;
import org.apache.guacamole.net.SimpleGuacamoleTunnel;
import org.apache.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.apache.guacamole.protocol.GuacamoleConfiguration;
import org.apache.guacamole.servlet.GuacamoleHTTPTunnelServlet;

import javax.servlet.http.HttpServletRequest;

public class StandardLabTunnel extends GuacamoleHTTPTunnelServlet {
    @Override
    protected GuacamoleTunnel doConnect(HttpServletRequest httpServletRequest) throws GuacamoleException {
        // Create our configuration
        GuacamoleConfiguration config = new GuacamoleConfiguration();
        config.setProtocol("rdp");
        config.setParameter("hostname", "127.0.0.1");
        config.setParameter("port", "3389");
        config.setParameter("ignore-cert", "true");
        config.setParameter("resize-method", "display-update");

        // Connect to guacd - everything is hard-coded here.
        GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
                new InetGuacamoleSocket("localhost", 4822),
                config
        );

        // Return a new tunnel which uses the connected socket
        return new SimpleGuacamoleTunnel(socket);
    }
}
