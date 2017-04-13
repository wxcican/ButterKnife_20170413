package com.fuicuiedu.xc.butterknife_20170413;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_btn)
    Button button;//单行复制  ctrl + d     单行删除  ctrl + y
    @BindView(R.id.main_tv1)
    TextView textView1;//单行复制  ctrl + d     单行删除  ctrl + y
    @BindView(R.id.main_tv2)
    TextView textView2;//单行复制  ctrl + d     单行删除  ctrl + y
    @BindView(R.id.main_tv3)
    TextView textView3;//单行复制  ctrl + d     单行删除  ctrl + y

    //序列化格式   ctrl + alt + L


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);//不要忘记这一步

        button.setText("面对疾风吧");
        textView1.setText("面对疾风吧");
        textView2.setText("面对疾风吧");
        textView3.setText("面对疾风吧");

    }
}
