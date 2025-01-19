package com.example.localq



import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.localq.databinding.QuestionsPznBinding
import androidx.core.content.ContextCompat



class QuestionsPzn : Fragment() {

    private var _binding: QuestionsPznBinding? = null
    private val binding get() = _binding!!
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var questionsPzn: Array<String>
    private lateinit var optionsPzn: Array<Array<String>>
    private val correctAnswersPzn = arrayOf(2,0,2,2,0)
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

        questionsPzn = arrayOf(getString(R.string.firstQuestionPzn),
            getString(R.string.secondQuestionPzn),
            getString(R.string.thirdQuestionPzn),
            getString(R.string.fourthQuestionPzn),
            getString(R.string.fifthQuestionPzn))

        optionsPzn = arrayOf(
            arrayOf(getString(R.string.firstQestionPznAnsA), getString(R.string.firstQestionPznAnsB),
                getString(R.string.firstQestionPznAnsC), getString(R.string.firstQestionPznAnsD)),
            arrayOf(getString(R.string.secondQuestionPznAnsA), getString(R.string.secondQuestionPznAnsB),
                getString(R.string.secondQuestionPznAnsC), getString(R.string.secondQuestionPznAnsD)),
            arrayOf(getString(R.string.thirdQuestionPznAnsA), getString(R.string.thirdQuestionPznAnsB),
                getString(R.string.thirdQuestionPznAnsC), getString(R.string.thirdQuestionPznAnsD)),
            arrayOf(getString(R.string.fourthQuestionPznAnsA), getString(R.string.fourthQuestionPznAnsB),
                getString(R.string.fourthQuestionPznAnsC), getString(R.string.fourthQuestionPznAnsD)),
            arrayOf(getString(R.string.fifthQuestionPznAnsA), getString(R.string.fifthQuestionPznAnsB),
                getString(R.string.fifthQuestionPznAnsC), getString(R.string.fifthQuestionPznAnsD)))


        displayQuestion()
        binding.answerPznA.setOnClickListener {
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

    private fun setButtonColors(buttonIndex: Int, color: Int){

        when(buttonIndex){
            0 -> binding.answerPznA.setBackgroundColor(color)
            1 -> binding.answerPznB.setBackgroundColor(color)
            2 -> binding.answerPznC.setBackgroundColor(color)
            3 -> binding.answerPznD.setBackgroundColor(color)
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

        private fun changesAfterAnswered(result: Int, color: Int, soundResId: Int){
        showNextQuestionBtn()
        binding.resultInfo.text = getString(result)
        binding.resultInfo.setTextColor(color)
        binding.resultInfo.visibility = View.VISIBLE
        mediaPlayer = MediaPlayer.create(context, soundResId)
        mediaPlayer.start()
        if(currentQuestionsPznIndex == questionsPzn.size -1){
            binding.nextQuestionBtn.text = getString(R.string.finishQuiz)
    }
    }

    private fun checkAnswer(selectedAnswerIndex: Int){
        val correctAnswerIndex = correctAnswersPzn[currentQuestionsPznIndex]
        disableAllButtons()

        if(selectedAnswerIndex == correctAnswerIndex){
            //score++
            setButtonColors(selectedAnswerIndex, yellowGreen)
            changesAfterAnswered(R.string.resultCorrect, yellowGreen,  R.raw.correct)
        }else{
            setButtonColors(selectedAnswerIndex, goldenOrange)
            changesAfterAnswered(R.string.resultWrong, goldenOrange, R.raw.wrong)
        }

        binding.nextQuestionBtn.setOnClickListener {
            if(currentQuestionsPznIndex < questionsPzn.size -1){
                currentQuestionsPznIndex++
                binding.resultInfo.visibility = View.INVISIBLE
                binding.nextQuestionBtn.visibility = View.INVISIBLE
                displayQuestion()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer.release()
    }
}
