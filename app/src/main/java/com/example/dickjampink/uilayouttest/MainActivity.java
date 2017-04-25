package com.example.dickjampink.uilayouttest;

import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //左右括号计数器
    private int LeftBracket = 0;
    //小数点的输入判断
    private boolean PointCheck = true ;


    private TextView ResultScreen;
    //建立一个振动器对象：
    private Vibrator vibrator=null;
    Calculating calculating = new Calculating();
    OperateTabPriority operateTabPriority = new OperateTabPriority();

    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //实例化，编辑窗口
        ResultScreen = (TextView) findViewById(R.id.enter_message);

        //实例化这个振动器对象
        vibrator=(Vibrator)getSystemService(Service.VIBRATOR_SERVICE);

//        ResultScreen.setInputType(InputType.TYPE_NULL);  //输入类型为没有指定明确的类型的特殊内容类型，导致系统会不调用输入法


        ResultScreen.setKeyListener(null);//输入框的监听器：获得焦点后不会弹出输入法，监听值恒为NULL不做任何操作

        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();

        //当标题栏存在，就将其隐藏
        if (actionBar != null) actionBar.hide();

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //监视事件的声明：

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);
        findViewById(R.id.button12).setOnClickListener(this);
        findViewById(R.id.button13).setOnClickListener(this);
        findViewById(R.id.button14).setOnClickListener(this);
        findViewById(R.id.button15).setOnClickListener(this);
        findViewById(R.id.button16).setOnClickListener(this);
        findViewById(R.id.button17).setOnClickListener(this);
        findViewById(R.id.button18).setOnClickListener(this);
        findViewById(R.id.button19).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button1:

                vibrator.vibrate(10);//引发振动器振动，括号内是振动的时间，单位是 ms；

                if (!CheckEmpty()) {
                    ResultScreen.append("0");
                } else {
                    if (ResultScreen.getText().length() == 1 && ResultScreen.getText().charAt(0) != '0') {

                        ResultScreen.append("0");
                    } else if (ResultScreen.getText().length() > 1) {

                        CheckFinalNumber();

                        ResultScreen.append("0");
                    }

                }
                break;

            case R.id.button2: {

                vibrator.vibrate(10);
                try {
                    while (LeftBracket > 0) {

                        ResultScreen.append(")");
                        LeftBracket--;
                    }
                    String result = calculating.Calculate(ResultScreen.getText().toString());
                    ResultScreen.setText("");
                    ResultScreen.setText(result);

                    LeftBracket = 0;
                    PointCheck = true;
                } catch (Exception e) {
                    ResultScreen.setText(ResultScreen.getText());
                }

            }
            break;

            case R.id.button3:

                vibrator.vibrate(10);
                if (!CheckEmpty()){
                    ResultScreen.append("0.");
                    PointCheck = false;
                }
                else if (ResultScreen.getText().charAt(ResultScreen.length()-1)==')') {
                    ResultScreen.append("×0.");
                    PointCheck = false;
                }
                else if (ResultScreen.getText().charAt(ResultScreen.length()-1)=='(' || ResultScreen.getText().charAt(ResultScreen.length()-1)=='+'
                        || ResultScreen.getText().charAt(ResultScreen.length()-1)=='-' || ResultScreen.getText().charAt(ResultScreen.length()-1)=='×'
                        || ResultScreen.getText().charAt(ResultScreen.length()-1)=='÷' ) {

                    ResultScreen.append("0.");
                    PointCheck = false;
                }
                else {
                    if (PointCheck){
                        ResultScreen.append(".");
                        PointCheck = false;
                    }
                }

                break;

            case R.id.button4: {

                vibrator.vibrate(10);
                if (!CheckEmpty())
                    ResultScreen.append("0+");
                else {
                    CheckFinalTab();
                    if (ResultScreen.getText().charAt(ResultScreen.length()-1)=='('){
                        ResultScreen.append("0+");
                    }else
                    ResultScreen.append("+");
                    PointCheck = true;
                }
                break;
            }
            case R.id.button5:

                vibrator.vibrate(10);
                if (!CheckEmpty()) {
                    ResultScreen.append("1");
                } else {
                    CheckFinalNumber();
                    ResultScreen.append("1");
                }
                break;

            case R.id.button6:

                vibrator.vibrate(10);
                if (!CheckEmpty()) {
                    ResultScreen.append("2");
                } else {
                    CheckFinalNumber();
                    ResultScreen.append("2");
                }
                break;

            case R.id.button7:

                vibrator.vibrate(10);
                if (!CheckEmpty()) {
                    ResultScreen.append("3");
                } else {
                    CheckFinalNumber();
                    ResultScreen.append("3");
                }
                break;

            case R.id.button8:

                vibrator.vibrate(10);
                if (!CheckEmpty()) {
                    ResultScreen.append("4");
                } else {
                    CheckFinalNumber();
                    ResultScreen.append("4");
                }

                break;

            case R.id.button9:

                vibrator.vibrate(10);
                if (!CheckEmpty()) {
                    ResultScreen.append("5");
                } else {
                    CheckFinalNumber();
                    ResultScreen.append("5");
                }

                break;

            case R.id.button10:

                vibrator.vibrate(10);
                if (!CheckEmpty()) {
                    ResultScreen.append("6");
                } else {
                    CheckFinalNumber();
                    ResultScreen.append("6");
                }
                break;

            case R.id.button11:

                vibrator.vibrate(10);
                if (!CheckEmpty())
                    ResultScreen.append("0-");
                else{
                    CheckFinalTab();
                    if (ResultScreen.getText().charAt(ResultScreen.length()-1)=='(')
                        ResultScreen.append("0-");
                    else
                    ResultScreen.append("-");
                    PointCheck = true;
                }
                break;

            case R.id.button12:

                vibrator.vibrate(10);
                if (!CheckEmpty()) {
                    ResultScreen.append("7");
                } else {
                    CheckFinalNumber();
                    ResultScreen.append("7");
                }

                break;

            case R.id.button13:

                vibrator.vibrate(10);
                if (!CheckEmpty()) {
                    ResultScreen.append("8");
                } else {
                    CheckFinalNumber();
                    ResultScreen.append("8");
                }
                break;

            case R.id.button14:

                vibrator.vibrate(10);
                if (!CheckEmpty()) {
                    ResultScreen.append("9");
                } else {
                    CheckFinalNumber();
                    ResultScreen.append("9");
                }
                break;

            case R.id.button15:

                vibrator.vibrate(10);
                if (CheckEmpty()) {
                    CheckFinalTab();
                    if (ResultScreen.getText().charAt(ResultScreen.getText().length() - 1) != '('){

                        ResultScreen.append("×");
                        PointCheck = true;
                    }

                }
                break;

            case R.id.button16: {

                vibrator.vibrate(10);
                ResultScreen.setText("");

                LeftBracket = 0;
                PointCheck = true;

            }
            break;

            case R.id.button17:

                vibrator.vibrate(10);
                //当从未输入数据时，允许“（ ” 的输入
                if (!CheckEmpty()) {
                    ResultScreen.append("(");
                    PointCheck = true;
                    LeftBracket++;
                    break;
                }

                //当输入的数据末尾是“（ ”或是操作符的时候，允许“（ ” 的输入
                char FinalChar = ResultScreen.getText().toString().charAt(ResultScreen.getText().length() - 1);
                if (FinalChar == '(' || operateTabPriority.CheckfinalTab(FinalChar)) {
                    ResultScreen.append("(");
                    PointCheck = true;
                    LeftBracket++;
                    break;
                }

                /*
                  两种特殊情况：   1.数据的末尾是“ . ”时，添加“ 0× ”，使其满足正常的表达式
                                  2.数据的末尾是 数字 时，添加“ × ”，使其满足正常的表达式
                 */
                if (FinalChar == '.') {
                    ResultScreen.append("0×(");
                    PointCheck = true;
                    LeftBracket++;
                } else {
                    ResultScreen.append("×(");
                    PointCheck = true;
                    LeftBracket++;
                }
                break;

            case R.id.button18:

                vibrator.vibrate(10);
                if (CheckEmpty() && LeftBracket > 0) {
                    ResultScreen.append(")");
                    PointCheck = true;
                    LeftBracket--;
                }
                break;

            case R.id.button19:

                vibrator.vibrate(10);
                if (CheckEmpty()) {
                    CheckFinalTab();
                    if (ResultScreen.getText().charAt(ResultScreen.getText().length() - 1) != '('){
                        ResultScreen.append("÷");
                        PointCheck = true;
                    }
                }
                break;

        }
    }

    private String DeleteFinalTab(String temp) {
        return temp.substring(0, temp.length() - 1);
    }

    private void CheckFinalTab() {
        String RealityOut = ResultScreen.getText().toString();
        try {
            if (operateTabPriority.CheckfinalTab(RealityOut.charAt(ResultScreen.getText().length() - 1))) {
                ResultScreen.setText(this.DeleteFinalTab(RealityOut));
            }
        } catch (Exception e) {
            ResultScreen.setText("");
        }

    }

    private boolean CheckEmpty() {
        return (ResultScreen.getText().length() > 0);
    }

    private void CheckFinalNumber() {
        String RealityOut = ResultScreen.getText().toString();

        if (RealityOut.charAt(RealityOut.length() - 1) == ')') {

            ResultScreen.append("×");

        } else if (RealityOut.length() == 1 && RealityOut.charAt(0) == '0') {

            ResultScreen.setText("");

        } else if (RealityOut.length() > 1) {

            if (RealityOut.charAt(RealityOut.length() - 1) == '0') {

                if (operateTabPriority.CheckfinalTab(RealityOut.charAt(RealityOut.length() - 2))
                        || RealityOut.charAt(RealityOut.length() - 2) == '(') {

                    ResultScreen.setText(this.DeleteFinalTab(RealityOut));
                }
            }
        }
    }
}
