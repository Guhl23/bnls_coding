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

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

/**
 *
 * @author Luca Neukom <luca.neukom@gmail.com>
 */
public class MenuPointModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder<String, MenuPoint> functionBinder = MapBinder.newMapBinder(binder(), String.class, MenuPoint.class);
        functionBinder.addBinding("transform").to(TransformMenuPoint.class);
        bind(MenuPointRegistry.class).to(MenuPointRegistry.class);
    }

}