import java.awt.*;

public class MyColorConverter {
    public static void main(String[] args) {

        String hexColor = "0x1FF0FF";

        MyColor c = MyColor.decode(hexColor);

        float[] hsb = new float[3];
        float[] hsl = new float[3];
        float[] cmyk = new float[4];

        MyColor.RGBtoHSB(c.getR(), c.getG(), c.getB(), hsb);
        System.out.println("Boja u HEX formatu: 0x" +
                Integer.toHexString(c.getRGB() & 0x00FFFFFF));

        System.out.println("Boja u HSB formatu: " + hsb[0] * 360 + "°, " +
                hsb[1] * 100 + "%, " + hsb[2] * 100 + "%");

        System.out.println("Boja u RGB formatu: " + c.getR() + ", " +
                c.getG() + ", " + c.getB());

        MyColor.RGBtoHSL(c.getR(), c.getG(), c.getB(), hsl);
        System.out.println("Boja u HSL formatu: " + hsl[0] * 360 + "°, " +
                hsl[1] * 100 + "%, " + hsl[2] * 100 + "%");

        MyColor.RGBtoCMYK(c.getR(), c.getG(), c.getB(), cmyk);
        System.out.println("Boja u CMYK formatu: " + cmyk[0] * 100 + "%, " +
                cmyk[1] * 100 + "%, " + cmyk[2] * 100 + "%, " + cmyk[3] * 100 + "%");
    }
}
