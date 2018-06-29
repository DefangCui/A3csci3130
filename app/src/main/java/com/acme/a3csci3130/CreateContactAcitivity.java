package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, emailField,businumFiled,pribusiFiled,addrFiled,provFiled;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        businumFiled=(EditText) findViewById(R.id.businum);
        pribusiFiled=(EditText) findViewById(R.id.pribusi);
        addrFiled=(EditText) findViewById(R.id.addR);
        provFiled=(EditText) findViewById(R.id.provin);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String businessNumber=businumFiled.getText().toString();
        String primaryBusiness=pribusiFiled.getText().toString();
        String address=addrFiled.getText().toString();
        String province=provFiled.getText().toString();
        Contact person = new Contact(personID, name, email,businessNumber,primaryBusiness,address,province);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
