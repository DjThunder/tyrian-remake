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

import com.b3dgs.lionengine.Timing;
import com.b3dgs.tyrian.effect.Effect;
import com.b3dgs.tyrian.effect.EffectType;
import com.b3dgs.tyrian.entity.Entity;

/**
 * Missile projectile.
 * 
 * @author Pierre-Alexandre (contact@b3dgs.com)
 */
public abstract class Missile
        extends Projectile
{
    /** Effect timer. */
    private final Timing timerEffect;
    /** Thrown. */
    private boolean thrown;
    /** Speed. */
    private double speed;

    /**
     * Constructor.
     * 
     * @param setup The setup reference.
     * @param frame The missile frame.
     */
    protected Missile(SetupProjectile setup, int frame)
    {
        super(setup, frame);
        timerEffect = new Timing();
        speed = 1.0;
    }

    /**
     * Add smoke effect.
     * 
     * @param x The horizontal location.
     * @param y The vertical location.
     */
    public void addEffect(int x, int y)
    {
        final Effect effect = factoryEffect.create(EffectType.SMOKE);
        effect.start(x, y, 0);
        handlerEffect.add(effect);
    }

    /*
     * Projectile
     */

    @Override
    public void update(double extrp)
    {
        super.update(extrp);
        if (!thrown)
        {
            addEffect(getLocationIntX(), getLocationIntY());
            timerEffect.start();
            thrown = true;
        }
    }

    @Override
    public void onHit(Entity entity, int damages)
    {
        super.onHit(entity, damages);
        final int size = 2;
        final int x = getLocationIntX();
        final int y = getLocationIntY() + getHeight();
        for (int i = 0; i < size; i++)
        {
            final Effect effect1 = factoryEffect.create(EffectType.EXPLODE2);
            final Effect effect2 = factoryEffect.create(EffectType.EXPLODE2);

            effect1.start(x - i * effect1.getWidth() / 2, y, i * 20);
            effect2.start(x + i * effect2.getWidth() / 2, y, i * 20);

            handlerEffect.add(effect1);
            handlerEffect.add(effect2);
        }
        for (int i = 0; i < size; i++)
        {
            final Effect effect1 = factoryEffect.create(EffectType.EXPLODE2);
            final Effect effect2 = factoryEffect.create(EffectType.EXPLODE2);

            effect1.start(x, y - i * effect1.getHeight() / 2, i * 20);
            effect2.start(x, y + i * effect2.getHeight() / 2, i * 20);

            handlerEffect.add(effect1);
            handlerEffect.add(effect2);
        }
    }

    @Override
    protected void updateMovement(double extrp, double vecX, double vecY)
    {
        super.updateMovement(extrp, vecX * speed, vecY * speed);
        speed += 0.1;
        if (timerEffect.elapsed(40))
        {
            addEffect(getLocationIntX(), getLocationIntY());
            timerEffect.restart();
        }
    }
}
