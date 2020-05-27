package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import android.text.util.Linkify.EMAIL_ADDRESSES
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var textInputEmail: TextInputLayout
    private lateinit var textInputUserName: TextInputLayout
    private lateinit var textInputPassword: TextInputLayout
    private lateinit var ClickButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInputEmail =  findViewById(R.id.inputEmail) as TextInputLayout
        textInputUserName = findViewById(R.id.inputUsername) as TextInputLayout
        textInputPassword = findViewById(R.id.inputpassword) as TextInputLayout


    }

    //Validation for the Email
    private fun validEmail(): Boolean {
        var Email: String = textInputEmail.textEmail.text.toString()
        if (Email.isEmpty()) {
            textInputEmail.setError("Field cant be empty")
            return false
        } else {

            if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches() ){
                textInputEmail.setError("Please enter valid Email Address")
                return false
            }
            else
             textInputEmail.setError(null)
             return true
        }
    }

    //Validation for the UserName
    private fun validUserName(): Boolean {
        var UserName: String = textInputUserName.textUsername.text.toString()
        if (UserName.isEmpty()) {
            textInputUserName.setError("Field cant be empty")
            return false
        } else {
            if (UserName.equals("admin", false)) {
                textInputUserName.setError(null)
                return true

            } else {
                textInputUserName.setError("Invalid Password")
                return false
            }
        }
    }


    //Validation for the Password
    private fun validPassword(): Boolean {
        var UserName: String = textInputPassword.textPassword.text.toString()
        if (UserName.isEmpty()) {
            textInputPassword.setError("Field cant be empty")
            return false
        } else {
            if(UserName.equals("admin",false)) {
                textInputPassword.setError(null)
                return true
            }else
                textInputPassword.setError("Invalid Passowrd")
                 return false


        }
    }
    //this methode invoke when you click the submit button and
    fun confirmInput(view:View){
        if (validEmail() and validUserName() and validPassword()) {

            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()
            textInputEmail.textEmail.setText(null)
            textInputPassword.textPassword.setText(null)
            textInputUserName.textUsername.setText(null)
        }



    }
}







