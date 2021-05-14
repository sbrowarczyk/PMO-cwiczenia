package pl.pamo.ui.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pl.pamo.R;
//import pl.pamo.databinding.FragmentDashboardBinding;

public class QuizFragment extends Fragment {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private TextView question;
    private int points;
    private int round;
    private TextView pointsCoutner;
    private List<Button> buttons;
    private String currentCorrectAnswer;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        points = 0;
        round = 0;

        View rootView = inflater.inflate(R.layout.fragment_quiz, container, false);

        btn1 = rootView.findViewById(R.id.btn_one);
        btn2 = rootView.findViewById(R.id.btn_two);
        btn3 = rootView.findViewById(R.id.btn_three);
        btn4 = rootView.findViewById(R.id.btn_four);
        question = rootView.findViewById(R.id.tv_question);
        pointsCoutner = rootView.findViewById(R.id.tv_score);

        buttons = new ArrayList<>();
        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);

        for (Button b : buttons) {
            b.setOnClickListener(onClickListener);
        }


        nextQuestion();

        return rootView;
    }

    private void nextQuestion() {

        if (round >= Questions.values().length) {

            pointsCoutner.setText(R.string.final_points_message + points);
            currentCorrectAnswer = "";
            for (Button b : buttons) {
                b.setVisibility(View.INVISIBLE);
            }
            question.setVisibility(View.INVISIBLE);
            return;
        }
        Questions question = Questions.getQuestion(round);
        setQuestion(question);
        currentCorrectAnswer = question.getCorrectAnswer();
    }


    private void setQuestion(Questions q) {
        question.setText(q.getQuestion());

        Iterator<Button> iterator = buttons.iterator();
        String[] answers = q.getAnswers();

        for (String s : answers) {
            Button button = iterator.next();
            button.setText(s);
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            round++;
            Button clickedButton = (Button) v;
            String buttonAnswer = clickedButton.getText().toString();

            if (buttonAnswer.equals(currentCorrectAnswer)) {
                points++;
            }

            nextQuestion();
            pointsCoutner.setText("Points: " + points);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}