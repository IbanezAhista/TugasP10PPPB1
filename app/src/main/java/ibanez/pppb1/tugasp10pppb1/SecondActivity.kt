package ibanez.pppb1.tugasp10pppb1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SecondActivity : AppCompatActivity() {

    private lateinit var txtName: TextView
    private lateinit var txtEmail: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        txtName = findViewById(R.id.txt_name)
        txtEmail = findViewById(R.id.txt_email)
        imageView = findViewById(R.id.photo_profile)

        // Ambil data dari Intent
        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")
        val avatar = intent.getStringExtra("avatar")

        // Set data ke UI
        txtName.text = "Name  : $firstName $lastName"
        txtEmail.text = "Email   : $email"
        Glide.with(this).load(avatar).into(imageView)
    }
}
