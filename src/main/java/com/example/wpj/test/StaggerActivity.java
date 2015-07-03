package com.example.wpj.test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class StaggerActivity extends ActionBarActivity {
private RecyclerView recyclerView;
    private List<String> mDatas;
    private StaggerAdapter mySimpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMyDatas();
        recyclerView= (RecyclerView) findViewById(R.id.myrecycler);
        mySimpleAdapter=new StaggerAdapter(this,mDatas);
        recyclerView.setAdapter(mySimpleAdapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        mySimpleAdapter.setOnItemClickListener(new MySimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postition) {
                mySimpleAdapter.remData(postition);
            }

            @Override
            public void onItemLongClick(View view, int postition) {

            }
        });
    }

    public void setMyDatas() {
        mDatas=new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add(""+(char)i);
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

//            switch (id){
//                case R.id.action_listview:
//                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
//                    break;
//                case R.id.action_gridviewe:
//                    recyclerView.setLayoutManager(new GridLayoutManager(this,3));//三列
//
//                    break;
//                case R.id.action_hor_gridview:
//
//                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
//                    break;
//                case R.id.action_stagger_gridview:break;
//
//            }


        return super.onOptionsItemSelected(item);
    }
}
