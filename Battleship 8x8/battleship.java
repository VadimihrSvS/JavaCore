package com.epam.rd.autotasks;

import java.util.ArrayList;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;
    private String map;

    public Battleship8x8(final long ships) {
        this.ships = ships;
        map = Long.toBinaryString(ships);
    }

    public boolean shoot(String shot) {
       char[] letters = shot.toCharArray();
       int charLength = map.length();
       if(charLength < 64){
           for(int i = 0; i < 64 - charLength; i++){
               map = "0" + map;
           }
       }
       int indexOfLetter = (letters[0] - 64);
       int indexOfNumber = Integer.parseInt(Character.toString(letters[1]));
       int finalIndex = (indexOfNumber - 1) * 8 + indexOfLetter;
       if(map.charAt(finalIndex - 1) == '1'){
           map = map.substring(0, finalIndex - 1) + "☒" + map.substring(finalIndex);
           return true;
       } else if(map.charAt(finalIndex - 1) == '0'){
           map = map.substring(0, finalIndex - 1) + "×" + map.substring(finalIndex);
           return false;
       }
       return true;
    }

    public String state() {
        ArrayList<String> list = new ArrayList<>();
        map = map.replaceAll("1", "☐");
        map = map.replaceAll("0", ".");
        list.add(map.substring(0, 8));
        int length = map.length();
        for(int i = 1; i < 8; i++) {
            list.add(map.substring(0 + (i * 8) , 8 + (i * 8)));
        }
        return String.join("\n", list);
    }
}
