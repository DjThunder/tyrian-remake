/*
 * Copyright (C) 2013-2018 Byron 3D Games Studio (www.b3dgs.com) Pierre-Alexandre (contact@b3dgs.com)
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
package com.b3dgs.tyrian.effect;

import com.b3dgs.lionengine.Animation;
import com.b3dgs.lionengine.LionEngineException;
import com.b3dgs.lionengine.Localizable;
import com.b3dgs.lionengine.Viewer;
import com.b3dgs.lionengine.game.AnimationConfig;
import com.b3dgs.lionengine.game.feature.FeaturableModel;
import com.b3dgs.lionengine.game.feature.LayerableModel;
import com.b3dgs.lionengine.game.feature.Services;
import com.b3dgs.lionengine.game.feature.Setup;
import com.b3dgs.lionengine.game.feature.Transformable;
import com.b3dgs.lionengine.game.feature.TransformableModel;
import com.b3dgs.lionengine.graphic.drawable.SpriteAnimated;
import com.b3dgs.tyrian.Constant;

/**
 * Effect implementation.
 */
public class Effect extends FeaturableModel
{
    /** Explode node name. */
    public static final String NODE_EXPLODE = com.b3dgs.lionengine.Constant.XML_PREFIX + "explode";

    private final Animation anim;
    private final SpriteAnimated surface;

    private final Transformable transformable;

    private final Viewer viewer;

    /**
     * Create effect.
     * 
     * @param services The services reference (must not be <code>null</code>).
     * @param setup The setup reference (must not be <code>null</code>).
     * @throws LionEngineException If invalid arguments.
     */
    public Effect(Services services, Setup setup)
    {
        super(services, setup);

        viewer = services.get(Viewer.class);

        addFeature(new LayerableModel(Constant.LAYER_EFFECT.intValue()));
        transformable = addFeatureAndGet(new TransformableModel(services, setup));

        final EffectModel model = addFeatureAndGet(new EffectModel(services, setup));
        addFeature(new EffectUpdater(services, setup, model));
        addFeature(new EffectRenderer(services, setup, model));

        anim = AnimationConfig.imports(setup).getAnimation("start");
        surface = model.getSurface();
    }

    /**
     * Start the effect.
     * 
     * @param localizable The localizable reference.
     */
    public void start(Localizable localizable)
    {
        transformable.setLocation(localizable.getX(), localizable.getY());
        surface.setLocation(viewer, transformable);
        surface.play(anim);
    }
}
