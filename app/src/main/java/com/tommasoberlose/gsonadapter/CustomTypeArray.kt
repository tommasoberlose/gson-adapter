package com.tommasoberlose.gsonadapter
import android.support.annotation.NonNull
import android.util.Log
import com.google.gson.TypeAdapter
import com.google.gson.annotations.SerializedName
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException
import kotlin.math.absoluteValue
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.instanceParameter
import kotlin.reflect.jvm.javaField


/**
 * Created by tommaso on 14/02/18.
 */

class CustomTypeArray : TypeAdapter<StatusObject>() {
  @Throws(IOException::class)
  override fun write(out: JsonWriter, obj: StatusObject) {
    // implement write: combine firstName and lastName into name
    out.beginObject()
    out.name("name")
    // out.value(user.firstName + " " + user.lastName)
    out.endObject()
  }

  @Throws(IOException::class)
  override fun read(reader: JsonReader): StatusObject? {
    for (m in StatusObject::class.declaredMemberProperties) {
      Log.d("TEST_M", m.returnType.toString() + " " + m.javaField?.name )
      m.javaField?.declaredAnnotations!!.toList()
          .filter { it.annotationClass == SerializedName::class }
          .forEach {
            val split_annotation = (it as SerializedName).value.split('.', limit = -1)

          }
    }

    if (reader.peek() == JsonToken.NULL) {
      reader.nextNull()
      return null
    }
    reader.beginObject()
    reader.nextName()
    val nameParts = reader.nextString().split(" ")
    reader.endObject()

    return StatusObject()
  }
}