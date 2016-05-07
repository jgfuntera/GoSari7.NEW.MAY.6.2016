package com.android.iit.chrs.gosari;

/**
 * Created by greg on 5/5/16.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by greg on 4/23/16.
 */
public class ItemAdapter extends ArrayAdapter<ItemCategory>{
    ArrayList<ItemCategory>ItemList;
    LayoutInflater vi;
    int Resource;
    ViewHolder holder;


    public ItemAdapter(Context context, int resource, ArrayList<ItemCategory> objects) {
        super(context, resource, objects);
        vi=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        ItemList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=convertView;

        if(v==null){
            holder=new ViewHolder();
            v=vi.inflate(Resource,null);
            holder.tvCategory=(TextView)v.findViewById(R.id.tvCategory);
            v.setTag(holder);

        }
        else {
            holder=(ViewHolder)v.getTag();
        }
        holder.tvCategory.setText(ItemList.get(position).getCategory());
        return v;
    }

    static class ViewHolder{

        public TextView tvCategory;

    }


}
