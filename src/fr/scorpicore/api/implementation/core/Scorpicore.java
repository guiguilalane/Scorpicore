/**
 * 
 */
package fr.scorpicore.api.implementation.core;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import fr.scorpicore.api.interfaces.ICore;
import fr.scorpicore.utils.TabulationManager;

/**
 * @author Guillaume
 * 
 */
public class Scorpicore implements ICore {

    private TabulationManager tabs = new TabulationManager();

    /**
     * file which contains plugins path
     */
    public static final String SCORPICORE_CONFIG = "scorpicore.path";

    private Map<String, Object> loadedPlugin;
    private Set<String> pluginsPath;

    /**
     * 
     */
    public Scorpicore() {
	System.out.println("[CONSTRUCTEUR] : entrant dans Scorpicore");
	this.loadedPlugin = new HashMap<String, Object>();
	this.pluginsPath = new HashSet<String>();
	this.initPluginsPath();
	System.out.println("[CONSTRUCTEUR] : sortant du constructeur");
    }

    /**
     * 
     */
    private void initPluginsPath() {
	tabs.plusPlus();
	System.out.println(tabs + "[SCOPICORE] : entrant dans initPluginsPath");
	Properties properties = new Properties();
	try {
	    properties.load(new FileReader(SCORPICORE_CONFIG));
	    String[] paths = properties.getProperty("PLUGINS_PATH").split(";");
	    tabs.plusPlus();
	    for (String path : paths) {
		if (this.checkPathIsDirectory(path)) {
		    this.pluginsPath.add(path);
		    System.out.println(tabs + "[INIT_PLUGIN_PATH] : " + path
			    + " ajouter aux chemins des plugins");
		} else {
		    System.out.println(tabs + "[INIT_PLUGIN_PATH] : " + path
			    + " n'est pas un répertoire");
		}
	    }
	    tabs.moinMoins();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println(tabs + "[SCOPICORE] : sortant de initPluginsPath");
	tabs.moinMoins();
    }

    private boolean checkPathIsDirectory(String path) {
	File f = new File(path);
	return f.isDirectory();
    }
}
