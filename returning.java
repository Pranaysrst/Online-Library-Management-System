import java.sql.*;
import javax.servlet.*;

public class returning extends GenericServlet
{
                     Connection con;

          public void init(ServletConfig sc)
          {
           try
           {
            super.init(sc);
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:sri","gscl","granada");
           }
           catch(Exception e){e.printStackTrace();}
          }

          public void service(ServletRequest req,ServletResponse res)
          {
           try
           {
            Statement st = con.createStatement();
            String st1 = req.getParameter("rin");
            String st2 = req.getParameter("bn");
            String st3 = req.getParameter("doi");
            String st4 = req.getParameter("doe");
            int j =st.executeUpdate("delete from issue where idno ='"+st1+"' and bookname ='"+st2+"'");
            ServletOutputStream sos = res.getOutputStream();
            if(j>0)
             sos.println("<html><body bgcolor = pink><h1>The book is deleted</h1></body></html>");
            else
             sos.println("<html><body bgcolor = pink><h1>The book is not deleted</h1></body></html>");
           }
           catch(Exception ex){ex.printStackTrace();}
          }
}
             


