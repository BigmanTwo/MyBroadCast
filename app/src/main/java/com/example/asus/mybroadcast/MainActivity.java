package com.example.asus.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        private Button mButton;
        private Button mButton1;
        private Button mButton3;
        private Button mButton4;
    private static final String NAME="com.android.user.WEDS";
    private MyBroad myBroad;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=(TextView)findViewById(R.id.text_change);
        mButton=(Button)findViewById(R.id.but1_change);
        mButton1=(Button)findViewById(R.id.but2_change);
        mButton3=(Button)findViewById(R.id.but);
        mButton4=(Button)findViewById(R.id.but1);
        mButton.setOnClickListener(this);
        mButton1.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.but1_change:
                //静态注册广播
                staticBroad();
                break;
            case R.id.but2_change:
                //动态注册广播
                dynamicBroad();
                break;
            case R.id.but:
                staticBroad();
                break;
            case R.id.but1:
                Intent intent=new Intent();
                intent.setAction("com.android.user.IUMNB");
                Bundle bundle=new Bundle();
                bundle.putCharSequence("有序广播","这是一个有序广播");
                intent.putExtra("bundle",bundle);
                sendOrderedBroadcast(intent,null);
                break;
        }

    }

    private void staticBroad() {
        Intent intent=new Intent();
        intent.setAction("com.android.user.IUMNB");
        intent.putExtra("textView1","这是一个广播稿");
        sendBroadcast(intent);
    }

    private void dynamicBroad() {
        myBroad=new MyBroad();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(NAME);
        registerReceiver(myBroad,intentFilter);
        Intent intent1=new Intent(NAME);
        intent1.putExtra("textView","这是一个动态广播");
        sendBroadcast(intent1);
    }

    @Override
      protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroad);
    }

   public class MyBroad extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String str=intent.getStringExtra("textView");
            mTextView.setText(str);
            Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
        }
    }

}
