package edu.gcccd.csis;

public class Recursion {

    static String printEveryOther(final int[] ia, final int k) {
        if (k < 0) throw new IllegalArgumentException("index must be greater or equal 0");
        if(ia.length == 0 || ia == null) throw new IllegalArgumentException("there is no array");
        if(ia.length > k)
            return printEveryOther(ia, k+2) + ia[k];
        else
            return "";
    }

    static String printStars(final String s) {
        if(s.length() <= 1 || s==null)
            return s;
        if(s.charAt(0) == s.charAt(1))
            return s.charAt(0) + "*" + printStars(s.substring(1));
        else
            return s.charAt(0) + printStars(s.substring(1));
    }

    static int sum(int k) {
        return k > 0 ? k + sum(k - 1) : 0;
    }

    public static void main(String[] args) {
        System.out.println(printEveryOther(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2));
        System.out.println(printStars("Hellloo"));
        System.out.println(sum(4));
    }
}