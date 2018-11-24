package com.info.mustapha.moststarredgithubrepos;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.info.mustapha.moststarredgithubrepos.models.Repository;
import com.info.mustapha.moststarredgithubrepos.commonclasses.ReposAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Repository> reposList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ReposAdapter repositoriesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        repositoriesAdapter = new ReposAdapter(reposList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(repositoriesAdapter);


        loadReposData();
    }

    //load data repositories from github API
    private void loadReposData(){

        //get string date 30 days ago
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        int month = calendar.get(Calendar.MONTH)+1;
        String dateBefore30Days = calendar.get(Calendar.YEAR)+"-"+month+"-"+calendar.get(Calendar.DAY_OF_MONTH);

       //github repositories url
        String url = "https://api.github.com/search/repositories?q=created:>"+dateBefore30Days+"&sort=stars&order=desc";

        //build request for getting repositories data
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    //Toast.makeText(MainActivity.this, "Response Response : ", Toast.LENGTH_LONG).show();
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonRepositories = jsonObject.getJSONArray("items");
                    for(int i=0;i<jsonRepositories.length();i++){
                        JSONObject jsonRepo = jsonRepositories.getJSONObject(i);
                        JSONObject jsonOwner = jsonRepo.getJSONObject("owner");
                        Repository repository = new Repository(
                                jsonRepo.getString("name"),
                                jsonOwner.getString("login"),
                                jsonRepo.getString("description"),
                                jsonOwner.getString("avatar_url"),
                                jsonRepo.getInt("stargazers_count")
                        );
                        reposList.add(repository);
                    }
                    repositoriesAdapter.notifyDataSetChanged();
                }catch(JSONException e){

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error Response : "+error, Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
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
        repositoriesAdapter.notifyDataSetChanged();
    }
}