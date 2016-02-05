package lwtech.itad230.assignment3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class firstActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String message = data.getExtras().getString(secondActivity.EXTRA_MESSAGE);
                TextView textView = (TextView) findViewById(R.id.displayMessage);
                textView.setText(message);
            } else if (resultCode == Activity.RESULT_CANCELED) {
                TextView textView = (TextView) findViewById(R.id.displayMessage);
                textView.setText("...Canceled...");
            }
        }
    }

    public void SendMessage(View view){
        Intent intent = new Intent(this, secondActivity.class);
        EditText editText = (EditText) findViewById(R.id.Message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, 1);
    }
}
