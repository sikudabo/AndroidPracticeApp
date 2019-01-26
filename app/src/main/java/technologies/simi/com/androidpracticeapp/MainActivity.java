package technologies.simi.com.androidpracticeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Below we will create variables that will reference the UI widgets in the onCreate() method.
    //We create the variables here so that they have a "class scope" and can be accessed anywhere in the class.
    //But the widgets will not be initialized until the onCreate() method.
    private int value = 0; //We give each variable the private access modifier since they won't be accessed outside of the class.
    private Button btnAdd;
    private Button btnTake;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnHide;
    private Button btnReset;
    private TextView txtValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
        We initialize each widget in the onCreate() method so that they can be intialized before the
        activity starts. When we intialize them we do so by first "type casting" so that we are sure
        the widget is referencing the correct "type". We do this because the findViewById() method is
        polymorphic and could return an Object of any widget "type". We then use the R.id.nameOfWidget method
        to make sure that we are referencing the proper widget. The Object is stored in the memory "heap" and the
        reference Object that we are creating will be stored in the memory "stack".
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnTake = (Button) findViewById(R.id.btnTake);
        btnGrow = (Button) findViewById(R.id.btnGrow);
        btnShrink = (Button) findViewById(R.id.btnShrink);
        btnHide = (Button) findViewById(R.id.btnHide);
        btnReset = (Button) findViewById(R.id.btnReset);
        txtValue = (TextView) findViewById(R.id.txtValue);

        //Below we set an onClickListener for each widget and we pass "this" instance of MainActivity as the argument to the method.
        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnHide.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        txtValue.setOnClickListener(this);
    }

    public void onClick(View v){
        /*
        param: View v: The widget (View) that will be passed to the onClick method and operated on.
         */

        float size; //This is a local variable that cannot be accessed outside of the method.


        switch(v.getId()){//Create a switch statement to perform a series of operations depending on which widget is passed.

            case R.id.btnAdd:
                value++;
                txtValue.setText("" + value);
                break;

            case R.id.btnTake:
                value--;
                txtValue.setText("" + value);
                break;

            case R.id.btnReset:
                value = 0;
                txtValue.setText("" + value);
                break;

            case R.id.btnGrow:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size + 1);
                break;

            case R.id.btnShrink:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size - 1);
                break;

            case R.id.btnHide:
                if(txtValue.getVisibility() == View.VISIBLE){
                    txtValue.setVisibility(View.INVISIBLE);
                    btnHide.setText("SHOW");
                }

                else{
                    txtValue.setVisibility(View.VISIBLE);
                    btnHide.setText("HIDE");
                }
                break;
       }
    }
}
