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
//singleton
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
		SpriteList.put(Name.VOITURE1_NAME, packageImage(Name.VOITURE1));
		SpriteList.put(Name.VOITURE2_NAME, packageImage(Name.VOITURE2));
		SpriteList.put(Name.VOITURE3_NAME, packageImage(Name.VOITURE3));
		SpriteList.put(Name.VOITURE4_NAME, packageImage(Name.VOITURE4));
		SpriteList.put(Name.VOITURE6_NAME, packageImage(Name.VOITURE6));
		SpriteList.put(Name.VOITURE7_NAME, packageImage(Name.VOITURE7));
		SpriteList.put(Name.VOITURE8_NAME, packageImage(Name.VOITURE8));
		SpriteList.put(Name.VOITURE9_NAME, packageImage(Name.VOITURE9));
		SpriteList.put(Name.ARRIVAL_NAME, packageImage(Name.ARRIVAL));
		SpriteList.put(Name.ROCK_NAME, packageImage(Name.ROCK));
		SpriteList.put(Name.WATER_NAME, packageImage(Name.WATER));


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
