/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author lol
 */
public class StringUtil {

    private StringUtil() {

    }

    public static String subInt(String a, String b) {
        try {
            if (a == null || "".equals(a)) {
                a = "0";
            }
            if (b == null || "".equals(b)) {
                b = "0";
            }
            return String.valueOf(Integer.parseInt(a) - Integer.parseInt(b));
        } catch (Exception ex) {
            System.out.println("StringUtil" + ex.getMessage());
        }
        return "";
    }

    public static String subDouble(String a, String b) {
        try {
            if (a == null || "".equals(a)) {
                a = "0";
            }
            if (b == null || "".equals(b)) {
                b = "0";
            }
            return String.valueOf(Double.parseDouble(a) - Double.parseDouble(b));
        } catch (Exception ex) {
            System.out.println("StringUtil" + ex.getMessage());
        }
        return "";
    }

    public static String subFloat(String a, String b) {
        try {
            if (a == null || "".equals(a)) {
                a = "0";
            }
            if (b == null || "".equals(b)) {
                b = "0";
            }
            return String.valueOf(Float.parseFloat(a) - Float.parseFloat(b));
        } catch (Exception ex) {
            System.out.println("StringUtil" + ex.getMessage());
        }
        return "";
    }

    public static String subLong(String a, String b) {
        try {
            if (a == null || "".equals(a)) {
                a = "0";
            }
            if (b == null || "".equals(b)) {
                b = "0";
            }
            return String.valueOf(Long.parseLong(a) - Long.parseLong(b));
        } catch (Exception ex) {
            System.out.println("StringUtil" + ex.getMessage());
        }
        return "";
    }

    public static String addInt(String a, String b) {
        try {
            if (a == null || "".equals(a)) {
                a = "0";
            }
            if (b == null || "".equals(b)) {
                b = "0";
            }
            return String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
        } catch (Exception ex) {
            System.out.println("StringUtil" + ex.getMessage());
        }
        return "";
    }

    public static String addDouble(String a, String b) {
        try {
            if (a == null || "".equals(a)) {
                a = "0";
            }
            if (b == null || "".equals(b)) {
                b = "0";
            }
            return String.valueOf(Double.parseDouble(a) + Double.parseDouble(b));
        } catch (Exception ex) {
            System.out.println("StringUtil" + ex.getMessage());
        }
        return "";
    }

    public static String addFloat(String a, String b) {
        try {
            if (a == null || "".equals(a)) {
                a = "0";
            }
            if (b == null || "".equals(b)) {
                b = "0";
            }
            return String.valueOf(Float.parseFloat(a) + Float.parseFloat(b));
        } catch (Exception ex) {
            System.out.println("StringUtil" + ex.getMessage());
        }
        return "";
    }

    public static String addLong(String a, String b) {
        try {
            if (a == null || "".equals(a)) {
                a = "0";
            }
            if (b == null || "".equals(b)) {
                b = "0";
            }
            return String.valueOf(Long.parseLong(a) + Long.parseLong(b));
        } catch (Exception ex) {
            System.out.println("StringUtil" + ex.getMessage());
        }
        return "";
    }
}
