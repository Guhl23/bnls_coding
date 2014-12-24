package ch.bnc.coding.guice;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.inject.Module;

public class Modules {
	private Set<Module> modules;
	
	public Modules() {
		this.modules = Sets.newHashSet();
	}
	
	public Set<Module> getModules() {
		return modules;
	}
	
	public void addModule(Module module) {
		modules.add(module);
	}
}
