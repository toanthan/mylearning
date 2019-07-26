package javapq.web101;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String voc = request.getParameter("voc");
        String result = translate(voc);
        response.getOutputStream().write(result.getBytes());
    }

    private String translate(String voc) {
        String result = "NOT FOUND";
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydict", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from vocabularies where voc1 = '" + voc + "'");
            if (rs.next()) {
                result = rs.getString("voc2");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}