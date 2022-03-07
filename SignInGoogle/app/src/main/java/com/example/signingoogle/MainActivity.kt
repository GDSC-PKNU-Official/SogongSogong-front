package com.example.signingoogle

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.signingoogle.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var options: GoogleSignInOptions
    private lateinit var client: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        options = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestServerAuthCode(resources.getString(R.string.server_client_id))
            .requestEmail()
            .requestIdToken(resources.getString(R.string.server_client_id))
            .build()

        client = GoogleSignIn.getClient(this,options)


        val account = GoogleSignIn.getLastSignedInAccount(this)
        if(account!=null){
            val name = account.displayName
            val email = account.email
            val token = account.idToken
            binding.mainTv.text = "$name \n $email \n $token"
            binding.signOutButton.setOnClickListener {
                signOut()
            }
        }


        setContentView(binding.root)
    }

    private fun signOut() {
        client.signOut().addOnCompleteListener {
            finish()
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}