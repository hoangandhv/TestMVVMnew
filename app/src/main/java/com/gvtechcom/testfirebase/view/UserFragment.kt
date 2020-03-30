package com.gvtechcom.testfirebase.view

import App
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gvtechcom.testfirebase.R
import com.gvtechcom.testfirebase.databinding.FragmentUserBinding
import com.gvtechcom.testfirebase.viewmodel.UserViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment(),  InterfaceShowDialog {
    lateinit var dataBindingUtil: FragmentUserBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBindingUtil =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)
        userViewModel = UserViewModel()
        dataBindingUtil.userData = userViewModel
        dataBindingUtil.lifecycleOwner = this
        return dataBindingUtil.root//inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        btn_setaccount.setOnClickListener {
//            dataBindingUtil.userData!!.onClickBtn()
//            Toast.makeText(context,dataBindingUtil.userData!!.messageToast.get(), Toast.LENGTH_LONG).show()
//        }
        userViewModel.getState().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            showToast(it)
        })
    }

    fun isEmailValid(email: String): Boolean {
        var isValid = false
        val expression = "[a-zA-Z0-9._-]+@[a-z]+(\\.+[a-z]+)+"
        val inputStr: CharSequence = email
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(inputStr)
        if (matcher.matches()) {
            isValid = true
        }
        return isValid
    }

    fun showToast(state: String){
        Toast.makeText(context,"Toast: $state", Toast.LENGTH_LONG).show()
    }

    override fun showDialog() {
        val dialog = Dialog(context!!)
        dialog.setContentView(R.layout.item_dialog)
        dialog.show()
    }

    companion object {
        //        @JvmStatic
//        @BindingAdapter("messageToast")
//        fun set(view: View, message: String?) {
//            if (message!=null){
//                Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
//            }
//        }
        @JvmStatic
        @BindingAdapter("messageToast")
        fun setOntouch(view: View, boolean: Boolean) {
            view.setOnTouchListener { v, event ->
                if (event?.action == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(view.context, "ACTION_DOWN", Toast.LENGTH_SHORT).show()
                } else if (event?.action == MotionEvent.ACTION_UP) {
                    Toast.makeText(view.context, "ACTION_UP", Toast.LENGTH_SHORT).show()
                }
                boolean
            }
        }
        @JvmStatic
        @BindingAdapter("show")
        fun setShow(view: View, number: Int) {
            view.setOnClickListener {
                Toast.makeText(view.context, "$number", Toast.LENGTH_SHORT).show()
            }

        }

    }



}
