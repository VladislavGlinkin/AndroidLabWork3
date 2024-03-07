package com.example.laba2

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class ListFragmentDirections private constructor() {
  private data class ActionListFragmentToDetailFragment(
    public val description: String,
    public val cpu: String,
    public val ram: String,
    public val title: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_listFragment_to_detailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("description", this.description)
        result.putString("cpu", this.cpu)
        result.putString("ram", this.ram)
        result.putString("title", this.title)
        return result
      }
  }

  public companion object {
    public fun actionListFragmentToDetailFragment(
      description: String,
      cpu: String,
      ram: String,
      title: String,
    ): NavDirections = ActionListFragmentToDetailFragment(description, cpu, ram, title)
  }
}
