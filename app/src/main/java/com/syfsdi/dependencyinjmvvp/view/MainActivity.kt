package com.syfsdi.dependencyinjmvvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.syfsdi.dependencyinjmvvp.databinding.ActivityMainBinding
import com.syfsdi.dependencyinjmvvp.viewmodel.MakeupApplication
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var  binding : ActivityMainBinding
    lateinit var makeupAdapter : MakeupAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmtoAdapter()
    }
    fun setVmtoAdapter(){
    val viewModel = ViewModelProvider(this).get(MakeupApplication::class.java)
    viewModel.CallApiMakeup()
    viewModel.getLiveDataMakeup().observe(this, Observer {
        makeupAdapter = MakeupAdapter(it)
        if ( it != null){
            binding.rvMakeup.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rvMakeup.adapter = MakeupAdapter(it)

        }

    })
}

}