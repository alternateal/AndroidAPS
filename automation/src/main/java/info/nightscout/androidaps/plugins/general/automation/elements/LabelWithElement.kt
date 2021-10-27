package info.nightscout.androidaps.plugins.general.automation.elements

import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import info.nightscout.androidaps.utils.resources.ResourceHelper

class LabelWithElement(
    private val resourceHelper: ResourceHelper,
    var textPre: String = "",
    var textPost: String = "",
    var element: Element? = null,
) : Element() {

    override fun addToLayout(root: LinearLayout) { // container layout
        // val layout = LinearLayout(root.context).also {
        //     it.orientation = LinearLayout.VERTICAL
        //     it.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        // }
        // text view pre element
        val px = resourceHelper.dpToPx(1)

        root.addView(
            TextView(root.context).apply {
                text = textPre
                layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    gravity = Gravity.CENTER
                }
                setPadding(px, px, px, px)
                setTypeface(typeface, Typeface.BOLD)
            }
        )

        // add element to layout
        element?.addToLayout(root)
        // text view post element
        root.addView(
            TextView(root.context).also {
                it.text = textPost
                it.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    gravity = Gravity.CENTER
                }
                it.setPadding(px, px, px, px)
                it.setTypeface(it.typeface, Typeface.BOLD)
            })
        // add layout to root layout
        // root.addView(layout)
    }

}