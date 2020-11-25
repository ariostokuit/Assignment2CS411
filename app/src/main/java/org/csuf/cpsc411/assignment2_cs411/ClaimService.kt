package org.csuf.cpsc411.assignment2_cs411

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import java.lang.reflect.Type

class ClaimService (val ctx : MainActivity) {
    lateinit var claimList : MutableList<Claim>
    var success : Boolean = true

    inner class GetAllServiceRespHandler : AsyncHttpResponseHandler() {
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            //JSON String representing list of claims
            if(responseBody != null){
                //log debug statement
                Log.d("Claim Service", "The response JSON String is ${String(responseBody)}")
                val gson = Gson()
                val claimListType : Type = object : TypeToken<List<Claim>>() {}.type

                Log.d("Claim Service", "The Claim List: ${claimList}")

            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            TODO("Not yet implemented")
        }
    }

    inner class addServiceRespHandler(var cObj : Claim) : AsyncHttpResponseHandler(){
        override fun onSuccess(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?
        ) {
            if(responseBody != null){
                val respStr = String(responseBody)
                Log.d("Claim Service", "The add Service response : ${respStr}")
            }
        }

        override fun onFailure(
            statusCode: Int,
            headers: Array<out Header>?,
            responseBody: ByteArray?,
            error: Throwable?
        ) {
            success = false
        }

    }

    fun addClaim(cObj : Claim){
        val client = AsyncHttpClient()
        val requestUrl = "http://192.168.1.14:8080/ClaimService/add"

        //1. Convert the cObj into JSON String
        val cJsonString = Gson().toJson(cObj)
        //2. Send the Post Request
        val entity = StringEntity(cJsonString)

        //ctx is Android Application Context Object
        client.post(ctx, requestUrl, entity, "application/json", addServiceRespHandler(cObj))
    }

    //return a list of Claims
    fun getAll(){
        //Call the HTTP
        val client = AsyncHttpClient()

        val requestUrl = "http://192.168.1.14:8080/ClaimService/getAll"

        Log.d("Claim Service", "About sending the HTTP Request.")

        // have the client get the url and response Handler object
        client.get(requestUrl, GetAllServiceRespHandler())
    }
}