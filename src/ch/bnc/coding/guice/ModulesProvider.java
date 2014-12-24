package ch.bnc.coding.guice;

import java.io.File;
import java.util.Set;

import com.google.inject.Module;
import com.thoughtworks.xstream.XStream;

public class ModulesProvider {
	private static ModulesProvider instance = null;

	private Modules modules;
	
	public static ModulesProvider getModulesProvider() {
		if(instance == null) {
			instance = new ModulesProvider();
		}
		return instance;
	}
	
	private ModulesProvider() {
		XStream xstream = new XStream();
		File config = new File("config/config.xml");
		this.modules = (Modules) xstream.fromXML(config);
	}
	
	public Set<Module> getModules() {
		return modules.getModules();
	}
}
