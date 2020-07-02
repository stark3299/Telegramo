package com.example.android.telegramo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText message;
    ImageView mImageView, mic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.message);
        mImageView = findViewById(R.id.send);
        mic = findViewById(R.id.mic);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mic.setVisibility(View.INVISIBLE);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_patient_home_screen, menu);
        menu.add(0, 1, 1, menuIconWithText(getResources().getDrawable(R.drawable.call), getResources().getString(R.string.call)));
        menu.add(0, 2, 2, menuIconWithText(getResources().getDrawable(R.drawable.search), getResources().getString(R.string.search)));
        menu.add(0, 3, 3, menuIconWithText(getResources().getDrawable(R.drawable.history), getResources().getString(R.string.history)));
        menu.add(0, 4, 4, menuIconWithText(getResources().getDrawable(R.drawable.mute), getResources().getString(R.string.mute)));
        menu.add(0, 5, 5, menuIconWithText(getResources().getDrawable(R.drawable.delete), getResources().getString(R.string.delete)));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(MainActivity.this, "Call Users", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(MainActivity.this, "Search Chats", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(MainActivity.this, "Clear History", Toast.LENGTH_SHORT).show();
                return true;
            case 4:
                Toast.makeText(MainActivity.this, "Mute Notification", Toast.LENGTH_SHORT).show();
                return true;
            case 5:
                Toast.makeText(MainActivity.this, "Delete Chats", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private CharSequence menuIconWithText(Drawable r, String title) {

        r.setBounds(0, 0, r.getIntrinsicWidth(), r.getIntrinsicHeight());
        SpannableString sb = new SpannableString("    " + title);
        ImageSpan imageSpan = new ImageSpan(r, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}