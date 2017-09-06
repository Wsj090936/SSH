package converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * �Զ�������ת����
 * @author wushijia
 *
 */
public class MyStrutsConverter extends StrutsTypeConverter {
	private DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	/**
	 * �ַ���ת������������
	 * values ��ʾҪת��������
	 * toClass��ʾת����������
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		//1�����ж�values����û������
		if(values == null || values.length == 0){
			return null;
		}
		//2��ȡ�������еĵ�һ��Ԫ��
		String date = values[0];
		//3���ж�Ŀ���ֽ��������ǲ�����������
		if(toClass == java.util.Date.class){
			//4��ʹ��DateFormat����ת�������ҷ���ת����Ľ��
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
 * ��������ת�����ַ���
 * O��ʾҪת��������
 */
	@Override
	public String convertToString(Map context, Object o) {
		//1���ж�O�Ƿ�Ϊ��������
		if(o instanceof Date){
			Date date = (Date)o;
			//2�����������ͣ���ת��Ϊָ����ʽ���ַ�����������
			return format.format(date);
		}
		return null;
	}

}
