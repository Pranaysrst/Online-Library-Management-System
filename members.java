import javax.servlet.*;
import java.sql.*;

public class members extends GenericServlet
{
                 Connection con;
                 ResultSet rs;
                 Statement st ;

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
              st=con.createStatement();
              rs = st.executeQuery("select * from members");
              ServletOutputStream sos = res.getOutputStream();
              sos.println("Currently existing members are");
              if(rs.next())
               sos.println("<html><head></head><body bgcolor=seagreen><table border=2><tr><th>MID</th><th>MNAME</th><th>MADDR</th><th>MDOI</th><th>MDOE</th><th>MSTATUS</th><th>MTYPE</th><th>AMOUNT</th></tr>");
              while(rs.next())
              {
               sos.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>");
              }
              sos.println("</table></body></html>");
              st.close();
              rs.close();
             }
             catch(Exception ex){ex.printStackTrace();}
            }
}

             


