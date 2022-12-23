package com.yojulab.toy_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollWithDB {
 
    public HashMap<String, Object> getQuestion(String questions_Uid) throws SQLException{

        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM QUESTIONS_LIST " +
                        " WHERE QUESTIONS_UID = '"+questions_Uid+"'";
        
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
    public ArrayList<String> getExample(ArrayList<String> questions_Uid, Object answer) throws SQLException{ //추가
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM ANSWERS INNER JOIN EXAMPLE_LIST " +
        " ON ANSWERS.EXAMPLE_UID = EXAMPLE_LIST.EXAMPLE_UID " +
       " WHERE QUESTIONS_UID = '"+questions_Uid+"'";
       
        new ArrayList<>();
        return null;
    
    }
    public ArrayList<String> getQuestion_Uid() {
        return null;
    }
    public ArrayList<String> getExample(String questions_Uid) {
        return null;
    }
    public ArrayList<HashMap> getExamples(String questions_Uid) {
        return null;
    }
}



// SELECT * FROM QUESTIONS_LIST
    // WHERE QUESTIONS_UID = 'Q2'