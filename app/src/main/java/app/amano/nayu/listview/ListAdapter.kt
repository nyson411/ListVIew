package app.amano.nayu.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.amano.nayu.listview.databinding.ListItemBinding
import app.amano.nayu.listview.utils.getStringArrayList

class ListAdapter(
    context: Context,
) : RecyclerView.Adapter<FlowerListViewHolder>() {

    val messageList = mutableListOf<Message>()
    lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FlowerListViewHolder {
//        val view =
//            LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        val view: ListItemBinding =
            ListItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return FlowerListViewHolder(view)
    }

    // ViewHolderの設定
    override fun onBindViewHolder(holder: FlowerListViewHolder, position: Int) {
        holder.binding.message.text = messageList[position].main
        holder.binding.title.text = messageList[position].title
        holder.binding.root.setOnClickListener {
            listener.onItemClickListener(
                position = position,
                clickedText = messageList[position].title
            )
        }
    }

    // ViewHolderの数の決定
    override fun getItemCount(): Int {
        return messageList.size
    }

    interface OnItemClickListener {
        //        fun onItemClickListener(view: View, position: Int, clickedText: String)
        fun onItemClickListener(position: Int, clickedText: String)
    }

    // リスナー
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }


}