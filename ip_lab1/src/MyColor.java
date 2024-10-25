
public class MyColor {
    int r, g, b;

    public MyColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getRGB() {
        return (r << 16) | (g << 8) | b;
    }

//  red
    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }

//  green
    public int getG() {
        return g;
    }
    public void setG(int g) {
        this.g = g;
    }

//  blue
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }

    public static MyColor decode(String nm) throws NumberFormatException {
        Integer intval = Integer.decode(nm);
        int i = intval.intValue();
        return new MyColor((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);
    }

    public static float[] RGBtoHSB(int r, int g, int b, float[] hsbvals) {
        float hue, saturation, brightness;
        if (hsbvals == null) {
            hsbvals = new float[3];
        }
        int cmax = (r > g) ? r : g;
        if (b > cmax) cmax = b;
        int cmin = (r < g) ? r : g;
        if (b < cmin) cmin = b;

        brightness = ((float) cmax) / 255.0f;
        if (cmax != 0)
            saturation = ((float) (cmax - cmin)) / ((float) cmax);
        else
            saturation = 0;
        if (saturation == 0)
            hue = 0;
        else {
            float redc = ((float) (cmax - r)) / ((float) (cmax - cmin));
            float greenc = ((float) (cmax - g)) / ((float) (cmax - cmin));
            float bluec = ((float) (cmax - b)) / ((float) (cmax - cmin));
            if (r == cmax)
                hue = bluec - greenc;
            else if (g == cmax)
                hue = 2.0f + redc - bluec;
            else
                hue = 4.0f + greenc - redc;
            hue = hue / 6.0f;
            if (hue < 0)
                hue = hue + 1.0f;
        }
        hsbvals[0] = hue;
        hsbvals[1] = saturation;
        hsbvals[2] = brightness;
        return hsbvals;
    }

    public static float[] RGBtoHSL(int r, int g, int b, float[] hslvals) {
        float hue, saturation, lightness;

        if (hslvals == null) {
            hslvals = new float[3];
        }

        float rNorm = r / 255.0f;
        float gNorm = g / 255.0f;
        float bNorm = b / 255.0f;

        float cmax = Math.max(rNorm, Math.max(gNorm, bNorm));
        float cmin = Math.min(rNorm, Math.min(gNorm, bNorm));
        float delta = cmax - cmin;

        lightness = (cmax + cmin) / 2.0f;

        if (delta == 0) {
            saturation = 0;
            hue = 0;
        } else {
            if (lightness > 0.5f)
                saturation = delta / (2.0f - cmax - cmin);
            else
                saturation = delta / (cmax + cmin);

            if (cmax == rNorm)
                hue = ((gNorm - bNorm) / delta) % 6;
            else if (cmax == gNorm)
                hue = ((bNorm - rNorm) / delta) + 2;
            else
                hue = ((rNorm - gNorm) / delta) + 4;

            hue = hue * (1 / 6f);
        }

        hslvals[0] = hue;
        hslvals[1] = saturation;
        hslvals[2] = lightness;
        return hslvals;
    }

    public static void RGBtoCMYK(int r, int g, int b, float[] cmyk) {
        float cyan, magenta, yellow, black;

        if(cmyk == null){
            cmyk = new float[4];
        }

        float rNorm = r / 255.0f;
        float gNorm = g / 255.0f;
        float bNorm = b / 255.0f;

        black = 1 - Math.max(rNorm, Math.max(gNorm, bNorm));
        cyan = (1 - rNorm - black) / (1 - black);
        magenta = (1 - gNorm - black) / (1 - black);
        yellow = (1 - bNorm - black) / (1 - black);

        cmyk[0] = cyan;
        cmyk[1] = magenta;
        cmyk[2] = yellow;
        cmyk[3] = black;
    }

}
