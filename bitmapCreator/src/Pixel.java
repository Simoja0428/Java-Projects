public class Pixel
{
    private int colorValue; //Private variable that holds the RGB value
    private int redMask; //Private variable holds red mask
    private int greenMask; //Private variable holds green mask
    private int blueMask; //Private variable holds blue mask

    public Pixel() //Default constructor for Pixel class
    {
        colorValue = 0; //Sets the RGB value to be 0 to start
        redMask = 0b00000000000000000000000011111111;  //Sets red mask to value in binary
        greenMask = 0b00000000000000001111111100000000; //Sets green mask to value in binary
        blueMask = 0b00000000111111110000000000000000;  //Sets blue mask to value in binary
    }

    public void setRed(int r) //Sets the red portion of the RGB value
    {
        if (r < 0 || r > 255) //If r is not between 0-255 then it returns
            return;
        int blue = colorValue & blueMask; //Creates copy of the value currently in blue section
        int green = colorValue & greenMask; //Creates copy of the value currently in green section
        colorValue = r; //Sets the color value of red which takes up 1st 8 bits
        colorValue += green; //Adds back in the green value to colorValue
        colorValue += blue; //Adds back in the blue value to colorValue
    }

    public int getRed() //Returns the value of the red portion of RGB value
    {
        return (colorValue & redMask); //Returns the value of red by using the bit and operator for the red mask
    }

    public void setGreen(int g) //Sets the green portion of the RGB value
    {
        if (g < 0 || g > 255) //If g is not between 0-255 then it returns
            return;
        int red  = colorValue & redMask;  //Creates copy of the value currently in red section
        int blue = colorValue & blueMask; //Creates copy of the value currently in blue section
        colorValue = red; //Sets color to be red value
        colorValue += (g << 8); //Adds in the new green value making sure it is shift 8 bits
        colorValue += blue; //Adds back in the blue value to colorValue
    }
      

    public int getGreen() //Returns the value of the green portion of RGB value
    {
        int g = colorValue & greenMask; //The value of green by using the bit and operator for the green mask
        return g >> 8; //Returns the value of green which takes up the third 8 bits
    }

    public void setBlue(int b) //Sets the blue portion of the RGB value
    {
        if (b < 0 || b > 255) //If b is not between 0-255 then it returns
            return;
        
        int red = colorValue & redMask; //Creates copy of the value currently in red section
        int green = colorValue & greenMask; //Creates copy of the value currently in green section
        colorValue = red; //Sets color to be red value
        colorValue += green; //Adds back in the green value to colorValue
        colorValue += b << 16; //Adds back in the new blue value making sure to shift it 16 bits
    }

    public int getBlue() //Returns the value of the blue portion of RGB value
    {
        int b = colorValue & blueMask; //The value of blue using the bit and operator for the blue mask
        return b >> 16; //Returns the value of blue which takes up the third 8 bits
    }
    public String toStringHex(int n) //Method returns string hex of the number inputted
    {
        if (n != 0) //If the value of n does not equal 0
            return "#" + Integer.toHexString(n); //Uses the toHexString() in Integer class to convert
        else
            return "#000000"; //Returned if the pixel value is 0
    }

    public int getColorValue() //Gives public access to RGB value
    {
        return colorValue; //Returns private variable containing RGB value
    }
}
