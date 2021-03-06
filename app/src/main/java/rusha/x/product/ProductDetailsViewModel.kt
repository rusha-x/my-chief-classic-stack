package rusha.x.product

import androidx.lifecycle.MutableLiveData
import rusha.x.BaseViewModel
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(): BaseViewModel() {

    val nameLiveData = MutableLiveData<String>("")
    val formattedPriceLiveData = MutableLiveData<String>("")

    data class ShowWelcomeParams(val text: String)

    val showWelcomeLiveData = MutableLiveData<ShowWelcomeParams?>(null)

    fun init(product: Product) {
        nameLiveData.value = product.name
        formattedPriceLiveData.value = "${product.price}/${product.unit}"
    }

    fun onResume() {
        showWelcomeLiveData.value = ShowWelcomeParams(text = "Привет!")
        showWelcomeLiveData.value = null
    }
}