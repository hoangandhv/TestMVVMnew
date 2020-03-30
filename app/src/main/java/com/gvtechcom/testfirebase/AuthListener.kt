package com.gvtechcom.testfirebase

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}