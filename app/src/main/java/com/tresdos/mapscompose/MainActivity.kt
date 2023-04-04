package com.tresdos.mapscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.tresdos.mapscompose.ui.theme.MapsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MapsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyGoogleMaps()
                }
            }
        }
    }
}

@Composable
fun MyGoogleMaps() {
    val marker = LatLng(28.270833, -16.63916)
    val  properties by remember {
        mutableStateOf((MapProperties(mapType = MapType.HYBRID)))
    }
    GoogleMap(modifier = Modifier.fillMaxSize(), properties = properties, uiSettings = MapUiSettings(zoomControlsEnabled = false)) {
        Marker(position = marker, title = "Volcan", snippet = "Volcan Test")
    }
}
