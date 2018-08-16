package com.gmail.mityakruglov;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "QueastionnaireServlet", urlPatterns = "/")
public class QueastionnaireServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String text = "<!DOCTYPE html><html><head>"
                + "<meta charset='UTF-8'><title>Insert title here</title></head><body><center>"
                + "<form action=statistic method=post>"
                + "<p><b>TaskB1</b></p>"

                + "<p><input type='textbox' name='name' size='5' value=''> Input one name</p>"
                + "<p><input type='textbox' name='surname' size='5' value=''> Input surname</p>"
                + "<p><input type='textbox' name='age' size='5' value=''> Input age</p>"

                + "<p>Do you like Windows ?</p>"
                + "<p><input name=questionOne type=radio value=Yes checked> Yes"
                +" <input name=questionOne type=radio value=No> No</p>"

                + "<p>Do you like learn Java ?</p>"
                + "<p><input name=questionTwo type=radio value=Yes checked> Yes2"
                + "<input name=questionTwo  type=radio value=No> No2</p>"

                + "<p><input type=submit value=Choose></p>" + "</form>" + "</center></body></html>";

        PrintWriter pw = resp.getWriter();
        pw.println(text);
        pw.close();
    }
}
