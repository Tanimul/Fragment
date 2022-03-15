package com.example.fragment


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.transaction
import com.example.fragment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(binding.fragCont.id, HomeFragment())
            .commit()

        binding.buttomNavigation.setOnItemSelectedListener {
            Toast.makeText(this, "Clicked : $it", Toast.LENGTH_SHORT).show()

            when (it.itemId) {

                R.id.home ->
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragCont.id, HomeFragment())
                        .commit()
                R.id.phone ->
                supportFragmentManager.commit {
                    replace(R.id.frag_cont,CallFragment(),"ok")
                }
                R.id.Notification ->
                    supportFragmentManager.beginTransaction()
                        .replace(binding.fragCont.id, NotificationFragment())
                        .commit()

            }
            return@setOnItemSelectedListener true
        }
    }
}