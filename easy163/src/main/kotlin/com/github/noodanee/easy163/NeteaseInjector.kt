package com.github.noodanee.easy163

import com.github.megatronking.netbare.http.*
import com.github.megatronking.netbare.injector.InjectorCallback
import com.github.megatronking.netbare.injector.SimpleHttpInjector

class NeteaseInjector : SimpleHttpInjector() {

    companion object {
        const val TAG = "NeteaseInjector"
    }

    private var mHoldResponseHeader: HttpResponseHeaderPart? = null

    override fun sniffRequest(request: HttpRequest): Boolean {
        return super.sniffRequest(request)
    }

    override fun sniffResponse(response: HttpResponse): Boolean {
        return super.sniffResponse(response)
    }

    override fun onRequestInject(header: HttpRequestHeaderPart, callback: InjectorCallback) {
        super.onRequestInject(header, callback)
    }

    override fun onResponseInject(header: HttpResponseHeaderPart, callback: InjectorCallback) {
        mHoldResponseHeader = header
    }

    override fun onRequestInject(request: HttpRequest, body: HttpBody, callback: InjectorCallback) {
        super.onRequestInject(request, body, callback)
    }

    override fun onResponseInject(response: HttpResponse, body: HttpBody, callback: InjectorCallback) {
        if (mHoldResponseHeader == null) {
            // 一般不会发生
            return
        }
    }

    override fun onRequestFinished(request: HttpRequest) {
        super.onRequestFinished(request)
    }

    override fun onResponseFinished(response: HttpResponse) {
        super.onResponseFinished(response)
    }
}