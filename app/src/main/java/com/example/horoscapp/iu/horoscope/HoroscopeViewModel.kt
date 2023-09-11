package com.example.horoscapp.iu.horoscope

import androidx.lifecycle.ViewModel
import com.example.horoscapp.data.provider.HoroscopeProvider
import com.example.horoscapp.domain.model.HoroscopeInfo
import com.example.horoscapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider):ViewModel() {
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    var horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = horoscopeProvider.getHoroscope()
    }
}