package org.tuyinti.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @ClassName: ToastUtil
 * @Description: TODO
 * @author FH 
 * @date 2015年7月29日 下午3:24:00
 * 
*/

public class ToastUtil {


	public static void longShow(Context context,String text){
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}
	
	
	public static void shortShow(Context context,String text){
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
	
}
