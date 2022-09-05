package test01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.JDBConnect;

/**
 * Servlet implementation class Sample03
 */
@WebServlet("/Sample03")
public class Sample03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement st;
	private ResultSet rs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		try {
			JDBConnect jd = new JDBConnect();
			ServletContext sc = getServletContext();
			String kensaku = request.getParameter("kensaku");
//			pw.println(kensaku);
			if(kensaku!=null) {

				String[] data = jd.getData(kensaku);

				String shohin_id = data[0];
				String shohin_mei = data[1];
				String shohin_bunrui = data[2];
				String hanbai_tanka = data[3];
				String shiire_tanka = data[4];
				String torokubi = data[5];
//				pw.println(shohin_id+" "+shohin_mei+" "+shohin_bunrui+" "+hanbai_tanka+" "+shiire_tanka+" "+torokubi);


				request.setAttribute("shohin_id",shohin_id);
				request.setAttribute("shohin_mei",shohin_mei);
				request.setAttribute("shohin_bunrui",shohin_bunrui);
				request.setAttribute("hanbai_tanka",hanbai_tanka);
				request.setAttribute("shiire_tanka",shiire_tanka);
				request.setAttribute("torokubi",torokubi);
//				pw.println(request.getAttribute("shohin_id"));
				sc.getRequestDispatcher("/test01/sample03.jsp").forward(request, response);
			}else {
//					pw.print("<div>[");
//					pw.print(rs.getString("shohin_id"));
//					pw.print("&nbsp;:&nbsp");
//					pw.print(rs.getString("shohin_mei"));
//					pw.print("&nbsp;:&nbsp");
//					pw.print(rs.getString("shohin_bunrui"));
//					pw.print("&nbsp;:&nbsp");
//					pw.print(rs.getInt("hanbai_tanka"));
//					pw.print("&nbsp;:&nbsp");
//					pw.print(rs.getInt("shiire_tanka"));
//					pw.print("&nbsp;:&nbsp");
//					pw.print(rs.getString("torokubi"));
//					pw.print("]</div>");



			String shohin_id = request.getParameter("shohin_id");
			String shohin_mei = request.getParameter("shohin_mei");
			String shohin_bunrui = request.getParameter("shohin_bunrui");
			int hanbai_tanka = Integer.parseInt(request.getParameter("hanbai_tanka"));
			int shiire_tanka = Integer.parseInt(request.getParameter("shiire_tanka"));
			String torokubi = request.getParameter("torokubi");


//				pw.println(upsql);
			int count = jd.updata(shohin_id, shohin_mei, shohin_bunrui, hanbai_tanka, shiire_tanka, torokubi);
			ArrayList<String[]>datas = jd.getDatas("");

			request.setAttribute("datas",datas);

			sc.getRequestDispatcher("/test01/sample01.jsp").forward(request, response);

//			pw.print(count);
			}
		}catch(Exception e) {
			pw.println(e.getStackTrace());
		}
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(con!=null)con.close();
		}catch(Exception e) {
			pw.println(e);
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
