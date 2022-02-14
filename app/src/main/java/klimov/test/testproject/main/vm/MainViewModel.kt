package klimov.test.testproject.main.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import klimov.test.testproject.common.ApiStatus
import klimov.test.testproject.common.vm.BaseViewModel
import klimov.test.testproject.main.entity.CharacterItem
import klimov.test.testproject.main.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {
    private val repository = MainRepository

    private val _loadingStatus = MutableLiveData<ApiStatus<List<CharacterItem>>>()
    // cache data
    private val _characterList = MutableLiveData<List<CharacterItem>>()

    val loadingStatus: LiveData<ApiStatus<List<CharacterItem>>> get() = _loadingStatus

    fun requestToGetCharacterList() = viewModelScope.launch {
        try {
            _loadingStatus.value = ApiStatus.LoadingStatus(_characterList.value)

            val data = repository.requestToGetCharacterList()

            _characterList.value = data.docs
            _loadingStatus.value = ApiStatus.SuccessStatus(data.docs)
        } catch (exception: Exception) {
            _loadingStatus.value = ApiStatus.ErrorStatus(_characterList.value, errorMessage = exception.message)
        }
    }

}