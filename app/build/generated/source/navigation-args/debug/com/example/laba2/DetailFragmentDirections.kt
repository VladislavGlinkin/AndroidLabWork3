package com.example.laba2

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class DetailFragmentDirections private constructor() {
  private data class ActionDetailFragmentToEditFragment(
    public val title: String,
    public val description: String,
    public val cpu: String,
    public val ram: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_detailFragment_to_editFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("title", this.title)
        result.putString("description", this.description)
        result.putString("cpu", this.cpu)
        result.putString("ram", this.ram)
        return result
      }
  }

  public companion object {
    public fun actionDetailFragmentToListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailFragment_to_listFragment)

    public fun actionDetailFragmentToEditFragment(
      title: String,
      description: String,
      cpu: String,
      ram: String,
    ): NavDirections = ActionDetailFragmentToEditFragment(title, description, cpu, ram)
  }
}
