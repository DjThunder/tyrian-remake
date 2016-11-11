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
package com.b3dgs.tyrian.projectile;

import com.b3dgs.lionengine.drawable.SpriteAnimated;
import com.b3dgs.lionengine.game.collision.object.Collidable;
import com.b3dgs.lionengine.game.feature.FeatureModel;
import com.b3dgs.lionengine.game.feature.Service;
import com.b3dgs.lionengine.game.feature.displayable.Displayable;
import com.b3dgs.lionengine.graphic.Graphic;

/**
 * Projectile renderer implementation.
 */
final class ProjectileRenderer extends FeatureModel implements Displayable
{
    private final SpriteAnimated surface;

    @Service private Collidable collidable;

    /**
     * Create a projectile renderer.
     * 
     * @param model The model reference.
     */
    ProjectileRenderer(ProjectileModel model)
    {
        super();

        surface = model.getSurface();
    }

    @Override
    public void render(Graphic g)
    {
        surface.render(g);
        collidable.render(g);
    }
}
