package com.gvtechcom.testfirebase.view

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gvtechcom.testfirebase.R
import com.gvtechcom.testfirebase.databinding.FragmentUserBinding
import com.gvtechcom.testfirebase.databinding.ItemDialogBinding
import com.gvtechcom.testfirebase.viewmodel.UserViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment(),  InterfaceShowDialog {
    lateinit var dataBindingUtil: FragmentUserBinding
    lateinit var bindingDialog: ItemDialogBinding
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
        userViewModel.getState().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            showToast(it)
            showDialog()
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
        bindingDialog = DataBindingUtil
            .inflate(LayoutInflater.from(context), R.layout.item_dialog, null, false)
        bindingDialog.dialog = userViewModel
        bindingDialog.lifecycleOwner = this
        val dialog = Dialog(context!!)
        dialog.setContentView(bindingDialog.root)
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

        @BindingAdapter("messageToast")
        @JvmStatic fun setOntouch(view: View, boolean: Boolean) {
            view.setOnTouchListener { v, event ->
                if (event?.action == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(view.context, "ACTION_DOWN", Toast.LENGTH_SHORT).show()
                } else if (event?.action == MotionEvent.ACTION_UP) {
                    Toast.makeText(view.context, "ACTION_UP", Toast.LENGTH_SHORT).show()
                }
                boolean
            }
        }

        @BindingAdapter("show")
        @JvmStatic fun setShow(view: View, number: Int) {
            view.setOnClickListener {
                Toast.makeText(view.context, "$number", Toast.LENGTH_SHORT).show()
                when(view.id){
                    R.id.btn_show1 -> Log.d("AAA","Show 1")
                    R.id.btn_show2 -> Log.d("AAA","Show 2")
                }
            }

        }
    }



}
