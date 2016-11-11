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
package com.b3dgs.tyrian;

import android.app.Activity;
import android.os.Bundle;

import com.b3dgs.lionengine.core.AudioFactory;
import com.b3dgs.lionengine.core.AudioVoidFormat;
import com.b3dgs.lionengine.core.Config;
import com.b3dgs.lionengine.core.Engine;
import com.b3dgs.lionengine.core.Loader;
import com.b3dgs.lionengine.core.Version;
import com.b3dgs.lionengine.core.android.EngineAndroid;
import com.b3dgs.lionengine.core.android.WavFormat;

/**
 * Android entry point.
 */
public final class AppTyrianAndroid extends Activity
{
    /** Application name. */
    public static final String NAME = "Tyrian Remake";
    /** Application version. */
    public static final Version VERSION = Version.create(0, 1, 0);

    /**
     * Private constructor.
     */
    public AppTyrianAndroid()
    {
        super();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);

        EngineAndroid.start(NAME, VERSION, this);
        AudioFactory.addFormat(new WavFormat(), new AudioVoidFormat("lds"));

        final Config config = new Config(Scene.NATIVE, 32, true);
        final Loader loader = new Loader();
        loader.start(config, Scene.class);
    }

    @Override
    public void finish()
    {
        super.finish();
        Engine.terminate();
    }
}
