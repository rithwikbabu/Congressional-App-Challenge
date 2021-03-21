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
                var intent = Intent(context, diet_1::class.java).apply {
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
        code.clear()
        if (differention == "1"){
            code.add(0, "Intermittent fasting is a dietary strategy that cycles between periods of fasting and eating.\n" +
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
            code.add(0,"Plant-based diets may help you lose weight. Vegetarianism and veganism are the most popular versions, which restrict animal products for health, ethical, and environmental reasons.\n" +
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
        } else if (differention == "3"){
            code.add(0, "Low-carb diets are among the most popular diets for weight loss. Examples include the Atkins diet, ketogenic (keto) diet, and low-carb, high-fat (LCHF) diet.\n" +
                    "\n" +
                    "Some varieties reduce carbs more drastically than others. For instance, very-low-carb diets like the keto diet restrict this macronutrient to under 10% of total calories, compared with 30% or less for other types (18Trusted Source).\n" +
                    "\n" +
                    "How it works: Low-carb diets restrict your carb intake in favor of protein and fat.\n" +
                    "\n" +
                    "They’re typically higher in protein than low-fat diets, which is important, as protein can help curb your appetite, raise your metabolism, and conserve muscle mass (19Trusted Source, 20Trusted Source).\n" +
                    "\n" +
                    "In very-low-carb diets like keto, your body begins using fatty acids rather than carbs for energy by converting them into ketones. This process is called ketosis (21Trusted Source).\n" +
                    "\n" +
                    "Weight loss: Many studies indicate that low-carb diets can aid weight loss and may be more effective than conventional low-fat diets (22Trusted Source, 23Trusted Source, 24Trusted Source, 25Trusted Source).\n" +
                    "\n" +
                    "For example, a review of 53 studies including 68,128 participants found that low-carb diets resulted in significantly more weight loss than low-fat diets (22Trusted Source).\n" +
                    "\n" +
                    "What’s more, low-carb diets appear to be quite effective at burning harmful belly fat (26Trusted Source, 27Trusted Source, 28Trusted Source).\n" +
                    "\n" +
                    "Other benefits: Research suggests that low-carb diets may reduce risk factors for heart disease, including high cholesterol and blood pressure levels. They may also improve blood sugar and insulin levels in people with type 2 diabetes (29Trusted Source, 30Trusted Source).\n" +
                    "\n" +
                    "Downsides: In some cases, a low-carb diet may raise LDL (bad) cholesterol levels. Very-low-carb diets can also be difficult to follow and cause digestive upset in some people (31Trusted Source).\n" +
                    "\n" +
                    "In very rare situations, following a very-low-carb diet may cause a condition known as ketoacidosis, a dangerous metabolic condition that can be fatal if left untreated (32Trusted Source, 33Trusted Source).")
        } else if (differention == "4"){
            code.add(0, "The Mediterranean diet is based on foods that people in countries like Italy and Greece used to eat.\n" +
                    "\n" +
                    "Though it was designed to lower heart disease risk, numerous studies indicate that it can also aid weight loss (53Trusted Source).\n" +
                    "\n" +
                    "How it works: The Mediterranean diet advocates eating plenty of fruits, vegetables, nuts, seeds, legumes, tubers, whole grains, fish, seafood, and extra virgin olive oil.\n" +
                    "\n" +
                    "Foods such as poultry, eggs, and dairy products are to be eaten in moderation. Meanwhile, red meats are limited.\n" +
                    "\n" +
                    "Additionally, the Mediterranean diet restricts refined grains, trans fats, refined oils, processed meats, added sugar, and other highly processed foods.\n" +
                    "\n" +
                    "Weight loss: Though it’s not specifically a weight loss diet, many studies show that adopting a Mediterranean-style diet may aid weight loss (53Trusted Source, 54Trusted Source, 55Trusted Source).\n" +
                    "\n" +
                    "For example, an analysis of 19 studies found that people who combined the Mediterranean diet with exercise or calorie restriction lost an average of 8.8 pounds (4 kg) more than those on a control diet (53Trusted Source).\n" +
                    "\n" +
                    "Other benefits: The Mediterranean diet encourages eating plenty of antioxidant-rich foods, which may help combat inflammation and oxidative stress by neutralizing free radicals. It has been linked to reduced risks of heart disease and premature death (55Trusted Source, 56Trusted Source).\n" +
                    "\n" +
                    "Downsides: As the Mediterranean diet is not strictly a weight loss diet, people may not lose weight following it unless they also consume fewer calories.")
        } else if (differention == "5"){
            code.add(0, "Like low-carb diets, low-fat diets have been popular for decades.\n" +
                    "\n" +
                    "In general, a low-fat diet involves restricting your fat intake to 30% of your daily calories.\n" +
                    "\n" +
                    "Some very- and ultra-low-fat diets aim to limit fat consumption to under 10% of calories (24Trusted Source).\n" +
                    "\n" +
                    "How it works: Low-fat diets restrict fat intake because fat provides about twice the number of calories per gram, compared with the other two macronutrients — protein and carbs.\n" +
                    "\n" +
                    "Ultra-low-fat diets contain fewer than 10% of calories from fat, with approximately 80% of calories coming from carbs and 10% from protein.\n" +
                    "\n" +
                    "Ultra-low-fat diets are mainly plant-based and limit meat and animal products.\n" +
                    "\n" +
                    "Weight loss: As low-fat diets restrict calorie intake, they can aid weight loss (42Trusted Source, 43Trusted Source, 44Trusted Source, 45Trusted Source).\n" +
                    "\n" +
                    "An analysis of 33 studies including over 73,500 participants found that following a low-fat diet led to small but relevant changes in weight and waist circumference (42Trusted Source).\n" +
                    "\n" +
                    "However, while low-fat diets appear to be as effective as low-carb diets for weight loss in controlled situations, low-carb diets seem to be more effective day to day (22Trusted Source, 46Trusted Source, 47Trusted Source).\n" +
                    "\n" +
                    "Ultra-low-fat diets have been shown to be successful, especially among people with obesity. For example, an 8-week study in 56 participants found that eating a diet comprising 7–14% fat led to an average weight loss of 14.8 pounds (6.7 kg) (48Trusted Source).\n" +
                    "\n" +
                    "Other benefits: Low-fat diets have been linked to a reduced risk of heart disease and stroke. They may also reduce inflammation and improve markers of diabetes (49Trusted Source, 50Trusted Source, 51Trusted Source).\n" +
                    "\n" +
                    "Downsides: Restricting fat too much can lead to health problems in the long term, as fat plays a key role in hormone production, nutrient absorption, and cell health. Moreover, very-low-fat diets have been linked to a higher risk of metabolic syndrome (52Trusted Source).")
        } else if (differention == "6"){
            code.add(0, "The paleo diet advocates eating the same foods that your hunter-gatherer ancestors allegedly ate.\n" +
                    "\n" +
                    "It’s based on the theory that modern diseases are linked to the Western diet, as proponents believe that the human body hasn’t evolved to process legumes, grains, and dairy.\n" +
                    "\n" +
                    "How it works: The paleo diet advocates eating whole foods, fruits, vegetables, lean meats, nuts, and seeds. It restricts the consumption of processed foods, grains, sugar, and dairy, though some less restrictive versions allow for some dairy products like cheese.\n" +
                    "\n" +
                    "Weight loss: Numerous studies have shown that the paleo diet can aid weight loss and reduce harmful belly fat (34Trusted Source, 35Trusted Source, 36Trusted Source).\n" +
                    "\n" +
                    "For example, in one 3-week study, 14 healthy adults following a paleo diet lost an average of 5.1 pounds (2.3 kg) and reduced their waist circumference — a marker for belly fat — by an average of 0.6 inches (1.5 cm) (37Trusted Source).\n" +
                    "\n" +
                    "Research also suggests that the paleo diet may be more filling than popular diets like the Mediterranean diet and low-fat diets. This may be due to its high protein content (38Trusted Source, 39Trusted Source).\n" +
                    "\n" +
                    "Other benefits: Following the paleo diet may reduce several heart disease risk factors, such as high blood pressure, cholesterol, and triglyceride levels (40Trusted Source, 41Trusted Source).\n" +
                    "\n" +
                    "Downsides: Though the paleo diet is healthy, it restricts several nutritious food groups, including legumes, whole grains, and dairy.")
        } else if (differention == "7"){
            code.add(0, "Dietary Approaches to Stop Hypertension, or DASH diet, is an eating plan that is designed to help treat or prevent high blood pressure, which is clinically known as hypertension.\n" +
                    "\n" +
                    "It emphasizes eating plenty of fruits, vegetables, whole grains, and lean meats and is low in salt, red meat, added sugars, and fat.\n" +
                    "\n" +
                    "While the DASH diet is not a weight loss diet, many people report losing weight on it.\n" +
                    "\n" +
                    "How it works: The DASH diet recommends specific servings of different food groups. The number of servings you are allowed to eat depends on your daily calorie intake.\n" +
                    "\n" +
                    "For example, an average person on the DASH diet would eat about 5 servings of vegetables, 5 servings of fruit, 7 servings of healthy carbs like whole grains, 2 servings of low-fat dairy products, and 2 servings or fewer of lean meats per day.\n" +
                    "\n" +
                    "In addition, you’re allowed to eat nuts and seeds 2–3 times per week (65Trusted Source).\n" +
                    "\n" +
                    "Weight loss: Studies show that the DASH diet can help you lose weight (66Trusted Source, 67Trusted Source, 68Trusted Source, 69Trusted Source).\n" +
                    "\n" +
                    "For example, an analysis of 13 studies found that people on the DASH diet lost significantly more weight over 8–24 weeks than people on a control diet (70Trusted Source).\n" +
                    "\n" +
                    "Other benefits: The DASH diet has been shown to reduce blood pressure levels and several heart disease risk factors. Also, it may help combat recurrent depressive symptoms and lower your risk of breast and colorectal cancer (71Trusted Source, 72Trusted Source, 73Trusted Source, 74Trusted Source, 75Trusted Source, 76Trusted Source).\n" +
                    "\n" +
                    "Downsides: While the DASH diet may aid weight loss, there is mixed evidence on salt intake and blood pressure. In addition, eating too little salt has been linked to increased insulin resistance and an increased risk of death in people with heart failure (77Trusted Source, 78Trusted Source).")
        } else if (differention == "8"){
            code.add(0, "The ketogenic diet is a very low carb, high fat diet that shares many similarities with the Atkins and low carb diets.\n" +
                    "\n" +
                    "It involves drastically reducing carbohydrate intake and replacing it with fat. This reduction in carbs puts your body into a metabolic state called ketosis.\n" +
                    "\n" +
                    "When this happens, your body becomes incredibly efficient at burning fat for energy. It also turns fat into ketones in the liver, which can supply energy for the brain (6Trusted Source).\n" +
                    "\n" +
                    "Ketogenic diets can cause significant reductions in blood sugar and insulin levels. This, along with the increased ketones, has some health benefits (6Trusted Source, 7Trusted Source, 8Trusted Source\n" +
                    "Trusted Source\n" +
                    "\n" +
                    "PubMed Central\n" +
                    " Highly respected database from the National Institutes of Health\n" +
                    "Go to source\n" +
                    "\n" +
                    ").")
            code.add("There are several versions of the ketogenic diet, including:\n" +
                    "\n" +
                    "Standard ketogenic diet (SKD): This is a very low carb, moderate protein and high fat diet. It typically contains 70% fat, 20% protein, and only 10% carbs (9Trusted Source).\n" +
                    "Cyclical ketogenic diet (CKD): This diet involves periods of higher carb refeeds, such as 5 ketogenic days followed by 2 high carb days.\n" +
                    "Targeted ketogenic diet (TKD): This diet allows you to add carbs around workouts.\n" +
                    "High protein ketogenic diet: This is similar to a standard ketogenic diet, but includes more protein. The ratio is often 60% fat, 35% protein, and 5% carbs.\n" +
                    "However, only the standard and high protein ketogenic diets have been studied extensively. Cyclical or targeted ketogenic diets are more advanced methods and primarily used by bodybuilders or athletes.\n" +
                    "\n" +
                    "The information in this article mostly applies to the standard ketogenic diet (SKD), although many of the same principles also apply to the other versions.")
            code.add("Ketosis is a metabolic state in which your body uses fat for fuel instead of carbs.\n" +
                    "\n" +
                    "It occurs when you significantly reduce your consumption of carbohydrates, limiting your body’s supply of glucose (sugar), which is the main source of energy for the cells.\n" +
                    "\n" +
                    "Following a ketogenic diet is the most effective way to enter ketosis. Generally, this involves limiting carb consumption to around 20 to 50 grams per day and filling up on fats, such as meat, fish, eggs, nuts, and healthy oils (6Trusted Source).\n" +
                    "\n" +
                    "It’s also important to moderate your protein consumption. This is because protein can be converted into glucose if consumed in high amounts, which may slow your transition into ketosis (10Trusted Source).\n" +
                    "\n" +
                    "Practicing intermittent fasting could also help you enter ketosis faster. There are many different forms of intermittent fasting, but the most common method involves limiting food intake to around 8 hours per day and fasting for the remaining 16 hours (11Trusted Source).\n" +
                    "\n" +
                    "Blood, urine, and breath tests are available, which can help determine whether you’ve entered ketosis by measuring the amount of ketones produced by your body.\n" +
                    "\n" +
                    "Certain symptoms may also indicate that you’ve entered ketosis, including increased thirst, dry mouth, frequent urination, and decreased hunger or appetite (12Trusted Source).")
            code.add("A ketogenic diet is an effective way to lose weight and lower risk factors for disease (1Trusted Source, 2Trusted Source, 3Trusted Source, 4Trusted Source, 5Trusted Source).\n" +
                    "\n" +
                    "In fact, research shows that the ketogenic diet may be as effective for weight loss as a low fat diet (13Trusted Source, 14Trusted Source, 15Trusted Source).\n" +
                    "\n" +
                    "What’s more, the diet is so filling that you can lose weight without counting calories or tracking your food intake (16Trusted Source).\n" +
                    "\n" +
                    "One review of 13 studies found that following a very low carb, ketogenic diet was slightly more effective for long-term weight loss than a low fat diet. People who followed the keto diet lost an average of 2 pounds (0.9 kg) more than the group that followed a low fat diet (13Trusted Source).\n" +
                    "\n" +
                    "What’s more, it also led to reductions in diastolic blood pressure and triglyceride levels (13Trusted Source).\n" +
                    "\n" +
                    "Another study in 34 older adults found that those who followed a ketogenic diet for 8 weeks lost nearly five times as much total body fat as those who followed a low fat diet (17Trusted Source).\n" +
                    "\n" +
                    "The increased ketones, lower blood sugar levels, and improved insulin sensitivity may also play a key role (18Trusted Source, 19Trusted Source).")
            code.add("The ketogenic diet actually originated as a tool for treating neurological diseases such as epilepsy.\n" +
                    "\n" +
                    "Studies have now shown that the diet can have benefits for a wide variety of different health conditions:\n" +
                    "\n" +
                    "Heart disease. The ketogenic diet can help improve risk factors like body fat, HDL (good) cholesterol levels, blood pressure, and blood sugar (28Trusted Source, 29Trusted Source).\n" +
                    "Cancer. The diet is currently being explored as an additional treatment for cancer, because it may help slow tumor growth. (4Trusted Source, 30Trusted Source, 31Trusted Source).\n" +
                    "Alzheimer’s disease. The keto diet may help reduce symptoms of Alzheimer’s disease and slow its progression (5Trusted Source, 32Trusted Source, 33Trusted Source).\n" +
                    "Epilepsy. Research has shown that the ketogenic diet can cause significant reductions in seizures in epileptic children (3Trusted Source).\n" +
                    "Parkinson’s disease. Although more research is needed, one study found that the diet helped improve symptoms of Parkinson’s disease (34Trusted Source).\n" +
                    "Polycystic ovary syndrome. The ketogenic diet can help reduce insulin levels, which may play a key role in polycystic ovary syndrome (35Trusted Source, 36Trusted Source).\n" +
                    "Brain injuries. Some research suggests that the diet could improve outcomes of traumatic brain injuries (37Trusted Source).\n" +
                    "However, keep in mind that research into many of these areas is far from conclusive.")
            code.add("Any food that’s high in carbs should be limited.\n" +
                    "\n" +
                    "Here’s a list of foods that need to be reduced or eliminated on a ketogenic diet:\n" +
                    "\n" +
                    "sugary foods: soda, fruit juice, smoothies, cake, ice cream, candy, etc.\n" +
                    "grains or starches: wheat-based products, rice, pasta, cereal, etc.\n" +
                    "fruit: all fruit, except small portions of berries like strawberries\n" +
                    "beans or legumes: peas, kidney beans, lentils, chickpeas, etc.\n" +
                    "root vegetables and tubers: potatoes, sweet potatoes, carrots, parsnips, etc.\n" +
                    "low fat or diet products: low fat mayonnaise, salad dressings, and condiments\n" +
                    "some condiments or sauces: barbecue sauce, honey mustard, teriyaki sauce, ketchup, etc.\n" +
                    "unhealthy fats: processed vegetable oils, mayonnaise, etc.\n" +
                    "alcohol: beer, wine, liquor, mixed drinks\n" +
                    "sugar-free diet foods: sugar-free candies, syrups, puddings, sweeteners, desserts, etc.")
            code.add("You should base the majority of your meals around these foods:\n" +
                    "\n" +
                    "meat: red meat, steak, ham, sausage, bacon, chicken, and turkey\n" +
                    "fatty fish: salmon, trout, tuna, and mackerel\n" +
                    "eggs: pastured or omega-3 whole eggs\n" +
                    "butter and cream: grass-fed butter and heavy cream\n" +
                    "cheese: unprocessed cheeses like cheddar, goat, cream, blue, or mozzarella\n" +
                    "nuts and seeds: almonds, walnuts, flaxseeds, pumpkin seeds, chia seeds, etc.\n" +
                    "healthy oils: extra virgin olive oil, coconut oil, and avocado oil\n" +
                    "avocados: whole avocados or freshly made guacamole\n" +
                    "low carb veggies: green veggies, tomatoes, onions, peppers, etc.\n" +
                    "condiments: salt, pepper, herbs, and spices\n" +
                    "It’s best to base your diet mostly on whole, single-ingredient foods. Here’s a list of 44 healthy low carb foods.")
            code.add("Staying on the keto diet in the long term may have some negative effectsTrusted Source, including risks of the following:\n" +
                    "\n" +
                    "low protein in the blood\n" +
                    "extra fat in the liver\n" +
                    "kidney stones\n" +
                    "micronutrient deficiencies\n" +
                    "A type of medication called sodium-glucose cotransporter 2 (SGLT2) inhibitors for type 2 diabetes can increase the risk for diabetic ketoacidosis, a dangerous condition that increases blood acidity. Anyone taking this medication should avoid the keto diet (40Trusted Source, 41Trusted Source).\n" +
                    "\n" +
                    "More research is being done to determine the safety of the keto diet in the long term. Keep your doctor informed of your eating plan to guide your choices.")
        } else if(differention == "0"){
            code.add("")
            code.add("")
            code.add("")
            code.add("")
            code.add("")
            code.add("")
            code.add("")
        }
    }
}

