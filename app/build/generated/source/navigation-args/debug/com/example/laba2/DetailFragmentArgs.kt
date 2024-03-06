package com.example.laba2

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class DetailFragmentArgs(
  public val description: String,
  public val processor: String,
  public val ram: String,
  public val title: String,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("description", this.description)
    result.putString("processor", this.processor)
    result.putString("ram", this.ram)
    result.putString("title", this.title)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("description", this.description)
    result.set("processor", this.processor)
    result.set("ram", this.ram)
    result.set("title", this.title)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
      bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
      val __description : String?
      if (bundle.containsKey("description")) {
        __description = bundle.getString("description")
        if (__description == null) {
          throw IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"description\" is missing and does not have an android:defaultValue")
      }
      val __processor : String?
      if (bundle.containsKey("processor")) {
        __processor = bundle.getString("processor")
        if (__processor == null) {
          throw IllegalArgumentException("Argument \"processor\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"processor\" is missing and does not have an android:defaultValue")
      }
      val __ram : String?
      if (bundle.containsKey("ram")) {
        __ram = bundle.getString("ram")
        if (__ram == null) {
          throw IllegalArgumentException("Argument \"ram\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"ram\" is missing and does not have an android:defaultValue")
      }
      val __title : String?
      if (bundle.containsKey("title")) {
        __title = bundle.getString("title")
        if (__title == null) {
          throw IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"title\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__description, __processor, __ram, __title)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailFragmentArgs {
      val __description : String?
      if (savedStateHandle.contains("description")) {
        __description = savedStateHandle["description"]
        if (__description == null) {
          throw IllegalArgumentException("Argument \"description\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"description\" is missing and does not have an android:defaultValue")
      }
      val __processor : String?
      if (savedStateHandle.contains("processor")) {
        __processor = savedStateHandle["processor"]
        if (__processor == null) {
          throw IllegalArgumentException("Argument \"processor\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"processor\" is missing and does not have an android:defaultValue")
      }
      val __ram : String?
      if (savedStateHandle.contains("ram")) {
        __ram = savedStateHandle["ram"]
        if (__ram == null) {
          throw IllegalArgumentException("Argument \"ram\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"ram\" is missing and does not have an android:defaultValue")
      }
      val __title : String?
      if (savedStateHandle.contains("title")) {
        __title = savedStateHandle["title"]
        if (__title == null) {
          throw IllegalArgumentException("Argument \"title\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"title\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__description, __processor, __ram, __title)
    }
  }
}
