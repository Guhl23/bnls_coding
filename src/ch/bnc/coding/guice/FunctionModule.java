package ch.bnc.coding.guice;

import ch.bnc.coding.transform.FunctionRegistry;
import ch.bnc.coding.transform.LeetFunction;
import ch.bnc.coding.transform.TransformFunction;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
public class FunctionModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder<String, TransformFunction> functionBinder = MapBinder.newMapBinder(binder(), String.class, TransformFunction.class);
        functionBinder.addBinding("leet").to(LeetFunction.class);
        bind(FunctionRegistry.class).asEagerSingleton();
    }

}
