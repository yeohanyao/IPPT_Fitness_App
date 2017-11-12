package sg.com.kaplan.ipptcalculator;



import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView time;
    private Button start;
    private Button cancel;
    private CountDownTimer countDownTimer;

    //button used on timer button, user can click start and cancel using switch case
    private View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.start :
                    start();
                    break;
                case R.id.cancel :
                    cancel();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(btnClickListener);
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(btnClickListener);
        time = (TextView) findViewById(R.id.time);
    }

    //the time and count down speed can be adjusted below, but as a ippt counter, 60 seconds is the standard used, thus non adjustable for front end user.
    private void start() {
        time.setText("60");

        countDownTimer = new CountDownTimer(60 * 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                time.setText("Done!");
            }
        };

        countDownTimer.start();
    }



    private void cancel() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }
}
