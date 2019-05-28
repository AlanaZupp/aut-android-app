package com.example.autandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class contactdev_button extends AppCompatActivity {
    //This class enables a user to be able to send a email to the developers with queries or issues. This class also enables a client, gmail, to respond inorder to send the message
    private EditText mEditTextTo; //input for the email if user wants to send it to someone different
    private EditText mEditTextSubject; // input for subject area
    private EditText mEditTextMessage;// input for message area


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactdev_button);
        mEditTextTo = findViewById(R.id.edit_text_to);
        mEditTextSubject = findViewById(R.id.edit_text_subject);
        mEditTextMessage = findViewById(R.id.edit_text_message);

        //creates a send button, when the button is clicked it calls sendMail
        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    //sendMail allows for a user to be able to enter a recipient, add a subject and a message to text box areas. It also enables these to be shown within the client when opened
    private void sendMail()
    {
        //creates strings for the recipient, subject and message
        String recipientList = mEditTextTo.getText().toString();
        String[] recipients = recipientList.split(",");//this allows for multiple emails to be input
        //example@gmail.com,
        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,
                new String[] { "autappdevelopers@gmail.com" }); //automatically puts the email address into the client
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        //enables a client to send the message e.g gmail
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));

    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //when home button (action_home) is pressed, the page is redirected to the homepage (MainActivity)
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_home:
                Intent homePageIntent= new Intent(this, MainActivity.class);
                this.startActivity(homePageIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
