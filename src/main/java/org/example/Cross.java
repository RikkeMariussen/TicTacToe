package org.example;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Cross {
    //Represents the cross in tic-tac-toe

    private final double brickSize;
    private final double width;
    private final double height;

    public Cross(double brickSize, double width, double height) {
        this.brickSize = brickSize;
        this.width = width;
        this.height = height;
    }

    public Geometry3D getGeometry(JavaCSG csg){
        Geometry2D cross2D = getFinalCross2D(csg);
        Geometry3D res = csg.linearExtrude(height, false,cross2D);
        return res;
    }

    private Geometry2D getArm(JavaCSG csg){
        //a2+b2=c2 == crossWidth = SqrRoot af (brickSize^2)*2
        double crossLength = Math.sqrt(2*(brickSize*brickSize));
        Geometry2D arm = csg.rectangle2D(crossLength, width);
        return arm;
    }

    private Geometry2D getCross2D(JavaCSG csg){
        Geometry2D arm = getArm(csg);
        Geometry2D arm2  = csg.rotate2D(csg.degrees(90)).transform(arm);
        Geometry2D cross = csg.union2D(arm,arm2);
        return cross;
    }

    private Geometry2D getFinalCross2D(JavaCSG csg){
        Geometry2D cross = getCross2D(csg);
        cross = csg.rotate2D(csg.degrees(45)).transform(cross);
        Geometry2D bound = csg.rectangle2D(brickSize,brickSize);
        cross = csg.intersection2D(cross,bound);
        return cross;
    }
}
