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

import com.b3dgs.lionengine.Align;
import com.b3dgs.lionengine.core.Context;
import com.b3dgs.lionengine.core.Medias;
import com.b3dgs.lionengine.core.Sequence;
import com.b3dgs.lionengine.drawable.Drawable;
import com.b3dgs.lionengine.drawable.Image;
import com.b3dgs.lionengine.drawable.SpriteFont;
import com.b3dgs.lionengine.graphic.Graphic;

/**
 * Loading screen.
 */
public final class Loading extends Sequence
{
    private static final String TEXT_LOADING = "Loading... ";
    private static final int LOADING_OFFSET_Y = 50;

    private final Image loading = Drawable.loadImage(Medias.create(Constant.FOLDER_PIC, "loading.png"));
    private final SpriteFont font = Drawable.loadSpriteFont(Medias.create(Constant.FOLDER_FONT, "font.png"),
                                                            Medias.create(Constant.FOLDER_FONT, "font.xml"),
                                                            8,
                                                            9);

    private boolean loaded;

    /**
     * Constructor.
     * 
     * @param context The context reference.
     */
    public Loading(Context context)
    {
        super(context, Constant.NATIVE);

        setSystemCursorVisible(false);
        setExtrapolated(true);
    }

    @Override
    public void load()
    {
        loading.load();
        loading.prepare();

        font.load();
        font.prepare();

        font.setText(TEXT_LOADING);
        font.setAlign(Align.CENTER);
        font.setLocation(getWidth() / 2, getHeight() / 2 + LOADING_OFFSET_Y);
    }

    @Override
    public void update(double extrp)
    {
        if (loaded)
        {
            end(Scene.class);
        }
        loaded = true;
    }

    @Override
    public void render(Graphic g)
    {
        loading.render(g);
        font.render(g);
    }

    @Override
    public void onTerminated(boolean hasNextSequence)
    {
        super.onTerminated(hasNextSequence);

        loading.dispose();
        font.dispose();
    }
}