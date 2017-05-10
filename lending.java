import java.sql.*;
import javax.servlet.*;

public class lending extends GenericServlet
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
            String st1 = req.getParameter("lin");
            String st2 = req.getParameter("lbn");
            String st3 = req.getParameter("ldoi");
            String st4 = req.getParameter("ldoe");
            int j =st.executeUpdate("insert into issue values('"+st1+"','"+st2+"','"+st3+"','"+st4+"')");
            ServletOutputStream sos = res.getOutputStream();
            if(j>0)
             sos.println("<html><body bgcolor = pink><h1>The data is added successfully</h1></body></html>");
            else
             sos.println("<html><body bgcolor = pink><h1>The data is not added</h1></body></html>");
           }
           catch(Exception ex){ex.printStackTrace();}
          }
}
             
