package app.amano.nayu.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import app.amano.nayu.listview.databinding.ListItemBinding

class FlowerListViewHolder(
    val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root)
//{
//
//    //private lateinit var binding:LayoutUserItemBinding
//    val title:TextView=view.findViewById(R.id.title)
//    val message:TextView=view.findViewById(R.id.message)
//    val container: ConstraintLayout = view.findViewById(R.id.container)
//
//
//}