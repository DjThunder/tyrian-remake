/*
 * Copyright (C) 2013 Byron 3D Games Studio (www.b3dgs.com) Pierre-Alexandre (contact@b3dgs.com)
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
package com.b3dgs.tyrian.weapon;

import com.b3dgs.lionengine.core.Media;
import com.b3dgs.lionengine.game.FactoryObjectGame;
import com.b3dgs.lionengine.game.SetupGame;
import com.b3dgs.tyrian.AppTyrian;
import com.b3dgs.tyrian.projectile.FactoryProjectile;
import com.b3dgs.tyrian.projectile.HandlerProjectile;

/**
 * Weapon factory.
 * 
 * @author Pierre-Alexandre (contact@b3dgs.com)
 */
public final class FactoryWeapon
        extends FactoryObjectGame<WeaponType, SetupGame, Weapon>
{
    /** Factory projectile. */
    private final FactoryProjectile factory;
    /** Handler projectile. */
    private final HandlerProjectile handler;

    /**
     * Constructor.
     * 
     * @param factory The factory reference.
     * @param handler The handler reference.
     */
    public FactoryWeapon(FactoryProjectile factory, HandlerProjectile handler)
    {
        super(WeaponType.class, AppTyrian.WEAPONS_DIR);
        this.factory = factory;
        this.handler = handler;
        load();
    }

    /*
     * FactoryObjectGame
     */

    @Override
    protected SetupGame createSetup(WeaponType type, Media config)
    {
        return new SetupWeapon(config, factory, handler);
    }
}
