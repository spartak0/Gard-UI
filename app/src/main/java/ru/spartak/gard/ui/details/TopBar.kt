package ru.spartak.gard.ui.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.spartak.gard.R
import ru.spartak.gard.ui.theme.spacing


@Composable
fun TopBar(
    subtitleText: String,
    leftView: @Composable (RowScope.() -> Unit)? = null,
    rightView: @Composable (RowScope.() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(41.dp)
    ) {
        Text(
            text = subtitleText,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.align(Alignment.Center)
        )
        leftView?.let {
            Row(modifier = Modifier.align(Alignment.CenterStart)) { it() }
        }
        rightView?.let {
            Row(modifier = Modifier.align(Alignment.CenterEnd)) { it() }
        }

    }
}

@Composable
fun BackBtn(onClick: () -> Unit) {
    TopAppBarBtn(
        icon = painterResource(id = R.drawable.ic_arrow_back),
        text = stringResource(id = R.string.back)
    ) {
        onClick()
    }
}

@Composable
fun EditBtn(onClick: () -> Unit) {
    TopAppBarBtn(
        icon = painterResource(id = R.drawable.ic_edit),
        text = stringResource(R.string.edit)
    ) {
        onClick()
    }
}

@Composable
fun TopAppBarBtn(icon: Painter, text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(4.dp))
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.smallMedium))
        Icon(
            painter = icon,
            contentDescription = null,
            tint = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.extraSmall))
        Text(
            text = text,
            style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Medium),
            color = MaterialTheme.colors.primary
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.mediumLarge))
    }
}