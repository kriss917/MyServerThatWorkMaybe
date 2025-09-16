package org.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AnagramServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            var word = req.getParameter("word");
            var result = new AnagramFinder().findAnagrams(word);
            resp.setContentType("text/html");
            var writer = resp.getWriter();
            writer.println("<h1>Anagrams for " + word + "</h1>");
            writer.println("<ul>");
            result.forEach(w -> writer.println("<li>" + w + "</li>"));
            writer.println("</ul>");
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var writer = resp.getWriter();
        //for å skrive noe må jeg ha en writer
        writer.println("<div> bitch </div>");
    }
}
