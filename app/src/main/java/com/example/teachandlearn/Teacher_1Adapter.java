package com.example.teachandlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Teacher_1Adapter extends RecyclerView.Adapter
{
    private ArrayList<Registers> teacherData;

    private Context parentContext;

    public class teacherViewHolder extends RecyclerView.ViewHolder
    {

        public TextView textViewName;
        public TextView textViewCertificate;
        public TextView textViewEmail;
        public TextView textViewSubject;
        public TextView textViewBirthday;


        public teacherViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textViewName = itemView.findViewById(R.id.studentTextName);
            textViewCertificate = itemView.findViewById(R.id.studentTextCertificate);
            textViewEmail = itemView.findViewById(R.id.studentTextEmail);
            textViewSubject = itemView.findViewById(R.id.studentTextSubject);
            textViewBirthday = itemView.findViewById(R.id.studentTextBirthday);


            itemView.setTag(this);
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewCertificate() {
            return textViewCertificate;
        }

        public TextView getTextViewEmail() {
            return textViewEmail;
        }

        public TextView getTextViewSubject() {
            return textViewSubject;
        }

        public TextView getTextViewBirthday() {
            return textViewBirthday;
        }


    }

    public Teacher_1Adapter(ArrayList<Registers> arrayList, Context context) {
        teacherData = arrayList;
        parentContext = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new teacherViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        teacherViewHolder tvh = (teacherViewHolder) holder;


        tvh.getTextViewName().setText(teacherData.get(position).getRegisters_2Name());
        tvh.getTextViewCertificate().setText(teacherData.get(position).getRegisters_2Certificate());
        tvh.getTextViewEmail().setText(teacherData.get(position).getRegisters_2Email());
        tvh.getTextViewSubject().setText(teacherData.get(position).getRegisters_2Subject());
        tvh.getTextViewBirthday().setText(teacherData.get(position).getRegisters_2Birthday());
        int id = teacherData.get(position).getRegisters_2ID();
        holder.itemView.setTag(id);
    }


    @Override
    public int getItemCount() {
        return teacherData.size();
    }
}