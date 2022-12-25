package com.yojulab.toy_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollWithDB {
   
    public HashMap<String, Object> getQuestion(String questionsUid) throws SQLException{

        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        
        String query = "SELECT * FROM QUESTIONS_LIST " +
                        " WHERE QUESTIONS_UID = '" + questionsUid + "'";
       
         ResultSet resultSet = statement.executeQuery(query);
        
        HashMap<String, Object> result = null;
        
        while(resultSet.next()){
            result = new HashMap<>();
            result.put("QUESTIONS_UID",resultSet.getString("QUESTIONS_UID"));
            result.put("QUESTIONS", resultSet.getString("QUESTIONS"));
            result.put("ORDERS",resultSet.getInt("ORDERS"));
        }

        return result;
    }
    public ArrayList<HashMap> getAnswer(String questions_Uid) throws SQLException { 
    
        Commons commons = new Commons();
    Statement answerStatement = commons.getStatement();

    String query = "SELECT EXAMPLE_LIST.EXAMPLE_UID, EXAMPLE_LIST.ORDERS, EXAMPLE_LIST.EXAMPLE " +
                    "FROM ANSWERS" + "INNER JOIN EXAMPLE_LIST" 
                    + "ON ANSWERS.EXAMPLE_UID = EXAMPLE_LIST.EXAMPLE_UID" 
                    + " WHERE QUESTIONS_UID = '" + questions_Uid + "' " + "ORDER BY ORDERS";

    ResultSet resultSetAnswers = answerStatement.executeQuery(query);

    ArrayList<HashMap> answers = new ArrayList<HashMap>();
    HashMap<String, Object> example_list = null;

    while (resultSetAnswers.next()) {
      example_list = new HashMap<>();
      example_list.put("ORDERS", resultSetAnswers.getInt("ORDERS"));
      example_list.put("EXAMPLE", resultSetAnswers.getString("EXAMPLE"));
      example_list.put("EXAMPLE_UID", resultSetAnswers.getString("EXAMPLE_UID"));

      answers.add(example_list);
    }
    return answers;
  }
    public ArrayList<String> getQuestion_Uid() {
      return null;
    }
}

