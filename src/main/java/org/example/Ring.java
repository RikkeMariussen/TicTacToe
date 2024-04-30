package org.example;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Ring {
    private final double brickSize;
    private final double width;
    private final double height;


    public Ring(double brickSize, double width, double height) {
        this.brickSize = brickSize;
        this.width = width;
        this.height = height;
    }
    public Geometry3D getGeometry(JavaCSG csg){
        Geometry2D ring2D = getRing(csg);
        Geometry3D res = csg.linearExtrude(height, true,ring2D);

        return res;
    }
    private Geometry2D getRing(JavaCSG csg){
        Geometry2D circle = csg.ring2D(brickSize-width,brickSize,64);
        return circle;
    }
}