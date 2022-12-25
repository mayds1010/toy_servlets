package com.yojulab.toy_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.yojulab.toy_servlets.dao.PollWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/polls/PollServlet")
public class DetailServlets extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");

        // biz with DB and Class
        PollWithDB pollWithDB = new PollWithDB();
        HashMap<String, Object> question = null;
        ArrayList<HashMap> answers = null;
        ArrayList<String> questionUIDs = null;
       
        try {
            question = pollWithDB.getQuestion(questions_Uid);
            answers = pollWithDB.getAnswer(questions_Uid);
            questionUIDs =  pollWithDB.getQuestion_Uid();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // output with html
        request.setAttribute("question", question);
        request.setAttribute("answers", answers);
        request.setAttribute("questionUIDs", questionUIDs);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/polls/details.jsp");
        requestDispatcher.forward(request, response);
    }
}
    

