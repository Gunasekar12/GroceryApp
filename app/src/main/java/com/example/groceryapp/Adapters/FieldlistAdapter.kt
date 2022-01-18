package com.example.groceryapp.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.R
import com.example.groceryapp.model.Field1
import com.example.groceryapp.model.Record1
import com.example.groceryapp.model.Recordsdc
import com.example.groceryapp.model.Root
import java.lang.reflect.Field

class FieldlistAdapter (private val context : Activity, private val mList: ArrayList<Record1>) : ArrayAdapter<Record1>(context, R.layout.card_view_desing, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.card_view_desing, null)

        val state: TextView = view.findViewById(R.id.statsubtit)
        val district: TextView = view.findViewById(R.id.disubtit)
        val market: TextView = view.findViewById(R.id.mktsubtit)
        val variety : TextView = view.findViewById(R.id.varsubtit)
        val arrivaldate: TextView = view.findViewById(R.id.arivdtsubtile)
        val minprice: TextView = view.findViewById(R.id.minpricesub)
        val commodity:TextView= view.findViewById(R.id.comdsubtit)
        val maxprice: TextView = view.findViewById(R.id.maxpricesub)
        val modelprice: TextView = view.findViewById(R.id.mdlpricesub)

        state.text = mList.get(position).getState()
        district.text = mList.get(position).getDistrict()
        market.text = mList.get(position).getMarket()
        minprice.text = mList.get(position).getMin_price()
        maxprice.text = mList.get(position).getMax_price()
        variety.text = mList.get(position).getVariety()
        arrivaldate.text = mList.get(position).getArrival_date()
        modelprice.text = mList.get(position).getModal_price()
        commodity.text=mList.get(position).getCommodity()

        return view
    }
    /*// create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_desing, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       // val  = mList[position]

        // sets the image to the imageview from our itemHolder class
    //    holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.state!!.text = mList.get(position).getState()
        holder.district!!.text = mList.get(position).getDistrict()
        holder.market!!.text = mList.get(position).getMarket()
        holder.minprice!!.text = mList.get(position).getMin_price()
        holder.maxprice!!.text = mList.get(position).getMax_price()
        holder.variety!!.text = mList.get(position).getVariety()
        holder.arrivaldate!!.text = mList.get(position).getArrival_date()
        holder.modelprice!!.text = mList.get(position).getModal_price()
        holder.commodity!!.text=mList.get(position).getCommodity()

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val state: TextView = itemView.findViewById(R.id.statsubtit)
        val district: TextView = itemView.findViewById(R.id.disubtit)
        val market: TextView = itemView.findViewById(R.id.mktsubtit)
        val variety : TextView = itemView.findViewById(R.id.varsubtit)
        val arrivaldate: TextView = itemView.findViewById(R.id.arivdtsubtile)
        val minprice: TextView = itemView.findViewById(R.id.minpricesub)
        val commodity:TextView=itemView.findViewById(R.id.comdsubtit)
        val maxprice: TextView = itemView.findViewById(R.id.maxpricesub)
        val modelprice: TextView = itemView.findViewById(R.id.mdlpricesub)

    }*/
}