package ui.quiz;

public enum Questions {

    QUESTION1("Which of the following is considered a starchy vegetable?", new String[]{"Broccoli", "Capsicum", "Corn", "Spinach"}, "Corn"),
    QUESTION2("Which of the following is responsible for strengthening muscles, bones, and teeth??", new String[]{"Steak", "Spinach", "Wholegrain bread", "Kidney beans"}, "Minerals"),
    QUESTION3("How much water should an individual drink per day?", new String[]{"1.5 - 2 litres", "1 litre", "2 - 3 litres", "2.5 litres"}, "1.5 - 2 litres"),
    QUESTION4("What contains the most vitamin C?", new String[]{"Milk", "Oranges", "Bread", "Sprouts"}, "Sprouts");


    private final String question;
    private final String[] answers;
    private final String correctAnswer;

    Questions(String question, String[] answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public static Questions getQuestion(int i) {
        return Questions.values()[i];
    }
}
