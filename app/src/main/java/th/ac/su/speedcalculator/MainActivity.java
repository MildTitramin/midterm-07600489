package th.ac.su.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calButton = findViewById(R.id.cal);
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText meterB = findViewById(R.id.meter);
                EditText secondB = findViewById(R.id.second);
                String meter = meterB.getText().toString();
                String second = secondB.getText().toString();


                if(meter.isEmpty() || second.isEmpty()){
                    Toast t = Toast.makeText(MainActivity.this,
                            R.string.D,
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else if(second.equals("0")){
                    Toast t = Toast.makeText(MainActivity.this,
                            R.string.T,
                            Toast.LENGTH_LONG);
                    t.show();
                }
                else{
                    //สูตรคำนวณ ความเร็ว/1000 * 3600/เวลา
                    double myDoubleVar = Double.parseDouble(meter);
                    double myDoubleVar2 = Double.parseDouble(second);
                    double answer = myDoubleVar/1000 * 3600/myDoubleVar2;

                    if(answer > 80.0){
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("SPEED CALCULATOR");
                        dialog.setMessage(R.string.speedisover);
                        dialog.setPositiveButton("OK",null);
                        dialog.show();
                    }

                }
            }
        });

        Button clearB = findViewById(R.id.clear);
        clearB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText m = findViewById(R.id.meter);
                EditText s = findViewById(R.id.second);
                TextView Text = findViewById(R.id.answer);
                m.setText("");
                s.setText("");
                Text.setText("");
            }
        });



    }
}