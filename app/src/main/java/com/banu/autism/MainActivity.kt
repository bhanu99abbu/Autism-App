package com.bhanu.autism

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.bhanu.autism.app.AutismApps
import com.bhanu.autism.ui.theme.AutismAppTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutismApps()
        }



    }
}

