package com.info.mustapha.moststarredgithubrepos.commonclasses;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;
import com.info.mustapha.moststarredgithubrepos.R;
import com.info.mustapha.moststarredgithubrepos.models.Repository;

public class ReposAdapter  extends RecyclerView.Adapter<ReposAdapter.RepositoryViewHolder> {

    private List<Repository> reposList;
    OnBottomReachedListener onBottomReachedListener;

    public class RepositoryViewHolder extends RecyclerView.ViewHolder {

        public TextView nameRepos,owner,description,starCount;
        public ImageView ownerImage;

        public RepositoryViewHolder(View view) {
            super(view);
            nameRepos = (TextView) view.findViewById(R.id.name);
            owner = (TextView) view.findViewById(R.id.owner);
            description = (TextView) view.findViewById(R.id.description);
            starCount = (TextView) view.findViewById(R.id.starsCount);
            ownerImage = (ImageView) view.findViewById(R.id.owner_img);
        }
    }

    public void setOnBottomReachedListener(OnBottomReachedListener onBottomReachedListener){

        this.onBottomReachedListener = onBottomReachedListener;
    }


    public ReposAdapter(List<Repository> reposList) {
        this.reposList = reposList;
    }



    @Override
    public ReposAdapter.RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repository_list_row, parent, false);

        return new ReposAdapter.RepositoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ReposAdapter.RepositoryViewHolder holder, int position) {
        Repository repos = reposList.get(position);
        holder.nameRepos.setText(repos.getName());
        holder.owner.setText(repos.getOwner());
        holder.description.setText(repos.getDescription());

        //if stars count > 1000 then add k after the count stars
        if(repos.getStarCount()>1000){
            double starcount = (double)(repos.getStarCount()/1000.00);
            holder.starCount.setText(String.format("%.02f", starcount)+" k");
        }else{
            int starcount = repos.getStarCount();
            holder.starCount.setText(starcount+" ");
        }

        //if bottom reached
        if (position == reposList.size() - 1){

            onBottomReachedListener.onBottomReached();

        }





    }

    @Override
    public int getItemCount() {
        return reposList.size();
    }
}