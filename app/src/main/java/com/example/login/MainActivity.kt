package com.example.login

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import android.text.util.Linkify.EMAIL_ADDRESSES
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // This method invoke when you click sunbmit button
        submit.setOnClickListener(View.OnClickListener {
            if (validEmail() and validUserName() and validPassword()) {

                Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()
                inputEmail.textEmail.setText(null)
                inputpassword.textPassword.setText(null)
                inputUsername.textUsername.setText(null)
            }


        })

        submit.background=gradientDrawable



    }

    //Validation for the Email
    private fun validEmail(): Boolean {
        var Email: String = inputEmail.textEmail.text.toString()
        if (Email.isEmpty()) {
            inputEmail.setError("Field cant be empty")
            return false
        } else {

            if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches() ){
                inputEmail.setError("Please enter valid Email Address")
                return false
            }
            else
             inputEmail.setError(null)
             return true
        }
    }

    //Validation for the UserName
    private fun validUserName(): Boolean {
        var UserName: String = inputUsername.textUsername.text.toString()
        if (UserName.isEmpty()) {
            inputUsername.setError("Field cant be empty")
            return false
        } else {
            if (UserName.equals("admin", false)) {
                inputUsername.setError(null)
                return true

            } else {
                inputUsername.setError("Invalid Password")
                return false
            }
        }
    }


    //Validation for the Password
    private fun validPassword(): Boolean {
        var UserName: String = inputpassword.textPassword.text.toString()
        if (UserName.isEmpty()) {
            inputpassword.setError("Field cant be empty")
            return false
        } else {
            if(UserName.equals("admin",false)) {
                inputpassword.setError(null)
                return true
            }else
                inputpassword.setError("Invalid Passowrd")
                 return false


        }
    }


  val gradientDrawable=GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,
                                 intArrayOf(0XFFD98880.toInt(),0XFFF4D03F.toInt(),0XFF48C9B0.toInt()))







}







