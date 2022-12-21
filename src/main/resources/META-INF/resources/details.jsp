<!DOCTYPE html>
<html lang='en'>
            <head>
            <meta charset='UTF-8' />
            <title>title</title>
            <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet' />
            <link rel='stylesheet' href='./css/common.css' />
            </head>
            <body>
              <% 
        HashMap<String, String> searchForm = (HashMap<String, String>)request.getAttribute("searchForm"); 
        ArrayList<String> tablesListWithString = (ArrayList<String>)request.getAttribute("tablesListWithString");
    %>  
            <div class='container'>
            <div class='fs-5'>"+ "이름 : "+ userInfo.get("name")+"    "+
                                   "소속 : "+
                                   userInfo.get("attached")+
                                   "</div>
       
               for(int i=0; i < questionsData.size(); i++){
                   <div class=''>" + (i+1) +" . "+ questionsData.get("Q" + (i+1)) +"</div>
                   ArrayList<String> tempsArray = setquestion.get("Q" + (i+1));
                   for(int j = 0; j < tempsArray.size(); j++){
                      <div class='form-check'><input name='Q+"+(i+1)+"' type='radio'>"+AnswersData.get(tempsArray.get(j))+"</div>
                    }
                   <div> <button type='submit'>확인</button> </div>
               }
       
               </div>
               <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'
               integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'
               crossorigin='anonymous'></script>
               </body>
               </html>