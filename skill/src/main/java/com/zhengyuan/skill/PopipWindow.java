package com.zhengyuan.skill;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2018/10/6.
 */

public class PopipWindow extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle bundle) {

        super.onCreate(bundle);
        setContentView(R.layout.activity_popipwindow);
        Button show = (Button) findViewById(R.id.showpopiwindow);
        show.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.showpopiwindow:
                new ConfirmPopWindow(this).showAtBottom(view);
                break;
        }
    }
}
