package com.example.SecondAssignment;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/firstservlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("Only POST request allowed");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer num1 = Integer.parseInt(request.getParameter("number1"));
        Integer num2 = Integer.parseInt(request.getParameter("number2"));

        Data obj = new Data(num1, num2);
        Gson gs = new Gson();
        String jsonToSend = gs.toJson(obj);
        request.setAttribute("json", jsonToSend);
        try {
            request.getRequestDispatcher("/secondservlet").include(request,response);
            String jsonData = String.valueOf(request.getAttribute("afterCalculationData"));
            DataObject tempObj =  gs.fromJson(jsonData, DataObject.class);
            Integer multiply1 = tempObj.getaddition() * tempObj.getsubtraction();
            Integer multiply2 = tempObj.getaddition() * tempObj.getaddition();
            Integer multiply3 = tempObj.getsubtraction() * tempObj.getsubtraction();
            FinalResult result = new FinalResult(multiply1, multiply2, multiply3);
            String finalResult = gs.toJson(result);
            PrintWriter out = response.getWriter();
            out.write(finalResult);
        } catch (ServletException e) {
            e.printStackTrace();
        }



    }
}
