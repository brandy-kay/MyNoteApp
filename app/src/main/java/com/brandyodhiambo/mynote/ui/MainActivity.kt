package com.brandyodhiambo.mynote.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.brandyodhiambo.mynote.NavGraphs
import com.brandyodhiambo.mynote.ui.theme.MyNoteTheme
import com.brandyodhiambo.mynote.workmanager.startPeriodicWorkRequest
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold() {
                        DestinationsNavHost(
                            navGraph = NavGraphs.root,
                        )
                    }
                    startPeriodicWorkRequest(this)
                }
            }
        }
    }
}
