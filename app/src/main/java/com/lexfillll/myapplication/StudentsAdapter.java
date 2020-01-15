package com.lexfillll.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentHolder> {

    private final List<Student> students;
    private ListenerClickStudent onStudentClickListener;
    public static int positionIndex;

    public StudentsAdapter(List<Student> students, ListenerClickStudent onStudentClickListener){
        this.students = students;
        this.onStudentClickListener = onStudentClickListener;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);
        return new StudentHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        Student student = students.get(position);
        holder.bind(student);
        holder.itemView.setTag(student);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    final class StudentHolder extends RecyclerView.ViewHolder{

        private TextView nameView;
        private TextView lastNameView;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);

            nameView = itemView.findViewById(R.id.student_name_in_list);
            lastNameView = itemView.findViewById(R.id.student_lastName_in_list);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    positionIndex = getAdapterPosition();
                    onStudentClickListener.onStudentClick((Student)v.getTag());
                }
            });
        }

        public void bind(Student student){
            nameView.setText(student.getFirstName());
            lastNameView.setText(student.getLastName());
        }
    }

    interface ListenerClickStudent {
        void onStudentClick(Student student);
    }

}
