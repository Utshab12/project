package com.example.met_eireann_clone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

//NAME
//STUDENT NUMBER

public class ResetWarningsAdapter extends RecyclerView.Adapter<ResetWarningsAdapter.ItemsViewHolder> {

    private Context context;
    private List<Warning> objects;

    public ResetWarningsAdapter() {

    }

    public ResetWarningsAdapter(Context context, List<?> objects) {
        this.context = context;
        this.objects = (List<Warning>) objects;

    }

    @NonNull
    @Override
    public ResetWarningsAdapter.ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView= LayoutInflater.from(context).inflate(R.layout.warning_reset_layout, parent,false);

        return new ResetWarningsAdapter.ItemsViewHolder(mView);

    }


    @Override
    //connecting the data from list to view
    public void onBindViewHolder(@NonNull ResetWarningsAdapter.ItemsViewHolder holder, final int position) {

        final Warning obj= objects.get(position);

        holder.area.setText(obj.getAreaS());
        holder.type.setText(obj.getTypeS());
        if (obj.getLevelS().equals("Red Level")){
            holder.level.setImageResource(R.drawable.warning_icon);
        }else{
            holder.level.setImageResource(R.drawable.yellow_warning_icon);
        }

        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        //navigation to edit warnings activity for a weather item on selected position
                    Intent myIntent=new Intent(context, EditWarning.class);
                    myIntent.putExtra("position",position);
                    context.startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

        //connecting itemViews to their instances
    public static class ItemsViewHolder extends RecyclerView.ViewHolder{

        TextView area,type;
        ImageView level;
        ImageButton editBtn;


        public ItemsViewHolder(View object) {
            super(object);

            area=object.findViewById(R.id.warningA);
            type=object.findViewById(R.id.warningT);
            level=object.findViewById(R.id.warningL);
            editBtn=object.findViewById(R.id.warningEB);


        }
    }




}
