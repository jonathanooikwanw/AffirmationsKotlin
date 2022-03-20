package com.example.affirmations.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

//we cre

//The ItemAdapter needs information on how to resolve the string resources.
// This, and other information about the app, is stored in a Context object instance that you can pass into an ItemAdapter instance.

class ItemAdapter (private val context: Context, private val dataset: List<Affirmation>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

//    RecyclerView doesn't interact directly with item views, but deals with ViewHolders instead.
//    A ViewHolder represents a single list item view in RecyclerView, and can be reused when possible.
    class ItemViewHolder(private val view:View) : RecyclerView.ViewHolder(view){
        val textView : TextView = view.findViewById(R.id.item_title)
        val imageView : ImageView = view.findViewById(R.id.item_image)
    }

//    The onCreateViewHolder()method is called by the layout manager to create new view holders for the
//    RecyclerView (when there are no existing view holders that can be reused). Remember that a view holder represents a single list item view
    //parent is the view group that the new list item view will be attached to
    //A viewType parameter which becomes important when there are multiple item view types in the same RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)

        return ItemViewHolder(adapterLayout)
    }

//    The last method you need to override is onBindViewHolder().
//    This method is called by the layout manager in order to replace the contents of a list item view.
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}