package klimov.test.testproject.main.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import klimov.test.testproject.common.ApiStatus
import klimov.test.testproject.common.extensions.showElseGone
import klimov.test.testproject.common.ui.BaseFragment
import klimov.test.testproject.databinding.MainFragmentBinding
import klimov.test.testproject.main.entity.CharacterItem
import klimov.test.testproject.main.vm.MainViewModel

class MainFragment : BaseFragment<MainFragmentBinding>() {
    private lateinit var viewModel: MainViewModel

    private lateinit var progress: ProgressBar
    private lateinit var errorTV: TextView
    private lateinit var recyclerRV: RecyclerView

    private val adapter: MainAdapter by lazy {
        MainAdapter()
    }

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        MainFragmentBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initSubscription()

        viewModel.requestToGetCharacterList()
    }

    override fun findViews(binding: MainFragmentBinding) {
        progress = binding.progressPb
        errorTV = binding.errorTV
        recyclerRV = binding.recyclerRV
    }

    override fun initViews() {
        recyclerRV.adapter = adapter
    }

    private fun initSubscription() {
        viewModel.run {
            loadingStatus.observe(viewLifecycleOwner) { status ->
                progress.showElseGone(status is ApiStatus.LoadingStatus<*>)
                errorTV.showElseGone(status is ApiStatus.ErrorStatus<*>)

                when (status) {
                    is ApiStatus.LoadingStatus<*> -> {

                    }
                    is ApiStatus.ErrorStatus<*> -> {
                        errorTV.text = status.errorMessage
                    }
                    is ApiStatus.SuccessStatus<List<CharacterItem>> -> {
                        adapter.setData(status.data)
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}