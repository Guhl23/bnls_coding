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

package ch.bnc.coding.menu.menupoints;

import ch.bnc.coding.menu.MenuPoint;
import java.util.List;

/**
 *
 * @author Luca Neukom <luca.neukom@gmail.com>
 */
public class ExitMenuPoint implements MenuPoint {

    @Override
    public String run(List<String> arguments) {
        System.exit(0);
        return "";
    }

    @Override
    public String getLabel() {
        return "Schliessen";
    }

    @Override
    public String getDescription() {
        return "Das Programm schliessen";
    }

}
