package com.gvtechcom.testfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.view_tab))
        tabLayout.addTab(tabLayout.newTab().setText("Message"))
        tabLayout.addTab(tabLayout.newTab().setText("Support"))
        tabLayout.addOnTabSelectedListener(object : TabLayout.BaseOnTabSelectedListener<TabLayout.Tab>{
            override fun onTabReselected(p0: TabLayout.Tab?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                Log.d("AAA","-------------- ${p0?.position}")
            }

        })
    }
}
