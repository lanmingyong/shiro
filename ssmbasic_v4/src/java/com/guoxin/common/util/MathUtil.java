package com.guoxin.common.util;

import java.math.BigDecimal;

public class MathUtil {
	public static Double addDoubles(Double value, Double addValue) {
		BigDecimal sum = new BigDecimal(0.0D);
		if (value != null) {
			//创建一个具有参数所指定以字符串表示的数值的对象
			sum = new BigDecimal(value.toString());
		}
		if (addValue != null) {
			//BigDecimal对象中的值相加，然后返回这个对象。
			sum = sum.add(new BigDecimal(addValue.toString()));
		}
		//将BigDecimal对象中的值以双精度数返回
		return new Double(sum.doubleValue());
	}

	public static Double multiply(Object value1, Object value2) {
		if ((value1 == null) || (value2 == null)) {
			return new Double(0.0D);
		}
		BigDecimal val1 = new BigDecimal(value1.toString());
		BigDecimal val2 = new BigDecimal(value2.toString());
		//BigDecimal对象中的值相乘，然后返回这个对象
		return new Double(val1.multiply(val2).doubleValue());
	}

	public static Integer addInteger(Integer value, Integer addValue) {
		int sum = 0;
		if (value != null) {
			// 将BigDecimal对象中的值以整数返回
			sum = value.intValue();
		}
		if (addValue != null) {
			sum += addValue.intValue();
		}
		return new Integer(sum);
	}
}