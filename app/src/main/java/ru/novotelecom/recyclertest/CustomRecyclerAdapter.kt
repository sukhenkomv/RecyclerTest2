package ru.novotelecom.recyclertest

import android.content.ContentResolver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION


class CustomRecyclerAdapter(
    private val names: List<String>,
    private val listener: SettingsItemListener
) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(private val itemView: View, private val listener: SettingsItemListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener, View.OnFocusChangeListener {
        val largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
        val smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)
        private val mainLl: LinearLayout = itemView.findViewById(R.id.main_ll)

        init {
            mainLl.setOnClickListener(this)
            mainLl.onFocusChangeListener = this
        }

        override fun onClick(p0: View?) {
            if (absoluteAdapterPosition != NO_POSITION) {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }

        override fun onFocusChange(p0: View?, p1: Boolean) {
            listener.onFocusChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)

        itemView.isFocusable = true;
        itemView.isFocusableInTouchMode = true;

        return MyViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.largeTextView.text = names[position]
        holder.smallTextView.text = "кот"
    }

    override fun getItemCount(): Int {
        return names.size
    }
}