package klimov.test.welcome.entity

import androidx.annotation.StringRes
import klimov.test.welcome.R

internal data class InformationResources(@StringRes val title: Int, @StringRes val text: Int)

internal val stepResources = mutableListOf(
    InformationResources(R.string.information_step_1_title, R.string.information_step_1_text),
    InformationResources(R.string.information_step_2_title, R.string.information_step_2_text),
    InformationResources(R.string.information_step_3_title, R.string.information_step_3_text)
)