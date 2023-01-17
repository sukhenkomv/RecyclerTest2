package ru.novotelecom.recyclertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//interface OnNoteListener {
//    fun onNoteClick(position: Int, name: String)
//}

//class CustomRecyclerAdapter(private val names: List<String>, private val listener: OnNoteListener) :
class CustomRecyclerAdapter(private val names: List<String>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
        val smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)
//
//        init {
//            itemView.setOnClickListener {
//                listener.onNoteClick(bindingAdapterPosition, names[bindingAdapterPosition])
//            }
//        }
//
//        override fun onNoteClick(position: Int) {
//            TODO("Not yet implemented")
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)

        itemView.isFocusable = true;
        itemView.isFocusableInTouchMode = true;

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.largeTextView.text = names[position]
        holder.smallTextView.text = "кот"
    }

    override fun getItemCount(): Int {
        return names.size
    }
}