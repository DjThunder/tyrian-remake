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
package com.b3dgs.tyrian.weapon.front;

import com.b3dgs.lionengine.core.Media;
import com.b3dgs.lionengine.game.SetupGame;
import com.b3dgs.tyrian.Sfx;
import com.b3dgs.tyrian.entity.Entity;
import com.b3dgs.tyrian.projectile.MissileFront;
import com.b3dgs.tyrian.weapon.Weapon;
import com.b3dgs.tyrian.weapon.WeaponCategory;

/**
 * Missile front implementation.
 * 
 * @author Pierre-Alexandre (contact@b3dgs.com)
 */
public final class MissileLauncherFront
        extends Weapon
{
    /** Class media. */
    public static final Media MEDIA = Weapon.getConfig(WeaponCategory.FRONT, MissileLauncherFront.class);

    /**
     * {@link Weapon#Weapon(SetupGame)}
     */
    public MissileLauncherFront(SetupGame setup)
    {
        super(setup);
        setRate(400);
    }

    /*
     * Weapon
     */

    @Override
    protected void launchProjectile(Entity owner)
    {
        int dmg;
        final int speed = 3;
        Sfx.WEAPON_MISSILE.play();
        switch (level.getCurrent())
        {
            case 0:
                dmg = 60;
                addProjectile(MissileFront.MEDIA, dmg, 0, speed, 0, 0);
                break;
            case 1:
                dmg = 60;
                addProjectile(MissileFront.MEDIA, dmg, -0.1, speed, -5, 0);
                addProjectile(MissileFront.MEDIA, dmg, 0.1, speed, 5, 0);
                break;
            case 2:
                dmg = 60;
                addProjectile(MissileFront.MEDIA, dmg, -0.2, speed, -6, -10);
                addProjectile(MissileFront.MEDIA, dmg, 0, speed, 0, 0);
                addProjectile(MissileFront.MEDIA, dmg, 0.2, speed, 6, -10);
                break;
            case 3:
                dmg = 60;
                addProjectile(MissileFront.MEDIA, dmg, -0.2, speed, -10, -10);
                addProjectile(MissileFront.MEDIA, dmg, -0.05, speed, -5, 0);
                addProjectile(MissileFront.MEDIA, dmg, 0.05, speed, 5, 0);
                addProjectile(MissileFront.MEDIA, dmg, 0.2, speed, 10, -10);
                break;
            case 4:
                dmg = 60;
                addProjectile(MissileFront.MEDIA, dmg, -0.25, speed, -10, -12);
                addProjectile(MissileFront.MEDIA, dmg, 0, speed, 0, 0).setFrame(135);
                addProjectile(MissileFront.MEDIA, dmg, 0.25, speed, 10, -12);
                break;
            case 5:
                dmg = 60;
                addProjectile(MissileFront.MEDIA, dmg, -0.2, speed, -15, -12);
                addProjectile(MissileFront.MEDIA, dmg, -0.05, speed, -7, -5);
                addProjectile(MissileFront.MEDIA, dmg, 0, speed, 0, 0).setFrame(135);
                addProjectile(MissileFront.MEDIA, dmg, 0.05, speed, 7, -5);
                addProjectile(MissileFront.MEDIA, dmg, 0.2, speed, 15, -12);
                break;
            default:
                break;
        }
    }
}
