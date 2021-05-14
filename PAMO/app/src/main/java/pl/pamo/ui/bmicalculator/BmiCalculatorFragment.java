package pl.pamo.ui.bmicalculator;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

import pl.pamo.R;

public class BmiCalculatorFragment extends Fragment {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private TextView scoreTextView;
    private EditText inputWeight;
    private EditText inputHeight;
    private TextView recipeTextView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_bmi_calculator, container, false);

        inputWeight = rootView.findViewById(R.id.inputWeightEditText);
        inputHeight = rootView.findViewById(R.id.inputHeightEditText);
        scoreTextView = rootView.findViewById(R.id.scoreView);
        recipeTextView = rootView.findViewById(R.id.recipeView);
        Button countBtn = rootView.findViewById(R.id.countBtn);

        countBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                printBMIScore(calculateBMI());
            }
        });

        return rootView;
    }

    private void printBMIScore(double score) {
        scoreTextView.setText(String.format("%s%s", getString(R.string.score_bmi_message), decimalFormat.format(score)));
        if (score > 25.0) {
            Spanned spanned = Html.fromHtml("<p style=\"text-align:justify\">Pat pork chops dry with paper towels, then coat both sides with oil. In a medium bowl, combine Parmesan and spices. Coat both sides of pork chops with Parmesan mixture. Place pork chops in basket of air fryer and cook at 375° for 9 minutes, flipping halfway through </p>\n ");

            recipeTextView.setText(spanned);
        } else {
            Spanned spanned = Html.fromHtml("<p style=\"text-align:justify\">Preheat oven to 325º. Place peppers in a large baking dish and bake until tender, 30 minutes.\n" +
                    "                    Meanwhile, in a large skillet over medium-high heat, heat oil. Add onions and mushrooms and season with salt and pepper. Cook until soft, 6 minutes. Add steak and season with more salt and pepper. Cook, stirring occasionally, 3 minutes. Stir in Italian seasoning.\n" +
                    "            Add provolone to bottom of baked peppers and top with steak mixture. Top with another piece of provolone and broil until golden, 3 minutes.\n" +
                    "                    Garnish with parsley before serving. </p>\n ");

            recipeTextView.setText(spanned);
        }
    }


    private double calculateBMI() {
        double weight = Double.parseDouble(inputWeight.getText().toString());
        double height = Double.parseDouble(inputHeight.getText().toString()) / 100;
        return weight / Math.pow(height, 2);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}