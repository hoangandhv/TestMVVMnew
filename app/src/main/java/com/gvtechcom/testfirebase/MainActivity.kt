package com.gvtechcom.testfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.gvtechcom.testfirebase.view.UserFragment
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fm = supportFragmentManager.beginTransaction()
        fm.replace(R.id.fragment_container, UserFragment())
        fm.commit()

        val database = Firebase.database
        val myRef = database.getReference("message${Calendar.getInstance().timeInMillis}")
        myRef.child("message").child("message3").setValue("123")

        myRef.addChildEventListener(object : ChildEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                Log.d("AAA-", "Value is: ${p0} ")
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                Log.d("AAA-", "Value is: ${p0} ")
            }

            override fun onChildRemoved(p0: DataSnapshot) {
                Log.d("AAA-", "Value is: ${p0} ")
            }

        })


    }
}
