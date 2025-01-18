package com.example.localq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.localq.databinding.QuestionsPznBinding
import com.example.localq.databinding.StartBinding
import androidx.core.content.ContextCompat



class QuestionsPzn : Fragment() {

    private var _binding: QuestionsPznBinding? = null
    private val binding get() = _binding!!

    private val questionsPzn = arrayOf(" W którym roku powstało słynne Muzeum Rogala Świętomarcińskiego w Poznaniu?","Test1","Test2","Test3","Test4")
    private val optionsPzn = arrayOf(arrayOf("A. 2003", "B. 2018", "C. 2014", "D. 2021"),
        arrayOf("A. 2003", "B. 2018", "C. 2014", "D. 2021"),
        arrayOf("A. 2003", "B. 2018", "C. 2014", "D. 2021"),
        arrayOf("A. 2003", "B. 2018", "C. 2014", "D. 2021"),
        arrayOf("A. 2003", "B. 2018", "C. 2014", "D. 2021"))

    private val correctAnswersPzn = arrayOf(0,2,3,1,1)
    private var currentQuestionsPznIndex = 0
    private var goldenOrange: Int = 0
    private var green: Int = 0
    private var yellowGreen: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goldenOrange = ContextCompat.getColor(requireContext(), R.color.goldenOrange)
        green = ContextCompat.getColor(requireContext(), R.color.green)
        yellowGreen = ContextCompat.getColor(requireContext(), R.color.yellowGreen)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = QuestionsPznBinding.inflate(inflater, container, false)

        //return inflater.inflate(R.layout.questions_pzn, container, false)

        displayQuestion()
        binding.answerPznB.setOnClickListener {
            checkAnswer(0)
        }
        binding.answerPznB.setOnClickListener {
            checkAnswer(1)
        }
        binding.answerPznC.setOnClickListener {
            checkAnswer(2)
        }
        binding.answerPznD.setOnClickListener {
            checkAnswer(3)
        }
        return binding.root
    }

    private fun correctButtonColors(buttonIndex: Int){

        when(buttonIndex){
            0 -> binding.answerPznA.setBackgroundColor(yellowGreen)
            1 -> binding.answerPznB.setBackgroundColor(yellowGreen)
            2 -> binding.answerPznC.setBackgroundColor(yellowGreen)
            3 ->binding.answerPznD.setBackgroundColor(yellowGreen)
        }
    }


    private fun wrongButtonColors(buttonIndex: Int){

        when(buttonIndex){
            0 -> binding.answerPznA.setBackgroundColor(goldenOrange)
            1 -> binding.answerPznB.setBackgroundColor(goldenOrange)
            2 ->binding.answerPznC.setBackgroundColor(goldenOrange)
            3 ->binding.answerPznD.setBackgroundColor(goldenOrange)
        }
    }
    private fun resetButton(){
        binding.answerPznA.setBackgroundColor(green)
        binding.answerPznB.setBackgroundColor(green)
        binding.answerPznC.setBackgroundColor(green)
        binding.answerPznD.setBackgroundColor(green)
        binding.answerPznA.isEnabled = true
        binding.answerPznB.isEnabled = true
        binding.answerPznC.isEnabled = true
        binding.answerPznD.isEnabled = true
    }

    private fun displayQuestion(){
        binding.questionPzn.text = questionsPzn[currentQuestionsPznIndex]
        binding.answerPznA.text = optionsPzn[currentQuestionsPznIndex][0]
        binding.answerPznB.text = optionsPzn[currentQuestionsPznIndex][1]
        binding.answerPznC.text = optionsPzn[currentQuestionsPznIndex][2]
        binding.answerPznD.text = optionsPzn[currentQuestionsPznIndex][3]
        resetButton()
    }

    private fun showNextQuestionBtn(){
        binding.nextQuestionBtn.visibility = View.VISIBLE
    }

    private fun disableAllButtons() {
        binding.answerPznA.isEnabled = false
        binding.answerPznB.isEnabled = false
        binding.answerPznC.isEnabled = false
        binding.answerPznD.isEnabled = false
    }


    private fun checkAnswer(selectedAnswerIndex: Int){
        val correctAnswerIndex = correctAnswersPzn[currentQuestionsPznIndex]
        disableAllButtons()

        if(selectedAnswerIndex == correctAnswerIndex){
            //score++
            correctButtonColors(selectedAnswerIndex)
            showNextQuestionBtn()
            binding.resultInfo.text = "PRAWIDŁOWA ODPOWIDŹ :)"
            binding.resultInfo.setTextColor(yellowGreen)
            binding.resultInfo.visibility = View.VISIBLE
        }else{
            wrongButtonColors(selectedAnswerIndex)
            showNextQuestionBtn()
            binding.resultInfo.text = "BŁĘDNA ODPOWIEDŹ :("
            binding.resultInfo.setTextColor(goldenOrange)
            binding.resultInfo.visibility = View.VISIBLE
        }

        binding.nextQuestionBtn.setOnClickListener {
            if(currentQuestionsPznIndex < questionsPzn.size -1){
                currentQuestionsPznIndex++
                binding.resultInfo.visibility = View.INVISIBLE
                displayQuestion()
            }else{
                binding.nextQuestionBtn.text = "ZAKOŃCZ QUIZ"
            }

        }

    }


}
