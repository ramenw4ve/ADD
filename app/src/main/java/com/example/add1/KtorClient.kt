package com.example.add1

import androidx.compose.runtime.MutableState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class KtorClient {
    private val client = HttpClient(OkHttp) {
        defaultRequest { url("http://10.0.0.162:7000/") }

        install(Logging) {
            logger = Logger.SIMPLE
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }


    }

    suspend fun postDoctor(end: String, doc: Doctor): String {


        val response = client.post("doctor/$end") {
            contentType(ContentType.Application.Json)
            setBody(doc)
        }

        return response.body()
    }

    suspend fun getDoctor(end: String, accesstoken: String): GDoctor {

//        val accesstoken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkNTU1ZjU0MzhjYmNkMTNjMzczZmQiLCJpYXQiOjE3MDU4NTg0MTYsImV4cCI6MTcwNTg2MjAxNn0.Z8V3OCTIYGU6sNuDNAhI5w6E7v4k0end-yEtce1BXf8"

        val request = client.get("/doctor/$end") {
            header("Authorization", "Bearer $accesstoken")
        }

        return request.body()
    }

    suspend fun postMeds(end: String, medicines: AMedicines, accesstoken: String): String {

        val response = client.post("/doctor/addMedicines/$end") {
            header("Authorization", "Bearer $accesstoken")
            contentType(ContentType.Application.Json)
            setBody(medicines)
        }

        if (response.status != HttpStatusCode(200, "OK")) {
            val parsedErrorResponse: Map<String, String> = Json.decodeFromString(response.body())
            val errorMessage = parsedErrorResponse["message"]

            return errorMessage.toString()
        } else {


            return "Added Successfully"
        }
    }

    suspend fun getSPatient(end: String): SPatient {

//        val accesstoken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkNTU1ZjU0MzhjYmNkMTNjMzczZmQiLCJpYXQiOjE3MDU4NTg0MTYsImV4cCI6MTcwNTg2MjAxNn0.Z8V3OCTIYGU6sNuDNAhI5w6E7v4k0end-yEtce1BXf8"

        val request = client.get("/doctor/searchPatient/$end")

        return request.body()
    }

    suspend fun getPatient(end: String, accesstoken: String): GPatient {

//         accesstoken =
//            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkNTU1ZjU0MzhjYmNkMTNjMzczZmQiLCJpYXQiOjE3MDU4NTg0MTYsImV4cCI6MTcwNTg2MjAxNn0.Z8V3OCTIYGU6sNuDNAhI5w6E7v4k0end-yEtce1BXf8"

        val request = client.get("/patient/$end") {
            header("Authorization", "Bearer $accesstoken")
        }

        return request.body()
    }

    suspend fun getHPatient(end: String, accesstoken: String): HPatient {

//         accesstoken =
//            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkNTU1ZjU0MzhjYmNkMTNjMzczZmQiLCJpYXQiOjE3MDU4NTg0MTYsImV4cCI6MTcwNTg2MjAxNn0.Z8V3OCTIYGU6sNuDNAhI5w6E7v4k0end-yEtce1BXf8"

        val request = client.get("/patient/$end") {
            header("Authorization", "Bearer $accesstoken")
        }

        return request.body()
    }
    suspend fun getQR(end: String): ViewQR {



        val request = client.get("/patient/viewDocPrescription/$end")

        return request.body()
    }

//    suspend fun getQR(end: String): ViewQR {
//        return withContext(Dispatchers.IO) {  // Switch to IO dispatcher for network calls
//            val response: HttpResponse = client.get("/patient/viewDocPrescription/$end")
////                .await()  // Await the response
//
//            if (response.status.isSuccess()) {
//                response.body<ViewQR>() // Parse response body as ViewQR
//            } else {
//                // Handle error cases appropriately
//                throw Exception("Failed to get QR data: ${response.status}")  // Example handling
//            }
//        }
//    }

    suspend fun postPatient(end: String, pat: Patient): String? {


        val response = client.post("patient/$end") {
            contentType(ContentType.Application.Json)
            setBody(pat)
        }

        if (response.status != HttpStatusCode(200, "OK")) {
            val parsedErrorResponse: Map<String, String> = Json.decodeFromString(response.body())
            val errorMessage = parsedErrorResponse["error"]

            return errorMessage
        } else {
            val parsedResponse: Map<String, Int> = Json.decodeFromString(response.body())
            val uniqueIdNumber = parsedResponse["UniqueId"]

            return uniqueIdNumber.toString()
        }


    }

    suspend fun postLPatient(end: String, pat: LPatient): String? {


        val response = client.post("patient/$end") {
            contentType(ContentType.Application.Json)
            setBody(pat)
        }

        if (response.status == HttpStatusCode(200, "OK")) {
            val parsedResponse: Map<String, String> = Json.decodeFromString(response.body())
            val token = parsedResponse["token"]

            return token
        } else {
            val parsedResponse: Map<String, String> = Json.decodeFromString(response.body())
            val uniqueIdNumber = parsedResponse["error"]

            return uniqueIdNumber.toString()

        }


    }


}


@Serializable
data class Doctor(
    val name: String,
    val registrationNumber: String,
    val specialization: String,
    val password: String
)

@Serializable
data class GDoctor(
    val name: String,
    val registrationNumber: Int,
    val specialization: String,
)

@Serializable
data class Patient(
    val name: String,
    val phone_no: String,
    val password: String
)

@Serializable
data class LPatient(
    val uniqueId: String = "",
    val password: String,

    )

@Serializable
data class GPatient(
    val name: String,
    val uniqueId: Int,
    val phone_no: String,
)

@Serializable
data class HPatient(
    val doctorName: String = "Doctor0",
    val numberOfMedicines: Int = 69,
    val Medicines: List<IMedicine>
)




@Serializable
data class SPatient(
    val name: String,
    val phoneNumber: String,
    val uniqueId: Int
)

@Serializable
data class AMedicines(
    val medicines: List<Medicine>,
)

@Serializable
data class Medicine(
    val name: String,
    val mg: String,
    val quantity: String
)
@Serializable
data class ViewQR(
    val message: String,
    val qrData: String
)

@Serializable
data class IMedicine(
    val Medicine_name: String,
    val mg: Int,
    val quantity: Int,
    val price: Int,
    val _id:String
)


@Serializable
data class Goblet(
    val name: MutableState<String>,
    val mg: MutableState<String>,
    val quantity: MutableState<String>
)

@Serializable
data class Tablet(
    val name: MutableState<String>,
    val mg: MutableState<String>,
    val quantity: MutableState<String>
)

//@Serializable
//data class Character(
//    val name:String,
//    val registrationNumber:Int,
//    val phone_no:String
//)

//@Serializable
//data class Character(
//    val id:Int,
//    val name:String,
//    val origin:Origin
//) {
//    @Serializable
//    data class Origin(
//        val name:String
//    )
//}