<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Addition Quiz</title>
</head>
<body>

<%
    // Check if this is the first time accessing the page or a postback
    String action = request.getParameter("action");
    Random random = new Random();
    int[] numbers1 = new int[5];
    int[] numbers2 = new int[5];
    int[] userAnswers = new int[5];
    boolean isQuizStarted = false;

    if ("submit".equals(action)) {
        isQuizStarted = true;
        for (int i = 0; i < 5; i++) {
            numbers1[i] = Integer.parseInt(request.getParameter("num1_" + i));
            numbers2[i] = Integer.parseInt(request.getParameter("num2_" + i));
            userAnswers[i] = Integer.parseInt(request.getParameter("answer_" + i));
        }
    } else {
        for (int i = 0; i < 5; i++) {
            numbers1[i] = random.nextInt(50); // Generates numbers between 0-49
            numbers2[i] = random.nextInt(50);
        }
    }
%>

<% if (!isQuizStarted) { %>
    <form action="quiz.jsp" method="post">
        <h3>Addition Quiz</h3>
        <% for (int i = 0; i < 5; i++) { %>
            <input type="hidden" name="num1_<%= i %>" value="<%= numbers1[i] %>">
            <input type="hidden" name="num2_<%= i %>" value="<%= numbers2[i] %>">
            <%= numbers1[i] %> + <%= numbers2[i] %> = <input type="text" name="answer_<%= i %>" required><br/>
        <% } %>
        <input type="submit" name="action" value="submit">
    </form>
<% } else { %>
    <h3>Results</h3>
    <% int correctCount = 0; %>
    <% for (int i = 0; i < 5; i++) { %>
        <%= numbers1[i] %> + <%= numbers2[i] %> = <%= userAnswers[i] %>
        <% if (userAnswers[i] == (numbers1[i] + numbers2[i])) { %>
            <span style="color: green;">Correct</span><br/>
            <% correctCount++; %>
        <% } else { %>
            <span style="color: red;">Incorrect</span><br/>
        <% } %>
    <% } %>
    <br/>
    You got <%= correctCount %> out of 5 questions right.
<% } %>

</body>
</html>
