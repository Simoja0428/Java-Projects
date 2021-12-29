import java.util.*; //Import statement needed for the Array List and its methods
import java.io.*;

public class Icon 
{
    private ArrayList<ArrayList<Pixel>> grid; //Creates a 2D grid of Pixels by using 2 array lists
    private int height; //Variable used to hold the height of the grid
    private int width; //Variable used to hold the width of the grid
    private int gridPadding;

    public Icon() //Default constructor for the Icon class
    {
        grid = new ArrayList<ArrayList<Pixel>>(); //Fills grid creating ArrayList on the heap
        height = 40; //Sets default height of grid to be 40
        width = 40; //Sets default width of grid to be 40
        gridPadding = (4 - (width * 3) % 4) % 4;

        for (int i = 0; i < height; i++) 
        {
            grid.add(new ArrayList<Pixel>()); //Adds new array list to create second dimension
            
            for (int r  = 0; r < width; r++)
                grid.get(i).add(new Pixel()); //Fills the created ArrayList with pixels
        }
    }

    public Icon(int row, int col) //Specific constructor for Icon class with user inputs
    {
        grid = new ArrayList<ArrayList<Pixel>>(); //Fills grid creating ArrayList on the heap
        height = row; //Sets the height to be the amount of rows the user wants
        width = col; //Sets the width to be the amount of columns user wants
        gridPadding = (4 - (width * 3) % 4) % 4;

        for (int i = 0; i < height; i++)
        {
            grid.add(new ArrayList<Pixel>()); //Adds new array list to create second dimension
            
            for (int r  = 0; r < width; r++)
                grid.get(i).add(new Pixel()); //Fills the created ArrayList with pixels
        }
    }

    public int getHeight() //Method used to return the height for testing purposes in App.java
    {
        return height; //Returns private variable holding height of Icon
    }

    public int getWidth() //Method used to return the width for testing purposes in App.java
    {
        return width; //Returns private variable holding width of Icon
    }

    public int getRGB(int row, int col) //Method used to return the RGB value of a specfic pixel in the grid
    {
        return grid.get(row).get(col).getColorValue(); //Returns the RGB value of the pixel in the grid
    }

    public int getIconRed(int row, int col) //Method used to return the red value of a specfic pixel in the grid
    {
        return grid.get(row).get(col).getRed(); //Returns the red value of the pixel in the grid
    }

    public int getIconGreen(int row, int col) //Method used to return the green value of a specfic pixel in the grid
    {
        return grid.get(row).get(col).getGreen(); //Returns the green value of the pixel in the grid
    }

    public int getIconBlue(int row, int col) //Method used to return the blue value of a specfic pixel in the grid
    {
        return grid.get(row).get(col).getBlue(); //Returns the blue value of the pixel in the grid
    }

    public void setRGB(int row, int col, int red, int green, int blue) //Method used to set the RGB value of a specfic pixel in the grid
    {
        grid.get(row).get(col).setRed(red); //Sets the value of the red in the RGB value of a specific pixel
        grid.get(row).get(col).setGreen(green); //Sets the value of the green in the RGB value of a specific pixel
        grid.get(row).get(col).setBlue(blue); //Sets the value of the blue in the RGB value of a specific pixel
    }

    public void setRed(int row, int col, int red) //Method used to set the red value of a specfic pixel in the grid
    {
        grid.get(row).get(col).setRed(red); //Sets the value of the red in the RGB value of a specific pixel
    }

    public void setGreen(int row, int col, int green) //Method used to set the green value of a specfic pixel in the grid
    {
        grid.get(row).get(col).setGreen(green); //Sets the value of the green in the RGB value of a specific pixel
    }

    public void setBlue(int row, int col, int blue) //Method used to set the blue value of a specfic pixel in the grid
    {
        grid.get(row).get(col).setBlue(blue); //Sets the value of the blue in the RGB value of a specific pixel
    }

    public String toString() //Method toString() which returns all the hex values as a grid form in a String variable
    {
        String pixelData = ""; //Initializes variable which will hold all the hexvalues

        for (int r = 0; r < height; r++)
        {
            for(int c = 0; c < width; c++)
                pixelData += grid.get(r).get(c).toStringHex(grid.get(r).get(c).getColorValue()) + " "; //Adds the hex value plus a space for each index in the row into a string
            pixelData += "\n"; //Adds a new line to pixelData variable as you are at the end of the row
        }
        return pixelData; //Returns this new string formatted grid
    }

