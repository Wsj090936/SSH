package converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * 自定义类型转换器
 * @author wushijia
 *
 */
public class MyStrutsConverter extends StrutsTypeConverter {
	private DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	/**
	 * 字符串转换到其他类型
	 * values 表示要转换的数据
	 * toClass表示转换到的类型
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		//1、先判断values中有没有数据
		if(values == null || values.length == 0){
			return null;
		}
		//2、取出数组中的第一个元素
		String date = values[0];
		//3、判断目标字节码类型是不是日期类型
		if(toClass == java.util.Date.class){
			//4、使用DateFormat进行转换，并且返回转换后的结果
			try {
				return format.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
/**
 * 其他类型转换到字符串
 * O表示要转换的数据
 */
	@Override
	public String convertToString(Map context, Object o) {
		//1、判断O是否为日期类型
		if(o instanceof Date){
			Date date = (Date)o;
			//2、是日期类型，就转换为指定格式的字符串，并返回
			return format.format(date);
		}
		return null;
	}

}
