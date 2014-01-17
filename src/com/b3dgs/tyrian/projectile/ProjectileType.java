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
package com.b3dgs.tyrian.projectile;

import com.b3dgs.lionengine.game.ObjectType;
import com.b3dgs.lionengine.game.ObjectTypeUtility;

/**
 * List of projectile types.
 * 
 * @author Pierre-Alexandre (contact@b3dgs.com)
 */
public enum ProjectileType implements ObjectType
{
    /*
     * Front
     */

    /** Pulse. */
    PULSE(Pulse.class, ProjectileCategory.FRONT),
    /** Missile front. */
    MISSILE_FRONT(MissileFront.class, ProjectileCategory.FRONT),
    /** Bullet. */
    BULLET(Bullet.class, ProjectileCategory.FRONT),

    /*
     * Rear
     */

    /** Wave. */
    WAVE(Wave.class, ProjectileCategory.REAR),
    /** Missile rear left. */
    MISSILE_REAR(MissileRear.class, ProjectileCategory.REAR),

    /*
     * Other
     */

    /** Impulse. */
    IMPULSE(Impulse.class, ProjectileCategory.OTHER);

    /** Class target. */
    private final Class<?> target;
    /** Path name. */
    private final String pathName;
    /** Weapon category. */
    private final ProjectileCategory category;

    /**
     * Constructor.
     * 
     * @param target The target class.
     * @param category The projectile category.
     */
    private ProjectileType(Class<?> target, ProjectileCategory category)
    {
        this.target = target;
        this.category = category;
        pathName = ObjectTypeUtility.getPathName(this);
    }

    /**
     * Get the projectile category.
     * 
     * @return The projectile category.
     */
    public ProjectileCategory getCategory()
    {
        return category;
    }

    /*
     * ObjectType
     */

    @Override
    public Class<?> getTargetClass()
    {
        return target;
    }

    @Override
    public String getPathName()
    {
        return pathName;
    }
}
