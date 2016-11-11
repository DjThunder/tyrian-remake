/*
 * Copyright (C) 2013-2016 Byron 3D Games Studio (www.b3dgs.com) Pierre-Alexandre (contact@b3dgs.com)
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
package com.b3dgs.tyrian.bonus;

import com.b3dgs.lionengine.Origin;
import com.b3dgs.lionengine.drawable.SpriteAnimated;
import com.b3dgs.lionengine.game.camera.Camera;
import com.b3dgs.lionengine.game.collision.object.Collidable;
import com.b3dgs.lionengine.game.feature.Factory;
import com.b3dgs.lionengine.game.feature.FeatureModel;
import com.b3dgs.lionengine.game.feature.FeatureProvider;
import com.b3dgs.lionengine.game.feature.Service;
import com.b3dgs.lionengine.game.feature.Services;
import com.b3dgs.lionengine.game.feature.identifiable.Identifiable;
import com.b3dgs.lionengine.game.feature.refreshable.Refreshable;
import com.b3dgs.lionengine.game.feature.transformable.Transformable;
import com.b3dgs.lionengine.game.handler.Handler;

/**
 * Bonus updater implementation.
 */
public class BonusUpdater extends FeatureModel implements Refreshable
{
    private static final double FALLING_SPEED = -1.0;

    private final SpriteAnimated surface;

    @Service private Factory factory;
    @Service private Handler handler;
    @Service private Camera camera;
    @Service private Transformable transformable;
    @Service private Collidable collidable;

    /**
     * Create a bonus updater.
     * 
     * @param model The model reference.
     */
    BonusUpdater(BonusModel model)
    {
        super();

        surface = model.getSurface();
    }

    @Override
    public void prepare(FeatureProvider provider, Services services)
    {
        super.prepare(provider, services);

        collidable.setOrigin(Origin.MIDDLE);
    }

    @Override
    public void update(double extrp)
    {
        transformable.moveLocation(extrp, 0.0, FALLING_SPEED);
        collidable.update(extrp);
        surface.setLocation(camera, transformable);
        surface.update(extrp);

        if (transformable.getY() < -transformable.getHeight())
        {
            getFeature(Identifiable.class).destroy();
        }
    }
}
