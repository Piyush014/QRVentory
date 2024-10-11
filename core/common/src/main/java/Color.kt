import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val BrightGreen = Color(0xFF00C713)
val DarkGreen = Color(0xFF00790C)
val Orange = Color(0xFFFFAA00)
val CarbColor = Color(0xFFEEFF00)
val ProteinColor = Orange
val FatColor = Color(0xFFF44336)
val LightGray = Color(0xFF808080)
val MediumGray = Color(0xFF404040)
val DarkGray = Color(0xFF202020)
val TextWhite = Color(0xFFEEEEEE)


// Primary Color
val Primary = Color(0xFF150099)
val PrimaryGradientStart = Color(0xFF1A237E) // Darker shade of blue
val PrimaryGradientEnd = Color(0xFF8C9EFF) // Lighter shade of blue

// Secondary Color
val Secondary = Color(0xFF6E008A)
val SecondaryGradientStart = Color(0xFF4A148C) // Darker shade of purple
val SecondaryGradientEnd = Color(0xFFE1BEE7) // Lighter shade of purple

val Neutral50 = Color(0xFF787579)


val Gradient = Brush.linearGradient(
    listOf(Primary, Secondary)
)