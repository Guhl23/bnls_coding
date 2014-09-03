/*
 * Copyright (C) 2014 Luca Neukom <luca.neukom@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ch.bnc.coding.menu;

import com.google.inject.Inject;
import java.util.List;

/**
 *
 * @author Luca Neukom <luca.neukom@gmail.com>
 */
public class Menu {
    private final MenuPointRegistry menuRegistry;
    
    @Inject
    public Menu(MenuPointRegistry menuRegistry) {
        this.menuRegistry = menuRegistry;
    }

    public void listOptions() {
        menuRegistry.getMenuPoints().entrySet().stream().map((menuPointEntry) -> {
            MenuPoint menuPoint = menuPointEntry.getValue();
            Object[] functionValues = {
                menuPointEntry.getKey(),
                menuPoint.getLabel(),
                menuPoint.getDescription()
            };
            return functionValues;
        }).forEach((functionValues) -> {
            System.out.println(String.format("%s\n--- %s: %s", functionValues));
        });
    }
    
    public void runMenu(String id, List<String> arguments) {
        try {
            MenuPoint menuPoint = menuRegistry.getMenuPoint(id);
            System.out.println(menuPoint.run(arguments));
        } catch (MenuPointRegistry.MenuPointNotFoundException
                | MenuPoint.MenuException
                | MenuPoint.ArgumentsException e) {
            System.out.println(e.getMessage());
        }
    }

}
