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
	private ArrayList<ClassEcoVO> list;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	
	public ClassEcoVO getCorrentInfo(){
		ClassEcoVO vo = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select temperature, humidity, innerdust, outerdust, to_char(reg_time,'yyyy/mm/dd hh24:mi:ss') reg_time"); 
		sql.append(" from classeco");
		sql.append(" where reg_time = (select max(reg_time) from classeco)");
		
		if(connect()) {
			try {
				ps = con.prepareStatement(sql.toString());
				if(ps != null) {
					rs = ps.executeQuery();
					
					if(rs.next()) {
						vo = new ClassEcoVO();
						vo.setTemperature(rs.getDouble("temperature"));
						vo.setHumidity(rs.getDouble("humidity"));
						vo.setInnerDust(rs.getDouble("innerDust"));
						vo.setOuterDust(rs.getDouble("outerDust"));
						vo.setRegTime(rs.getString("reg_time"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		close();
		
		return vo;
	}
	
	public List<ClassEcoVO> list() {
		list = new ArrayList<ClassEcoVO>();
		String sql = "select * from (select * from classeco order by rownum desc) where rownum<=10";
		
		if(connect()) {
			try {
				ps = con.prepareStatement(sql);
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
				System.out.println("실패");
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
			String id = prop.getProperty("id");
			String pw = prop.getProperty("pw");
			System.out.printf("url=%s, id=%s, pw=%s\n" , url, id, pw);

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("con : " + con);

		} catch (FileNotFoundException fe) {
			System.out.println("파일 연결 실패 : " + fe.getMessage());
		} catch (IOException ie) {
			System.out.println("입출력 실패 :" + ie.getMessage());
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
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
			System.out.println("해제 실패 : " + e.getMessage());
		}
	}
}
