package com.example.signingoogle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.signingoogle.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var options: GoogleSignInOptions
    private lateinit var client: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        options = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestServerAuthCode(resources.getString(R.string.server_client_id))
            .requestEmail()
            .requestIdToken(resources.getString(R.string.server_client_id))
            .build()

        client = GoogleSignIn.getClient(this,options)

        val account = GoogleSignIn.getLastSignedInAccount(this)
        if(account!=null){
            navigateToMainActivity()
        }

        binding.signInButton.setOnClickListener {
            signIn()
        }
        setContentView(binding.root)
    }

    private fun signIn() {
        val intent = client.signInIntent
        startActivityForResult(intent,100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==100){
            val task : Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)

        }
    }



    private fun handleSignInResult(task: Task<GoogleSignInAccount>) {
        try {
            val account = task.getResult(ApiException::class.java)
            okResult(account)
        }catch (e: Exception){
            okResult(null)
        }
    }

    fun okResult(account: GoogleSignInAccount?){
        if(account==null){
            binding.textView.text = "noname"
        }else{
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
        finish()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}