package ch.bnc.coding.menu;

import com.google.inject.Inject;
import java.util.Map;

public class MenuPointRegistry {

    Map<String, MenuPoint> menuPoints;

    @Inject
    public MenuPointRegistry(Map<String, MenuPoint> functions) {
        this.menuPoints = functions;
    }

    public MenuPoint getMenuPoint(String id) throws MenuPointNotFoundException {
        if (menuPoints.containsKey(id)) {
            return menuPoints.get(id);
        } else {
            throw new MenuPointNotFoundException(id);
        }
    }
    
    public Map<String, MenuPoint> getMenuPoints() {
        return menuPoints;
    }

    public static class MenuPointNotFoundException extends Exception {

        public MenuPointNotFoundException(String id) {
            super(String.format("Menu point with id '%s' is not registered!", id));
        }
    }
}
