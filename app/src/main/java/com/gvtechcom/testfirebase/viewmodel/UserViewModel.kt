package com.gvtechcom.testfirebase.viewmodel

import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gvtechcom.testfirebase.AuthListener
import com.gvtechcom.testfirebase.BR
import com.gvtechcom.testfirebase.model.UserModel
import okhttp3.internal.Util
import java.util.*

class UserViewModel: ViewModel() {
    val userModel = UserModel("Nguyen An","nguyenvanan808@gmail.com", "0982037808","Đang hoặt động", "05/03", "30/03")
    var accountName: MutableLiveData<String> = MutableLiveData()
    var email: MutableLiveData<String> = MutableLiveData()
    var numberPhone: MutableLiveData<String> = MutableLiveData()
    val authListener: AuthListener? = null
    private val messageTrue = "Cập nhật thành công"
    private val messageFalse = "Không đúng định dạng"

    var messageToast: MutableLiveData<String?> = MutableLiveData()
    var txtEditText: MutableLiveData<String> = MutableLiveData()
    init {
        accountName.postValue(userModel.accountName)
        email.postValue(userModel.email)
        numberPhone.postValue(userModel.numberPhone)
    }

    fun validateEditText(): Boolean{
        return !(TextUtils.isEmpty(txtEditText.value)||txtEditText.value?.length!!<6)
    }

    fun onClickBtn(){
        Log.d("AAA","" + txtEditText.value)
        authListener?.onStarted()
        if (validateEditText()){
            authListener?.onSuccess()
            accountName.postValue(txtEditText.value)
            messageToast.postValue(messageTrue)
        } else{
            messageToast.postValue(messageFalse)
            authListener?.onFailure(messageFalse)
        }

    }

    fun getData(): LiveData<String>{
      return getData()
    }

    //TODO get Dialog
    var namePlayer = MutableLiveData<Boolean>()
    var state = MutableLiveData<String>()
//    var state = ObservableField<String>()
//    var state = MutableLiveData<EditProfileState>()

    fun getState(): LiveData<String> {
        return state
    }
    fun setStateValue(string: String){
        state.value = string
    }
//    fun setTrue(){
//        state.postValue(EditProfileState(isCityDialogShown = true))
//        namePlayer.postValue(state.value?.isCityDialogShown)
//        Log.d("AAA","${state.value?.isCityDialogShown}")
//    }
//    fun setFalse(){
//        state.postValue(EditProfileState(isCityDialogShown = false))
//        namePlayer.postValue(state.value?.isCityDialogShown)
//        Log.d("AAA","${state.value?.isCityDialogShown}")
//    }
}