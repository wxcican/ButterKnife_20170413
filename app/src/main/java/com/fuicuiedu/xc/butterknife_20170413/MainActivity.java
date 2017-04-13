package com.fuicuiedu.xc.butterknife_20170413;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindViews({R.id.main_tv1,R.id.main_tv2,R.id.main_tv3})
    List<TextView> textViews;

    @BindString(R.string.app_name)String app_name;

    private Unbinder unbinder;//解绑对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);//不要忘记这一步

        //统一操作视图集合（实现ButterKnfie.Action接口）
        ButterKnife.apply(textViews, new ButterKnife.Action<TextView>() {
            @Override
            public void apply(@NonNull TextView view, int index) {
                view.setText(app_name);
            }
        });

        //统一操作视图集合(实现Butterknife.Setter接口)
        ButterKnife.apply(textViews, new ButterKnife.Setter<TextView, String>() {
            @Override
            public void set(@NonNull TextView view, String value, int index) {
                view.setText(value);
            }
        },app_name);//看参数，ctrl + p



    }


    //butterknife实现点击监听，注意方法一定要是public
    @OnClick({R.id.main_btn1,R.id.main_btn2,R.id.main_btn3})
    public void aaa(View v){
        switch (v.getId()){
            case R.id.main_btn1:
                Toast.makeText(this, "点击了  1111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn2:
                Toast.makeText(this, "点击了  222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn3:
                Toast.makeText(this, "点击了  333", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ButterKnife解绑操作
        unbinder.unbind();
    }
}
