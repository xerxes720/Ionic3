package com.example.Ionic3;

import android.content.Intent;
import android.drm.DrmStore;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class TasksActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MyListAdapter myAdapter;
    SwipeController swipeController = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks);
        Toolbar toolbar = findViewById(R.id.tasks_toolbar);
//        setSupportActionBar(toolbar);

        DrawerLayout dl = findViewById(R.id.tasks_drawer);
        ActionBarDrawerToggle t = new ActionBarDrawerToggle(this, dl,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        dl.addDrawerListener(t);
        t.syncState();

        ArrayList<MyListData> listData = new ArrayList<>();

        listData.add(new MyListData("MyTask","Me",1));
        listData.add(new MyListData("MyTask2","Him",2));
        listData.add(new MyListData("MyTask3","Her",3));
        listData.add(new MyListData("MyTask4","We",4));
        listData.add(new MyListData("MyTask5","You",5));


        RecyclerView recyclerView = findViewById(R.id.tasks_recycler_view);

        RecyclerView.LayoutManager layoutManager;


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyListAdapter(listData);
        recyclerView.setAdapter(myAdapter);

        NavigationView nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(this);

        ImageButton IB = findViewById(R.id.add_task);
        IB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TasksActivity.this , newTask.class));
            }
        });

        SwipeController swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onDeleteClicked(int position) {
                myAdapter.listData.remove(position);
                myAdapter.notifyItemRemoved(position);
                myAdapter.notifyItemRangeChanged(position, myAdapter.getItemCount());
            }

            @Override
            public void onEditClicked(int position) {
                super.onEditClicked(position);
            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.tasks_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, recyclerView.VERTICAL, false));
        recyclerView.setAdapter(myAdapter);

        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onDeleteClicked(int position) {
                myAdapter.listData.remove(position);
                myAdapter.notifyItemRemoved(position);
                myAdapter.notifyItemRangeChanged(position, myAdapter.getItemCount());
            }
        });

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(this,MainActivity.class));
        } else if (id == R.id.nav_tasks) {

        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_password) {

        } else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = findViewById(R.id.tasks_drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
