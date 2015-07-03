package com.example.wpj.test;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;//定义一个RecyclerView
    private List<String> mDatas; //数据绑定
    private MySimpleAdapter mySimpleAdapter; //适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMyDatas();
        recyclerView = (RecyclerView) findViewById(R.id.myrecycler);
        mySimpleAdapter = new MySimpleAdapter(this, mDatas);
        recyclerView.setAdapter(mySimpleAdapter);
        //设置recyclerview的布局管理 使得RecyclerView显示listview形式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
//        设置分割线
        //   recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setItemAnimator(new DefaultItemAnimator());//添加item的动画，这里默认动画
//        recyclerView.addItemDecoration();
        //自定义回调事件查看adapter
        mySimpleAdapter.setOnItemClickListener(new MySimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postition) {
                Toast.makeText(MainActivity.this, "onItemClick" + postition, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int postition) {
                Toast.makeText(MainActivity.this, "onItemLongClick" + postition, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void setMyDatas() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {
            case R.id.action_add:
                mySimpleAdapter.addDat5a(1);
                break;
            case R.id.action_remove:
                mySimpleAdapter.remData(1);
                break;
            case R.id.action_listview:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_gridviewe:
                //改变RecyclerView为gridview
                               recyclerView.setLayoutManager(new GridLayoutManager(this, 3));//三列

                break;
            case R.id.action_hor_gridview:
//水平的gridview
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_stagger_gridview:
                //跳转到 瀑布流
                startActivity(new Intent(MainActivity.this, StaggerActivity.class));
                overridePendingTransition(R.anim.abc_fade_out, R.anim.abc_fade_in);
                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
