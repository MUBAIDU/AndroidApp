package com.example.c3477513.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TodoActivity extends AppCompatActivity {

    private String[] mTodos;
    private int mTodoIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // calls the super class onCreate to complete the creation of  the activity like
        // view hierarchy
        super.onCreate(savedInstanceState);

        // sets user interface layout for this Activity
        // the layout file is in the project res/layout/activity_todo.xml file
        setContentView(R.layout.activity_todo);


        // initialize member TextView so that we can manipulate it later
        final TextView TodoTextView;
        TodoTextView = (TextView) findViewById(R.id.textViewTodo);


        // it reads the todo array from res/values/strings.xml file
        // where the string code is located
        Resources res = getResources();
        mTodos = res.getStringArray(R.array.todo);
        // displays the first task from mTodo array in the TodoTextView
        TodoTextView.setText(mTodos[mTodoIndex]);


        Button buttonNext;
        buttonNext = (Button) findViewById(R.id.buttonNext);


        // OnClick is listener for the  Next button
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                /* !!!! BUG !!!!!!!
                Compile time error because  mTodoIndexx is misspelled
                Runtime Error: no check for maximum number of items in todos array

                //BUG fix for compile error IS to spell mTodoIndex correctly by removing
                        by removing EXTRA(X) mTodoIndexx
                // Bug fix run time error, use the remainder as index to the array,
                //i.e. mTodoIndex = (mTodoIndex + 1) % todos.length;
                */

                mTodoIndex += 1;
                mTodoIndex = (mTodoIndex + 1) % todos.length;
            }
        });
    }
}
