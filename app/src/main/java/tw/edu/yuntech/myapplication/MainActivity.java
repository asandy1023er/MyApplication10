package tw.edu.yuntech.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.text.util.Linkify;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import javax.xml.transform.Result;

import static android.transition.TransitionSet.ORDERING_SEQUENTIAL;

public class MainActivity extends AppCompatActivity {

    Button B1,B3;
    TextView T1,T2;
    EditText E1,E2;
    RadioButton RR1,RR2,RR3;


    //RadioGroup R1=findViewById(R.id.R1);
    int num=4;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int num1 = 0,num2=0,num3=0;
        B1=findViewById(R.id.B1);
        B3=findViewById(R.id.B3);
        E1=findViewById(R.id.E1);
        E2=findViewById(R.id.E2);
        RR1=findViewById(R.id.RR1);
        RR2=findViewById(R.id.RR2);
        RR3=findViewById(R.id.RR3);
        /*R1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i){
                    case R.id.RR1:
                        num=0;
                        break;
                    case R.id.RR2:
                        num=1;
                        break;
                    case R.id.RR3:
                        num=2;
                        break;
                }
            }
        });*/
        B1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                Double a,b,o;
                s=E1.getText().toString();
                a=Double.valueOf(s);
                s=E2.getText().toString();
                b=Double.valueOf(s);
                if(RR1.isChecked()){
                    o=a*b;
                    Intent intent =new Intent(MainActivity.this , MainActivity2.class);
                    Bundle bundle1 =new Bundle();
                    bundle1.putDouble("num1" , a);
                    bundle1.putDouble("num2" , b);
                    bundle1.putDouble("num3" , o);
                    intent.putExtras(bundle1);
                    Transition trans1= TransitionInflater.from(MainActivity.this).inflateTransition(android.R.transition.slide_top);
                    getWindow().setExitTransition(trans1);
                    startActivity(intent);
                }else if(RR2.isChecked()){
                    o=a*b/2;
                    Intent intent =new Intent(MainActivity.this , MainActivity2.class);
                    Bundle bundle1 =new Bundle();
                    bundle1.putDouble("num1" , a);
                    bundle1.putDouble("num2" , b);
                    bundle1.putDouble("num3" , o);
                    intent.putExtras(bundle1);
                    Transition trans1= TransitionInflater.from(MainActivity.this).inflateTransition(android.R.transition.slide_top);
                    getWindow().setExitTransition(trans1);
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                }else{
                    Double a2=a/2;
                    Double b2=b/2;
                    Double area = a2 * b2 * 3.14D;
                    o=area;
                    Intent intent =new Intent(MainActivity.this , MainActivity2.class);
                    Bundle bundle1 =new Bundle();
                    bundle1.putDouble("num1" , a);
                    bundle1.putDouble("num2" , b);
                    bundle1.putDouble("num3" , o);
                    intent.putExtras(bundle1);
                    Transition trans1= TransitionInflater.from(MainActivity.this).inflateTransition(android.R.transition.slide_top);
                    getWindow().setExitTransition(trans1);
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                }

            }
        });
        B3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this , MainActivity3.class);
                Transition trans1= TransitionInflater.from(MainActivity.this).inflateTransition(android.R.transition.explode);
                getWindow().setExitTransition(trans1);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });


    }
}