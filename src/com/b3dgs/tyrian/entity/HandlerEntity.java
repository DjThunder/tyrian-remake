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
package com.b3dgs.tyrian.entity;

import com.b3dgs.lionengine.Graphic;
import com.b3dgs.lionengine.game.CameraGame;
import com.b3dgs.lionengine.game.entity.HandlerEntityGame;
import com.b3dgs.tyrian.entity.ship.Ship;

/**
 * Handler entity.
 * 
 * @author Pierre-Alexandre (contact@b3dgs.com)
 */
public final class HandlerEntity
        extends HandlerEntityGame<EntityOpponent>
{
    /** Camera reference. */
    private final CameraGame camera;
    /** Ship reference. */
    private Ship ship;

    /**
     * Constructor.
     * 
     * @param camera The camera reference.
     */
    public HandlerEntity(CameraGame camera)
    {
        super();
        this.camera = camera;
    }

    /**
     * Set the ship reference.
     * 
     * @param ship The ship reference.
     */
    public void setShip(Ship ship)
    {
        this.ship = ship;
    }

    /*
     * HandlerEntityGame
     */

    @Override
    protected void update(double extrp, EntityOpponent entity)
    {
        super.update(extrp, entity);
        entity.update(ship);
        if (ship != null && entity.collide(ship))
        {
            entity.onHit(ship);
        }
    }

    @Override
    protected void render(Graphic g, EntityOpponent entity)
    {
        if (camera.isVisible(entity))
        {
            entity.render(g, camera);
        }
    }
}
