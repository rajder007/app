package com.exaple.tamzaczyk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.exaple.tamzaczyk.repository.CountryResponse
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.exaple.tamzaczyk.ui.theme.TamZaczykTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getData()
        setContent {
            TamZaczykTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(android.graphics.Color.parseColor("#121212"))
                ) {
                    Country(viewModel, onClick = { code -> navigateToDetailsActivity(code) })                }
            }
        }
    }
    fun navigateToDetailsActivity(code: String) {
        val detailsIntent = Intent(this, DetailsActivity::class.java)
        detailsIntent.putExtra("COUNTRY_CODE", code)
        startActivity(detailsIntent)
    }
}

@Composable
fun Country(viewModel: MainViewModel, onClick: (String) -> Unit, modifier: Modifier=Modifier) {
    val uiState by viewModel.immutableCountriesData.observeAsState(MainViewModel.UiState())

    when {
        uiState.isLoading -> {
            Loader()
        }

        uiState.error != null -> {
            uiState.error?.let {Error(errorMessage = it)}
        }

        uiState.data != null -> {
            uiState.data?.let { ShowCountriesList(countries = it, onClick = { id -> onClick.invoke(id) })}
        }
    }
}

@Composable
fun Loader() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(Color.Gray.copy(alpha = 0.8f), shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Loading...", fontWeight = FontWeight.Bold, color = Color(240, 240, 240))
        }
    }
}

@Composable
fun Error(errorMessage:String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Snackbar(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            content = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Warning, contentDescription = null, tint = Color.Yellow)
                    Text(text = errorMessage, fontWeight = FontWeight.Bold, color = Color.Red)
                }
            }
        )
    }
}

@Composable
fun ShowCountriesList(countries: List<CountryResponse>, onClick: (String) -> Unit) {
    if (countries.isNotEmpty()){
        LazyColumn {
            countries.forEachIndexed {_, country ->
                item {
                    Row (modifier = Modifier.clickable { onClick.invoke(country.cca2) }){
                        Row(modifier=Modifier.padding(10.dp,10.dp)) {
                            Column{
                                AsyncImage(
                                    model = country.flags.values.first(),
                                    contentDescription = "flag",
                                    modifier = Modifier.border(1.dp, Color.White)
                                )
                            }
                        }
                        Row(modifier=Modifier.padding(10.dp,5.dp)){
                            Column{
                                Text(text = country.name.common, fontSize = 25.sp, color = Color(240, 240, 240))
                                Text(text = country.capital.first(), fontSize = 18.sp, color = Color(240, 240, 240))
                                Text(text = country.region, color = Color(240, 240, 240))

                            }
                        }
                    }
                }
            }
        }
    }
}

class DetailsActivity: ComponentActivity() {
    private val viewModel: DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val code = intent.getStringExtra("COUNTRY_CODE")

        if (code != null) {
            viewModel.getData(code)
        };
        setContent {
            TamZaczykTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(android.graphics.Color.parseColor("#121212"))
                ) {
                    CountryDetail(viewModel)
                }
            }
        }
    }
}

@Composable
fun CountryDetail(viewModel: DetailViewModel, modifier: Modifier=Modifier) {
    val uiState by viewModel.immutableCountryData.observeAsState(DetailViewModel.UiState())

    when {
        uiState.isLoading -> {
            Loader()
        }

        uiState.error != null -> {
            uiState.error?.let {Error(errorMessage = it)}
        }

        uiState.data != null -> {
            uiState.data?.let { DetailView(country = it[0]) }
        }
    }
}

@Composable
fun DetailView(country: CountryResponse) {
    Column (modifier=Modifier.padding(5.dp,5.dp)){
        Text(text = country.name.official, fontSize = 35.sp, color = Color(240, 240, 240))
        Text(text = "Capital: " + country.capital.first(), fontSize = 25.sp, color = Color(240, 240, 240))
        Text(text = "Subregion: " + country.subregion, fontSize = 20.sp, color = Color(240, 240, 240))
        Text(text = "Population: " + country.population, fontSize = 20.sp, color = Color(240, 240, 240))
        Text(text = "Area: " + country.area.toString() + " km²", fontSize = 20.sp, color = Color(240, 240, 240))
        Text(text = "Coat of arms", color = Color(240, 240, 240), modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center).padding(10.dp,10.dp))
        AsyncImage(
            model = country.coatOfArms.values.first(),
            contentDescription = "flag",
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
