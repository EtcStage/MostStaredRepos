package com.info.mustapha.moststarredgithubrepos;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.info.mustapha.moststarredgithubrepos.models.Repository;
import com.info.mustapha.moststarredgithubrepos.commonclasses.ReposAdapter;
import java.util.ArrayList;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Repository> reposList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ReposAdapter RepositoriesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        RepositoriesAdapter = new ReposAdapter(reposList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(RepositoriesAdapter);


        loadStaticData();
    }

    //create mock data for filling recyclerview
    private void loadStaticData() {
        Repository repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 1", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);

        repos = new Repository("Name 10", "owner1", "description 1 loree epsom detail in some words her just to clarify", "", 2345);
        reposList.add(repos);
        RepositoriesAdapter.notifyDataSetChanged();
    }
}