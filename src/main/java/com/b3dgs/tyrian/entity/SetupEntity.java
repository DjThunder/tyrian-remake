/*
 * Copyright (C) 2013-2014 Byron 3D Games Studio (www.b3dgs.com) Pierre-Alexandre (contact@b3dgs.com)
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.b3dgs.tyrian.entity;

import com.b3dgs.lionengine.core.Media;
import com.b3dgs.lionengine.game.SetupSurfaceGame;
import com.b3dgs.tyrian.effect.FactoryEffect;
import com.b3dgs.tyrian.effect.HandlerEffect;
import com.b3dgs.tyrian.weapon.FactoryWeapon;

/**
 * Setup entity implementation.
 * 
 * @author Pierre-Alexandre (contact@b3dgs.com)
 */
public class SetupEntity
        extends SetupSurfaceGame
{
    /** Factory weapon. */
    public final FactoryWeapon factoryWeapon;
    /** Factory effect. */
    final FactoryEffect factoryEffect;
    /** Handler effect. */
    final HandlerEffect handlerEffect;

    /**
     * Constructor.
     * 
     * @param config The config file.
     * @param factoryEffect The factory effect reference.
     * @param handlerEffect The handler effect reference.
     * @param factoryWeapon The weapon factory reference.
     */
    public SetupEntity(Media config, FactoryEffect factoryEffect, HandlerEffect handlerEffect,
            FactoryWeapon factoryWeapon)
    {
        super(config, false);
        this.factoryEffect = factoryEffect;
        this.handlerEffect = handlerEffect;
        this.factoryWeapon = factoryWeapon;
    }
}
