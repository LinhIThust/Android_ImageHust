package com.example.lotte1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lotte1.R;
import com.example.lotte1.database.RealmHandle;
import com.example.lotte1.model.StudentModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.realm.Realm;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    public List<StudentModel> studentModelList;
    public RealmHandle realm = new RealmHandle().getInstance();

    public StudentAdapter(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }

    @NonNull
    @Override

    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //truyền vào 1 layout
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_student,null);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        studentViewHolder.setData(studentModelList.get(i));
    }

    @Override
    public int getItemCount() {
        return studentModelList.size();
    }

    public  void remoteItem(int position){
        realm.removeStudent(studentModelList.get(position).getCode());
        notifyItemRemoved(position);

    }
    public class StudentViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHisotryPhoto ;
        TextView tvHistoryCode;
        public StudentViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.ivHisotryPhoto = itemView.findViewById(R.id.iv_history_photo);
            this.tvHistoryCode = itemView.findViewById(R.id.tv_history_code);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remoteItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Remove"+tvHistoryCode, Toast.LENGTH_SHORT).show();
                }
            });
        }
        public  void setData(StudentModel studentModel){
            Picasso.get().load(studentModel.getUrl()).into(ivHisotryPhoto);
            tvHistoryCode.setText(studentModel.getCode());
        }

    }
}
