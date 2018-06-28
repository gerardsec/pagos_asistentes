package uam.admision.pagos.Utils;

import java.lang.reflect.Array;

public class ArrayStringArray {
    public int[] StringToArray(String stringConvertir) {
        String[] integerStrings = stringConvertir.split(",");
        int[] integers = new int[integerStrings.length];
        for (int i = 0; i < integers.length; i++) {
    integers[i] = Integer.parseInt(integerStrings[i]);
        }
        return integers;
    }

    public String[] StrintToStringArray(String stringConvertir) {
        String[] arrayString=stringConvertir.split(",");
        return arrayString;
    }

}
