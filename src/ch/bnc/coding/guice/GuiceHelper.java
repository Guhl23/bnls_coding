package ch.bnc.coding.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceHelper {
	public static <T> T getInstanceOf(Class<T> classToGet) {
		return getInjector().getInstance(classToGet);
	}
	
	private static Injector getInjector() {
		ModulesProvider modules = ModulesProvider.getModulesProvider();
		return Guice.createInjector(modules.getModules());
	}
}
