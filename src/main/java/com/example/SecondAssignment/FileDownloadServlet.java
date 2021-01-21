package com.example.SecondAssignment;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "FileDownloadServlet", value = "/filedownloadservlet")
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=\"Demo.csv\"");
            OutputStream outputStream = null;
            try
            {
                File f = new File("C:\\Users\\Vicky Kumar\\IdeaProjects\\SecondAssignment\\src\\main\\resources\\Demo.csv");
                FileReader reader = new FileReader(f);
                String data = "";
                int i;
                while( (i = reader.read()) != -1){
                    data += (char)i;
                }
                outputStream = response.getOutputStream();
                outputStream.write(data.getBytes());

            }finally {
                outputStream.flush();
                outputStream.close();
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("Only GET request are allowed");
    }
}
