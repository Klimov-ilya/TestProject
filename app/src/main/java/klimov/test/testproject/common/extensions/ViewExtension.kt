package klimov.test.testproject.common.extensions

import android.view.View

fun View.showElseGone(isShow: Boolean) {
    visibility = if (isShow) View.VISIBLE else View.GONE
}

fun View.showElseInvisible(isShow: Boolean) {
    visibility = if (isShow) View.VISIBLE else View.INVISIBLE
}