package br.com.etzero.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FNum {
	public static double round(double value) {
		BigDecimal bd = new BigDecimal(value).setScale(3, RoundingMode.UP);

		return bd.doubleValue();

	}

	public static double round(double value, int scale) {
		BigDecimal bd = new BigDecimal(value).setScale(scale, RoundingMode.UP);

		return bd.doubleValue();

	}

}
