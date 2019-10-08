package com.csair.cbs.util;
/**
* @author can 
* @comment 
* @version 创建时间：2017年10月16日 上午11:03:00
* 
*/
import java.util.Locale;
import java.util.ResourceBundle;

public class MessagesUtils {
	private static final String PROPS_MESSAGE = "i18n.messages";
	private static ResourceBundle bundleCN=ResourceBundle.getBundle(PROPS_MESSAGE,new Locale("zh","CN"));
	private static ResourceBundle bundleEN=ResourceBundle.getBundle(PROPS_MESSAGE,new Locale("en","US"));
	private static ResourceBundle bundleKO=ResourceBundle.getBundle(PROPS_MESSAGE,new Locale("ko","KO")); //韩文 add by czh 20170512
	
	/**
	 * 
	 * @param lang
	 * @return
	 */
	public static ResourceBundle getResourceBundle(String lang){
		//update by czh 20170512 增加韩文提示语
		if("en".equals(lang)){
			return bundleEN;
		}else if("ko".equals(lang)){
			return bundleKO;
		}else{
			return bundleCN;
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param lang
	 * @return
	 */
	public static String getString(String key,String lang){
		return getResourceBundle(lang).getString(key);
	}
	
}
