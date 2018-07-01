package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/**
 * Class that user can use update button and delete button
 * to update or delete contact information
 */

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField,businumField,pribusiField,addrField,provField;
    private Button eraseButton, editButton;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        businumField=(EditText) findViewById(R.id.busiNum);
        pribusiField=(EditText) findViewById(R.id.priBusi);
        addrField=(EditText) findViewById(R.id.addR);
        provField=(EditText) findViewById(R.id.proV);


        eraseButton=(Button) findViewById(R.id.deleteButton);
        editButton=(Button) findViewById(R.id.updateButton);




        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            businumField.setText(receivedPersonInfo.businessNumber);
            pribusiField.setText(receivedPersonInfo.primaryBusiness);
            addrField.setText(receivedPersonInfo.address);
            provField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        String UID=receivedPersonInfo.uid;
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String businessNumber=businumField.getText().toString();
        String primaryBusiness=pribusiField.getText().toString();
        String address=addrField.getText().toString();
        String province=provField.getText().toString();
        appState.firebaseReference.child(UID).child("name").setValue(name);
        appState.firebaseReference.child(UID).child("email").setValue(email);
        appState.firebaseReference.child(UID).child("businessNumber").setValue(businessNumber);
        appState.firebaseReference.child(UID).child("primaryBusiness").setValue(primaryBusiness);
        appState.firebaseReference.child(UID).child("address").setValue(address);
        appState.firebaseReference.child(UID).child("province").setValue(province);
        finish();



    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        String UID=receivedPersonInfo.uid;
        appState.firebaseReference.child(UID).removeValue();
        finish();
    }
}
