package tw.tcnr13.m0704;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0704 extends ListActivity {

    private ArrayList<Map<String,Object>> mlist;   //  這邊要自己用手打改成Map.....(本來alt enter是自動生別的)
    private String[] listFromResource;
    private TextView mTxtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0704);
        setupComponent();
    }

    private void setupComponent() {
        mTxtResult = (TextView) findViewById(R.id.m0704_ans);
        listFromResource = getResources().getStringArray(R.array.weekday);  // 抓資料，目前寫死在Value裡，以後是抓資料庫(或Opendata)
//---------------------------------------------------------------

        mlist = new ArrayList<Map<String, Object>>();

        for(int i=0; i<listFromResource.length; i++){
            Map<String,Object> item = new HashMap<String, Object>();
            item.put("pic", R.drawable.img01th);   // key(ID) value(值)  // 真正塞圖是在這裡，Layout design那邊參考示意而已
            item.put("text", listFromResource[i]);
            mlist.add(item);   // add是加一行的意思  倉庫裡現在有上面兩行東西了，現在把它們棧板拖進去(？)

            SimpleAdapter adapter = new SimpleAdapter(
                    this,  //指定誰用它
                    mlist,  //資料來源
                    R.layout.list_item,  //報表
                    new String[]{"pic","text"},
                    new int[]{R.id.m0704_imageView,R.id.m0704_t001});

            //----------------------------------------------------------------
            setListAdapter(adapter);
            ListView listview = getListView();
            listview.setTextFilterEnabled(true);
            listview.setOnItemClickListener(listviewOnItemClkLis);
        }
    }
    AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mTxtResult.setText(getText(R.string.m0704_ans)+listFromResource[position]);
        }
    };



}
