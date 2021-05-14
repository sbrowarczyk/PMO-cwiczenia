package ui.bmrcalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import pl.pamo.R
import java.text.DecimalFormat

class BmrCalculator : Fragment() {
    private var scoreTextView: TextView? = null
    private var inputWeight: EditText? = null
    private var inputHeight: EditText? = null
    private var inputAge: EditText? = null
    private var gender: String? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_harris_benedict_calculator, container, false)
        inputWeight = rootView.findViewById(R.id.inputWeightEditText)
        inputHeight = rootView.findViewById(R.id.inputHeightEditText)
        inputAge = rootView.findViewById(R.id.inputAgeEditText)
        scoreTextView = rootView.findViewById(R.id.scoreView)
        val genderSpinner = rootView.findViewById<Spinner>(R.id.spinner)
        val countBtn = rootView.findViewById<Button>(R.id.countBtn)
        val staticAdapter = ArrayAdapter.createFromResource(
                requireContext(), R.array.gender_list, android.R.layout.simple_spinner_item)
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        genderSpinner.adapter = staticAdapter
        genderSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                gender = parent.getItemAtPosition(position) as String
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                gender = "Kobieta"
            }
        }
        countBtn.setOnClickListener { printBmrScore(countBMR()) }
        return rootView
    }

    private fun printBmrScore(score: Double) {
        scoreTextView!!.text = String.format("%s%s", getString(R.string.score_bmr_message), decimalFormat.format(score))
    }

    private fun countBMR(): Double {
        val weight = inputWeight!!.text.toString().toDouble()
        val height = inputHeight!!.text.toString().toDouble()
        val age = inputAge!!.text.toString().toDouble()
        val score: Double
        score = when (gender) {
            "Male" -> 66.5 + 13.75 * weight + 5.003 * height - 6.775 * age
            "Female" -> 655.1 + 9.563 * weight + 1.85 * height - 4.676 * age
            else -> throw IllegalStateException("Unexpected value: $gender")
        }
        return score
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object {
        /*
      Dla mężczyzn przyjmuje postać:
        66,5 + 13,75M + 5,003W – 6,775 L

      Dla kobiet natomiast:

        655,1 + (9,563*M) + (1,85*W) – (4,676 *L)
       gdzie:

       M – oznacza masę ciała w kilogramach
       W – wzrost w centymetrach
       L – wiek w latach


       */
        private val decimalFormat = DecimalFormat("#.##")
    }
}