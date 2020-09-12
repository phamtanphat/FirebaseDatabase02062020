package com.example.firebasedatabase02062020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 : Gui du lieu dang string
//        myRef.child("Sinhvien")
//                .setValue("Nguyen Van A")
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Them du lieu thanh cong", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
        // 2 : Gui du lieu hashmap
        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("Xe dap", 2);
        hashMap.put("Xe hoi", 4);
        hashMap.put("Xe ba gac", 3);
        myRef.child("Phuongtien")
                .setValue(hashMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Them du lieu thanh cong", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}