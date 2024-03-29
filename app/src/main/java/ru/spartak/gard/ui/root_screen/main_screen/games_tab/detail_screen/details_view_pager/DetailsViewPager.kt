package ru.spartak.gard.ui.root_screen.main_screen.games_tab.detail_screen.details_view_pager

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import ru.spartak.gard.ui.root_screen.main_screen.games_tab.detail_screen.DetailsViewModel
import ru.spartak.gard.ui.root_screen.main_screen.games_tab.games_screen.ConnectionStatus
import ru.spartak.gard.ui.theme.Text50
import ru.spartak.gard.ui.theme.Text500

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailsViewPagerTabs(
    tabs: List<DetailsTabItem>,
    pagerState: PagerState,
    modifier: Modifier,
    onClick: (index: Int, tab: DetailsTabItem) -> Unit
) {
    TabRow(
        modifier = modifier,
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = Text50,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            val isSelected = pagerState.currentPage == index
            Tab(
                text = {
                    Text(
                        stringResource(id = tab.titleId),
                        style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
                        color = if (isSelected) Text50 else Text500
                    )
                },
                selected = isSelected,
                onClick = {
                    onClick(index, tab)
                },
            )
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun DetailsTabsContent(
    tabs: List<DetailsTabItem>,
    pagerState: PagerState,
    connectionStatus: ConnectionStatus,
    navController: NavController,
    viewModel: DetailsViewModel,
    modifier: Modifier
) {
    HorizontalPager(
        state = pagerState,
        count = tabs.size,
        modifier = modifier,
        userScrollEnabled = connectionStatus != ConnectionStatus.DISCONNECTED,
        verticalAlignment = Alignment.Top
    ) { page ->
        tabs[page].screen(connectionStatus, navController, viewModel)
    }
}