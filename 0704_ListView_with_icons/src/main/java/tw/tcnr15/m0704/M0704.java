package tw.tcnr15.m0704;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0704 extends ListActivity {

    private TextView mTxtResult;
    private String[] listFromResource,listFromResource2;
    private ArrayList<Map<String,Object>> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0704);
        setViewComponent();
    }

    private void setViewComponent() {
        mTxtResult = (TextView) findViewById(R.id.m0704_t001);
        listFromResource = getResources().getStringArray(R.array.weekday);
        listFromResource2 = getResources().getStringArray(R.array.weekday02);

//---------------------------------------------------------------
        mList = new ArrayList<>();

        for (int i = 0; i < listFromResource.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            String idNme = "img" + String.format("%02d" + "th", i + 1);
            int resID = getResources().getIdentifier(idNme, "drawable",getPackageName() );

            item.put("imgView", resID);                              //從img01抓資料
            item.put("textView", listFromResource[i]);                               //從陣列裡面抓資料
            item.put("textView2", listFromResource2[i]);
            mList.add(item);
            SimpleAdapter adapter = new SimpleAdapter(
                    this,
                    mList,
                    R.layout.list_item,
                    new String[]{"imgView", "textView","textView2"},
                    new int[]{R.id.imageView, R.id.m0704_t001a,R.id.m0704_t001b});

            //----------------------------------------------------------------
            setListAdapter(adapter);
            ListView listview = getListView();
            listview.setTextFilterEnabled(true);

            listview.setOnItemClickListener(listviewOnItemClkLis);


        }




    }
    AdapterView.OnItemClickListener listviewOnItemClkLis=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mTxtResult.setText(getText(R.string.m0704_t001)+listFromResource[position]);
        }


//                mTxtResult.setText(getText(R.string.m0704_t001)+listFromResource[position]);


    };

}