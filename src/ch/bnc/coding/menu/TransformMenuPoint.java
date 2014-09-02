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

import ch.bnc.coding.transformfunctions.FunctionRegistry;
import com.google.inject.Inject;

/**
 *
 * @author Luca Neukom <luca.neukom@gmail.com>
 */
class TransformMenuPoint implements MenuPoint {
    private final FunctionRegistry functionRegistry;
    
    @Inject
    public TransformMenuPoint(FunctionRegistry functionRegistry) {
        this.functionRegistry = functionRegistry;
    }

    @Override
    public String run(String... arguments) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLabel() {
        return "Transform";
    }

    @Override
    public String getDescription() {
        return "Transformiere einen String";
    }

}
