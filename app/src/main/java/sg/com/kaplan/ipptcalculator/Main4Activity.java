package sg.com.kaplan.ipptcalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // 2 edit text used to input the push up and sit up count, 1 textview to show the ippt result, 1 button to start the java code
        final TextView ipptresult = (TextView) findViewById(R.id.ipptresult);
        final EditText pushup = (EditText) findViewById(R.id.pushup);
        final EditText situp = (EditText) findViewById(R.id.situp);
        Button button = (Button) findViewById(R.id.resultbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double pushupcount = Double.parseDouble(pushup.getText().toString());
                double situpcount = Double.parseDouble(situp.getText().toString());
                double result = pushupcount + situpcount;

                String statusText;
                int statusColor;

                //based on actual mindef IPPT calculator, with a fixed 2.4km running timing of 11 minutes, users need to hit the count to get the below if else statement.
                if (result >= 107 && result <= 116 ) {
                    statusText = "Gold!! $500 Incentive!";
                    statusColor = Color.YELLOW;
                    Toast.makeText(getApplicationContext(), "Excellent", Toast.LENGTH_SHORT).show();
                } else if (result >= 70 && result < 107) {
                    statusText = "Silver!! $300 Incentive!";
                    statusColor = Color.LTGRAY;
                    Toast.makeText(getApplicationContext(), "Well Done", Toast.LENGTH_SHORT).show();
                } else if (result > 33 && result < 70) {
                    statusText = "You Pass!! $200 incentive!";
                    statusColor = Color.GREEN;
                    Toast.makeText(getApplicationContext(), "Keep It Up", Toast.LENGTH_SHORT).show();
                } else {
                    statusText = "Fail! Register for RT session!";
                    statusColor = Color.RED;
                    Toast.makeText(getApplicationContext(), "Try Harder", Toast.LENGTH_SHORT).show();
                }

                ipptresult.setText(statusText);
                ipptresult.setBackgroundColor(statusColor);
            }
        });
    }
}