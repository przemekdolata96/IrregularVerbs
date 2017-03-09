package com.example.dolci.irregularverbs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Adapter extends ArrayAdapter<String>{
    //Declaratiom
    int[] images={};
    String[] firstForm={};
    String[] secondForm={};
    String[] thirdForm={};
    String[] translation={};
    Context c;
    private static LayoutInflater inflater=null;
    public Adapter(Context context,String[] firstForm,String[] secondForm,String[] thirdForm,
                   String[] translation,int[] images){

        super(context,R.layout.model,firstForm);
        c=context;
        this.firstForm=firstForm;
        this.secondForm=secondForm;
        this.thirdForm=thirdForm;
        this.translation=translation;
        this.images=images;
    }

    public class  ViewHolder
    {
        TextView firstForm;
        TextView secondForm;
        TextView thirdForm;
        TextView translation;
        ImageView image;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return images.length;
    }

    @Override
    public String getItem(int position) {
        // TODO Auto-generated method stub
        return firstForm[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    @NonNull
    public View getView(final int position, View convertView, ViewGroup parent){

        if(convertView==null)
        {
            inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.model,null);
        }


        ViewHolder holder=new ViewHolder();

        holder.firstForm=(TextView)convertView.findViewById(R.id.modelFistForm);
        holder.secondForm=(TextView)convertView.findViewById(R.id.modelSecondForm);
        holder.thirdForm=(TextView)convertView.findViewById(R.id.modelThridForm);
        holder.translation=(TextView)convertView.findViewById(R.id.modelTranslation);
        holder.image=(ImageView) convertView.findViewById(R.id.modelImageView);

        holder.firstForm.setText(firstForm[position]);
        holder.secondForm.setText(secondForm[position]);
        holder.thirdForm.setText(thirdForm[position]);
        holder.translation.setText(translation[position]);
        holder.image.setImageResource(images[position]);


        return convertView;
    }

}
