package com.example.quizapp

object setData {

    const val name:String = "name"
    const val score: String = "score"

    fun getQuestion(): ArrayList<QuestionData> {
        var que: ArrayList<QuestionData> = arrayListOf()
        var q1 = QuestionData(
            "What is the capital of India",
            1,
            "UP",
            "MP",
            "Mumbai",
            "New Delhi",
            4
        )
        var q2 = QuestionData(
            "What is the capital of Maharashtra",
            2,
            "Mumbai",
            "MP",
            "New Delhi",
            "UP",
            1
        )
        var q3 = QuestionData(
            "What is the capital of Uttar Pradesh",
            3,
            "UP",
            "Lucknow",
            "New Delhi",
            "Mumbai",
            2
        )
        var q4 = QuestionData(
            "What is the capital of Bihar",
            4,
            "Jaipur",
            "Nagpur",
            "Patna",
            "Mumbai",
            3
        )

        var q5 = QuestionData(
            "Pink city in India",
            5,
            "Mumbai",
            "Lucknow",
            "Nagpur",
            "Jaipur",
            4
        )

        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)

        return que
    }
}