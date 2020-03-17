package pk.edu.pucit.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private TextView min;
    private TextView plus;
    private TextView ac;
    private TextView dzero;
    private TextView zero;
    private TextView divi;
    private TextView mul;
    private TextView eq;
    private TextView dot;
    private TextView cl;
    private TextView mod;
    private TextView tv_result;
    private TextView tv_equation;
    private final char Addition = '+';
    private final char Subtraction = '-';
    private final char Multiplication = '*';
    private final char Division = '/';
    private final char Equation=0;
    private double val1 = Double.NaN;
    private double val2;
    private char Action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupUIView();
        zero.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
             tv_equation.setText(tv_equation.getText().toString()+ "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ "9");
            }
        });
        dzero.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ "00");
            }
        });
        dot.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                tv_equation.setText(tv_equation.getText().toString()+ ".");
            }
        });

        plus.setOnClickListener( new View.OnClickListener(){

            public void onClick(View v){
              compute();
              Action=Addition;
              tv_result.setText(String.valueOf(val1) + "+" );
              tv_equation.setText(null);
            }
        });
        min.setOnClickListener( new View.OnClickListener(){

            public void onClick(View v){
                compute();
                Action=Subtraction;
                tv_result.setText(String.valueOf(val1) + "-" );
                tv_equation.setText(null);
            }
        });
        divi.setOnClickListener( new View.OnClickListener(){

            public void onClick(View v){
                compute();
                Action=Division;
                tv_result.setText(String.valueOf(val1) + "/" );
                tv_equation.setText(null);
            }
        });
        mul.setOnClickListener( new View.OnClickListener(){

            public void onClick(View v){
                compute();
                Action=Multiplication;
                tv_result.setText(String.valueOf(val1) + "*" );
                tv_equation.setText(null);
            }
        });

        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                Action=Equation;
                tv_result.setText(tv_result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                tv_equation.setText(null);
            }
        });
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_equation.getText().length()>0){
                    CharSequence name= tv_equation.getText().toString();
                    tv_equation.setText(name.subSequence(0,name.length()-1));
                }
                else{
                    val1=Double.NaN;
                    val2=Double.NaN;
                    tv_equation.setText(null);
                    tv_result.setText(null);

                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_equation.setText("");
                tv_result.setText("");
            }
        });
    }
    private void setupUIView(){
        one=(TextView)findViewById(R.id.one);
        two=(TextView)findViewById(R.id.two);
        three=(TextView)findViewById(R.id.three);
        four=(TextView)findViewById(R.id.four);
        five=(TextView)findViewById(R.id.five);
        six=(TextView)findViewById(R.id.six);
        seven=(TextView)findViewById(R.id.seven);
        eight=(TextView)findViewById(R.id.eight);
        nine=(TextView)findViewById(R.id.nine);
        zero=(TextView)findViewById(R.id.zero);
        dzero=(TextView)findViewById(R.id.dzero);
        dot=(TextView)findViewById(R.id.dot);
        divi=(TextView)findViewById(R.id.divi);
        mul=(TextView)findViewById(R.id.mul);
        mod=(TextView)findViewById(R.id.mod);
        eq=(TextView)findViewById(R.id.eq);
        min=(TextView)findViewById(R.id.min);
        cl=(TextView)findViewById(R.id.cl);
        ac=(TextView)findViewById(R.id.ac);
        plus=(TextView)findViewById(R.id.plus);
        tv_equation=(TextView)findViewById(R.id.tv_equation);
        tv_result=(TextView)findViewById(R.id.tv_result);
    }

       private void compute(){
        if(!Double.isNaN(val1)){
            val2= Double.parseDouble(tv_equation.getText().toString());
            switch (Action){
                case Addition:
                    val1=val1 + val2;
                    break;
                case Subtraction:
                    val1=val1 - val2;
                    break;
                case Multiplication:
                    val1=val1 * val2;
                    break;
                case Division:
                    val1=val1/val2;
                    break;
                case Equation:
                    break;
            }
        }
        else{
            val1=Double.parseDouble(tv_equation.getText().toString());
        }
    }
}
