/**
 *
 */
package com.alliance.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @Description: 这里用一句话描述这个类的作用
 * @see: ListUtils 此处填写需要参考的类
 * @version 2017年12月12日 下午2:12:28
 * @author chao.luo
 */
public class ListUtils {
	public static boolean isBlankList(List<?> list) {
		if (list != null && !list.isEmpty()) {
			return false;
		}
		return true;
	}

	public static <T> List<T> deepCopy(List<T> src) {
		try {
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(byteOut);
			out.writeObject(src);

			ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			ObjectInputStream in = new ObjectInputStream(byteIn);
			@SuppressWarnings("unchecked")
			List<T> dest = (List<T>) in.readObject();
			return dest;
		} catch (Exception e) {

		}
		return null;
	}
}
