package com.example.javatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        PyObject pym = py.getModule("hello");
        PyObject obj = pym.callAttr("hellotest");
        TextView textView = findViewById(R.id.tv1);
        textView.setText(obj.toString());

    }
}