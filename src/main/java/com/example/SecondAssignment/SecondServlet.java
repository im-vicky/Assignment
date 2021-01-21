package com.example.SecondAssignment;

import com.google.gson.Gson;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet", value = "/secondservlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("Only POST request are allowed");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Gson gs = new Gson();
        String jsonData = String.valueOf(request.getAttribute("json"));
        Data obj = gs.fromJson(jsonData, Data.class);
        Integer addition = obj.getFirstNumber() + obj.getSecondNumber();
        Integer substraction = obj.getFirstNumber() - obj.getSecondNumber();

        DataObject object = new DataObject(addition, substraction);
        String afterCalculationData = gs.toJson(object);
        request.setAttribute("afterCalculationData", afterCalculationData);
    }
}
