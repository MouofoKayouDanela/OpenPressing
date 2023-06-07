package com.android.openpressing.data.models.annonce

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class AnnounceData(
    var id: Int? = null ,
    var attributes: AnnounceAttributes
):Parcelable
