<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="exam.css">
  <title>Quiz</title>
</head>
<body>
  <div class="title">
    <h1>ONLINE QUIZ</h1>
    <span>Timer:</span>
    <span id="time"></span>
  </div>
  <div id="questions">
    <form name="quiz" action="ExamServer.jsp" >
      <ol>
        <li class="question-wrapper">
          <h3>Who is the creator of  Python??</h3>
          <input type="radio" name="question1-answer" id="" class="question1-option" value="Dennis Ritchie" required>
          <label for="">Dennis Ritchie</label>
          <input type="radio" name="question1-answer" id="" class="question1-option" value="Guido Van Rossum" required>
          <label for="">Guido Van Rossum</label>
          <input type="radio" name="question1-answer" id="" class="question1-option" value="Bjarne Stroustrup" required>
          <label for="">Bjarne Stroustrup</label>
          <input type="radio" name="question1-answer" id="" class="question1-option" value="Linus Torvalds" required>
          <label for="">Linus Torvalds</label>
        </li>
        <li class="question-wrapper">
          <h3>How many bytes are set aside by the compiler for a variable of type ‘int’ in C?</h3>
          <input type="radio" name="question2-answer" id="" class="question2-option" value="2" required>
          <label for="">2</label>
          <input type="radio" name="question2-answer" id="" class="question2-option" value="4" required>
          <label for="">4</label>
          <input type="radio" name="question2-answer" id="" class="question2-option" value="8" required>
          <label for="">8</label>
          <input type="radio" name="question2-answer" id="" class="question2-option" value="10" required>
          <label for="">10</label>
        </li>
        <li class="question-wrapper">
          <h3>Which of the following is the fastest memory?</h3>
          <input type="radio" name="question3-answer" id="" class="question3-option" value="USB Flashdrive" required>
          <label for="">USB Flashdrive</label>
          <input type="radio" name="question3-answer" id="" class="question3-option" value="RAM" required>
          <label for="">RAM</label>
          <input type="radio" name="question3-answer" id="" class="question3-option" value="Harddisk" required>
          <label for="">Harddisk</label>
          <input type="radio" name="question3-answer" id="" class="question3-option" value="Cache" required>
          <label for="">Cache</label>
        </li>
        <li class="question-wrapper">
          <h3>Which of the following is called Universal Gate??</h3>
          <input type="radio" name="question4-answer" id="" class="question4-option" value="NAND gate" required>
          <label for="">NAND gate</label>
          <input type="radio" name="question4-answer" id="" class="question4-option" value="OR gate" required>
          <label for="">OR gate</label>
          <input type="radio" name="question4-answer" id="" class="question4-option" value="AND gate" required>
          <label for="">AND gate</label>
          <input type="radio" name="question4-answer" id="" class="question4-option" value="NOT gate" required>
          <label for="">NOT gate</label>
        </li>
        <li class="question-wrapper">
          <h3>Which of the following Terminal commands use to display current directory??</h3>
          <input type="radio" name="question5-answer" id="" class="question5-option" value="cd" required>
          <label for="">cd</label>
          <input type="radio" name="question5-answer" id="" class="question5-option" value="pwd" required>
          <label for="">pwd</label>
          <input type="radio" name="question5-answer" id="" class="question5-option" value="ls" required>
          <label for="">ls</label>
          <input type="radio" name="question5-answer" id="" class="question5-option" value="mkdir" required>
          <label for="">mkdir</label>
        </li>
        <li class="question-wrapper">
          <h3>Which of the following Machine learning model is comes under unsupervised Learning??</h3>
          <input type="radio" name="question6-answer" id="" class="question6-option" value="Linear Regression" required>
          <label for="">Linear Regression</label>
          <input type="radio" name="question6-answer" id="" class="question6-option" value="Logistic Regression" required>
          <label for="">Logistic Regression</label>
          <input type="radio" name="question6-answer" id="" class="question6-option" value="K-means Clustering" required>
          <label for="">K-means Clustering</label>
          <input type="radio" name="question6-answer" id="" class="question6-option" value="Naive Bayes classifier" required>
          <label for="">Naive Bayes Classifier</label>
        </li>
        <li class="question-wrapper">
          <h3>Which of following is a non-linear Data structure</h3>
          <input type="radio" name="question7-answer" id="" class="question7-option" value="Array" required>
          <label for="">Array</label>
          <input type="radio" name="question7-answer" id="" class="question7-option" value="Stack" required>
          <label for="">Stack</label>
          <input type="radio" name="question7-answer" id="" class="question7-option" value="Queue" required>
          <label for="">Queue</label>
          <input type="radio" name="question7-answer" id="" class="question7-option" value="Trees" required>
          <label for="">Trees</label>
        </li>
        <li class="question-wrapper">
          <h3>Which of the Protocol is used for Email Systems?</h3>
          <input type="radio" name="question8-answer" id="" class="question8-option" value="SMTP" required>
          <label for="">SMTP</label>
          <input type="radio" name="question8-answer" id="" class="question8-option" value="TELNET" required>
          <label for="">TELNET</label>
          <input type="radio" name="question8-answer" id="" class="question8-option" value="HTTP" required>
          <label for="">HTTP</label>
          <input type="radio" name="question8-answer" id="" class="question8-option" value="FTP" required>
          <label for="">FTP</label>
        </li>
      </ol>
      <% 
      String user = request.getParameter("name");
      String rollno = request.getParameter("rollno");
      %>
      <input type="hidden" name="name" value="<%= user%>">
      <input type="hidden" name="rollno" value="<%= rollno%>">
      <input type="submit" value="Submit Test">
      <input type="reset" value="Clear Answer">
    </form>
  </div>
  <script>
    function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            //timer = duration;
          alert('test');
          document.forms["quiz"].submit();

        }
    }, 1000);
}

window.onload = function () {
    var fiveMinutes = 60 * 10;
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};
    </script>
</body>
</html>