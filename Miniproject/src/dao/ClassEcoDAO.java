package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import vo.ClassEcoVO;

public class ClassEcoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	
	public List<ClassEcoVO> getList(){
		List<ClassEcoVO> list = new ArrayList<ClassEcoVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select temperature, humidity, innerdust, outerdust, to_char(sysdate-0.001,'yyyy/mm/dd hh24:mi:ss') reg_time"); 
		sql.append(" from classeco");
		sql.append(" where reg_time = (select max(reg_time) from classeco)");
		
		if(connect()) {
			try {
				ps = con.prepareStatement(sql.toString());
				if(ps != null) {
					rs = ps.executeQuery();
					
					while(rs.next()) {
						ClassEcoVO vo = new ClassEcoVO();
						vo.setTemperature(rs.getDouble("temperature"));
						vo.setHumidity(rs.getDouble("humidity"));
						vo.setInnerDust(rs.getDouble("innerDust"));
						vo.setOuterDust(rs.getDouble("outerDust"));
						vo.setRegTime(rs.getString("reg_time"));
						list.add(vo);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		close();
		
		return list;
	}
	
	private boolean connect() {

		Boolean result = true;
		FileReader read = null;
		Properties prop = new Properties();
		try {
			read = new FileReader("db_info.properties");
			prop.load(read);
			String url = prop.getProperty("url");
			String id = prop.getProperty("user");
			String pw = prop.getProperty("pw");
			System.out.printf("url=%s, user=%s, pw=%s\n" , url, id, pw);

			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("con : " + con);

		} catch (FileNotFoundException fe) {
			System.out.println("���� ���� ���� : " + fe.getMessage());
		} catch (IOException ie) {
			System.out.println("����� ���� :" + ie.getMessage());
		} catch (Exception e) {
			System.out.println("���� ���� : " + e.getMessage());
		}
		return result;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println("���� ���� : " + e.getMessage());
		}
	}
}