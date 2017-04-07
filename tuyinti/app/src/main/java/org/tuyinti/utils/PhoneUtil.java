package org.tuyinti.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import cn.caregg.o2o.business.app.BusinessApplication;
import cn.caregg.o2o.business.config.ConstantValues;

import com.lidroid.xutils.util.LogUtils;

/**
 * @ClassName: PhoneUtil
 * @Description: TODO
 * @author FH 
 * @date 2015年6月30日 下午4:31:06
 * 
*/

public class PhoneUtil {

	public static String getTVIMEI(Context ctx, String phoneNumber) {
		StringBuffer buffer = new StringBuffer("");
		buffer.append(getImei(ctx));
		buffer.append(getWlanMac(ctx));
		buffer.append(getBTMac(ctx));
		buffer.append(phoneNumber);
		return StringUtils.str2MD5(buffer.toString());
	}
	
   public static String getTVIMEI(Context ctx) {
		
		if(StringUtils.isEmpty(BusinessApplication.serviceOrgEToken)){
			StringBuffer buffer = new StringBuffer("");
			buffer.append(getImei(ctx));
			buffer.append(getWlanMac(ctx));
			buffer.append(getBTMac(ctx));
			BusinessApplication.serviceOrgEToken = StringUtils.str2MD5(buffer.toString());
		}

		return BusinessApplication.serviceOrgEToken;
	}
	
   /**
	 * @Title: getImei
	 * @Description: 拿手机IMEI
	 * @return String 返回类型
	 */
	public static String getImei(Context ctx) {
		if (null == ctx) {
			LogUtils.e(" Context is null ");
			return null;
		}
		String imei = null;
		try {
			imei = (String) PreferencesUtils.getString(ctx, ConstantValues.IMEI);
			if (StringUtils.isEmpty(imei)) {
				TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Context.TELEPHONY_SERVICE);
				imei = tm.getDeviceId();
				PreferencesUtils.putString(ctx, ConstantValues.IMEI, imei);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtils.d("getImei error!");
		}
		LogUtils.d(" string imei = " + imei);
		return imei;
	}
	
	/**
	 * @Title: getWLANMac
	 * @Description: 获取mac地址
	 * @param ctx
	 *            上下文对象
	 * @return String 返回类型
	 */
	public static String getWlanMac(Context ctx) {
		if (null == ctx) {
			LogUtils.e(" Context is null ");
			return null;
		}
		String wlanMac = (String) PreferencesUtils.getString(ctx, ConstantValues.WLAN_MAC);
		if (StringUtils.isEmpty(wlanMac)) {
			WifiManager wifiManager = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
			if (null == wifiManager) {
				LogUtils.e(" WifiManager is null ");
				return wlanMac;
			}
			WifiInfo info = wifiManager.getConnectionInfo();
			if (info == null) {
				LogUtils.e(" WifiInfo is null ");
				return wlanMac;
			}
			wlanMac = info.getMacAddress();
			PreferencesUtils.putString(ctx, ConstantValues.WLAN_MAC, wlanMac);
		}
		LogUtils.d(" string mac = " + wlanMac);
		return wlanMac;
	}
	
	
	/**
	 * @Title: getBTMac
	 * @Description: 获取mac地址
	 * @param ctx
	 *            上下文对象
	 * @return String 返回类型
	 */
	public static String getBTMac(Context ctx) {
		if (null == ctx) {
			LogUtils.e(" Context is null ");
			return null;
		}
		String btMac = (String) PreferencesUtils.getString(ctx, ConstantValues.BT_MAC);
		if (StringUtils.isEmpty(btMac)) {
			BluetoothAdapter btManager = BluetoothAdapter.getDefaultAdapter();
			if (null == btManager) {
				LogUtils.e(" BluetoothAdapter is null ");
				return btMac;
			} else {
				btMac = btManager.getAddress();
				PreferencesUtils.putString(ctx, ConstantValues.WLAN_MAC, btMac);
			}
		}
		LogUtils.d(" string BTMac = " + btMac);
		return btMac;
	}
   
	/** 
	 * @author FH
	 * @Description: TODO  使用默认浏览器加载路径
	 * @throws:throws
	*/ 
	
	public static void defaultBrowserOpen(String url,Context context){
		Intent intent = new Intent();
		intent.setAction("android.intent.action.VIEW");
		intent.setData(Uri.parse(url));
		context.startActivity(intent);
	}
	
	
	/** 
	 * @author FH
	 * @Description: TODO  打电话
	 * @param context  控件
	 * @param mobile   手机号码
	 * @throws:throws
	*/ 
	
	public static void callPhone(Context context,String mobile){
		try{
			Intent i = new Intent("android.intent.action.CALL");
			i.setData(Uri.parse("tel:"+mobile));
			context.startActivity(i);
		}catch(Exception e){
			e.printStackTrace();
			new Exception("call phone exception!");
		}
	}
	
}
