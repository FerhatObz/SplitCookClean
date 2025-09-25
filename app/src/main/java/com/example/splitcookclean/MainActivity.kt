package com.example.splitcookclean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splitcookclean.data.ChefRole
import com.example.splitcookclean.data.Recipe
import com.example.splitcookclean.data.RecipeCategory
import com.example.splitcookclean.data.RecipeRepository
import com.example.splitcookclean.ui.theme.SplitCookCleanTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SplitCookCleanApp()

            SplitCookCleanTheme {
                SplitCookCleanApp()
            }
        }
    }
}

@Composable
fun SplitCookCleanApp() {
    val categories = remember { RecipeRepository.categories }
    var selectedRole by rememberSaveable { mutableStateOf<ChefRole?>(null) }
    var selectedCategoryId by rememberSaveable { mutableStateOf<String?>(null) }
    var selectedRecipeName by rememberSaveable { mutableStateOf<String?>(null) }

    val selectedCategory = categories.firstOrNull { it.id == selectedCategoryId }
    val selectedRecipe = selectedCategory?.recipes?.firstOrNull { it.name == selectedRecipeName }

    val backgroundColor = when (selectedRole) {
        ChefRole.Female -> Color(0xFFFFF5F9)
        ChefRole.Male -> Color(0xFFE6F3FF)
        null -> Color.Transparent
    }

    Surface(modifier = Modifier.fillMaxSize(), color = backgroundColor) {
        when {
            selectedRole == null -> RoleSelectionScreen(onRoleSelected = { selectedRole = it })
            selectedCategory == null -> CategorySelectionScreen(
                role = selectedRole!!,
                categories = categories,
                onCategorySelected = {
                    selectedCategoryId = it.id
                },
                onBack = { selectedRole = null }
            )
            selectedRecipe == null -> RecipeListScreen(
                role = selectedRole!!,
                category = selectedCategory,
                onRecipeSelected = {
                    selectedRecipeName = it.name
                },
                onBack = {
                    selectedCategoryId = null
                }
            )
            else -> RecipeDetailScreen(
                role = selectedRole!!,
                category = selectedCategory,
                recipe = selectedRecipe,
                onBack = {
                    selectedRecipeName = null
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RoleSelectionScreen(onRoleSelected: (ChefRole) -> Unit) {
    val slides = remember {
        listOf(
            RoleSlide(
                role = ChefRole.Male,
                title = "Erkek Şef",
                subtitle = "Isıyı yönet, servisle büyüle",
                description = "Ocakta ritmi ayarla, servis öncesi masayı hazırlarken partnerinle kusursuz bir dans yakala.",
                highlights = listOf(
                    "Tencerede pişirme ve sote temposunu takip et",
                    "Final tabaklamayı yaratıcı dokunuşlarla üstlen",
                    "Servis öncesi masa düzeni ve temizlik ritmini dengele"
                ),
                icon = Icons.Filled.Male,
                accent = Color(0xFF1D4ED8),
                backgroundColors = listOf(Color(0xFFE6F3FF), Color(0xFFEFF1FF))
            ),
            RoleSlide(
                role = ChefRole.Female,
                title = "Kadın Şef",
                subtitle = "Sosu kur, ritmi başlat",
                description = "Malzemeleri özenle hazırlayıp sosları dengelediğinde mutfak aşk dolu bir prova alanına dönüşür.",
                highlights = listOf(
                    "Sebze doğrama ve marinasyon temposunu yönet",
                    "Sosların kıvamını kontrol edip fırın öncesi dengeyi sağla",
                    "Sunum aksesuarlarını ve tatlı detayları planla"
                ),
                icon = Icons.Filled.Female,
                accent = Color(0xFFD946EF),
                backgroundColors = listOf(Color(0xFFFEE8F5), Color(0xFFEAF1FF))
            )
        )
    }
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { slides.size })
    val currentSlide = slides[pagerState.currentPage]
    val swipeIndicatorOffset by rememberInfiniteTransition(label = "swipe-indicator")
        .animateFloat(
            initialValue = -8f,
            targetValue = 8f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1400, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "swipe-offset"
        )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = currentSlide.backgroundColors,
                    start = Offset.Zero,
                    end = Offset(1000f, 1400f)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            Text(
                text = "Split Cook Clean'e Hoş Geldin",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Sağa kaydırınca ${ChefRole.Female.displayName}, sola kaydırınca ${ChefRole.Male.displayName} adımlarını keşfet.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF1F2937)
            )
            Spacer(modifier = Modifier.height(24.dp))
            HorizontalPager(
                state = pagerState,
                pageSpacing = 20.dp,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) { page ->
                RoleSlideCard(slide = slides[page], onRoleSelected = onRoleSelected)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                RolePagerIndicator(currentPage = pagerState.currentPage, pageCount = slides.size)
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(x = swipeIndicatorOffset.dp)
                .padding(bottom = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "⇆ Kaydır",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.85f),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun RoleSlideCard(slide: RoleSlide, onRoleSelected: (ChefRole) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.65f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .background(color = slide.accent.copy(alpha = 0.18f), shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = slide.icon,
                            contentDescription = null,
                            tint = slide.accent,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Column {
                        Text(
                            text = slide.title,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A)
                        )
                        Text(
                            text = slide.subtitle,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF475569)
                        )
                    }
                }
                Text(
                    text = slide.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF1E293B)
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    slide.highlights.forEach { highlight ->
                        Text(
                            text = "• $highlight",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF334155)
                        )
                    }
                }
            }
            Button(
                onClick = { onRoleSelected(slide.role) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = slide.accent,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${slide.role.displayName} rolünü seç",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun RolePagerIndicator(currentPage: Int, pageCount: Int) {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        repeat(pageCount) { index ->
            val size = if (index == currentPage) 14.dp else 8.dp
            Box(
                modifier = Modifier
                    .size(size)
                    .clip(CircleShape)
                    .background(
                        if (index == currentPage) Color.White.copy(alpha = 0.9f)
                        else Color.White.copy(alpha = 0.5f)
                    )
            )
        }
    }
}

