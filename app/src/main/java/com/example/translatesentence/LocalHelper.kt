package com.example.translatesentence

import android.content.Context
import java.util.*

class LocalHelper {

    //updateResource()>=N
    //updateResourceLegacy() <N
    //setLocale()


    //android>=N
    fun updateResource(context:Context,language:String):Context {
        val locale= Locale(language)  //"en","hi"
        Locale.setDefault(locale)
        val configuration=context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        return context.createConfigurationContext(configuration)
    }
}