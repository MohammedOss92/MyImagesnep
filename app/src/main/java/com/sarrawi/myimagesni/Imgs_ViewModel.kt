package com.sarrawi.myimagesni

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException


class Imgs_ViewModel(private val context: Context,  private val imgsRepo:ImgRepository ): ViewModel() {

    private val retrofitServices = ApiService.provideRetrofitInstance()



    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading



//    fun getSnippetss(): LiveData<List<ImgsModel>> {
//        val _imgsList = MutableLiveData<List<ImgsModel>>()
//
//        viewModelScope.launch {
//            try {
//                _isLoading.postValue(true)
//
//                val response = imgsRepo.getsnippets_Repo()
//
//                when {
//                    response.isSuccessful -> {
//
//                        val imgsResponse = response.body()
//                        val results = imgsResponse?.results
//                        _imgsList.postValue(results)
//                        Log.i("YourViewModel", "getSnippets: posts $results")
//                    }
//                    else -> {
//                        Log.i("YourViewModel", "getSnippets: data corrupted")
//                        Log.d("tag", "getSnippets Error: ${response.code()}")
//                        Log.d("tag", "getSnippets: ${response.body()}")
//                    }
//                }
//            } catch (e: Exception) {
//                Log.e("YourViewModel", "getSnippets: Error: ${e.message}")
//            } finally {
//                _isLoading.postValue(false)
//            }
//        }
//
//        return _imgsList
//    }



    fun getSnippetss(): LiveData<List<ImgsModel>> {
        val _imgsList = MutableLiveData<List<ImgsModel>>()

        viewModelScope.launch {
            try {
                _isLoading.postValue(true)

                val response = imgsRepo.getsnippets_Repoa()

                withContext(Dispatchers.Main) {
                    when {
                        response.isSuccessful -> {
                            val imgsResponse = response.body()
                            val results = imgsResponse?.results
                            _imgsList.postValue(results)
                            Log.i("YourViewModel", "getSnippets: posts $results")
                        }
                        else -> {
                            Log.i("YourViewModel", "getSnippets: data corrupted")
                            Log.d("tag", "getSnippets Error: ${response.code()}")
                            Log.d("tag", "getSnippets: ${response.body()}")
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e("YourViewModel", "getSnippets: Error: ${e.message}")
            } finally {
                _isLoading.postValue(false)
            }
        }

        return _imgsList
    }





}