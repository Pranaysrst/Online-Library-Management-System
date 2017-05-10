import java.sql.*;
import javax.servlet.*;

public class addbooks extends GenericServlet
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
            String str1 = req.getParameter("bn");
            String str2 = req.getParameter("bc");
            String str3 = req.getParameter("aut");
            String str4 = req.getParameter("doa");
            String str5 = req.getParameter("pr");
            String str6 = req.getParameter("rn");
            String str7 = req.getParameter("nob");
            String str8 = req.getParameter("sc");
            ServletOutputStream sos = res.getOutputStream();
            int k = st.executeUpdate("insert into addbooks values('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"','"+str7+"','"+str8+"')"); 
            if(k>0)
             sos.println("books are added successfully");
            else
             sos.println("books are not added");
           }
           catch(Exception ex){ex.printStackTrace();}
          }
}

