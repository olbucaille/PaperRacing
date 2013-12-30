package vue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import modele.Name;

public class SkinProvider {

	private static SkinProvider instance = null;

	private static Map<String, BufferedImage> SpriteList = null;

	private SkinProvider()
	{
		SpriteList = new HashMap<String, BufferedImage>();


		loadBasicsSkins();


	}

	public static SkinProvider GetInstance()
	{
		if(instance == null)
			instance = new SkinProvider();

		return instance;                
	}


	private void loadBasicsSkins() {
		SpriteList.put(Name.GRASS_NAME, packageImage(Name.GRASS));
		SpriteList.put(Name.ROAD_NAME, packageImage(Name.ROAD));
		SpriteList.put(Name.VOITURE_NAME, packageImage(Name.VOITURE));


	}

	public  BufferedImage	packageImage(String path)
	{
		BufferedImage myPicture= null;
		try {
			myPicture = ImageIO.read(new File(path));

		} catch (IOException e) 
		{}
		return myPicture;
	}


	public BufferedImage SpriteProvider( String Type)
	{
		if(SpriteList.containsKey((String) Type))
			return SpriteList.get((String)Type);        
		else
			return null;

	}

}
