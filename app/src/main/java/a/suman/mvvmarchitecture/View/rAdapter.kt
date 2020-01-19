package a.suman.mvvmarchitecture.View

import a.suman.mvvmarchitecture.Model.Room.DataClassRoom
import a.suman.mvvmarchitecture.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rAdapter(val inflate:InflateImageView):RecyclerView.Adapter<rViewHolder>(){

    var data= emptyList<DataClassRoom>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):rViewHolder {
        return rViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: rViewHolder, position: Int) {
        inflate.InflateImage(holder.imageView,data ,position)
        holder.textView2.text=data[position].earth_date
    }

    fun setDat(data:List<DataClassRoom>){
        this.data=data
        notifyDataSetChanged()
    }
}

class rViewHolder(view: View):RecyclerView.ViewHolder(view){
    val imageView:ImageView=view.findViewById(R.id.imageView)
    val textView2:TextView=view.findViewById(R.id.textView2)

}

interface InflateImageView{
    fun InflateImage(imageView: ImageView, dataI:List<DataClassRoom>, position: Int )
}