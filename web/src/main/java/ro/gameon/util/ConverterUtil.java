package ro.gameon.util;

import sun.org.mozilla.javascript.internal.ast.TryStatement;

/**
 * User: bogdan
 * Date: 2/5/14
 * Time: 9:45 AM
 */
public class ConverterUtil {


	public static final int getIntFromString(String value) {
		Integer ret;
		if (value != null) {
			ret = Integer.parseInt(value);
			if (ret != null) {
				return ret.intValue();
			}
		}

		return 0;
	}


}
