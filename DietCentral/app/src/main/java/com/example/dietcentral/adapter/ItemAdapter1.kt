package com.example.dietcentral.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dietcentral.InfoFragment
import com.example.dietcentral.R
import com.example.dietcentral.diet_1

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var code = mutableListOf("")
    var differention = "1"
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemCode: TextView

        init {
            itemCode = itemView.findViewById(R.id.cardtext)

            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, diet_1::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", itemCode.text)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.list_item1, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        getText()
        return code.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        getText()
        viewHolder.itemCode.text = code[i]
    }

    fun setAct(){
        differention = InfoFragment.idvalue
    }

    fun getText(){
        setAct()
        if (differention == "1"){
            code.set(0, "Intermittent fasting is a dietary strategy that cycles between periods of fasting and eating.\n" +
                    "\n" +
                    "Various forms exist, including the 16/8 method, which involves limiting your calorie intake to 8 hours per day, and the 5:2 method, which restricts your daily calorie intake to 500–600 calories twice per week.\n" +
                    "\n" +
                    "How it works: Intermittent fasting restricts the time you’re allowed to eat, which is a simple way to reduce your calorie intake. This can lead to weight loss — unless you compensate by eating too much food during allowed eating periods.\n" +
                    "\n" +
                    "Weight loss: In a review of studies, intermittent fasting was shown to cause 3–8% weight loss over 3–24 weeks, which is a significantly greater percentage than other methods (2Trusted Source).\n" +
                    "\n" +
                    "The same review showed that this way of eating may reduce waist circumference by 4–7%, which is a marker for harmful belly fat (2Trusted Source).\n" +
                    "\n" +
                    "Other studies found that intermittent fasting can increase fat burning while preserving muscle mass, which can improve metabolism (3Trusted Source, 4Trusted Source).\n" +
                    "\n" +
                    "Other benefits: Intermittent fasting has been linked to anti-aging effects, increased insulin sensitivity, improved brain health, reduced inflammation, and many other benefits (5Trusted Source, 6Trusted Source).\n" +
                    "\n" +
                    "Downsides: In general, intermittent fasting is safe for most healthy adults.\n" +
                    "\n" +
                    "That said, those sensitive to drops in their blood sugar levels, such as some people with diabetes, low weight, or an eating disorder, as well as pregnant or breastfeeding women, should talk to a health professional before starting intermittent fasting.")
        } else if (differention == "2"){
            code.set(0,"Plant-based diets may help you lose weight. Vegetarianism and veganism are the most popular versions, which restrict animal products for health, ethical, and environmental reasons.\n" +
                    "\n" +
                    "However, more flexible plant-based diets also exist, such as the flexitarian diet, which is a plant-based diet that allows eating animal products in moderation.\n" +
                    "\n" +
                    "How it works: There are many types of vegetarianism, but most involve eliminating all meat, poultry, and fish. Some vegetarians may likewise avoid eggs and dairy.\n" +
                    "\n" +
                    "The vegan diet takes it a step further by restricting all animal products, as well as animal-derived products like dairy, gelatin, honey, whey, casein, and albumin.\n" +
                    "\n" +
                    "There are no clear-cut rules for the flexitarian diet, as it’s a lifestyle change rather than a diet. It encourages eating mostly fruits, vegetables, legumes, and whole grains but allows for protein and animal products in moderation, making it a popular alternative.\n" +
                    "\n" +
                    "Many of the restricted food groups are high in calories, so limiting them may aid weight loss.\n" +
                    "\n" +
                    "Weight loss: Research shows that plant-based diets are effective for weight loss (7Trusted Source, 8Trusted Source, 9Trusted Source).\n" +
                    "\n" +
                    "A review of 12 studies including 1,151 participants found that people on a plant-based diet lost an average of 4.4 pounds (2 kg) more than those who included animal products (10Trusted Source).\n" +
                    "\n" +
                    "Plus, those following a vegan diet lost an average of 5.5 pounds (2.5 kg) more than people not eating a plant-based diet (10Trusted Source).\n" +
                    "\n" +
                    "Plant-based diets likely aid weight loss because they tend to be rich in fiber, which can help you stay fuller for longer, and low in high-calorie fat (11Trusted Source, 12Trusted Source, 13Trusted Source).\n" +
                    "\n" +
                    "Other benefits: Plant-based diets have been linked to many other benefits, such as a reduced risk of chronic conditions like heart disease, certain cancers, and diabetes. They can also be more environmentally sustainable than meat-based diets (14Trusted Source, 15Trusted Source, 16Trusted Source, 17Trusted Source).\n" +
                    "\n" +
                    "Downsides: Though plant-based diets are healthy, they can restrict important nutrients that are typically found in animal products, such as iron, vitamin B12, vitamin D, calcium, zinc, and omega-3 fatty acids.\n" +
                    "\n" +
                    "A flexitarian approach or proper supplementation can help account for these nutrients.")
        }
    }
}

