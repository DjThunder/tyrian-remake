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
package com.b3dgs.tyrian.entity.scenery;

import com.b3dgs.lionengine.game.ObjectType;
import com.b3dgs.lionengine.game.ObjectTypeUtility;

/**
 * List of entity scenery types.
 * 
 * @author Pierre-Alexandre (contact@b3dgs.com)
 */
public enum EntitySceneryType implements ObjectType
{
    /** Sub square. */
    SUB_SQUARE(SubSquare.class),
    /** House 812. */
    HOUSE812(House812.class),
    /** House 92. */
    HOUSE92(House92.class),
    /** Pump. */
    PUMP(Pump.class),
    /** Spider. */
    SPIDER(Spider.class),
    /** Lamp. */
    LAMP(Lamp.class),
    /** Head. */
    HEAD(Head.class),
    /** Silo. */
    SILO(Silo.class),
    /** Openable pulse. */
    OPENABLE_PULSE(OpenablePulse.class),
    /** Green pulse. */
    GREEN_PULSE(GreenPulse.class),
    /** Double canon. */
    DOUBLE_CANON(DoubleCanon.class),
    /** Single canon. */
    SINGLE_CANON(SingleCanon.class),
    /** Double pulse. */
    DOUBLE_PULSE(DoublePulse.class),
    /** Single pulse. */
    SINGLE_PULSE(SinglePulse.class),
    /** Red box. */
    RED_BOX(RedBox.class),
    /** Red engine. */
    RED_ENGINE(RedEngine.class),
    /** Three red horizontal. */
    THREE_RED_H(ThreeRedH.class),
    /** Three red vertical. */
    THREE_RED_V(ThreeRedV.class),
    /** Generator. */
    GENERATOR(Generator.class);

    /** Class target. */
    private final Class<?> target;
    /** Path name. */
    private final String pathName;

    /**
     * Constructor.
     * 
     * @param target The target class.
     */
    private EntitySceneryType(Class<?> target)
    {
        this.target = target;
        pathName = ObjectTypeUtility.getPathName(this);
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
