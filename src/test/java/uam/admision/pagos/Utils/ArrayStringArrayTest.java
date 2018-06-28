package uam.admision.pagos.Utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStringArrayTest {
    @Test
    public void testCreaArregloenterodenumeros() {
        ArrayStringArray arrayStringArray = new ArrayStringArray();
        String stringProbar = "1,3,5,7";
        int[] enteros = arrayStringArray.StringToArray(stringProbar);
        int[] enterosResultado = new int[]{1, 3, 5, 7};
        assertArrayEquals("Deben ser iguales", enterosResultado, enteros);
    }
}