package org.example;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class Board {
    private double boardLength;
    private final double holeSize;
    private final double height;
    private final double width;

    public Board(double holeSize, double width, double height) {
        this.holeSize = holeSize;
        this.height = height;
        this.width = width;
    }

    public Geometry3D getGeometry(JavaCSG csg) {
        //The grid is carved into the board - Unifies the board and the lines, and only shows the differences (where the lines do not intersect)
        //Geometry3D res = csg.difference3D(geoBoard(csg), getArms(csg));

        //Only shows the grid - Unifies the board and the lines, and only shows the intersection of the lines
        //Geometry3D res = csg.intersection3D(geoBoard(csg), getArms(csg));

        //Bottom plate with extruding grid - Unifies the board and the lines, and shows all of it
        Geometry3D res = csg.union3D(geoBoard(csg), getArms(csg));
        return res;
    }

    public Geometry3D geoBoard(JavaCSG csg) {
        //Sets the size and placement of the board
        Geometry3D rect = csg.box3D(getBoardLength(), getBoardLength(), height, true);
        return rect;
    }

    public double getBoardLength() {
        boardLength = (4 * width) + (3 * holeSize);
        return boardLength;
    }

    private Geometry3D getBoardArm1(JavaCSG csg) {
        //Decides the arms size - and used in ArmPlace
        Geometry3D boardArm = csg.box3D(getBoardLength() - width, 0.5 * width, height, false);
        //Decides the arms placement
        Geometry3D ArmPlace = csg.translate3D(0, 0.16 * boardLength, 0).transform(boardArm);
        return ArmPlace;
    }

    private Geometry3D getBoardArm2(JavaCSG csg) {
        //Same as getBoardArm1
        Geometry3D boardArm = csg.box3D(getBoardLength() - width, 0.5 * width, height, false);
        Geometry3D ArmPlace = csg.translate3D(0, -0.16 * boardLength, 0).transform(boardArm);
        return ArmPlace;
    }

    private Geometry3D getBoardArm3(JavaCSG csg) {
        //Same as getBoardArm1
        Geometry3D boardArm = csg.box3D(0.5 * width, getBoardLength() - width, height, false);
        Geometry3D ArmPlace = csg.translate3D(0.16 * boardLength, holeSize - holeSize, 0).transform(boardArm);
        return ArmPlace;
    }

    private Geometry3D getBoardArm4(JavaCSG csg) {
        //Same as getBoardArm1
        Geometry3D boardArm = csg.box3D(0.5 * width, getBoardLength() - width, height, false);
        Geometry3D ArmPlace = csg.translate3D(-0.16 * boardLength, holeSize - holeSize, 0).transform(boardArm);
        return ArmPlace;
    }

    private Geometry3D getBoarderLine(JavaCSG csg) {
        //BorderLines - the ones called P# decides the placements
        Geometry3D boardLine1 = csg.box3D(0.5 * width, getBoardLength() - width, height, false);
        Geometry3D boardLineP1 = csg.translate3D(-0.475 * boardLength, holeSize - holeSize, 0).transform(boardLine1);
        Geometry3D boardLine2 = csg.box3D(0.5 * width, getBoardLength() - width, height, false);
        Geometry3D boardLineP2 = csg.translate3D(0.475 * boardLength, holeSize - holeSize, 0).transform(boardLine2);
        Geometry3D boardLine3 = csg.box3D(getBoardLength() - width, 0.5 * width, height, false);
        Geometry3D boardLineP3 = csg.translate3D(0, 0.475 * boardLength, 0).transform(boardLine3);
        Geometry3D boardLine4 = csg.box3D(getBoardLength() - width, 0.5 * width, height, false);
        Geometry3D boardLineP4 = csg.translate3D(0, -0.475 * boardLength, 0).transform(boardLine4);

        //Unifies the borderline
        Geometry3D Lines1 = csg.union3D(boardLineP1, boardLineP2);
        Geometry3D Lines2 = csg.union3D(boardLineP3, boardLineP4);
        Geometry3D Lines = csg.union3D(Lines1, Lines2);
        return Lines;
    }

    private Geometry3D getArm13(JavaCSG csg) {
        //Unifies getBoardArm1 and getBoardArm3
        Geometry3D Arm13 = csg.union3D(getBoardArm1(csg), getBoardArm3(csg));
        return Arm13;
    }

    private Geometry3D getArm24(JavaCSG csg) {
        //Unifies getBoardArm2 and getBoardArm4
        Geometry3D Arm24 = csg.union3D(getBoardArm2(csg), getBoardArm4(csg));
        return Arm24;
    }

    private Geometry3D getArms(JavaCSG csg) {
        //Unifies getArm13() and getArm24()
        Geometry3D Arms = csg.union3D(getArm13(csg), getArm24(csg));
        //Unifies arms and borderlines
        Geometry3D ArmsAndLines = csg.union3D(Arms, getBoarderLine(csg));
        return ArmsAndLines;
    }
}