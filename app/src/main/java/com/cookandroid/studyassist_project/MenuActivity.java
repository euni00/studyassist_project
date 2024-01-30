package com.cookandroid.studyassist_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    Button btn_todolist, btn_timer, btn_stopwatch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("StudyTogether");

        Intent intent=getIntent();
        String name = intent.getStringExtra("name");

        Toast.makeText(getApplicationContext(),
                "사용자 이름 : "+name+"이(가) 로그인하셨습니다.",
                Toast.LENGTH_SHORT).show();

        btn_todolist = findViewById(R.id.btn_todolist);
        btn_timer = findViewById(R.id.btn_timer);
        btn_stopwatch = findViewById(R.id.btn_stopwatch);

        btn_todolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // intent1???
                Intent intent = new Intent(getApplicationContext(),TodolistActivity.class);
                startActivityForResult(intent, 2);

            }
        });

        btn_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // intent1???
                Intent intent = new Intent(getApplicationContext(),TimerActivity.class);
                startActivityForResult(intent, 3);

            }
        });

        btn_stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // intent1???
                Intent intent = new Intent(getApplicationContext(),StopwatchActivity.class);
                startActivityForResult(intent, 4);

            }
        });
    }

    // 액션버튼 메뉴 액션바에 집어 넣기
    public boolean onCreateOptionsMenu(Menu menu) {
       super.onCreateOptionsMenu(menu);
       MenuInflater mInflater = getMenuInflater();
       mInflater.inflate(R.menu.menu1, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //or switch문을 이용하면 될듯 하다.
        if (id == R.id.menuHome) {
            Intent homeIntent = new Intent(this, LoginActivity.class);
            startActivity(homeIntent);
        }
        if (id == R.id.menuUserInfo) {
            Toast.makeText(this, "사용자 정보 입력", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), UserInfoActivity.class);
            startActivityForResult(intent, 5);
            return true;
        }
        if (id == R.id.menuHelp) {
            Toast.makeText(this, "도움말", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
            startActivityForResult(intent, 6);
            return true;
        }
        if (id == R.id.menuDevInfo) {
            Toast.makeText(this, "개발자 정보", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), DevInfoActivity.class);
            startActivityForResult(intent, 7);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2&&resultCode==RESULT_OK){
            String name = data.getStringExtra("todolist");
            Toast.makeText(getApplicationContext(),
                    name+"응답 : Todolist result message OK",
                    Toast.LENGTH_SHORT).show();
        }
        /*else if(resultCode==RESULT_CANCELED){
            finish();
        }*/

        if(requestCode==3&&resultCode==RESULT_OK){
            String name = data.getStringExtra("timer");
            Toast.makeText(getApplicationContext(),
                    name+"응답 : Timer result message OK",
                    Toast.LENGTH_SHORT).show();
        }
        /*else if(resultCode==RESULT_CANCELED){
            finish();
        }*/

        if(requestCode==4&&resultCode==RESULT_OK){
            String name = data.getStringExtra("stopwatch");
            Toast.makeText(getApplicationContext(),
                    name+"응답 : Stopwatch result message OK",
                    Toast.LENGTH_SHORT).show();
        }
        /*else if(resultCode==RESULT_CANCELED){
            finish();
        }*/
    }
}
