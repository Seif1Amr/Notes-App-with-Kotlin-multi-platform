Navigation3Guide App

This project is an Android application demonstrating common UI patterns and navigation using Jetpack Compose. It includes examples of a bottom navigation bar, card views for displaying content, and basic app structure.

Project Structure

The main components of the project are:

  MainActivity.kt: The main entry point of the application. It sets up the overall Scaffold structure, including the bottom navigation bar and the main content area.
  BottomNavItem.kt (implied, as it's a sealed class within MainActivity.kt): Defines the items available in the bottom navigation bar, including their route, icon, and label.
  ui/theme/: Contains theme-related files, including Color.kt, Theme.kt, and Type.kt, defining the application's visual appearance.
  navigation/NavigationRoot.kt: (Assumed to exist based on MainActivity.kt) This component is likely responsible for handling the navigation graph and displaying different screens based on the current route.

Features

  Bottom Navigation Bar: Allows users to switch between different sections of the app (Home, Profile, Add, Settings).
    The selected item in the bottom navigation bar is visually highlighted.
    The state of the currently selected route is remembered across configuration changes using rememberSaveable.
  Main Content Area:
    Displays a "All Notes" title card.
    Includes a placeholder card with a search icon, suggesting future search functionality.
    Integrates a NavigationRoot composable, which is likely where different screen contents are loaded based on navigation.
  Jetpack Compose: The entire UI is built using Jetpack Compose, Android's modern toolkit for building native UIs.
  Material Design 3: Utilizes Material 3 components like Scaffold, NavigationBar, NavigationBarItem, Card, Icon, and Text.
  Edge-to-Edge Display: Enabled via enableEdgeToEdge() for a more immersive user experience.

UI Components

MainActivity.kt
  BottomNavItem Sealed Class:
    Defines navigation destinations: Home, Profile, Add, Settings.
    Each item has a route (String), icon (ImageVector), and label (String).
  MainActivity Class:
    onCreate(): Sets up the main UI using setContent.
    Manages the currentRoute state for the bottom navigation.
    Uses a Scaffold to structure the screen with a bottomBar.
  MainContent Composable:
    Displays a primary "All Notes" card.
    Displays a secondary card with a search icon.
    Includes the NavigationRoot composable for screen content.
  AppBottomNavigationBar Composable:
    Takes currentRoute and an onItemSelected lambda as parameters.
    Renders NavigationBarItem for each BottomNavItem.
    Highlights the selected item and triggers onItemSelected when an item is clicked.
  Greeting Composable: A simple composable for displaying a greeting message (likely for example or testing purposes).
  Preview Functions:
    GreetingPreview(): Previews the Greeting composable.
    MainContentPreview(): Previews the MainContent composable.

navigation/NavigationRoot.kt (Assumed)
  This file would typically contain the NavHost and define the navigation graph, linking routes from BottomNavItem to specific screen composables.

How to Build and Run

  Clone the repository:
The application should look like this-><img width="1366" height="768" alt="Screenshot (406)" src="https://github.com/user-attachments/assets/e2b5aa06-e15f-4f34-a81b-aa7b46e69073" />
<img width="1366" height="768" alt="Screenshot (408)" src="https://github.com/user-attachments/assets/3df410fc-1484-406e-8092-715596035e99" />
<img width="1366" height="768" alt="Screenshot (407)" src="https://github.com/user-attachments/assets/ddabec38-b811-4136-993b-45ae18dcf53f" />
