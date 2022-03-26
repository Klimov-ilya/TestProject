package klimov.test.welcome.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import klimov.test.core.extension.showElseGone
import klimov.test.core.ui.BaseFragment
import klimov.test.welcome.databinding.FragmentInformationStepBinding
import klimov.test.welcome.interactor.WelcomeInteractor
import org.koin.android.ext.android.inject

class InformationStepFragment : BaseFragment<FragmentInformationStepBinding>() {
    private val interactor: WelcomeInteractor by inject()

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentInformationStepBinding.inflate(inflater, container, false)

    override fun findViews(binding: FragmentInformationStepBinding) {
    }

    override fun initViews(binding: FragmentInformationStepBinding) {
        arguments?.let { args ->
            binding.titleTV.text = resources.getText(args.getInt(EXTRA_TITLE))
            binding.textTV.text = resources.getText(args.getInt(EXTRA_TEXT))
            binding.continueB.showElseGone(args.getBoolean(EXTRA_IS_LAST))
        }
        binding.continueB.onClick = { interactor.navigateToSingleActivity() }
    }

    override fun initViewModels() {
    }

    companion object {
        private const val EXTRA_TITLE = "extra_title"
        private const val EXTRA_TEXT = "extra_text"
        private const val EXTRA_IS_LAST = "extra_is_last"

        fun getInstance(titleRes: Int, textRes: Int, isLast: Boolean) = InformationStepFragment().apply {
            arguments = bundleOf(
                EXTRA_TITLE to titleRes,
                EXTRA_TEXT to textRes,
                EXTRA_IS_LAST to isLast
            )
        }
    }

}