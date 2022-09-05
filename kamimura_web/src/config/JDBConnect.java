package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;


	public JDBConnect() {
		try {
		String url = "jdbc:postgresql://localhost:5432/shop";
		String user = "postgres";
		String password = "igsyouken";

		Class.forName("org.postgresql.Driver");

		con = DriverManager.getConnection(url,user,password);
		st = con.createStatement();

		}catch(Exception e){
				System.out.println("1"+e);
		}
	}
	public void testPrint() {
		try {


		String sql = "select * from Shohin;";
		rs = st.executeQuery(sql);
		while(rs.next()) {

			System.out.print(rs.getString("shohin_id"));
			System.out.print("/");
			System.out.print(rs.getString("shohin_mei"));
			System.out.print("/");
			System.out.print(rs.getString("shohin_bunrui"));
			System.out.print("/");
			System.out.print(rs.getInt("hanbai_tanka"));
			System.out.print("/");
			System.out.print(rs.getInt("shiire_tanka"));
			System.out.print("/");
			System.out.println(rs.getObject("torokubi"));

		}
		}catch(Exception e) {
			System.out.println("2"+e);
		}
	}
	//検索(shohin_id)
	public String[] getData(String shohin_id) {
		String [] data = new  String[6];
		try {
		String sql = "select * from shohin where shohin_id = '"+shohin_id+"';";
		System.out.println(sql);
		rs = st.executeQuery(sql);
		rs.next();
				data[0] = rs.getString("shohin_id");
				data[1] = rs.getString("shohin_mei");
				data[2] = rs.getString("shohin_bunrui");
				data[3] = String.valueOf(rs.getInt("hanbai_tanka"));
				data[4] = String.valueOf(rs.getInt("shiire_tanka"));
				data[5] = String.valueOf(rs.getObject("torokubi"));
		}catch(Exception e) {
			System.out.println("3"+e);
		}
		return data;
	}
	//�?ータ検索(shohin_mei)
	public ArrayList<String[]> getDatas(String shohin_mei){
		ArrayList<String[]>datas = new ArrayList<>();
		try {
			String sql;
			if(shohin_mei.equals("")) {
				sql = "select * from Shohin order by shohin_id;";
			}else {
				sql = "select * from Shohin where shohin_mei = '"+shohin_mei+"' order by shohin_id;";
			}
			System.out.println(sql);
			rs = st.executeQuery(sql);


			while(rs.next()) {

				String [] data = {
						rs.getString("shohin_id"),
						rs.getString("shohin_mei"),
						rs.getString("shohin_bunrui"),
						String.valueOf(rs.getInt("hanbai_tanka")),
						String.valueOf(rs.getInt("shiire_tanka")),
						String.valueOf(rs.getObject("torokubi"))

				};
				datas.add(data);

			}
			}catch(Exception e) {
				System.out.println("4"+e);
			}
		return datas;
	}
	//登録用
	public int insertdata(String shohin_id,String shohin_mei,String shohin_bunrui,int hanbai_tanka,int shiire_tanka,String torokubi) {
		int count = 0;
		try {
		String sql = "insert into shohin values('"
				+shohin_id+"','"+shohin_mei+"','"
				+shohin_bunrui+"',"+hanbai_tanka+","
				+shiire_tanka+",'"+torokubi+"')";
		count = st.executeUpdate(sql);

		System.out.println(count);
		}catch(Exception e) {
			System.out.println("5"+e);
		}
		return  count;
	}
	// 更新用
	public int updata(String shohin_id,String shohin_mei,String shohin_bunrui,int hanbai_tanka,int shiire_tanka,String torokubi) {
			int count = 0;
		try {
		String sql = "update shohin set shohin_mei='"+shohin_mei+"',"
				+" shohin_bunrui='"+shohin_bunrui+"',"
				+" hanbai_tanka="+hanbai_tanka+","
				+" shiire_tanka="+shiire_tanka+","
				+" torokubi='"+torokubi+"'"
				+"where shohin_id = '"+shohin_id+"';";
		 count = st.executeUpdate(sql);

		System.out.println(count);
		}catch(Exception e) {
			System.out.println("6"+e);
		}
		return count;
	}
	// 削除用
	public int deletedata(String shohin_id) {
		int count = 0;
		try {
		String sql = "delete from shohin where shohin_id = '"+shohin_id+"';";

		count = st.executeUpdate(sql);

		System.out.println(count);
		}catch(Exception e) {
			System.out.println("7"+e);
		}
		return count;
	}
	//clause
	public void close() {
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(con!=null)con.close();
		}catch(Exception e) {
			System.out.println("8"+e);
		}

	}
}
