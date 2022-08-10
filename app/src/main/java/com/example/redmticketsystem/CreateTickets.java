package com.example.redmticketsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

public class CreateTickets<InitCreateTickets> extends AppCompatActivity {
private Spinner spinner;
    EditText editTextTextMultiLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tickets);
        InitCreateTickets();
        spinner = (Spinner)findViewById(R.id.spinnerDD);
        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);


        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            System.out.println("Fetching FCM registration token failed");
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();



                        System.out.println(token);
                        Toast.makeText(CreateTickets.this, token, Toast.LENGTH_SHORT).show();

                        editTextTextMultiLine.setText(token);
                    }
                });

    }



    private static ArrayList<CreateTickets> createTicketsArrayList = new ArrayList<>();

    private String id;
    private String name;

    public CreateTickets(String id,String name) {
        this.id = id;
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;

    }
    private void InitCreateTickets() {
        CreateTickets createtickets1 = new CreateTickets( "0",  "A");
        createTicketsArrayList.add(createtickets1);
        CreateTickets createtickets2 = new CreateTickets( "0",  "B");
        createTicketsArrayList.add(createtickets2);
        CreateTickets createtickets3 = new CreateTickets( "0",  "C");
        createTicketsArrayList.add(createtickets3);
        CreateTickets createtickets4 = new CreateTickets( "0", "D");
        createTicketsArrayList.add(createtickets4);

    }

    public static ArrayList<CreateTickets> getCreateTicketsArrayList() {
        return createTicketsArrayList;
    }
}