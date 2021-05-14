package pl.pamo.ui.bmrcalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

import pl.pamo.R;

public class BmrCalculator extends Fragment {

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
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private TextView scoreTextView;
    private EditText inputWeight;
    private EditText inputHeight;
    private EditText inputAge;
    private String gender;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_harris_benedict_calculator, container, false);

        inputWeight = rootView.findViewById(R.id.inputWeightEditText);

        inputHeight = rootView.findViewById(R.id.inputHeightEditText);

        inputAge = rootView.findViewById(R.id.inputAgeEditText);

        scoreTextView = rootView.findViewById(R.id.scoreView);

        Spinner genderSpinner = rootView.findViewById(R.id.spinner);
        Button countBtn = rootView.findViewById(R.id.countBtn);

        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(
                getContext(), R.array.gender_list, android.R.layout.simple_spinner_item);

        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        genderSpinner.setAdapter(staticAdapter);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                gender = "Kobieta";
            }
        });

        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printBmrScore(countBMR());
            }


        });

        return rootView;
    }


    private void printBmrScore(double score) {
        scoreTextView.setText(String.format("%s%s", getString(R.string.score_bmr_message), decimalFormat.format(score)));
    }


    private double countBMR() {
        double weight = Double.parseDouble(inputWeight.getText().toString());
        double height = Double.parseDouble(inputHeight.getText().toString());
        double age = Double.parseDouble(inputAge.getText().toString());
        double score;
        switch (gender) {

            case "Male":
                score = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
                break;
            case "Female":
                score = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gender);
        }
        return score;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
