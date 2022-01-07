package com.example.translatesentence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var str1:TextView
    private lateinit var str2:TextView
    private lateinit var str3:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        str1=findViewById(R.id.string1)
        str2=findViewById(R.id.string2)
        str3=findViewById(R.id.string3)

        val spinner: Spinner = findViewById(R.id.spinner_lang)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.lang,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when {
                    adapterView?.getItemAtPosition(position)==0 -> {
                        //show english
                        showEnglishText()
                    }
                    adapterView?.getItemAtPosition(position)==1 -> {
                        //show bengali
                        showBengaliText()
                    }
                    adapterView?.getItemAtPosition(position)==2 -> {
                        //spanish
                        showSpanishText()
                    }
                    else -> {
                        //german
                        showGermanText()
                    }
                }

                Toast.makeText(this@MainActivity,
                    "selected ${adapterView?.getItemAtPosition(position).toString() }",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }
    private fun showBengaliText(){
        val context=LocalHelper().updateResource(this@MainActivity,"bn")
        val resource=context.resources
        str1.text=resource.getString(R.string.string1)
        str2.text=resource.getString(R.string.string2)
        str3.text=resource.getString(R.string.string3)
    }
    private fun showGermanText(){
        val context=LocalHelper().updateResource(this@MainActivity,"de")
        val resource=context.resources
        str1.text=resource.getString(R.string.string1)
        str2.text=resource.getString(R.string.string2)
        str3.text=resource.getString(R.string.string3)
    }
    private fun showSpanishText(){
        val context=LocalHelper().updateResource(this@MainActivity,"es")
        val resource=context.resources
        str1.text=resource.getString(R.string.string1)
        str2.text=resource.getString(R.string.string2)
        str3.text=resource.getString(R.string.string3)
    }
    private fun showEnglishText(){
        val context=LocalHelper().updateResource(this@MainActivity,"en")
        val resource=context.resources
        str1.text=resource.getString(R.string.string1)
        str2.text=resource.getString(R.string.string2)
        str3.text=resource.getString(R.string.string3)
    }

}