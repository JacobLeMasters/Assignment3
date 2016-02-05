package lwtech.itad230.assignment3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity{
    public static final String EXTRA_MESSAGE = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(firstActivity.EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.displayMessage);
        textView.setText(message);

    }

    public void Cancel(View view){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    public void Return(View view){
        Intent intent = new Intent(this, firstActivity.class);
        EditText editText = (EditText) findViewById(R.id.ReturnMessage);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}
