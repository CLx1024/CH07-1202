package tw.tcnr13.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private LinearLayout layout1;
    private LinearLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupComponent();
    }

    private void setupComponent() {
        layout1 = (LinearLayout)findViewById(R.id.l1);
        layout2 = (LinearLayout)findViewById(R.id.l2);


    }

    //********************************************************


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  // 加onCreateOptionsMenu跟onOptionsItemSelected就會有右邊點點選單
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // 加onCreateOptionsMenu跟onOptionsItemSelected就會有右邊點點選單
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(item.getItemId()){
            case R.id.Item01:
                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.INVISIBLE);
                break;
            case R.id.Item02:
                layout2.setVisibility(View.VISIBLE);
                layout1.setVisibility(View.INVISIBLE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
//********************************************************
}