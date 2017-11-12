package sg.com.kaplan.ipptcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //progress bar used to do a simple loading animation when user click on each of the 4 button used.

        final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        //button to link to activity2
        Button a = (Button) findViewById(R.id.timerbutton);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleProgressBar.setVisibility(View.VISIBLE);
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);

            }
        });


        //button to link to activity3
                Button b = (Button) findViewById(R.id.bmibutton);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        simpleProgressBar.setVisibility(View.VISIBLE);
                        Intent i = new Intent(MainActivity.this, Main3Activity.class);
                        startActivity(i);

                    }
                });


        //button to link to activity4
                        Button c = (Button) findViewById(R.id.ipptbutton);
                        c.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                simpleProgressBar.setVisibility(View.VISIBLE);
                                Intent i = new Intent(MainActivity.this, Main4Activity.class);
                                startActivity(i);

                            }
                        });

        //button to link to the last activity
        Button d = (Button) findViewById(R.id.workoutButton);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleProgressBar.setVisibility(View.VISIBLE);
                Intent i = new Intent(MainActivity.this, images.class);
                startActivity(i);

            }
        });

                                    }
                                }