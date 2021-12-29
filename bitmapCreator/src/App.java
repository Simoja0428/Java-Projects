//Jacob Simonek | Object Oriented Programming | Week of: 9/20/21

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Icon icon = new Icon(5,5);
        icon.setRGB(0,0,255,0,0);
        icon.setRGB(0,4,0,255,0);
        icon.setRGB(4,0,0,0,255);
        icon.setRGB(4,4,255,255,255);

        icon.createFile();
        System.out.println(icon);

        /*
        DRIVER USED FOR TESTING DURING DEVELOPMENT

        Pixel p = new Pixel(); //Creates new Pixel

        System.out.println("Default red color value: " + p.getRed()); //Tests default color value for Red
        p.setRed(400); //Sets red to be outside bounds
        System.out.println("Set to outside bounds red color should still be same: " + p.getRed() ); //Checks to make sure red caught the issue
        p.setRed(230); //Sets red to a color in the bounds
        System.out.println("Set value of red should be 230: " + p.getRed() ); //Tests to make sure red was properly set
        
        System.out.println("Default green color value: " + p.getGreen()); //Tests default color value for Green
        p.setGreen(400); //Sets green to be outside bounds
        System.out.println("Set to outside bounds green color should still be same: " + p.getGreen() ); //Checks to make sure green caught the issue
        p.setGreen(150); //Sets green to a color in the bounds
        System.out.println("Set value of green should be 150: " + p.getGreen() ); //Tests to make sure green was properly set
        System.out.println("Set value of red should still be 230: " + p.getRed() ); //Tests to make sure red was unchanged

        System.out.println("Default blue color value: " + p.getBlue()); //Tests default color value for Blue
        p.setBlue(-5); //Sets blue to be outside bounds
        System.out.println("Set to outside bounds blue color should still be same: " + p.getBlue() ); //Checks to make sure blue caught the issue
        p.setBlue(120); //Sets blue to a color in the bounds
        System.out.println("Set value of blue should be 120: " + p.getBlue() ); //Tests to make sure blue was properly set
        System.out.println("Set value of red should still be 230: " + p.getRed() ); //Tests to make sure red was unchanged
        System.out.println("Set value of red should still be 150: " + p.getGreen() ); //Tests to make sure green was unchanged
        
        System.out.println("HexaDecimal Value of RGB: " + p.toStringHex(p.getColorValue())); //Tests the functionality of the to Sting Hex method
        
        Icon i1 = new Icon(); //Creates Icon using default constructor
        Icon i2 = new Icon(10,10); //Creates Icon using inputs constructor

        System.out.println("The default height of default icon is: " + i1.getHeight() ); //Tests to make sure default icon has height of 40
        System.out.println("The default width of default icon is: " + i1.getWidth() ); //Tests to make sure default icon has width of 40
        System.out.println("The default height of special icon should be 10: " + i2.getHeight() ); //Tests to make sure special icon has height of 10
        System.out.println("The default width of special icon should be 10: " + i2.getWidth() ); //Tests to make sure special icon has width of 10
   
        System.out.println("The default Red value of pixel at index (4,3) is: " + i1.getIconRed(4, 3)); //Tests to make sure default red value is 0
        System.out.println("The default Green value of pixel at index (4,3) is: " + i1.getIconGreen(4, 3)); //Tests to make sure default green value is 0
        System.out.println("The default Blue value of pixel at index (4,3) is: " + i1.getIconBlue(4, 3)); //Tests to make sure default blue value is 0
        i1.setRGB(4, 3, 50, 20, 110); //Sets the RGB value of the default icon
        i2.setRGB(4, 3, 50, 20, 110); //Sets the RGB value of the specialized smaller icon
        System.out.println("The changed Red value of pixel at index (4,3) should be 50: " + i1.getIconRed(4, 3)); //Tests to make sure default red value is 50
        System.out.println("The changed Green value of pixel at index (4,3) should be 20: " + i1.getIconGreen(4, 3)); //Tests to make sure default green value is 20
        System.out.println("The changed Blue value of pixel at index (4,3) should be 110: " + i1.getIconBlue(4, 3)); //Tests to make sure default blue value is 110
        System.out.println("Printing out the value of all the hexs as strings: \n" + i2.toString()); //Tests printing out all the hex values for the smaller Icon only one is filled
        i1.createHeader(); //Test creating the bit map file
        System.out.print(i1); //Test printing out the bit map file */
    }
}
