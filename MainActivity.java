import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button swapButton;
    private Button checkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        swapButton = findViewById(R.id.swapButton);
        checkButton = findViewById(R.id.checkButton);

        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = editText1.getText().toString();
                editText1.setText(editText2.getText().toString());
                editText2.setText(temp);
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                if (text1.equals(text2)) {
                    intent.putExtra("result", "SAME");
                } else {
                    intent.putExtra("result", "NOT THE SAME");
                }
                startActivity(intent);
            }
        });
    }
}
