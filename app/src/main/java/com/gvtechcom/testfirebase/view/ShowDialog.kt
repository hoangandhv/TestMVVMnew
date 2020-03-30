package com.gvtechcom.testfirebase.view

import android.app.Dialog
import android.content.Context
import com.gvtechcom.testfirebase.R

class ShowDialog(val context: Context){
    fun showDialog(){
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.item_dialog)
        dialog.show()
    }

}