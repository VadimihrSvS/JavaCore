package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        while(degrees > 315){
            degrees -= 360;
        }
        while (degrees < 0){
            degrees += 360;
        }
       switch(degrees){
           case 0 :
               return N;
           case 45 :
               return NE;
           case 90 :
               return E;
           case 135 :
               return SE;
           case 180 :
               return S;
           case 225 :
               return SW;
           case 270 :
               return W;
           case 315 :
               return NW;
           default:
               return null;
       }
    }

    public static Direction closestToDegrees(int degrees) {
        while (degrees > 315) {
            degrees -= 360;
        }
        while (degrees < 0) {
            degrees += 360;
        }
        if (degrees <= 23)
            return N;
        if (degrees <= 68)
            return NE;
        if (degrees <= 113)
            return E;
        if (degrees <= 158)
            return SE;
        if (degrees <= 203)
            return S;
        if (degrees <= 248)
            return SW;
        if (degrees <= 293)
            return W;
        if (degrees <= 343)
            return NW;
        if(degrees >= 344){
            return N;
        }
        return null;
    }

    public Direction opposite() {
       return ofDegrees(degrees - 180);
    }

    public int differenceDegreesTo(Direction direction) {

        if(direction == NW && degrees == 0){
            return 45;
        }

        return Math.abs(direction.degrees - degrees);
    }
}
