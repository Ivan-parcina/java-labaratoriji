import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyColorTest {

    @Test
    void testDecodeValid() {
        String hex = "0xFFFFFF";

        var color = MyColor.decode(hex);

        assertEquals(255, color.getR());
        assertEquals(255, color.getG());
        assertEquals(255, color.getB());
    }

    @Test
    void RGBtoHSB() {
        float[] hsb = new float[3];
        float[] act = MyColor.RGBtoHSB(31, 240,255, hsb);

        float[] exp = new float[] {184.01784f / 360f, 87.84314f / 100f, 1.0f};

        assertArrayEquals(exp, act, 0.00001f);
    }

    @Test
    void RGBtoHSL() {
        float[] hsl = new float[3];
        float[] act = MyColor.RGBtoHSL(31, 240,255, hsl);

        float[] exp = new float[] {184.01787f / 360f, 1.0f, 56.078434f / 100f};

        assertArrayEquals(exp, act, 0.00001f);
    }

    @Test
    void RGBtoCMYK() {
        float[] cmyk = new float[4];
        MyColor.RGBtoCMYK(31, 240, 255, cmyk);

        float[] expected = new float[] {87.84314f / 100f, 5.882353f / 100f, 0.0f / 100f, 0.0f / 100f};

        assertArrayEquals(expected, cmyk, 0.00001f);
    }
}