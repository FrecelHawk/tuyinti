package org.tuyinti.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.graphics.drawable.Drawable;
import cn.caregg.o2o.business.app.BusinessApplication;

/**
 * ResourceUtils
 */
public class ResourceUtils {
	
	//************************************************ Assets values************************************************************//
    public static String getFileFromAssets(String fileName) {
        if (fileName.equals("")) {
            return null;
        }

        StringBuilder s = new StringBuilder("");
        try {
            InputStreamReader in = new InputStreamReader(BusinessApplication.mContext.getResources().getAssets().open(fileName));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                s.append(line);
            }
            return s.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    
  //************************************************ Raw values************************************************************//
    public static String getFileFromRaw(int id) {

    	StringBuilder s = new StringBuilder();
        try {
            InputStreamReader in = new InputStreamReader(BusinessApplication.mContext.getResources().openRawResource(id));
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                s.append(line);
            }
            return s.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
	//************************************************ string values************************************************************//
	
	public static String getString(int id){
		return BusinessApplication.mContext.getResources().getString(id);
	}
	

	
	//************************************************ colors values************************************************************//
	
	public static int getColor(int id) {
		return BusinessApplication.mContext.getResources().getColor(id);
	}
	
	//************************************************ arrays values************************************************************//
	
	public static String[] getStringArray(int id){
		return BusinessApplication.mContext.getResources().getStringArray(id);
	}
	
	public static int[] getIntArray(int id){
		return BusinessApplication.mContext.getResources().getIntArray(id);
	}
	
	public static String  getStringFormat(int id,Object... formatArgs){
		return BusinessApplication.mContext.getResources().getString(id, formatArgs);
	}
	
	//************************************************ dimens values************************************************************//
	
	public static float getDimens(int id){
		return BusinessApplication.mContext.getResources().getDimension(id);
	}

	//************************************************ Drawable values************************************************************//
	
	public static Drawable getDrawable(int id) {
		return BusinessApplication.mContext.getResources().getDrawable(id);
	}
	
	
}
