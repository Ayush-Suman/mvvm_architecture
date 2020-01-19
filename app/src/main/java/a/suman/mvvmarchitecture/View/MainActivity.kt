package a.suman.mvvmarchitecture.View

import a.suman.mvvmarchitecture.Model.Room.DataClassRoom
import a.suman.mvvmarchitecture.R
import a.suman.mvvmarchitecture.ViewModel.ViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), InflateImageView {

    lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val rAdapter=rAdapter(this@MainActivity)
        viewModel= ViewModelProviders.of(this).get(ViewModel::class.java)
        button.setOnClickListener {
            viewModel.getViewData(Integer.parseInt(editText.text.toString())).observe(this, Observer {words->words.let{rAdapter.setDat(it)}  })
        recyclerView.adapter=rAdapter
    }
    }

    override fun InflateImage(imageView: ImageView, dataI:List<DataClassRoom>, position: Int ) {
        Glide.with(this).load(dataI[position].img_src).into(imageView)
    }
}
