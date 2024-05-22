package com.example.affirmation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmation.data.Affirmation
import com.example.affirmation.data.loadAffirmations
import com.example.affirmation.ui.theme.AffirmationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        AffirmationApplication()
                }
            }
        }
    }
}

@Composable
fun AffirmationApplication( ) {

    AffirmationList(affirmations = loadAffirmations(), modifier = Modifier)
}

@Composable
fun AffirmationList(affirmations:List<Affirmation>,modifier:Modifier){

    LazyColumn(modifier=modifier) {
        items(affirmations){
            affirmation -> AffirmationCarte(
            affirmationObjet = affirmation,
            modifier=Modifier.padding(8.dp)
            )
        }
    }
}
@Composable
fun AffirmationCarte(affirmationObjet:Affirmation,modifier:Modifier=Modifier){

    Card(modifier=modifier){
        Column {
            Image(
                painter = painterResource(affirmationObjet.imageResource),
                contentDescription = stringResource(affirmationObjet.stringRessourcesId),
                modifier= Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = LocalContext.current.getString(affirmationObjet.stringRessourcesId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
private fun AffirmationCardPreview(){

    AffirmationCarte(Affirmation(R.string.affirmation1,R.drawable.image1))
}