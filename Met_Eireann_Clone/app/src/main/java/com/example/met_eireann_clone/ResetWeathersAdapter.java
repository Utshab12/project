package com.example.met_eireann_clone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


//NAME
//STUDENT NUMBER


//VIews linking class
public class ResetWeathersAdapter extends RecyclerView.Adapter<ResetWeathersAdapter.ItemsViewHolder>{
    private Context context;
    private List<Weather> objects;
    public ResetWeathersAdapter(Context context, List<?> objects) {
        this.context = context;
        this.objects = (List<Weather>) objects;
    }

    @NonNull
    @Override
    //recyclerView connection
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView= LayoutInflater.from(context).inflate(R.layout.weather_reset_layout, parent,false);
        return new ItemsViewHolder(mView);
    }

    @Override
    //list to view connection
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
        final Weather obj= objects.get(position);
        holder.day.setText(obj.getDayName());
        holder.centigrade.setText(Integer.toString(obj.getCentigradeTemp()));
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }
    //itemViews to instances
    public static class ItemsViewHolder extends RecyclerView.ViewHolder{
        TextView day,centigrade;
        public ItemsViewHolder(View itemView) {
            super(itemView);
            day=itemView.findViewById(R.id.dayName);
            centigrade=itemView.findViewById(R.id.centigradeTemp);
        }
    }
}