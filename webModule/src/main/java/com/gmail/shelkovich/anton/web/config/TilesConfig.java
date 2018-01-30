package com.gmail.shelkovich.anton.web.config;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class TilesConfig implements DefinitionsFactory {

    private static final Map<String, Definition> tilesDefinitions = new HashMap<>();
    private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/views/layout/defaultLayout.jsp");
    private static final String viewsDir = "/WEB-INF/views/";
    private static final String ajaxViewsDir = "/WEB-INF/views/ajax/";
    private static final String adminViewsDir = "/WEB-INF/views/admin/";


    @Override
    public Definition getDefinition(String name, Request tilesContext) {
        return tilesDefinitions.get(name);
    }

    /**
     * @param name <code>Name of the view</code>
     * @param title <code>Page title</code>
     * @param body <code>Body JSP file path</code>
     *
     * <code>Adds default layout definitions</code>
     */
    private static void addDefaultLayoutDef(String name, String title, String body) {
        Map<String, Attribute> attributes = new HashMap<>();

        attributes.put("title", new Attribute(title));
        attributes.put("header", new Attribute("/WEB-INF/views/layout/header.jsp"));
        attributes.put("menu", new Attribute("/WEB-INF/views/layout/menu.jsp"));
        attributes.put("body", new Attribute(body));
        attributes.put("footer", new Attribute("/WEB-INF/views/layout/footer.jsp"));

        tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
    }

    private static void addAjaxDef(String name, String body){
        tilesDefinitions.put(name, new Definition(name, new Attribute(body), new HashMap<>()));
    }

    private static void addAdminLayoutDef(String name, String body) {
        Map<String, Attribute> attributes = new HashMap<>();

        attributes.put("header", new Attribute("/WEB-INF/views/layout/header.jsp"));
        attributes.put("menu", new Attribute("/WEB-INF/views/admin/layout/menu.jsp"));
        attributes.put("body", new Attribute(body));
        attributes.put("footer", new Attribute("/WEB-INF/views/layout/footer.jsp"));

        Attribute ADMIN_TEMPLATE = new Attribute("/WEB-INF/views/admin/layout/defaultLayout.jsp");

        tilesDefinitions.put(name, new Definition(name, ADMIN_TEMPLATE, attributes));
    }

    /**
     * <code>Add Apache tiles definitions</code>
     */
    public static void addDefinitions(String rootDir, LayoutType type){

        File dir = new File(rootDir);
        File[] files= dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().contains(".jsp")) {
                    String filename = file.getName();
                    filename = filename.substring(0, filename.indexOf("."));
                    switch (type){
                        case STANDART:
                            addDefaultLayoutDef(filename, filename + " page", viewsDir + filename + ".jsp");
                            break;
                        case AJAX:
                            addAjaxDef(filename, ajaxViewsDir + filename + ".jsp");
                            break;
                        case ADMIN:
                            addAdminLayoutDef(filename, adminViewsDir + filename + ".jsp");
                    }
                }
            }
        } else {
            throw new NullPointerException("No files");
        }

    }
}
