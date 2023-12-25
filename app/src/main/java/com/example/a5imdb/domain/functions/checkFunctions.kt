package com.example.a5imdb.domain.functions

import android.content.Context
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.a5imdb.R

fun checkInputsFullFilledAndUpdateButton(inputs : List<EditText>, button: Button,context:Context) : Boolean{
    button.isEnabled = true
    button.setBackgroundColor(ContextCompat.getColor(context,R.color.darkGray))
    for (input in inputs){
        if (input.text.toString() == "" ) {
            button.isEnabled = false
            button.setBackgroundColor(ContextCompat.getColor(context,R.color.gray))
            return false
        }
    }
    return true
}
