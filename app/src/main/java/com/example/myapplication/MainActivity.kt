package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val EXTRA_MESSAGE = "com.example.myapplication.MESSAGE"

class MainActivity : AppCompatActivity() {
    /*  private var btnMostrar: Button? = null

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //btnMostrar = findViewById<Button>(R.id.button_id)
        //btnMostrar?.setOnClickListener(View.OnClickListener {
        //    sendMessage()
        //})
    }

    fun sendMessage() {
        val editText = findViewById<EditText>(R.id.editText_id)
        val mensaje = editText.text.toString()
        val intento = Intent(this,SecondActivity::class.java)
        intento.putExtra("mensaje", mensaje)
        startActivity(intento)
    }*/

    private var btnLogin: Button? = null
    private var btnGetUsers: Button? = null
    var counter = 0

    val userAPIClient = APIBuilder().getRetrofitBuilder(APIUserClient::class.java)

    override fun onCreate(savedIntanceState: Bundle?){
        super.onCreate(savedIntanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById<Button>(R.id.button_login)
        btnLogin?.setOnClickListener(View.OnClickListener {
            userLogin()
        })

        btnGetUsers = findViewById<Button>(R.id.button_getUsers)
        btnGetUsers?.setOnClickListener(View.OnClickListener {
            getUsers()
        })
    }

    fun userLogin(){
        counter++
        val call:Call<User> = userAPIClient.login(User("Paula $counter"))
        call.enqueue(object: Callback<User>{
            override fun onResponse(call:Call<User>,response: Response<User>){
                val user = response.body()?.let{
                    println("${it.name},${it.id}")
                }?: run {
                    println("Error parsing User object on login method")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                println("Server error. Try again later")
            }
        })
    }

    fun getUsers(){
        val call: Call<List<User>> = userAPIClient.getUsers(nombre = "a")
        call.enqueue(object: Callback<List<User>>{
            override fun onResponse(call:Call<List<User>>,response: Response<List<User>>){
                val user = response.body()?.let{
                    for (user in it){
                        println("${user.name},${user.id}")
                    }
                }?: run {
                    println("Error parsing User object on login method")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                println("Server error. Try again later")
            }
        })
    }




}
