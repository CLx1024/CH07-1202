package tw.tcnr13.m0705;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import tw.tcnr13.m0705.R;

public class M0705 extends AppCompatActivity implements ViewSwitcher.ViewFactory, AdapterView.OnItemClickListener {

    private TextView txtSelect;
    private TextView txtResult;

    private String user_select;
    private String answer;
    private ImageButton btnScissors;
    private ImageButton btnStone;
    private ImageButton btnNet;

    private MediaPlayer startmusic;
    private MediaPlayer mediaWin;
    private MediaPlayer mediaLose;
    private MediaPlayer mediaDraw;
    private MediaPlayer endmusic;
    private Toast toast;
    private RelativeLayout r_layout;
    private ImageSwitcher txtComPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0705);
        setupViewCOmponent();
    }

    private void setupViewCOmponent() {
        btnScissors = (ImageButton)findViewById(R.id.m0705_b001); //***
        btnStone = (ImageButton)findViewById(R.id.m0705_b002); //***
        btnNet = (ImageButton)findViewById(R.id.m0705_b003);  //***
        txtSelect = (TextView) findViewById(R.id.m0705_s001);
        txtResult = (TextView)findViewById(R.id.m0705_f000);
        txtComPlay = (ImageSwitcher) findViewById(R.id.m0705_c001); //******我上支城市沒寫到這個變數？
        txtComPlay.setFactory(this);

        u_setalpha();  //--設定imageutton初始值為全透明B   // 設alpha透明，自定義函數

        // ---開機動畫---
        r_layout = (RelativeLayout) findViewById(R.id.m0705_r001);
        r_layout.setBackgroundResource(R.drawable.back01);
//        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_out));
        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_in));
        r_layout.setBackgroundResource(R.drawable.back01);


        // --開啟片頭音樂-----
        startmusic = MediaPlayer.create(getApplication(),R.raw.guess);  // 自定義開始的音樂  create建議一個媒體檔 這個create要放在哪個class 來源
        startmusic.start();

        // --Close音樂-----
        endmusic = MediaPlayer.create(getApplication(), R.raw.good9);

        mediaWin = MediaPlayer.create(getApplication(), R.raw.vctory);  //宣告
        mediaDraw = MediaPlayer.create(getApplication(), R.raw.haha);
        mediaLose = MediaPlayer.create(getApplication(), R.raw.lose);

        btnScissors.setOnClickListener(btn01On);
        btnStone.setOnClickListener(btn01On);
        btnNet.setOnClickListener(btn01On);
    }



    private View.OnClickListener btn01On = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1);       // 1 - scissors, 2 - stone, 3 - net.
            switch(v.getId()){   //這邊次之2
                case R.id.m0705_b001:  //玩家選剪刀
                    user_select = getString(R.string.m0705_ans1)+" "+getString(R.string.m0705_b001);
                    u_setalpha();  // 設透明度
                    btnScissors.getBackground().setAlpha(185); //0-255
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                        //    answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f003);  // 1123可寫到下面
                        //    txtResult.setTextColor(Color.YELLOW); //平手黃色  // 1123可寫到下面                            break;
                            music(2);
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                        //    answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f002);
                        //    txtResult.setTextColor(Color.RED); //輸用紅色
                            music(3);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                        //    answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f001);
                        //    txtResult.setTextColor(Color.GREEN); //贏用綠色
                            music(1);
                            break;
                    }

                   // switch(iComPlay)
                    break;
                case R.id.m0705_b002:  //石頭
                    user_select = getString(R.string.m0705_ans1)+" "+getString(R.string.m0705_b002);
                    u_setalpha();  // 設透明度
                    btnStone.getBackground().setAlpha(185); //0-255
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                        //    answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f001);
                        //    txtResult.setTextColor(Color.GREEN); //贏用綠色
                            music(1);
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                        //    answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f003);
                        //    txtResult.setTextColor(Color.YELLOW); //平手黃色
                            music(2);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                        //    answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f002);
                        //    txtResult.setTextColor(Color.RED); //輸用紅色
                            music(3);
                            break;
                    }
                    break;
                case R.id.m0705_b003:  //布
                    user_select = getString(R.string.m0705_ans1)+" "+getString(R.string.m0705_b003);
                    u_setalpha();  // 設透明度
                    btnNet.getBackground().setAlpha(185); //0-255
                    switch(iComPlay){  //這邊第三3
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);
                        //    answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f002);
                        //    txtResult.setTextColor(Color.RED); //輸用紅色
                            music(3);
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);
                        //    answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f001);
                        //    txtResult.setTextColor(Color.GREEN); //贏用綠色
                            music(1);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);
                        //    answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f003);  // 1123可寫到下面
                        //    txtResult.setTextColor(Color.YELLOW); //平手黃色  // 1123可寫到下面
                            music(2);
                            break;
                    }
                    break;
            }
            //-----------電腦出拳增加動畫-----------
            txtComPlay.clearAnimation();
            //Animation anim = AnimationUtils.loadAnimation(this,R.anim.anim_trans_in);  // 我打this會跳錯誤訊息 所以打下面那行
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim_trans_bounce);  // down
            anim.setInterpolator(new BounceInterpolator());  // jump
            txtComPlay.setAnimation(anim);
            //------------------------------------

            txtSelect.setText(user_select);  //這邊先寫1
            txtResult.setText(answer);
        }
    };

    private void u_setalpha() {  //這是我們自己設的自定義函數
        //imageButton 背景為銀色且為全透明
       // btnScissors.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));  //講義是舊的寫法 新版的是寫Color這樣而已// Class0~255 L0~1

        //btnScissors.setBackgroundColor(Color.GRAY);
        btnScissors.setBackgroundResource(R.drawable.circle_shape);  // 加這行 12/14
        btnScissors.getBackground().setAlpha(0); //0-255

        //btnStone.setBackgroundColor(Color.GRAY);
        btnStone.setBackgroundResource(R.drawable.circle_shape); // 加這行 12/14
        btnStone.getBackground().setAlpha(0);

        //btnNet.setBackgroundColor(Color.GRAY);
        btnNet.setBackgroundResource(R.drawable.circle_shape); // 加這行 12/14
        btnNet.getBackground().setAlpha(0);

        // 以上六行這一堆是在做歸零

        txtComPlay.setBackgroundResource(R.drawable.circle_shape);
        txtComPlay.getBackground().setAlpha(0);
    }

    private void music(int i) {
        if(startmusic.isPlaying()) //你直接stop會閃退所以先判斷
            startmusic.stop();
        if(mediaWin.isPlaying())
            mediaWin.pause();
        if(mediaDraw.isPlaying())
            mediaDraw.pause();
        if(mediaLose.isPlaying())
            mediaLose.pause();
        //i = 1 win, 2 draw, 3 lose
        switch(i){
            case(1):
                answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f001);
                txtResult.setTextColor(Color.GREEN); //贏用綠色
//                toast = Toast.makeText(getApplicationContext(),getText(R.string.m0705_f001),Toast.LENGTH_SHORT);
//                toast.show();
                Toast.makeText(getApplicationContext(),getText(R.string.m0705_f001),Toast.LENGTH_SHORT).show();
                mediaWin.start();
                break;
            case(2):
                answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f003);
                txtResult.setTextColor(Color.YELLOW); //平手黃色
//                toast = Toast.makeText(getApplicationContext(),getText(R.string.m0705_f003),Toast.LENGTH_SHORT);
//                toast.show();
                Toast.makeText(getApplicationContext(),getText(R.string.m0705_f003),Toast.LENGTH_SHORT).show();
                mediaDraw.start();
                break;
            case(3):
                answer = getString(R.string.m0705_ans2)+getString(R.string.m0705_f002);
                txtResult.setTextColor(Color.RED); //輸用紅色
//                toast = Toast.makeText(getApplicationContext(),getText(R.string.m0705_f002),Toast.LENGTH_SHORT);
//                toast.show();
                Toast.makeText(getApplicationContext(),getText(R.string.m0705_f002),Toast.LENGTH_SHORT).show();
                mediaLose.start();
                break;
            case(4):
                endmusic.start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if(startmusic.isPlaying())
//            startmusic.stop();
        music(4);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        // v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new
                ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
//    {
//        int icomp = (int) (Math.random() * 3 + 1);       // 1 - scissors, 2 - stone, 3 - net.
//
//        switch(){
//          case //玩家選
//
//      }
//        //txtSelect.setText
//
//    }
//}