package me.guntxjakka.mccalc.lib;

import static java.lang.Math.round;

public class NumberOps {
    public static boolean checkIfNumberIsInt(Double num){
        int roundedNum = num.intValue();
        Boolean returnValue = false;
        if (roundedNum == num){
            returnValue = true;
        }
        return returnValue;
    }
}
