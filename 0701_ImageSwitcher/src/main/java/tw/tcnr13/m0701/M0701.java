package tw.tcnr13.m0701;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class M0701 extends AppCompatActivity implements ViewSwitcher.ViewFactory,AdapterView.OnItemClickListener{
    // 加implements這個字  interface介面的意思
    private final String TAG = "tcnr13=>";  // final是斷絕父子關係

    // 圖庫的圖片資源索引
    private Integer[] imgArr = {
            R.drawable.img01, R.drawable.img02,
            R.drawable.img03, R.drawable.img04,
            R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08,
            R.drawable.img09, R.drawable.img10,
            R.drawable.img11, R.drawable.img12,
            R.drawable.img13,R.drawable.img14,
            R.drawable.img15,R.drawable.img16,
    };

    private Integer[] thumbImgArr = {
            R.drawable.img01th, R.drawable.img02th,
            R.drawable.img03th, R.drawable.img04th,
            R.drawable.img05, R.drawable.img06,  //******************
            R.drawable.img07, R.drawable.img08,
            R.drawable.img09, R.drawable.img10,
            R.drawable.img11, R.drawable.img12,
            R.drawable.img13,R.drawable.img14,
            R.drawable.img15,R.drawable.img16,
    };

    private GridView gridview;
    private ImageSwitcher imgSwi;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        imgSwi.setImageResource(imgArr[position]);
    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //繼承
        setContentView(R.layout.m0701);
        Log.d(TAG,"執行onCreate");  // d是debug  msg是傳遞文字訊息
        setupViewComponent();  // 自定義方法
    }

    private void setupViewComponent() {
        Log.d(TAG,"執行setupViewComponent()");

        // 從資源類別R中取得介面元件
        gridview = (GridView) findViewById(R.id.m0701_g001);
        imgSwi = (ImageSwitcher) findViewById(R.id.m0701_im01);

        //將縮圖填入 GridView
        gridview.setAdapter(new GridAdapter(this,thumbImgArr));

        // GridView元件的事件處理
        gridview.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        // 取得GridView元件
        imgSwi.setFactory((ViewSwitcher.ViewFactory) this); // 必須implements ViewSwitcher.ViewFactory
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
        getMenuInflater().inflate(R.menu.m0701, menu);
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