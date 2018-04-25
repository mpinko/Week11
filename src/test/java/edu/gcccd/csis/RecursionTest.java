package edu.gcccd.csis;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;
import static org.junit.Assert.*;

public class RecursionTest {

    @Test
    public void printEveryOther() {
        final int[] toTest = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] nothing = {};

        //when k < 0
        boolean isException = false;
        try {
            Recursion.printEveryOther(toTest, -1);
        } catch(IllegalArgumentException e){
            isException = true;
        }
        assertTrue(isException);

        //when nothing is in the array
        isException = false;
        try{
            Recursion.printEveryOther(nothing, 0);
        } catch(IllegalArgumentException e){
            isException = true;
        }
        assertTrue(isException);

        //when everything is normal
        assertEquals(Recursion.printEveryOther(toTest, 0), "97531");
        assertEquals(Recursion.printEveryOther(toTest, 2), "9753");
        assertEquals(Recursion.printEveryOther(toTest, 9), "10");
        assertEquals(Recursion.printEveryOther(toTest, 10), "");
    }

    @Test
    public void printStars() {
        String toTest = "Mississippi";
        String nothing = "";
        String onlyOne = "a";

        assertEquals(Recursion.printStars(nothing), "");
        assertEquals(Recursion.printStars(onlyOne), "a");
        assertEquals(Recursion.printStars(toTest), "Mis*sis*sip*pi");
    }

    /*
     * we know the sum of the 1st k positive numbers is n(n+1)2
     */
    @Test
    public void sum() {
        for (int i = 0; i < 10; i++) {
            int k = new Random().nextInt(100);
            assertEquals(k * (k + 1) / 2, Recursion.sum(k));
        }
        // corner cases
        assertEquals(0, Recursion.sum(-1));
        assertEquals(0, Recursion.sum(0));
        try {
            int x = Recursion.sum(Integer.MAX_VALUE); // stackoverflow
            fail();
        } catch (StackOverflowError error) {
            assertTrue(true);
        }
    }
}