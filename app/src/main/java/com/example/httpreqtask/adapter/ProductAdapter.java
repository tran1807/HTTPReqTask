package com.example.httpreqtask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.httpreqtask.R;
import com.example.httpreqtask.models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    public List<Product> productList;
    public Context context;

    public ProductAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.product,parent,false);
//        return new ViewHolder(view);
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View studentView =
                inflater.inflate(R.layout.product, parent, false);

        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
         holder.txtname.setText("ten : "+product.name);
//         holder.txtid.setText(product.id);
         holder.txtsoluong.setText("sl: " + product.soluong);
        Picasso.with(context).load(product.img).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txtname,txtid,txtsoluong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageViewHinhAnh);
            txtname = itemView.findViewById(R.id.textViewName);
//            txtid = itemView.findViewById(R.id.textViewid);
            txtsoluong = itemView.findViewById(R.id.textViewsl);

        }
    }
}
