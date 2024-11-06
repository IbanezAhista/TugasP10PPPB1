package ibanez.pppb1.tugasp10pppb1

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ibanez.pppb1.tugasp10pppb1.databinding.ActivityMainBinding
import ibanez.pppb1.tugasp10pppb1.model.Data
import ibanez.pppb1.tugasp10pppb1.model.Profile
import ibanez.pppb1.tugasp10pppb1.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProfile: ProfileAdapter
    private val userList = ArrayList<Data>() // Pastikan tipe data ArrayList<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterProfile = ProfileAdapter(userList) { profile ->
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("firstName", profile.firstName)
                putExtra("lastName", profile.lastName)
                putExtra("email", profile.email)
                putExtra("avatar", profile.avatar) // Jika Anda memiliki gambar URL
            }
            startActivity(intent)
        }

        binding.rvProfile.apply {
            adapter = adapterProfile
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        val client = ApiClient.getInstance()
        val response = client.getAllUsers()
        response.enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                response.body()?.data?.let { data ->
                    userList.clear()
                    userList.addAll(data)
                    adapterProfile.notifyDataSetChanged() // Memperbarui RecyclerView
                }
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error", Toast.LENGTH_LONG).show()
            }
        })
    }
}
