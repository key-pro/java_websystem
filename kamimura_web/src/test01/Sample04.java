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
 * Servlet implementation class sample04
 */
@WebServlet("/Sample04")
public class Sample04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement st;
	private ResultSet rs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample04() {
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


				request.setAttribute("shohin_id",shohin_id);
				request.setAttribute("shohin_mei",shohin_mei);
				request.setAttribute("shohin_bunrui",shohin_bunrui);
				request.setAttribute("hanbai_tanka",hanbai_tanka);
				request.setAttribute("shiire_tanka",shiire_tanka);
				request.setAttribute("torokubi",torokubi);
//				pw.println(request.getAttribute("shohin_id"));
			sc.getRequestDispatcher("/test01/sample04.jsp").forward(request, response);
			}else {

			String shohin_id = request.getParameter("shohin_id");

			int count = jd.deletedata(shohin_id);
			ArrayList<String[]>datas = jd.getDatas("");
			request.setAttribute("datas",datas);
			sc.getRequestDispatcher("/test01/sample01.jsp").forward(request, response);
//			pw.print(count);
			}
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
