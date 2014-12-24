package ch.bnc.coding.guice;

import ch.bnc.coding.menu.MenuPoint;
import ch.bnc.coding.menu.MenuPointRegistry;
import ch.bnc.coding.menu.menupoints.ExitMenuPoint;
import ch.bnc.coding.menu.menupoints.TransformMenuPoint;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class MenuPointModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder<String, MenuPoint> functionBinder = MapBinder.newMapBinder(binder(), String.class, MenuPoint.class);
        functionBinder.addBinding("transform").to(TransformMenuPoint.class);
        functionBinder.addBinding("exit").to(ExitMenuPoint.class);
        bind(MenuPointRegistry.class).asEagerSingleton();
    }

}
