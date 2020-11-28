package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class main
 */
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String name = (String) request.getAttribute("userName");


	    if (name == null || "".equals(name)) {
	        request.setAttribute("userName", "Guest");
	    }

	    String view = "/WEB-INF/view/index.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの指定
	    request.setCharacterEncoding("utf-8");
		// formから値を取得
	    String name = request.getParameter("name");
	    request.setAttribute("userName", name);

	    // 1.データベース・テーブルに接続する準備
	    Connection con = null;
	    Statement stmt = null;
	    ResultSet result = null;

	    // 2.接続文字列の設定
	    String url = "jdbc:postgresql://localhost:5432/BeautySalon" ;
	    String user = "postgres" ;
	    String password = "postgres" ;

	    try {
	      // 3.PostgreSQLに接続
	      con = DriverManager.getConnection ( url, user, password ) ;


	      // 4.SELECT文の作成・実行
	      stmt = con.createStatement() ;
	      String sql = "SELECT * from test" ;
	      result = stmt.executeQuery ( sql ) ;

	      // 5.実行結果の取得
	      while ( result.next() ) {
	        String col1 = result.getString ( 1 ) ;
//	        String col2 = result.getString ( 2 ) ;
//	        String col3 = result.getString ( 3 ) ;
	        System.out.println ( col1 ) ;
	      }
	    } catch ( SQLException e ) {
	      e.printStackTrace() ;
	    } finally {
	      // 6.クローズ処理
	      try {
	        if ( result != null ) {
	          result.close() ;
	        }
	        if ( stmt != null ) {
	          stmt.close() ;
	        }
	        if ( con != null ) {
	          con.close() ;
	        }
	      } catch ( SQLException e ) {
	        e.printStackTrace() ;
	      }
	    }

		doGet(request, response);
	}

}