    public void createFile() //Method called to create header and eventually bitmap file
    {
        int sizeOfFile = 3 * ((width + gridPadding) * height) + 54; //Calculates the size of the file using formula 
        ArrayList<Byte> bytes = new ArrayList<Byte>(); //Creates an ArrayList of bytes which we will use to fill with all the info for our file
        int res = 2835; //The resolution is stored in here
        int headSize = 0x28; //Size of header 40 bytes (0x28 in hex)

        bytes.add((byte)'B'); //Stores the ID field
        bytes.add((byte)'M');

        bytes.add((byte)sizeOfFile);//Stores the size of the file
        bytes.add((byte)(sizeOfFile>>8));
        bytes.add((byte)(sizeOfFile>>16));
        bytes.add((byte)(sizeOfFile>>24));

        for(int o = 0; o < 4; o++) 
            bytes.add((byte)0);
        bytes.add((byte)54); //Adds the offsets of the pixel array
        for (int v = 0; v < 3; v++)
            bytes.add((byte) 0);

        bytes.add((byte)headSize);//Stores the size of the header which is 40
        bytes.add((byte)(headSize>>8));
        bytes.add((byte)(headSize >> 16));
        bytes.add((byte)(headSize >> 24));

        bytes.add((byte) width);//Stores the width of the array
        bytes.add((byte) (width >> 8));
        bytes.add((byte) (width >> 16));
        bytes.add((byte) (width >> 24));

        bytes.add((byte) height);//Stores the height of the arrau
        bytes.add((byte) (height >> 8));
        bytes.add((byte) (height >> 16));
        bytes.add((byte) (height >> 24));

        bytes.add((byte)1);//Adds number of color panes
        bytes.add((byte)(1>>8));
        bytes.add((byte)24);//Adds number of bits per pixel, its a short and is 24
        bytes.add((byte)(24>>8));

        for (int p = 0; p < 4; p++)
            bytes.add((byte)0);//Start of compression method, which is 0 stored in an int
        
        int compSizeOfFile = sizeOfFile - 54; //Creates a new file size for the compressed file

        bytes.add((byte) compSizeOfFile);// Stores the size of the newly compressed file
        bytes.add((byte) (compSizeOfFile >> 8));
        bytes.add((byte) (compSizeOfFile >> 16));
        bytes.add((byte) (compSizeOfFile >> 24));

        for(int d = 0; d < 2; d++) //Loops through adding in the red's height and then width
        {
            bytes.add((byte)res); 
            bytes.add((byte) (res>>8));
            bytes.add((byte) (res >> 16));
            bytes.add((byte) (res >> 24));
        }
        for (int i = 0; i < 8; i++) //Loops through adding in number of colors in color paletter
            bytes.add((byte) 0);

        
        for (int i = height - 1; i >= 0; i--)
        {
            for (int r = 0; r < width; r++)
            {
                bytes.add((byte)grid.get(i).get(r).getRed()); //Adds the red from the specific pixel 
                bytes.add((byte)grid.get(i).get(r).getGreen()); //Adds the green from the specific pixel
                bytes.add((byte)grid.get(i).get(r).getBlue()); //Adds the blue from the specific pixel
            }
            for (int e = 0 ; e < gridPadding; e++)
                bytes.add((byte)0); //This is where the padding is added in that is calculated
        }

        convertToFile(bytes); //Calls on the convertToFile() method which inputs our header info and creates the rest of the file
    }

    public void convertToFile(ArrayList<Byte> headerInfo) //Converts all the info in our ArrayList into a file
    {
        byte[] info = new byte[headerInfo.size()]; //Creates an array that is the size of the ArrayList of info
        OutputStream out = null; //Creates an OutputStream and intializes it as null
        File myFile = new File("p1.bmp"); //Creates a new file, the String input is the name

        for(int i=0; i<headerInfo.size();i++) //Loops through setting each index in array to its respective in the array list
            info[i]=headerInfo.get(i);

        try 
        {
            if(!myFile.exists()) //Checks to see if the file doesn't exist already
                myFile.createNewFile(); //Creates new file using createNewFile() on pixelFile

            out = new FileOutputStream(myFile); //Sets the outputstream from above
            out.write(info); //Calls on the write() from outputstream to write the info in our byte[] to the file
            out.flush(); //Clears outputstream forcing anything remaining written to the file

        }
        catch(IOException e)
        {
            System.out.println("Exception: " + e); //Prints out that an exception has occured
            try
            {
                if(out != null) //Attempts to close the outputstream since it was opened
                    out.close();
            }
            catch(Exception e2)
            {
                System.out.println("Exception: " + e2); //Throws another exception if we cant close the output stream
            }
        }
    }
}
