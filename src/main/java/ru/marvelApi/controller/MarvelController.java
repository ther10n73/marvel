package ru.marvelApi.controller;

import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.marvelApi.MarvelFactory;
import ru.marvelApi.MarvelFactoryImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;

/**
 * Created by Khartonov Oleg on 23.04.2016.
 */
public class MarvelController extends HttpServlet {
    private String type;
    private String id;
    private String expendedType;
    private MarvelFactory marvelFactory = new MarvelFactoryImpl();
    private XStream xStream = new XStream();
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print("Welcome to Marvel Library! Use POST for info about comics");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(request.getInputStream());
            response.getWriter().print(parserXml(doc));
        } catch (Throwable e) {
            response.getWriter().println(xStream.toXML(e.getMessage()));
        }
    }

    private String parserXml(Document doc) throws Throwable {
        NodeList nList = doc.getChildNodes();
        for (int i=0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            Element element = (Element) node;
            type = element.getElementsByTagName("type").item(0).getTextContent();
             try {
                 id = element.getElementsByTagName("id").item(0).getTextContent();
                 expendedType = element.getElementsByTagName("expendedType").item(0).getTextContent();
             } catch (NullPointerException e){
             }

            if (StringUtils.isBlank(id) && StringUtils.isBlank(expendedType)) {
                return xStream.toXML(marvelFactory.createDataWrapper(type).getData().getResults());
            } else if (StringUtils.isNotBlank(id) && StringUtils.isBlank(expendedType)) {
                return xStream.toXML(marvelFactory.createDataWrapper(type)
                        .getData()
                        .getResults()
                        .stream()
                        .filter(p -> p.getId() == Integer.parseInt(id))
                        .findFirst()
                        .get());
            } else if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(expendedType)){
                return xStream.toXML(marvelFactory.createDataWrapper(type, Integer.parseInt(id), expendedType).getData().getResults());
            }
        }
        throw new IllegalStateException("can't parse this xml");
    }
}
