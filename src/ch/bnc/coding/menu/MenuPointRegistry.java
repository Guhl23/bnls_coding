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
import java.util.Map;

/**
 *
 * @author Luca Neukom <luca.neukom@gmail.com>
 */
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
