package com.android.openpressing.client_module.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.android.openpressing.R
import com.android.openpressing.utils.Screen
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.google.android.gms.common.util.CollectionUtils.listOf
import kotlinx.coroutines.launch


data class HorizontalPagerContent(
    @DrawableRes val res: Int,
    val title:String    ,
    val description: String
)

fun getList(): List<HorizontalPagerContent> {
    return listOf(
        HorizontalPagerContent(
            R.drawable.logo,
            "",
            "Verification is an extra or final bit of proof that establishes something is true"
        ),
        HorizontalPagerContent(
            R.drawable.image3,
            "",
            "We pay attention to all of your payments and find way for saving your money"
        ),
        HorizontalPagerContent(
            R.drawable.images2,
            "",
            "Free Advisory service,mobile banking application,visa"
        ),
        HorizontalPagerContent(
            R.drawable.images2,
            "",
            "Bank your life,We create something new you have never seen before"
        )
    )
}

@Composable
fun IntroScreen(navController: NavHostController) {
    val pagerState = rememberPagerState()
    val list = getList()

    val isNextVisible = remember { derivedStateOf { pagerState.currentPage != list.size - 1 } }
    val isPrevVisible = remember { derivedStateOf { pagerState.currentPage != 0 } }

    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.75f)
        ) {
            HorizontalPager(
                state = pagerState,
                verticalAlignment = Alignment.CenterVertically,
                count = list.size
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(), horizontalAlignment = CenterHorizontally
                ) {

                    AsyncImage(
                        model = list[currentPage].res,
                        contentDescription = null,
                        modifier = Modifier
                            .height(380.dp)
                            .width(300.dp)
                    )

                    Text(
                        text = list[currentPage].description,
                        style = MaterialTheme.typography.body1,
                        color = Black,
                        fontWeight=Bold,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth(.6f)

                    )

                }
            }
        }
        HorizontalPagerIndicator(
            pagerState = pagerState, modifier = Modifier
                .padding(vertical = 26.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            if (isPrevVisible.value) {
                Button(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }) {
                    Text(text = "Prev")
                }
            }
            if (isPrevVisible.value && isNextVisible.value) {
                Box(modifier = Modifier.fillMaxWidth(.2f))
            }

            if (isNextVisible.value) {
                Button(onClick = {
                    navController.navigate(Screen.Login.road)
                    scope.launch{
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }) {
                    Text(text = "Next")
                }
            }

        }

    }
}