private data class RoleSlide(
    val role: ChefRole,
    val title: String,
    val subtitle: String,
    val description: String,
    val highlights: List<String>,
    val icon: ImageVector,
    val accent: Color,
    val backgroundColors: List<Color>
)

@Composable
fun CategorySelectionScreen(
    role: ChefRole,
    categories: List<RecipeCategory>,
    onCategorySelected: (RecipeCategory) -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            AppTopBar(
                title = "Kategori Seç",
                onBack = onBack,
                subtitle = "${role.displayName} için pastel seçenekler"
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPadding)
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories) { category ->
                CategoryCard(category = category) {
                    onCategorySelected(category)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SplitCookCleanApp() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = { Text(text = "SplitCookClean") },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors()
                    )
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Merhaba Şef!",
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

fun CategoryCard(category: RecipeCategory, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = category.accentColor),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Surface(
                color = Color.White.copy(alpha = 0.7f),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.size(52.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = category.icon,
                    contentDescription = null,
                    tint = Color(0xFF1E293B),
                    modifier = Modifier.size(28.dp)
                )
            }
            Column {
                Text(
                    text = category.displayName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1F2937)
                )
                Text(
                    text = "${category.recipes.size} tarif",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF475569)
                )
            }
        }
    }
}

@Composable
fun RecipeListScreen(
    role: ChefRole,
    category: RecipeCategory,
    onRecipeSelected: (Recipe) -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            AppTopBar(
                title = category.displayName,
                onBack = onBack,
                subtitle = "${role.displayName} & ${role.opposite().displayName} ekip çalışması"
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(category.recipes, key = { it.name }) { recipe ->
                RecipeListItem(recipe = recipe) { onRecipeSelected(recipe) }
            }
        }
    }
}

@Composable
fun RecipeListItem(recipe: Recipe, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                color = Color(0xFFE0F2FE),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.size(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = recipe.icon,
                    contentDescription = null,
                    tint = Color(0xFF1E3A8A),
                    modifier = Modifier.size(26.dp)
                )
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = recipe.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1F2937)
                )
                Text(
                    text = "${recipe.calories} kcal / porsiyon",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF475569)
                )
            }
        }
    }
}

@Composable
fun RecipeDetailScreen(
    role: ChefRole,
    category: RecipeCategory,
    recipe: Recipe,
    onBack: () -> Unit
) {
    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            AppTopBar(
                title = recipe.name,
                onBack = onBack,
                subtitle = "${recipe.calories} kcal · ${category.displayName}"
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                InfoSection(title = "Kalori", content = "${recipe.calories} kcal / porsiyon")
            }
            item {
                InfoSection(title = "Malzemeler", content = recipe.ingredients.joinToString(separator = "\n") { "• $it" })
            }
            item {
                InfoSection(title = "Esinlenme", content = recipe.inspiration)
            }
            item {
                StepSection(
                    title = "${role.displayName} Adımları",
                    steps = recipe.femaleSteps.takeIf { role == ChefRole.Female } ?: recipe.maleSteps,
                    highlightColor = if (role == ChefRole.Female) Color(0xFFFFD9EC) else Color(0xFFD9E7FF)
                )
            }
            item {
                StepSection(
                    title = "${role.opposite().displayName} Adımları",
                    steps = recipe.femaleSteps.takeIf { role == ChefRole.Male } ?: recipe.maleSteps,
                    highlightColor = if (role == ChefRole.Male) Color(0xFFFFD9EC) else Color(0xFFD9E7FF)
                )
            }
        }
    }
}

@Composable
fun InfoSection(title: String, content: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.92f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1F2937)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF475569),
                lineHeight = 20.sp
            )
        }
    }
}

@Composable
fun StepSection(title: String, steps: List<String>, highlightColor: Color) {
    Card(
        colors = CardDefaults.cardColors(containerColor = highlightColor.copy(alpha = 0.6f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF111827)
            )
            Spacer(modifier = Modifier.height(12.dp))
            steps.forEachIndexed { index, step ->
                Text(
                    text = "${index + 1}. $step",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF1F2937),
                    modifier = Modifier.padding(bottom = if (index == steps.lastIndex) 0.dp else 8.dp)
                )
            }
        }
    }
}

@Composable
fun AppTopBar(title: String, onBack: () -> Unit, subtitle: String? = null) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color(0xFF111827)
        ),
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Geri")
            }
        },
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (!subtitle.isNullOrEmpty()) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF64748B)
                    )
                }
            }
        }
    )

}

private fun ChefRole.opposite(): ChefRole = when (this) {
    ChefRole.Female -> ChefRole.Male
    ChefRole.Male -> ChefRole.Female
}

@Preview(showBackground = true)
@Composable

private fun SplitCookCleanAppPreview() {
    SplitCookCleanApp()
}

fun RoleSelectionPreview() {
    SplitCookCleanTheme {
        RoleSelectionScreen(onRoleSelected = {})
    }
}

