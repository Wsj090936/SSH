package action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * checkboxlist��ǩ��ʹ��
 * @author wushijia
 *
 */
public class CheckboxlistAction extends ActionSupport {
	//��ʼ�����еİ���ѡ��
	private String[] hobbyarr = new String[]{"�Է�","�˶�","���"};
	//���ڴ洢�û�ѡ��İ���
	private String hobby;
	public String save(){
		System.out.println(hobby);
		return null;
	}
	public String[] getHobbyarr() {
		return hobbyarr;
	}
	public void setHobbyarr(String[] hobbyarr) {
		this.hobbyarr = hobbyarr;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}
