package com.gmail.mityakruglov;

import java.io.IOException;
import java.io.PrintWriter;
 import        javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
 import        javax.servlet.http.HttpServlet;
  import       javax.servlet.http.HttpServletRequest;
    import     javax.servlet.http.HttpServletResponse;
      import   javax.servlet.http.HttpSession;
@WebServlet(name = "StatisticServlet", urlPatterns = "/statistic")
public class StatisticServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String text = "<!DOCTYPE html><html> <head><meta charset=utf-8>" +
                "<title>Selector</title></head><body><center>";
        HttpSession hs = req.getSession();

        Statistic st = (Statistic) hs.getAttribute("stat");
        Statistic stTwo = (Statistic) hs.getAttribute("stat2");

        if (st == null) {
                    st = Statistic.getInstance();
            hs.setAttribute("stat", st);
        }

        if (stTwo == null) {
            stTwo = Statistic.getInstance2();
            hs.setAttribute("stat2", stTwo);
        }

        String voice = req.getParameter("questionOne");
        String voice2 =req.getParameter("questionTwo");

        st.addVoice(voice);
        stTwo.addVoice(voice2);

        PrintWriter pw = resp.getWriter();

        String answer = text +"<p>Question 1</p>"+ st.toString()
                +"<p>Question 2</p>"+stTwo.toString() + "</center></body></html>";

        pw.println(answer);
        pw.close();

    }
}
