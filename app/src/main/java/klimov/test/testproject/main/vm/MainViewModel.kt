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
    private val _apiStatus = MutableLiveData<ApiStatus<List<CharacterItem>>>()
    val apiStatus: LiveData<ApiStatus<List<CharacterItem>>> get() = _apiStatus

    // cached data
    private val _characterList = MutableLiveData<List<CharacterItem>>()

    fun requestToGetCharacterList() = viewModelScope.launch {
        try {
            _apiStatus.value = ApiStatus.LoadingStatus(_characterList.value)

            val data = repository.requestToGetCharacterList()

            _characterList.value = data.docs
            _apiStatus.value = ApiStatus.SuccessStatus(data.docs)
        } catch (exception: Exception) {
            _apiStatus.value = ApiStatus.ErrorStatus(_characterList.value, errorMessage = exception.message)
        }
    }
}