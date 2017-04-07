package org.tuyinti.utils;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

/**
 * @ClassName: ValidityUtil
 * @Description: TODO
 * @author FH 
 * @date 2015年7月28日 上午11:15:51
 * 
*/

public class ValidityUtil {

	
	/** 
	 * @author FH
	 * @Description: TODO  限制输入长度
	 * @param editText
	 * @param max void 
	 * @throws:throws
	*/ 
	
	public static void limitInputLength(EditText editText ,int max){
		editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(max)});
	}
	
	
	/** 
	 * @author FH
	 * @Description: TODO   设置输入密码格式
	 * @param editText void 
	 * @throws:throws
	*/ 
	
	public static void  setPasswdFormation(EditText editText){
		editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
	}
}
