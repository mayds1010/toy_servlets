<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
<% 
    HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question");
    ArrayList<String> answers = (ArrayList<String>)request.getAttribute("answers");
%>

    <div> 
        <a href="/polls/PollServlet?QUESTIONS_UID=Q1">Q1</a> / 
        <a href="/polls/PollServlet?QUESTIONS_UID=Q2">Q2</a> /
        <a href="/polls/PollServlet?QUESTIONS_UID=Q3">Q3</a> /
        <a href="/polls/PollServlet?QUESTIONS_UID=Q4">Q4</a> /
        <a href="/polls/PollServlet?QUESTIONS_UID=Q5">Q5</a>
    </div>
    <div>
        <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS")%>
    </div>
    <div>
        <%
            for(int i=0; i<answer.size();i++){ %>
            <div>
            <input type="radio" name="answers" id="ex">
                (<%= i+1 %>) <%= answer.get(i) %>
            </div>
           <% }
        %>
    </div>
</body>

</html>


<%-- 
<%@ %> = 환경
<%= %> = jsp 표시
<% %> = 나머지 
--%>



