package ui.bmicalculator

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import ui.R
import java.text.DecimalFormat

class BmiCalculatorFragment : Fragment() {
    private var scoreTextView: TextView? = null
    private var inputWeight: EditText? = null
    private var inputHeight: EditText? = null
    private var recipeTextView: TextView? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_bmi_calculator, container, false)
        inputWeight = rootView.findViewById(R.id.inputWeightEditText)
        inputHeight = rootView.findViewById(R.id.inputHeightEditText)
        scoreTextView = rootView.findViewById(R.id.scoreView)
        recipeTextView = rootView.findViewById(R.id.recipeView)
        val countBtn = rootView.findViewById<Button>(R.id.countBtn)
        countBtn.setOnClickListener { printBMIScore(calculateBMI()) }
        return rootView
    }

    private fun printBMIScore(score: Double) {
        scoreTextView!!.text = String.format("%s%s", getString(R.string.score_bmi_message), decimalFormat.format(score))
        if (score > 25.0) {
            val spanned = Html.fromHtml("<p style=\"text-align:justify\">Pat pork chops dry with paper towels, then coat both sides with oil. In a medium bowl, combine Parmesan and spices. Coat both sides of pork chops with Parmesan mixture. Place pork chops in basket of air fryer and cook at 375° for 9 minutes, flipping halfway through </p>\n ")
            recipeTextView!!.text = spanned
        } else {
            val spanned = Html.fromHtml("""<p style="text-align:justify">Preheat oven to 325º. Place peppers in a large baking dish and bake until tender, 30 minutes.
                    Meanwhile, in a large skillet over medium-high heat, heat oil. Add onions and mushrooms and season with salt and pepper. Cook until soft, 6 minutes. Add steak and season with more salt and pepper. Cook, stirring occasionally, 3 minutes. Stir in Italian seasoning.
            Add provolone to bottom of baked peppers and top with steak mixture. Top with another piece of provolone and broil until golden, 3 minutes.
                    Garnish with parsley before serving. </p>
 """)
            recipeTextView!!.text = spanned
        }
    }

    private fun calculateBMI(): Double {
        val weight = inputWeight!!.text.toString().toDouble()
        val height = inputHeight!!.text.toString().toDouble() / 100
        return weight / Math.pow(height, 2.0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object {
        private val decimalFormat = DecimalFormat("#.##")
    }
}