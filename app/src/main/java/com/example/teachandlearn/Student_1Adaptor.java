package com.example.teachandlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Student_1Adaptor extends RecyclerView.Adapter
{
    private ArrayList<Registers> studentData;

    private Context parentContext;

    public class studentViewHolder extends RecyclerView.ViewHolder
    {

        public TextView textViewName;
        public TextView textViewCertificate;
        public TextView textViewEmail;
        public TextView textViewSubject;
        public TextView textViewBirthday;
        public TextView textViewGrade;


        public studentViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textViewName = itemView.findViewById(R.id.studentTextName);
            textViewCertificate = itemView.findViewById(R.id.studentTextCertificate);
            textViewEmail = itemView.findViewById(R.id.studentTextEmail);
            textViewSubject = itemView.findViewById(R.id.studentTextSubject);
            textViewBirthday = itemView.findViewById(R.id.studentTextBirthday);
            textViewGrade = itemView.findViewById(R.id.studentTextGrade);


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

        public TextView getTextViewGrade()
        {
            return textViewGrade;
        }


    }

    public Student_1Adaptor(ArrayList<Registers> arrayList, Context context) {
        studentData = arrayList;
        parentContext = context;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2, parent, false);
        return new studentViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        studentViewHolder tvh = (studentViewHolder) holder;


        tvh.getTextViewName().setText(studentData.get(position).getRegisters_1Name());
        tvh.getTextViewCertificate().setText(studentData.get(position).getRegisters_1Certificate());
        tvh.getTextViewEmail().setText(studentData.get(position).getRegisters_1Email());
        tvh.getTextViewSubject().setText(studentData.get(position).getRegisters_1Subject());
        tvh.getTextViewBirthday().setText(studentData.get(position).getRegisters_1Birthday());
        tvh.getTextViewGrade().setText(studentData.get(position).getRegisters_1Grade());

        int id = studentData.get(position).getRegisters_1ID();
        holder.itemView.setTag(id);
    }


    @Override
    public int getItemCount() {
        return studentData.size();
    }
}