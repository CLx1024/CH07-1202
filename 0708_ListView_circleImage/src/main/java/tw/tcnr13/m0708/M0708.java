package tw.tcnr13.m0708;

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

public class M0708 extends ListActivity {

    private TextView mTxtResult;
    private String[] listFromResource,listFromResource2;
    private ArrayList<Map<String,Object>> mList;
    private TextView mTxtResult2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ListActivityActionBar);  // 讓ListActivityActionBar顯示action bar
        setContentView(R.layout.m0708);
        setViewComponent();
    }

    private void setViewComponent() {
        mTxtResult = (TextView) findViewById(R.id.m0708_t001);
        mTxtResult2 = (TextView) findViewById(R.id.m0708_t002);
        listFromResource = getResources().getStringArray(R.array.teacname);
        listFromResource2 = getResources().getStringArray(R.array.descr);

//---------------------------------------------------------------


        mList =new ArrayList<Map<String,Object>>();

        for(int i=0;i<listFromResource.length;i++)
        {
            String idName="t0"+String.format("%02d",i+1);
            int resID = getResources().getIdentifier(idName, "drawable", getPackageName());
            Map<String,Object> item =new HashMap<String,Object>();  //


            item.put("imgView",resID);   //這是屬於一個key我要丟的物件
            item.put("TextView",listFromResource[i]);
            item.put("TextView2",listFromResource2[i]);
            mList.add(item);    //將物品丟進陣列
            SimpleAdapter adapter =new SimpleAdapter(this,mList,R.layout.list_item
                    ,new String[]{"imgView","TextView","TextView2"},
                    new int[]{R.id.imgview,R.id.textview01,R.id.m0708_t002});

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
            mTxtResult.setText(getText(R.string.m0708_t002)+listFromResource[position]);
            mTxtResult2.setText(getText(R.string.m0708_descr)+listFromResource2[position]);
        }
//                mTxtResult.setText(getText(R.string.m0708_t001)+listFromResource[position]);


    };

}