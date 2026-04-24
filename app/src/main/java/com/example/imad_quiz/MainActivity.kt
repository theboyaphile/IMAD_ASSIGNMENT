package com.example.imad_quiz

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Carrots improve your eyesight",
        "Chocolate is toxic to dogs",
        "Eating late at night always causes weight gain",
        "Water has calories"
    )

    private val answers = arrayOf(
        false, true, false, false
    )

    private val explanations = arrayOf(
        "Carrots help vision but don't give super eyesight.",
        "Chocolate contains theobromine which is harmful to dogs",
        "Weight gain depends on total calories, not timing",
        "Water has zero calories."
    )

    private var index = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Layouts
        val welcome = findViewById<LinearLayout>(R.id.lytWelcome)
        val quiz = findViewById<LinearLayout>(R.id.lytQuiz)
        val scoreLayout = findViewById<LinearLayout>(R.id.lytScore)

        // Views
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnRestart = findViewById<Button>(R.id.btnScore)

        val txtQuestion = findViewById<TextView>(R.id.txtQuestion)
        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)
        val txtScore = findViewById<TextView>(R.id.txtScore)

        // 1. Start Button Logic
        btnStart.setOnClickListener {
            welcome.visibility = View.GONE
            quiz.visibility = View.VISIBLE
            scoreLayout.visibility = View.GONE

            index = 0
            score = 0
            loadQuestion(txtQuestion, txtFeedback)
            Log.d("APP_LOG", "QUIZ Started")
        }

        // 2. Answer Button Logic
        btnTrue.setOnClickListener {
            if (!answered) checkAnswer(true, txtFeedback)
        }

        btnFalse.setOnClickListener {
            if (!answered) checkAnswer(false, txtFeedback)
        }

        // 3. Next Button Logic
        btnNext.setOnClickListener {
            if (index < questions.size - 1) {
                index++
                loadQuestion(txtQuestion, txtFeedback)
            } else {
                quiz.visibility = View.GONE
                scoreLayout.visibility = View.VISIBLE

                txtScore.text = getString(R.string.final_score_format, score, questions.size)
                Log.d("APP_LOG", "Final Score: $score")
            }
        }

        // 4. Restart Button Logic
        btnRestart.setOnClickListener {
            index = 0
            score = 0
            scoreLayout.visibility = View.GONE
            welcome.visibility = View.VISIBLE
        }
    }

    private fun loadQuestion(qView: TextView, feedback: TextView) {
        qView.text = questions[index]
        feedback.text = ""
        answered = false
        Log.d("APP_LOG", "Question Loaded: ${questions[index]}")
    }

    private fun checkAnswer(userAnswer: Boolean, feedback: TextView) {
        answered = true
        if (userAnswer == answers[index]) {
            score++
            feedback.text = getString(R.string.feedback_correct, explanations[index])
        } else {
            feedback.text = getString(R.string.feedback_wrong, explanations[index])
        }
    }
}
