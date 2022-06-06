package ng.devtamuno.bolt.compose.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui. composed
import ng.devtamuno.bolt.compose.ui.theme.BoltComposeTheme

@Composable
fun PreviewComposableWithTheme(content: @Composable () -> Unit) {
    BoltComposeTheme { content() }
}

inline fun Modifier.noRippleClickable(
    enabled: Boolean = true,
    crossinline onClick: () -> Unit
): Modifier = composed {
    clickable(
        enabled = enabled,
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}