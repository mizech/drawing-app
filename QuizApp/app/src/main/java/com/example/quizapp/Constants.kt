package com.example.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(1,
            "What country does these flag belong to?",
            "", "Japan", "USA", "China",
            "France", 2)
        val que2 = Question(2,
            "What country does these flag belong to?",
            "", "Germany", "Italy", "UK",
            "Netherlands", 1)
        val que3 = Question(3,
            "What country does these flag belong to?",
            "", "Belgium", "Russia", "India",
            "France", 3)
        val que4 = Question(4,
            "What country does these flag belong to?",
            "", "Brazil", "Portugal", "Spain",
            "Argentina", 1)

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)

        return questionsList
    }
}