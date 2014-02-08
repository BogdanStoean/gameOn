package ro.gameon.util;

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

	public static final Long getLongFromString(String value) {
		Long ret = null;
		if (value != null && !value.equals("")) {
			ret = Long.parseLong(value);
			if (ret != null) {
				return ret;
			}
		}

		return ret;
	}

	public static final Double getDoubleFromString(String value) {
		Double ret = null;
		if (value != null && !value.equals("")) {
			ret = Double.parseDouble(value);
			if (ret != null) {
				return ret;
			}
		}

		return ret;
	}

}
