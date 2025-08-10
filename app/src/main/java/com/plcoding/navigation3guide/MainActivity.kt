package com.plcoding.navigation3guide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.navigation3guide.navigation.NavigationRoot
import com.plcoding.navigation3guide.ui.theme.Navigation3GuideTheme

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("home", Icons.Filled.Home, "Home")
    object Profile : BottomNavItem("profile", Icons.Filled.Person, "Profile")
    object Add : BottomNavItem("add", Icons.Filled.AddCircle, "Add")
    object Settings : BottomNavItem("settings", Icons.Filled.Settings, "Settings")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3GuideTheme {
                var currentRoute by rememberSaveable { mutableStateOf(BottomNavItem.Home.route) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AppBottomNavigationBar(
                            currentRoute = currentRoute,
                            onItemSelected = { route ->
                                currentRoute = route
                                // Future: Integrate with NavController to change content
                                // For now, this just updates the selected item in the bar
                            }
                        )
                    }
                ) { innerPadding ->
                    MainContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Text(
                text = "All Notes",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.Gray),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Notes",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        // Existing NavigationRoot can be placed here if needed,
        // or the new elements can be part of a specific screen within NavigationRoot
        NavigationRoot(
            modifier = Modifier
                .fillMaxSize()
            // Consider passing navController here if NavigationRoot uses one
            // and you want bottom bar to control it.
        )
    }
}

@Composable
fun AppBottomNavigationBar(currentRoute: String, onItemSelected: (String) -> Unit) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Profile,
        BottomNavItem.Add,
        BottomNavItem.Settings
    )
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = { onItemSelected(item.route) }
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Navigation3GuideTheme {
        // Previewing the Greeting composable, not the full app with bottom bar.
        // To preview the bottom bar, you might need a dedicated preview for AppBottomNavigationBar
        // or a more complex preview for MainActivity's content.
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    Navigation3GuideTheme {
        MainContent()
    }
}
