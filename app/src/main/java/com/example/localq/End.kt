import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.localq.databinding.EndBinding


class End : Fragment() {


    private var _binding: EndBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = EndBinding.inflate(inflater, container, false)

        val score = arguments?.getInt("SCORE_KEY", 0) ?: 0  // Odbieramy score z Bundle
        binding.totalPoints.text = "$score"


//        binding.tryAgainbtn.setOnClickListener {
//
//            view?.findNavController()?.navigate(R.id.action_start2_to_questionsPzn)
//        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
    