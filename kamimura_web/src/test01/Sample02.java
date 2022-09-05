package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * Servlet implementation class Sample02
 */
@WebServlet("/Sample02")
public class Sample02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement st;
	private ResultSet rs;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample02() {
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

			String shohin_id = request.getParameter("shohin_id");
			String shohin_mei = request.getParameter("shohin_mei");
			String shohin_bunrui = request.getParameter("shohin_bunrui");
			int hanbai_tanka = Integer.parseInt(request.getParameter("hanbai_tanka"));
			int shiire_tanka = Integer.parseInt(request.getParameter("shiire_tanka"));
			String torokubi = request.getParameter("torokubi");
			int red = jd.insertdata(shohin_id, shohin_mei, shohin_bunrui, hanbai_tanka, shiire_tanka, torokubi);
			ArrayList<String[]>datas = jd.getDatas("");
			request.setAttribute("datas",datas);
			sc.getRequestDispatcher("/test01/sample01.jsp").forward(request, response);

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
