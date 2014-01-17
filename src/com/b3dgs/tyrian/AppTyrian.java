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
package com.b3dgs.tyrian;

import com.b3dgs.lionengine.Resolution;
import com.b3dgs.lionengine.Version;
import com.b3dgs.lionengine.core.Config;
import com.b3dgs.lionengine.core.Engine;
import com.b3dgs.lionengine.core.Loader;
import com.b3dgs.lionengine.core.Media;

/**
 * Program starts here.
 * 
 * @author Pierre-Alexandre (contact@b3dgs.com)
 */
public final class AppTyrian
{
    /** Application name. */
    public static final String NAME = "Tyrian Remake";
    /** Application version. */
    public static final Version VERSION = Version.create(0, 1, 0);
    /** Entities directory. */
    public static final String ENTITIES_DIR = "entities";
    /** Dynamics directory. */
    public static final String DYNAMICS_DIR = Media.getPath("entities", "dynamic");
    /** Scenery directory. */
    public static final String SCENERY_DIR = Media.getPath(AppTyrian.ENTITIES_DIR, "scenery");
    /** Bonus directory. */
    public static final String BONUS_DIR = Media.getPath(AppTyrian.ENTITIES_DIR, "bonus");
    /** Weapons directory. */
    public static final String WEAPONS_DIR = "weapons";
    /** Effects directory. */
    public static final String EFFECTS_DIR = "effects";
    /** Ships directory. */
    public static final String SHIPS_DIR = "ships";
    /** Sfx directory. */
    public static final String SFX_DIR = "sfx";
    /** Enable sound. */
    private static final boolean ENABLE_SOUND = true;
    /** Resources directory. */
    private static final String RESOURCES = "resources";

    /**
     * Main function.
     * 
     * @param args The arguments.
     */
    public static void main(String[] args)
    {
        Engine.start(AppTyrian.NAME, AppTyrian.VERSION, AppTyrian.RESOURCES);
        Sfx.setEnabled(AppTyrian.ENABLE_SOUND);

        final Resolution output = new Resolution(640, 400, 60);
        final Config config = new Config(output, 16, true);
        final Loader loader = new Loader(config);
        loader.start(new Scene(loader));
    }

    /**
     * Private constructor.
     */
    private AppTyrian()
    {
        throw new RuntimeException();
    }
}
