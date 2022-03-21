package com.example.projecttimtro;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projecttimtro.activity.DetailHostelActivity;
import com.example.projecttimtro.activity.HomeActivity;
import com.example.projecttimtro.activity.SignInActivity;
import com.example.projecttimtro.models.hostel.HostelModel;
import com.example.projecttimtro.services.ConfigIpServer;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class HostelListAdapter extends RecyclerView.Adapter<HostelListAdapter.HostelViewHolder> {

    List<HostelModel> hostelModels;
    Context context;
    LayoutInflater inflater;
    ConfigIpServer configIpServer = new ConfigIpServer();

    public HostelListAdapter( Context context) {
        this.hostelModels = new ArrayList<>();
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<HostelModel> hostelModels){
        this.hostelModels.clear();
        this.hostelModels.addAll(hostelModels);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HostelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = inflater.inflate(
                R.layout.recyclerview_items, parent, false
        );
        return new HostelViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HostelViewHolder holder, int position) {
        HostelModel hm = hostelModels.get(position);
        holder.txtName.setText(hm.getNameHostel().toString());
        holder.txtAddress.setText(hm.getAddressHostel().toString());
        holder.txtTotalRoom.setText("Total room:"+hm.getTotalRoom().toString());
        holder.txtIdHostel.setText(hm.getIdHostel().toString());
        String url = configIpServer.ipAddressServerLocal+hm.getImgHostels();
        Glide.with(holder.itemView.getContext()).load(url).into(holder.imageView);
//        String uri = "@drawable/demo_hostel.png";
//        Drawable imageResource = holder.itemView.getContext().getResources().getDrawable(R.drawable.demo_hostel);
//        holder.imageView.setImageDrawable(imageResource);
    }

    @Override
    public int getItemCount() {
        return hostelModels.size();
    }

    public class HostelViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtAddress;
        TextView txtTotalRoom;
        ImageView imageView;
        TextView txtIdHostel;
        HostelModel hostelModel;

        public HostelViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtNameHostel);
            txtAddress = itemView.findViewById(R.id.txtAddressHostel);
            txtTotalRoom = itemView.findViewById(R.id.txtTotalRoom);
            txtIdHostel = itemView.findViewById(R.id.idHostel);
            hostelModel = new HostelModel();
            itemView.setBackgroundColor(232234246);
            imageView = (ImageView) itemView.findViewById(R.id.imgHostels);
            itemView.setOnClickListener(this::onClickItemView);

        }

        private void onClickItemView(View view) {
            Intent i = new Intent(view.getContext() , DetailHostelActivity.class);
            i.putExtra("idHostel", txtIdHostel.getText());
            view.getContext().startActivity(i);
        }

    }
}
