package sg.com.kaplan.ipptcalculator;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // 2 edit text for user to input weight and height, 1 textview for user to see the result and 1 button to start the code
        final TextView status = (TextView) findViewById(R.id.textViewStatus);
        final EditText editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        final EditText editTextHeight = (EditText) findViewById(R.id.editTextHeight);
        Button button = (Button) findViewById(R.id.buttonCheck);

        //media player used when user found out their bmi result
        final MediaPlayer soundObese = MediaPlayer.create(this, R.raw.obese);
        final MediaPlayer soundOverweight = MediaPlayer.create(this, R.raw.overweight);
        final MediaPlayer soundNormalweight = MediaPlayer.create(this, R.raw.normal);
        final MediaPlayer soundUnderweight = MediaPlayer.create(this, R.raw.underweight);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight = Double.parseDouble(editTextWeight.getText().toString());
                double height = Double.parseDouble(editTextHeight.getText().toString());
                double bmi = weight / (height * height);

                String statusText;
                int statusColor;

                //if else statement used to figure the bmi index
                if (bmi > 27.5) {
                    statusText = "Obese! Start to workout!";
                    statusColor = Color.RED;
                    soundObese.start();
                    Toast.makeText(getApplicationContext(), "obese", Toast.LENGTH_SHORT).show();
                } else if (bmi > 23) {
                    statusText = "Overweight! Watch Out for your diet!";
                    statusColor = Color.YELLOW;
                    soundOverweight.start();
                } else if (bmi > 18.5) {
                    statusText = "Normal weight! Keep It Up!";
                    statusColor = Color.GREEN;
                    soundNormalweight.start();
                } else {
                    statusText = "Underweight! Consume more!";
                    statusColor = Color.WHITE;
                    soundUnderweight.start();
                }

                status.setText(statusText);
                status.setBackgroundColor(statusColor);
            }
        });
    }
}
