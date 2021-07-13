package Enemy;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

public class ImageLoader 
{
	private Map<String, Image> imageBank;	//declares a map to hold images
	private static ImageLoader instance;
	
	private ImageLoader()
	{
		imageBank = new TreeMap<String, Image>();	// creates a treeMap
	}
	
	public static ImageLoader getLoader()
	{	
		if(instance == null)
			instance = new ImageLoader();
		return instance;	// gets the image loader object
	}
	
	public Image getImage(String pic)
	{	
		Image loaded = null;
		
		// Prevents and image from being loaded twice
		if(imageBank.containsKey(pic))	// if image is already in the map	
			return imageBank.get(pic);	// return that image
		else
		{
			try
			{
				ClassLoader myLoader = this.getClass().getClassLoader();
		        
				InputStream imageStream = myLoader.getResourceAsStream(pic);
				
				loaded = ImageIO.read(imageStream);
					
			}
			catch (IOException e) {System.out.println ("Could not load: " + e);}
			
			imageBank.put(pic, loaded);	// Adds new key and value to the map
			
			return loaded;	
		}
	}
}