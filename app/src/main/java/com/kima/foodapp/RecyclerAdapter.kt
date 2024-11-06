package com.kima.foodapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
// This is an Adapter that Creates The data to Put in Our Recycler View.
class RecyclerAdapter(var context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    // Array of Food titles    
    private val titles = arrayOf("snacks","pizza","burger","hotdogs","cheese","candies","jellofrice","chickenfry","omlet","choma")
    // Array of Food Details  
    private val details = arrayOf(" A classic Italian pizza topped with fresh mozzarella cheese, tomato sauce, and basil leaves, drizzled with olive oil. The flavors are simple yet rich, highlighting the freshness of the ingredients.",
        "Soft corn or flour tortillas filled with a choice of meat (like chicken, beef, or pork), topped with fresh salsa, lettuce, guacamole, and a sprinkle of cheese. Tacos are known for their bold flavors and satisfying textures.",
        "Tender chunks of chicken cooked in a creamy tomato-based sauce with a blend of Indian spices. Butter chicken is mildly spiced, rich, and pairs well with naan or rice.",
        " Crispy pork pieces coated in a tangy and sweet sauce with a hint of pineapple, bell peppers, and onions. This dish offers a perfect balance of savory and sweet flavors.",
        " Fresh slices of fish, such as tuna or salmon, served on vinegared rice with a hint of wasabi. Sushi is a light and delicate dish, perfect for seafood lovers.",
        " A flaky, buttery pastry with a golden crust and soft, airy layers inside. Often enjoyed for breakfast, croissants pair beautifully with coffee or tea.",
        "A soft pita or wrap filled with crispy falafel balls, fresh vegetables, and drizzled with tahini sauce. This vegetarian dish is flavorful, wholesome, and satisfying",
        "Stir-fried rice noodles with shrimp or chicken, eggs, bean sprouts, and peanuts, tossed in a tangy tamarind sauce. Pad Thai is a delicious balance of sweet, sour, and savory flavors.",
        "Fluffy couscous served with a fragrant stew of tender lamb, vegetables, and a blend of spices like cinnamon and cumin. This dish is hearty and aromatic.",
        "Soft corn or flour tortillas filled with a choice of meat (like chicken, beef, or pork), topped with fresh salsa, lettuce, guacamole, and a sprinkle of cheese. Tacos are known for their bold flavors and satisfying textures."
    )
    // Array of Food costs
    private val cost = arrayOf("Ksh.1000","Ksh.2000","ksh.3000","ksh.4000","ksh.5000","ksh.6000","ksh.7000","ksh.8000","ksh.9000","ksh.9000")

    // Array of Food images  
    private val images = intArrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10,
    )

    // Access the Single item XML Layout
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.singleitem, viewGroup, false)
        return ViewHolder(v)
    }
    
    //View Holder that does find Views in single item XML, 1 ImageView, 3 TextView    
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemCost: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle =itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_description)
            itemCost = itemView.findViewById(R.id.item_cost)
        }
    }

    //Set Items from Arrays and Put/Bind them in respectives Views    
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemImage.setImageResource(images [i])
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemCost.text = cost[i]


        //Below to be Done At the End to demonstrate how to move to Next Page on Item Click
        viewHolder.itemView.setOnClickListener {
         val intent = Intent(context,singleitemactivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
      }
    }

    // Get how many items the array have, All arrays must have equal sizes
    override fun getItemCount(): Int {
        return titles.size
    }
}