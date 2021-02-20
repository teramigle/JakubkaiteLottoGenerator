    package lt.vtmc.jakubkaitelottogenerator;

    import android.os.Bundle;
    import android.text.InputFilter;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import androidx.appcompat.app.AppCompatActivity;
    import java.util.Arrays;

    public class MainActivity extends AppCompatActivity {
    private EditText inputText;
    private Button button;
    private TextView outputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputText = findViewById(R.id.inputText);
        inputText.setFilters( new InputFilter[]{ new MinMaxFilter( "0" , "10" )}) ;
        button = findViewById(R.id.button);
        outputText = findViewById(R.id.outputText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(inputText.getText().toString());
                    int[] array = getArray(number);
                    outputText.setText("Random numbers: \n" + Arrays.toString(array));

                } catch (NumberFormatException ignored) {
                }
            }

            private int[] getArray(int number) {
                int[] array = new int[number];
                for (int i = 0; i < number; i++){
                    int random = (int) (Math.random() * ((100 - 0) + 1)) + 0;
                    array[i] = random;
                }return array;
            }
        });
//        inputText.setOnFocusChangeListener( new OnFocusChangeListenerMin("0"));
//        inputText.setFilters(new InputFilter[]{new InputFilterMax("10")});
    }

}