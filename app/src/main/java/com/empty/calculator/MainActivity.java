package com.empty.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;


public class MainActivity extends AppCompatActivity {
    //按钮id数组的
    private int[] id = new int[]{R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9, R.id.btnDel, R.id.btnC, R.id.btnAdd, R.id.btnLess, R.id.btnX, R.id.btnExc, R.id.btnPoint, R.id.btnEqual,R.id.btnPer};
    //按钮数组
    private Button[] btn = new Button[id.length];
    //输入显示和结果显示
    TextView tvShow, tvResult;
    //输入内容的拼接字符串
    private StringBuilder str =  new StringBuilder();
    //结果
    private double result = 0;
    //使用arity计算器引擎
    private Symbols symbols = new Symbols();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShow = (TextView) findViewById(R.id.tvShow);
        tvResult = (TextView) findViewById(R.id.tvResult);


        for (int i = 0; i < id.length; i++) {
            //批量关联按钮
            btn[i] = (Button) findViewById(id[i]);
            //批量添加监听
            btn[i].setOnClickListener(new OnClick());
        }
    }
    //清除功能

    public void clean(){
        if(str.length()!=0){
            str.delete(0,str.length());
            result=0;
            tvShow.setText(str.toString());
            tvResult.setText("");
        }
    }
    //删除最后一位功能

    public void delete(){
        if(str.length()!=0){
            str.delete(str.length()-1,str.length());

        }
    }
    //等于功能

    public void equal(){
        try {
            result=symbols.eval(str.toString());
        } catch (SyntaxException e) {
            e.printStackTrace();
        }
        tvResult.setText(String.valueOf(result));
    }
    //按钮单击事件处理


    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //功能键
                case R.id.btnC:
                    clean();
                    return;
                case R.id.btnDel:
                    delete();
                    break;
                case R.id.btnEqual:
                    equal();
                    break;
                //普通键
                default:
                    if (v instanceof Button) {
                        String text=((Button) v).getText().toString();
                        str.append(text);
                    }

            }
            //实时输入显示
            tvShow.setText(str);



        }

    }
}

