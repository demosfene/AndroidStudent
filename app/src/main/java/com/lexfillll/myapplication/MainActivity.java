package com.lexfillll.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public List<Student> students;
    private boolean studentGender;
    private Button buttonSave;
    private EditText name;
    private EditText lastName;
    private CheckBox maleGender;
    private Button buttonAdd;
    private Button buttonDel;
    private Student studentToRemove;
    private List<Integer> photoMale;
    private List<Integer> photoFemale;
    private ImageView photoUI;
    private int photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        students = new ArrayList();

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        final StudentsAdapter studentAdapter = new StudentsAdapter(students, new StudentsAdapter.ListenerClickStudent() {
            @Override
            public void onStudentClick(final Student student) {
                studentToRemove = student;
                name.setText(student.getFirstName());
                lastName.setText(student.getLastName());
                maleGender.setChecked(student.isMaleGender());
                buttonSave.setClickable(false);
                buttonDel.setClickable(true);
                photoUI.setImageResource(student.getPhoto());
            }
        });
        recyclerView.setAdapter(studentAdapter);

        name = findViewById(R.id.name);
        lastName = findViewById(R.id.last_name);
        maleGender = findViewById(R.id.sex);
        buttonDel = findViewById(R.id.delete);
        buttonSave = findViewById(R.id.save);
        buttonAdd = findViewById(R.id.button_add);

        photoMale = new ArrayList<>();
        photoUI = findViewById(R.id.avatar);
        photoMale.add(R.drawable.male_1);
        photoMale.add(R.drawable.male_2);
        photoMale.add(R.drawable.male_3);

        photoFemale = new ArrayList<>();
        photoFemale.add(R.drawable.female_1);
        photoFemale.add(R.drawable.female_2);
        photoFemale.add(R.drawable.female_3);

        buttonDel.setClickable(false);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().length() == 0 || lastName.getText().length() == 0){

                }else {
                    if(maleGender.isChecked()){
                        photo = anyPhoto(photoMale);
                        studentGender = true;
                    }else{
                        photo = anyPhoto(photoFemale);
                        studentGender = false;
                    }
                    students.add(new Student(name.getText().toString(), lastName.getText().toString(), studentGender, photo));
                    studentAdapter.notifyDataSetChanged();
                }
            }
        });


        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students.remove(studentToRemove);
                studentAdapter.notifyItemRemoved(StudentsAdapter.positionIndex);
                studentAdapter.notifyDataSetChanged();
                name.setText("");
                lastName.setText("");
                maleGender.setChecked(false);
                photoUI.setImageResource(R.drawable.ic_launcher_background);
                buttonSave.setClickable(true);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSave.setClickable(true);
                View group = findViewById(R.id.group);
                group.setVisibility(View.VISIBLE);
                name.setText("");
                lastName.setText("");
                maleGender.setChecked(false);
                photoUI.setImageResource(R.drawable.ic_launcher_background);
            }
        });

    }

    public int anyPhoto(List<Integer> list){
        Random random = new Random();
        int index = random.nextInt(list.size());
        int photo = list.get(index);
        return photo;
    }

}
