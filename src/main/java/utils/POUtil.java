package utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class POUtil {

	public static Map getFieldAndType(Class<?> clz) {
		Field[] fields = clz.getDeclaredFields();
		Map map = new HashMap<>();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Check.class)) {
				Check annotation = field.getDeclaredAnnotation(Check.class);// 获得注解
				String value = annotation.value();// 注解值
				String fieldname = field.getName();// 字段名
				try {
					field.setAccessible(true);// 开启属性设置权限
					Object o = field.get(clz.newInstance());
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("value=" + value + "\t" + "fieldname=" + fieldname);

				Class<?> declaringClass = field.getDeclaringClass();// 类名 class
																	// utils.TestPO
				Class<?> type = field.getType();// 属性类型 class java.lang.String
												// boolean
				map.put(fieldname, type);
			}
		}
		return map;
	}

	/**
	 * if(a.c==null){ 自动对@Check 注解的属性做非空校验 }
	 * 
	 * @param clz
	 * @return
	 */
	public static void checkInput(Class<?> clz) {
		Map<String, Class> map = getFieldAndType(clz); // String:class 例如age:int
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			Class class1 = map.get(key);
			String type = class1.getName(); // boolean int java.lang.String
			String out ="";
			String clzName = clz.getName();
			clzName = clzName.substring(clzName.lastIndexOf(".")+1);
			clzName = clzName.substring(0, 1).toLowerCase() + clzName.substring(1);// 类的对象名
			key = key.substring(0, 1).toUpperCase() + key.substring(1);

			if ("java.lang.String".equals(type)) {
				out = "if(StringUtils.isEmpty(" + clzName + ".get" + key + "())){\n\n\t}";
			} else {
				out = "if(" + clzName + ".get" + key + "()==null){\n\n\t}";
			}
			System.out.println(out);
		}
	}

	public static boolean check(Class<?> clz) {
		Field[] fields = clz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Check.class)) {
				field.setAccessible(true);
				try {
					Object o = field.get(clz.newInstance());
					System.out.println("o=" + o);
					if (o == null) {
						throw new Exception("不能为空");
					}
				} catch (IllegalArgumentException | IllegalAccessException | InstantiationException e) {
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}

		return false;
	}



	public static void main(String[] args) {
		// checkInput(TestPO.class);
		check(TestPO.class);
	}
}
