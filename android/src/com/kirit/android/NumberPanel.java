/*
    Copyright 1995-2010, Kirit Saelensminde.
    http://www.kirit.com/Missile%20intercept

    This file is part of Missile intercept.

    AnimRay is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    AnimRay is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Missile intercept.  If not, see <http://www.gnu.org/licenses/>.
*/


package com.kirit.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;


public class NumberPanel extends Element {
	private int number, digits, left, numbers_offset;
	private BitmapDrawable prolog, numbers;
	private Rect location = new Rect(), source = new Rect();

	public NumberPanel(Context context, int d, int p, int n) {
		number = 0; digits = d; left = 0;
		prolog = (BitmapDrawable)context.getResources().getDrawable(p);
		numbers = (BitmapDrawable)context.getResources().getDrawable(n);
		numbers_offset = getPrologHeight();
	}

	public void reset(int n) {
		number = n;
	}
	public int getValue() {
		return number;
	}
	public int alter(int by) {
		return number += by;
	}

	public int getWidth() {
		return Math.max(numbers.getMinimumWidth() / 10 * digits, prolog.getMinimumWidth());
	}
	public int getPrologHeight() {
		return prolog.getMinimumHeight();
	}
	public void setLeft(int l) {
		left = l;
	}
	public void setNumberOffset(int h) {
		numbers_offset = h;
	}

	@Override
	public boolean draw(Canvas c) {
		int width = numbers.getMinimumWidth() / 10;

		location.top = 0;
		location.bottom = getPrologHeight();
		location.left = left + ( getWidth() - prolog.getMinimumWidth() ) / 2;
		location.right = location.left + prolog.getMinimumWidth();
		prolog.setBounds(location);
		prolog.draw(c);

		source.top = 0;
		source.bottom = numbers.getMinimumHeight();
		location.top = numbers_offset;
		location.bottom = numbers_offset + getPrologHeight(); 
		for ( int i = digits - 1, n = number > 0 ? number : 0; i >= 0; --i, n = n / 10 ) {
			location.left = left + ( getWidth() - width * digits ) / 2 + i * width;
			location.right = location.left + width;
			source.left = (n % 10) * width;
			source.right = source.left + width;
			c.drawBitmap(numbers.getBitmap(), source, location, null);
		}

		return true;
	}
}