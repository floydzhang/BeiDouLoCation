/*
 * Copyright (c) 2010-2011, The MiCode Open Source Community (www.micode.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.administrator.beidoulocation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
/**
 * net.micode.compass.CompassView
 * @author Administrator
 * com.example.administrator.beidoulocation.view.CompassView
 */
public class CompassView extends android.support.v7.widget.AppCompatImageView {
    private float mDirection;
    private Drawable compass;

    public CompassView(Context context) {
        super(context);
        mDirection = 0.0f;
        compass = null;
    }

    public CompassView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDirection = 0.0f;
        compass = null;
    }

    public CompassView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mDirection = 0.0f;
        compass = null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (compass == null) {
            compass = getDrawable();
            compass.setBounds(0, 0, getWidth(), getHeight());
        }

        canvas.save();
        compass.setBounds(0, 0, getWidth(), getHeight());
        canvas.rotate(mDirection, getWidth() /2f, getHeight() /2f);
        compass.draw(canvas);
        canvas.restore();
    }

    public void updateDirection(float direction) {
        mDirection = direction;
        invalidate();
    }

}
