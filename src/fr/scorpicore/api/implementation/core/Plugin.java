/**
 * 
 */
package fr.scorpicore.api.implementation.core;

import java.util.Properties;

/**
 * @author Guillaume
 * 
 */
public class Plugin {

    private String name;
    private Properties properties;

    /**
     * @param name
     *            plugin name
     * @param properties
     *            plugin properties'
     * 
     */
    public Plugin(String name, Properties properties) {
	this.name = name;
	this.properties = properties;
    }

    /**
     * Return the propertie's value corresponding to propertyName.
     * 
     * @param propertyName
     *            the name of the property
     * @return the propertie's value corresponding to propertyName
     */
    public String getPropertyFromName(String propertyName) {
	String s = "";
	s = properties.getProperty(propertyName);
	return s;
    }

}
