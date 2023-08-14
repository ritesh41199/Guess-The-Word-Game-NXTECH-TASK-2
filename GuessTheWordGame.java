import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheWordGame extends JFrame implements ActionListener {
    private String[] words = {"apple", "banana", "orange", "grape", "watermelon"};
    private String hiddenWord;
    private int attempts = 3;

    private JLabel titleLabel;
    private JLabel wordLabel;
    private JTextField guessTextField;
    private JButton guessButton;

    public GuessTheWordGame() {
        setTitle("Guess the Word Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        titleLabel = new JLabel("Guess the Word!");
        wordLabel = new JLabel("");
        guessTextField = new JTextField(15);
        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);

        add(titleLabel);
        add(wordLabel);
        add(guessTextField);
        add(guessButton);

        initializeGame();
    }

    private void initializeGame() {
        int randomIndex = (int) (Math.random() * words.length);
        hiddenWord = words[randomIndex];
        attempts = 3;
        wordLabel.setText("Attempts left: " + attempts);
        guessTextField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (attempts > 0) {
            String guessedWord = guessTextField.getText().toLowerCase();
            if (guessedWord.equals(hiddenWord)) {
                wordLabel.setText("Congratulations! You guessed the word.");
                guessButton.setEnabled(false);
            } else {
                attempts--;
                wordLabel.setText("Attempts left: " + attempts);
                if (attempts == 0) {
                    wordLabel.setText("Out of attempts. The word was: " + hiddenWord);
                    guessButton.setEnabled(false);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GuessTheWordGame game = new GuessTheWordGame();
            game.setVisible(true);
        });
    }
}
