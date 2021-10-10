package com.example.quizapp

object setData {


    const val name:String="name"
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData>{

        var que:ArrayList<QuestionData> = arrayListOf()

        var question1 = QuestionData(
            1,
            "what is capital of Turkey ?",
            "Adana",
            "Istanbul",
            "Ankara",
            "Paris",
            3
        )
        var question2 = QuestionData(
            1,
            "Who is the first president of Turkey?",

            "Mustafa Kemal Atatürk.",
            "Ahmet Çelebi",
            "Battalgazi",
            "Turgut Özal",
            1
        )
        var question3 = QuestionData(
            3,
            "Who wrote the Nutuk",
            "Mustafa Kemal Atatürk.",
            "Orhan Kemal",
            "Anonim",
            "None of the above",
            1
        )
        var question4 = QuestionData(
            4,
            "Who was the first president of Turkey ?",

            "Mustafa Kemal Atatürk.",
            "İsmet İnönü",
            "Bülent Ecevit",
            "Abdulhamid",
            1
        )

        var question5 = QuestionData(
            1,
            "Who built the The republic of turkey?",

            "Mustafa Kemal Atatürk.",
            "İsmet İnönü",
            "Bülent Ecevit",
            "Abdulhamid",
            1
        )

        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que
    }
}