/*
 Copyright 1995-2010, Kirit Saelensminde.
 http://www.kirit.com/Missile%20intercept
 
 This file is part of Missile intercept.
 
 Missile intercept is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 
 Missile intercept is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 
 You should have received a copy of the GNU General Public License
 along with Missile intercept.  If not, see <http://www.gnu.org/licenses/>.
 */


#pragma once


namespace mintercept {
    
    
    class Element {
    public:
        enum Layer { background, cities, trails, explosions, missiles, chrome };
        
        virtual ~Element() {}
        
        virtual bool tick() = 0;
        virtual void draw( Layer ) = 0;
    };
    
    
}
