package Utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
/**
 * JDBC�Ĺ����࣬�������ݿ����ӳ��������ݿ⣬�Լ���Ӧ���������
 * @author wushijia
 *
 */
public class JDBCTools {
	/**
	 * �ύ����
	 * @param con
	 */
    public static void commit(Connection con){
    	if(con != null){
    		try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
    /**
     * ����Ļع�
     * @param con
     */
    public static void rollback(Connection con){
    	if(con != null){
    		try {
				con.rollback();
			} catch (Exception e) {
                e.printStackTrace();
			}
    	}
    }
    /**
     * ��ʼ����
     * @param con
     */
    public static void beginTransaction(Connection con){
    	if(con != null){
    		try {
				con.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
    /**
     * ���þ�̬������ʼ�����ݿ����ӳأ����ݿ����ӳ�Ӧ��ֻ����ʼ��һ��
     */
    public static DataSource datasource = null;
    static{
    	Properties properties = new Properties();
    	InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("dbcp.properties");
		try {
			properties.load(in);
			datasource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * ��ȡ���ݿ�����
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
    	return datasource.getConnection();
    }
    /**
     * �ͷ�����
     * @param con
     * @param state
     * @param rs
     */
    public static void releaseDB(ResultSet rs,Statement state,Connection con){
    	if(rs != null){
    		try {
    			rs.close();
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	if(state != null){
    		try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	if(con != null){
    		try {
    			con.close();//�ͷ�����ֻ�ǽ����ӷŻ����ݿ����ӳأ���������Ҫ���ӵ�����ʹ��
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    }
}
