package org.example;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Board {

    private double boardSize;
    //private final double holeSize;
    private final double holeSizeY;
    private final double holeSizeX;
    private final double height;
    private final double width;

    //boardSize skal være (4*width)+(3*holeSize) på hver side
    public Board(double holeSizeX, double holeSizeY, double width, double height) {
        this.holeSizeY = holeSizeY;
        this.holeSizeX = holeSizeX;
        this.height = height;
        this.width = width;
    }


    public Geometry3D getGeometry(JavaCSG csg) {

        geoBoard(csg);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                double holePosX = i * (width + holeSizeX);
                double holePosY = j * (width + holeSizeY);
                Geometry3D hole = csg.translate3D(holePosX, holePosY, 0).transform(geoHoleSize(csg));
            }
        }
        geoHoleSize(csg);


        //Række 1(?)
        // Geometry3D hole = csg.translate3D(-holeSize,-holeSize,0).transform(geoHoleSize(csg));
        // Geometry3D hole = csg.translate3D(-holeSize,-holeSize-holeSize,0).transform(geoHoleSize(csg));
        // Geometry3D hole = csg.translate3D(-holeSize,holeSize,0).transform(geoHoleSize(csg));

        //2. række
        // Geometry3D hole = csg.translate3D(-holeSizeX + holeSizeX, -holeSizeY, 0).transform(geoHoleSize(csg));
        // Geometry3D hole = csg.translate3D(-holeSize-holeSize,-holeSize-holeSize,0).transform(geoHoleSize(csg));
        // Geometry3D hole = csg.translate3D(-holeSize-holeSize,holeSize,0).transform(geoHoleSize(csg));

        //3. række
        // Geometry3D hole = csg.translate3D(holeSize,-holeSize,0).transform(geoHoleSize(csg));
        // Geometry3D hole = csg.translate3D(holeSize,-holeSize+holeSize,0).transform(geoHoleSize(csg));
        // Geometry3D hole = csg.translate3D(holeSize,holeSize,0).transform(geoHoleSize(csg));

        Geometry3D res = csg.difference3D(geoBoard(csg), hole);
        // Geometry3D res = csg.difference3D(geoBoard(csg), geoHoleSize(csg)); //difference
        // Geometry3D res2 = csg.difference3D(getBoard(csg), geHoleSize(csg)); //difference
        return res;
    }

    public Geometry3D geoBoard(JavaCSG csg) {
        Geometry3D rect = csg.box3D(getBoardSize(), getBoardSize(), height, true);
        return rect;
    }

    public double getBoardSize() {
        boardSize = (4 * width) + (3 * holeSizeX);
        return boardSize;
    }

    private Geometry3D geoHoleSize(JavaCSG csg) {
        Geometry3D rect = csg.box3D(holeSizeX, holeSizeY, height - 3, false);
        //Geometry3D rect2 = csg.box3D(holeSize,holeSize-(holeSize)+width,height-3,false);
        //Geometry3D rect3  = csg.rotate3D(csg.degrees(45),csg.degrees(45),csg.degrees(45)).transform(rect);
        return rect;
    }

}