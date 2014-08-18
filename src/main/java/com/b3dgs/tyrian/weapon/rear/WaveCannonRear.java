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
package com.b3dgs.tyrian.weapon.rear;

import com.b3dgs.lionengine.core.Media;
import com.b3dgs.lionengine.game.SetupGame;
import com.b3dgs.tyrian.Sfx;
import com.b3dgs.tyrian.entity.Entity;
import com.b3dgs.tyrian.projectile.Wave;
import com.b3dgs.tyrian.weapon.Weapon;
import com.b3dgs.tyrian.weapon.WeaponCategory;

/**
 * Wave cannon implementation.
 * 
 * @author Pierre-Alexandre (contact@b3dgs.com)
 */
public final class WaveCannonRear
        extends Weapon
{
    /** Class media. */
    public static final Media MEDIA = Weapon.getConfig(WeaponCategory.REAR, WaveCannonRear.class);

    /** Id 1. */
    private int id1;
    /** id 2. */
    private int id2;

    /**
     * @see Weapon#Weapon(SetupGame)
     */
    public WaveCannonRear(SetupGame setup)
    {
        super(setup);
        setOffsetY(-15);
        setRate(250);
    }

    /*
     * Weapon
     */

    @Override
    protected void launchProjectile(Entity owner)
    {
        final int dmg = 60;
        final int speed = 11;
        Sfx.WEAPON_WAVE.play();
        switch (level.getCurrent())
        {
            case 0:
                addProjectile(Wave.MEDIA, dmg, -speed, 1.5, -10, 0).setFrame(39);
                addProjectile(Wave.MEDIA, dmg, speed, 1.5, 10, 0).setFrame(54);
                break;
            case 1:
                addProjectile(Wave.MEDIA, dmg, -speed, speed, -10, 0).setFrame(70);
                addProjectile(Wave.MEDIA, dmg, speed, speed, 10, 0).setFrame(85);
                break;
            case 2:
                addProjectile(Wave.MEDIA, dmg, -speed, speed * 0.4, -10, 5).setFrame(69);
                addProjectile(Wave.MEDIA, dmg, speed, speed * 0.4, 10, 5).setFrame(84);

                addProjectile(Wave.MEDIA, dmg, -speed, -speed * 0.4, -10, -5).setFrame(99);
                addProjectile(Wave.MEDIA, dmg, speed, -speed * 0.4, 10, -5).setFrame(114);
                break;
            case 3:
                addProjectile(Wave.MEDIA, dmg, -speed, 1, -10, 0).setFrame(40);
                addProjectile(Wave.MEDIA, dmg, speed, 1, 10, 0).setFrame(55);

                addProjectile(Wave.MEDIA, dmg, -speed, speed * 0.4, -10, 5).setFrame(69);
                addProjectile(Wave.MEDIA, dmg, speed, speed * 0.4, 10, 5).setFrame(84);

                addProjectile(Wave.MEDIA, dmg, -speed, -speed * 0.4, -10, -5).setFrame(99);
                addProjectile(Wave.MEDIA, dmg, speed, -speed * 0.4, 10, -5).setFrame(114);

                addProjectile(Wave.MEDIA, dmg, 0, -speed, 0, -10).setFrame(24);
                break;
            case 4:
                id1++;
                addProjectile(Wave.MEDIA, id1, dmg, -speed, 1, -10, 6).setFrame(12);
                addProjectile(Wave.MEDIA, id1, dmg, -speed, 1, -10, -6).setFrame(27);

                id2++;
                addProjectile(Wave.MEDIA, id2, dmg, speed, 1, 10, 6).setFrame(42);
                addProjectile(Wave.MEDIA, id2, dmg, speed, 1, 10, -6).setFrame(57);

                addProjectile(Wave.MEDIA, dmg, -speed * 0.25, -speed, -3, -5).setFrame(101);
                addProjectile(Wave.MEDIA, dmg, speed * 0.25, -speed, 3, -5).setFrame(116);
                break;
            case 5:
                addProjectile(Wave.MEDIA, dmg, -speed, speed * 0.4, -10, 5).setFrame(69);
                addProjectile(Wave.MEDIA, dmg, speed, speed * 0.4, 10, 5).setFrame(84);

                id1++;
                addProjectile(Wave.MEDIA, id1, dmg, -speed, 1, -10, 6).setFrame(12);
                addProjectile(Wave.MEDIA, id1, dmg, -speed, 1, -10, -6).setFrame(27);

                id2++;
                addProjectile(Wave.MEDIA, id2, dmg, speed, 1, 10, 6).setFrame(42);
                addProjectile(Wave.MEDIA, id2, dmg, speed, 1, 10, -6).setFrame(57);

                addProjectile(Wave.MEDIA, dmg, -speed, -speed * 0.4, -10, -5).setFrame(99);
                addProjectile(Wave.MEDIA, dmg, speed, -speed * 0.4, 10, -5).setFrame(114);

                addProjectile(Wave.MEDIA, dmg, -speed * 0.25, -speed, -3, -5).setFrame(101);
                addProjectile(Wave.MEDIA, dmg, speed * 0.25, -speed, 3, -5).setFrame(116);
                break;
            default:
                break;
        }
    }
}
