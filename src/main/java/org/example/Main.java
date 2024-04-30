package org.example;
import org.abstractica.javacsg.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static <Board> void main(String[] args) {
       //System.out.println("Hello world!");

        /*Intro til SCAD

        //Java SCG - alt er et interface
        JavaCSG csg = JavaCSGFactory.createNoCaching();
        Geometry3D box = csg.box3D(10,20,30, true);
        Geometry3D sphere = csg.sphere3D(20,128,true);
        Geometry3D boxWHole = csg.difference3D(box,sphere); //difference
        Geometry3D boxWOHole = csg.union3D(box,sphere); //union
        Geometry3D boxInHole = csg.intersection3D(box,sphere); //intersection
        //csg.view(boxInHole);
       // csg.view(sphere);

        List<Vector2D> vertices = new ArrayList<Vector2D>();
        vertices.add(csg.vector2D(0,0));
        vertices.add(csg.vector2D(2,0));
        vertices.add(csg.vector2D(2,3));
        vertices.add(csg.vector2D(1,2));
        vertices.add(csg.vector2D(0,3));
        Geometry2D thingies = csg.polygon2D(vertices);
        thingies = csg.scale2D(10,10).transform(thingies);
        thingies = csg.translate2DX(10).transform(thingies); //Laver hul i midten
        // csg.view(thingies);

        //Make thingies 3D
        Geometry3D thingies3D = csg.linearExtrude(5,false,thingies);
        //csg.view(thingies3D);

        //Rotate thingies
        Geometry3D thingiesRotated = csg.rotateExtrude(csg.rotations(0.25),64, thingies);
        csg.view(thingiesRotated);
        //Kan også skrives
        Geometry3D thingiesRotated2 = csg.rotateExtrude(csg.rotations(360),64, thingies);
        csg.view(thingiesRotated2);*/

        JavaCSG csg = JavaCSGFactory.createNoCaching();
        //Cross
        Cross cross = new Cross(30,10,3);
        Geometry3D res = cross.getGeometry(csg);
        //csg.view(res);

        //Rings
        Ring ring = new Ring(30,10,3);
        Geometry3D resu = ring.getGeometry(csg);
        csg.view(resu);

        //Remember to make the holeSize a little bit bigger than the brickSize
        //Board   - it doesnt work otherwise
        org.example.Board board = new org.example.Board(30.5,5,10);
        Geometry3D res2 = board.getGeometry(csg);
        csg.view(res2);
   }
}