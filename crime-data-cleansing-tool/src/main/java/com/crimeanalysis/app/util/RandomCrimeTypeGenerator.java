package com.crimeanalysis.app.util;

import java.util.Random;

public class RandomCrimeTypeGenerator {
	
	public String getRandomCrimeType()
	{
		String crimeType=null;
		int x=(int)( Math.random()*10);
		switch (x) {
		case 0:  crimeType = "Threat";
        		 break;
        case 1:  crimeType = "Robbery";
                 break;
        case 2:  crimeType = "Theft";
                 break;
        case 3:  crimeType = "Assault";
                 break;
        case 4:  crimeType = "Vandalism";
                 break;
        case 5:  crimeType = "Arrest";
                 break;
        case 6:  crimeType = "Arson";
                 break;
        case 7:  crimeType = "Shooting";
                 break;
        case 8:  crimeType = "Accident";
                 break;
        case 9:  crimeType = "Missing Person";
                 break;
        default: crimeType = "Other";
                 break;
    }
		return crimeType;
	}

}
