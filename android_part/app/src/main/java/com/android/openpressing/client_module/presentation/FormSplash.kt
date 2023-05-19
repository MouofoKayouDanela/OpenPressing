package com.android.openpressing.client_module.presentation


import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.android.openpressing.R
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

data class HorizontalPagerContent(
    @DrawableRes val res: Int,
    val title:String,
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

                    Text(
                        text = list[currentPage].title,
                        style = MaterialTheme.typography.h4,
                        color = Black,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
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


/*
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GetStartedScreen() {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val (selectedPage, setSelectedPage) = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            setSelectedPage(page)
        }
    }

    Scaffold {
        Column {
            HorizontalPager(
                count = listData.size,
                state = pagerState,
                modifier = Modifier.weight(0.6f)
            ) { page ->
                val composition by rememberLottieComposition(LottieCompositionSpec.n(listData[page].resId))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    LottieAnimation(
                        composition,
                        /// looping the animation
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        listData[page].title,
                        style = MaterialTheme.typography.h4,
                    )
                    Box(modifier = Modifier.height(24.dp))
                    Text(
                        listData[page].desc,
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Center,
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                for (i in listData.indices) {
                    Box(
                        modifier = Modifier
                            .padding(end = if (i == listData.size - 1) 0.dp else 5.dp)
                            .width(if (i == selectedPage) 20.dp else 10.dp)
                            .height(10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                if (i == selectedPage) MaterialTheme.colors.primary else MaterialTheme.colors.primary.copy(
                                    alpha = 0.1f
                                )
                            )
                    )
                }
            }

            // only show if not last page
            if (selectedPage != listData.size - 1) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    TextButton(
                        onClick = {
                            scope.launch {
                                /// animate to last page
                                pagerState.animateScrollToPage(listData.size - 1)
                            }
                        },
                        modifier = Modifier.height(56.dp)
                    ) {
                        Text(text = "Skip")
                    }

                    Button(
                        onClick = {
                            scope.launch {
                                /// iterate to next screen
                                val nextPage = selectedPage + 1
                                pagerState.animateScrollToPage(nextPage)
                            }
                        },
                        modifier = Modifier.height(56.dp)
                    ) {
                        Text(text = "Next")
                    }
                }
            }

            /// show only in last page
            if (selectedPage == listData.size - 1) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    Text(text = "Get Started")
                }
            }
        }
    }
}


@Composable
fun OnBoarding(

){
    val  items = ArrayList<OnBoardingData>()

    items.add(
        OnBoardingData(
            R.drawable.logo,
            "val",
        "valdez kkk"
        )
    )
    items.add(
        OnBoardingData(
            R.drawable.image1,
            "val",
            "valdez kkk"
        )
    )
    items.add(
        OnBoardingData(
            R.drawable.images2,
            "val",
            "valdez kkk"
        )
    )
    items.add(
        OnBoardingData(
            R.drawable.image3,
            "val",
            "valdez kkk"
        )
    )



    @Composable
    fun OnBoardingPager(
        item: List<OnBoardingData>,
        pagerState: PagerState,
        modifier: Modifier = Modifier,
    ) {
        Box(modifier = modifier) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                HorizontalPager(state = pagerState) { page ->
                    Column(
                        modifier = Modifier
                            .padding(top = 60.dp)
                            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(id = item[page].image),
                            contentDescription = item[page].title,
                            modifier = Modifier
                                .height(250.dp)
                                .fillMaxWidth()
                        )

                        Text(
                            text = item[page].title,
                            modifier = Modifier.padding(top = 50.dp), color = Color.White,

                        )

                        Text(
                            text = item[page].desc,
                            modifier = Modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp),
                            color = Color.White,
                            //style = Typography.body1,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )

                    }
                }

                PagerIndicator(item.size, pagerState.currentPage)
            }

            Box(modifier = Modifier.align(Alignment.BottomCenter)){
                BottomSection(pagerState.currentPage)
            }
        }
    }

    @ExperimentalPagerApi
    @Composable
    fun rememberPagerState(
        @androidx.annotation.IntRange(from = 0) pageCount: Int,
        @androidx.annotation.IntRange(from = 0) initialPage: Int = 0,
        @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
        @androidx.annotation.IntRange(from = 1) initialOffscreenLimit: Int = 1,
        infiniteLoop: Boolean = false
    ): PagerState = rememberSaveable(saver = PagerState.Saver) {
        PagerState(
            pageCount = pageCount,
            currentPage = initialPage,
            currentPageOffset = initialPageOffset,
            offscreenLimit = initialOffscreenLimit,
            infiniteLoop = infiniteLoop
        )
    }

    @Composable
    fun PagerIndicator(size: Int, currentPage: Int) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(top = 60.dp)
        ) {
            repeat(size) {
                Indicator(isSelected = it == currentPage)
            }
        }
    }

    @Composable
    fun Indicator(isSelected: Boolean) {
        val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

        Box(
            modifier = Modifier
                .padding(1.dp)
                .height(10.dp)
                .width(width.value)
                .clip(CircleShape)
                .background(
                    if (isSelected) MaterialTheme.colors.primary else Grey300.copy(alpha = 0.5f)
                )
        )
    }

    @Composable
    fun BottomSection(currentPager: Int) {
        Row(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = if (currentPager != 2) Arrangement.SpaceBetween else Arrangement.Center
        ) {

            if (currentPager == 2){
                OutlinedButton(
                    onClick = { },
                    shape = RoundedCornerShape(50), // = 40% percent
                ) {
                    Text(
                        text = "Get Started",
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 40.dp),
                        color = Grey900
                    )
                }
            }else{
                SkipNextButton("Skip",Modifier.padding(start = 20.dp))
                SkipNextButton("Next",Modifier.padding(end = 20.dp))
            }

        }
    }

    @Composable
    fun SkipNextButton(text: String, modifier: Modifier) {
        Text(
            text = text, color = Grey300, modifier = modifier, fontSize = 18.sp,
            style = Typography.body1,
            fontWeight = FontWeight.Medium
        )

    }
}

}


*/