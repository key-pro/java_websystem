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
 * Servlet implementation class Sample01
 */
@WebServlet("/Sample01")
public class Sample01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement st;
	private ResultSet rs;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample01() {
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
			ArrayList<String[]>datas = jd.getDatas("");

			ServletContext sc = getServletContext();
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
