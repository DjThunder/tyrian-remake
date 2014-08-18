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

import com.b3dgs.lionengine.core.Media;
import com.b3dgs.lionengine.game.SetupSurfaceGame;
import com.b3dgs.tyrian.effect.Effect;
import com.b3dgs.tyrian.effect.Explode3;
import com.b3dgs.tyrian.entity.Entity;

/**
 * Wave projectile.
 * 
 * @author Pierre-Alexandre (contact@b3dgs.com)
 */
public final class Wave
        extends Projectile
{
    /** Class media. */
    public static final Media MEDIA = Projectile.getConfig(Wave.class);

    /**
     * Constructor.
     * 
     * @param setup The setup reference.
     */
    public Wave(SetupSurfaceGame setup)
    {
        super(setup, 9);
    }

    /*
     * Projectile
     */

    @Override
    public void onHit(Entity entity, int damages)
    {
        super.onHit(entity, damages);
        final Effect effect = factoryEffect.create(Explode3.MEDIA);
        effect.start(getLocationIntX(), getLocationIntY() + effect.getHeight() / 2, 0);
        handlerEffect.add(effect);
    }
}
