package org.cipango;

import org.cipango.Server;

import org.cipango.deployer.SipAppDeployer;
import org.cipango.handler.SipContextHandlerCollection;
import org.cipango.sip.SipConnector;
import org.cipango.sip.TcpConnector;
import org.cipango.sip.UdpConnector;
import org.cipango.sipapp.SipAppContext;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.log.Log;


public class CipangoRunner {
  
  public static final void main(String[] args) throws Exception {
    Server server = new Server();
    
    SipContextHandlerCollection contexts = new SipContextHandlerCollection();
    server.setHandler(contexts);

    UdpConnector udp = new UdpConnector();
    TcpConnector tcp = new TcpConnector();
    
    String sipHost = System.getProperty("sip.host", "0.0.0.0");
    Integer sipPort = Integer.getInteger("sip.port", 5060);  
    udp.setHost(sipHost);
    udp.setPort(sipPort);
    tcp.setHost(sipHost);
    tcp.setPort(sipPort);

    server.getConnectorManager().setConnectors(new SipConnector[] {udp, tcp});
    
    Connector connector=new SocketConnector();
    connector.setHost(System.getProperty("http.host", "0.0.0.0"));
    connector.setPort(Integer.getInteger("http.port", 8080));
    server.setConnectors(new Connector[]{connector});

    SipAppContext sipapp = new SipAppContext(args[0], "/");
    contexts.addHandler(sipapp);
      
    server.start();
  }
}