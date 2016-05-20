package ru.marvelApi;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.marvelApi.controller.MarvelController;

import javax.servlet.http.HttpServlet;

/**
 * Created by Khartonov Oleg on 09.04.2016.
 */
public class MainApplication extends HttpServlet {

    public void run() throws Exception {
        Server server = new Server(8081);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(contextHandler);
        contextHandler.setContextPath("/marvel/");
        contextHandler.addServlet(new ServletHolder(MarvelController.class), "/*");
        server.start();
    }

    public static void main (String[] args) throws Exception {
        new MainApplication().run();
    }
}
