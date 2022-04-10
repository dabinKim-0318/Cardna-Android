package org.cardna.data.remote.model.auth

import com.google.gson.annotations.SerializedName
import org.cardna.data.local.singleton.CardNaRepository

data class RequestAuthData(
    @SerializedName("social") val social: String = CardNaRepository.social,
    @SerializedName("uuid") val uuid: String = CardNaRepository.uuId,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("deviceToken") val deviceToken: String = "f-YkGM9BRlewnpgxF_zAkA:APA91bGCRhQy2OjRUuCGnS5Equ2N0YV9ojIKlOMfMCv_38zzbXMsA63-UCkEJLMulQOiy3c0tHgB-jaae818blz2AvJ9Vt4ioAApJGe04ywCtPXtc6Qcm-l5f_reX_XmDBR4FNiZm09F"
)