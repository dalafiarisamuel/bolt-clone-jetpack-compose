package ng.devtamuno.bolt.compose.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ng.devtamuno.bolt.compose.R

@Composable
fun BecomeDriver(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(10.dp)
            )
            .noRippleClickable(onClick = onClick)
    ) {

        Text(
            modifier = Modifier.padding(start = 12.dp, end = 10.dp, top = 12.dp),
            text = stringResource(R.string.become_a_driver),
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.onPrimary,
            fontSize = 15.sp
        )

        Text(
            modifier = Modifier.padding(start = 12.dp, end = 10.dp, bottom = 12.dp),
            text = stringResource(R.string.earn_money_on_your_schedule),
            color = MaterialTheme.colors.onPrimary,
            fontSize = 12.sp
        )

    }

}


@Composable
@Preview
private fun BecomeDriverPreview() {

    PreviewComposableWithTheme {
        BecomeDriver {}
    }

}