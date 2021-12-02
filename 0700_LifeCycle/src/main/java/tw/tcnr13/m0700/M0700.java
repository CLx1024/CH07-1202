package tw.tcnr13.m0700;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class M0700 extends AppCompatActivity {
    private final String TAG = "tcnr13=>";  // final是斷絕父子關係
    //private final String TAG = "tcnr13=>";   // (不可重複的??) 標籤

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //繼承
        setContentView(R.layout.m0700);
        Log.d(TAG,"執行onCreate");  // d是debug  msg是傳遞文字訊息
        setupViewComponent();  // 自定義方法
    }

    private void setupViewComponent() {
        int a = 9999+123;
        Log.d(TAG,"執行setupViewComponent()"+a);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"執行onStart");   //其實跟繼承是差不多同時執行 但一般都會先繼承在寫在它的下面
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"執行onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"執行onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"執行onDestroy");
    }

    //********************************************************
    @Override
    public void onBackPressed() {
        //      super.onBackPressed();  //不執行這行
        Toast.makeText(getApplication(),"禁用返回鍵",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  // 加onCreateOptionsMenu跟onOptionsItemSelected就會有右邊點點選單
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0700, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // 加onCreateOptionsMenu跟onOptionsItemSelected就會有右邊點點選單
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(item.getItemId()){
            case R.id.action_settings:
                this.finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
//********************************************************

}  // 這是整個Class的結尾  要注意不要刪到它