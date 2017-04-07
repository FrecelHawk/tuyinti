package org.tuyinti.utils;

import android.os.Handler;

/**
 * @ClassName: DelayHandler
 * @Description: TODO  延迟处理工具
 * @author FH 
 * @date 2015年7月29日 下午3:56:02
 * 
*/

public class DelayedHandler {

	
	public static void  execute(Runnable run,long delayMillis){
		new Handler().postDelayed(run, delayMillis);
	}
}
